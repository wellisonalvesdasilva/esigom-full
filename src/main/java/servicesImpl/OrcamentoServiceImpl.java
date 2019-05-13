package servicesImpl;

import java.io.IOException;
import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import auxiliar.SendMail;
import dao.ClienteDao;
import dao.OrcamentoDao;
import dao.PecaDao;
import dao.ServicoDao;
import dto.DtoClientePesquisa;
import dto.DtoItemOrcamento;
import dto.DtoListaPeca;
import dto.DtoOrcamentoPesquisa;
import dto.DtoRetornoPaginado;
import dto.DtoSalvarOrcamento;
import model.Cliente;
import model.Orcamento;
import model.OrcamentoItem;
import model.Peca;
import model.Servico;
import net.sf.jasperreports.engine.JRException;
import reports.GenerateRelatorio;
import services.OrcamentoService;

@Service
public class OrcamentoServiceImpl implements OrcamentoService {

	@Autowired
	OrcamentoDao _orcamentoDao;

	@Autowired
	PecaDao _pecaDao;

	@Autowired
	ServicoDao _servicoDao;

	@Autowired
	ClienteDao _clienteDao;

	@SuppressWarnings("unchecked")
	public byte[] exportPdfFile(HttpServletRequest request) throws JRException, IOException {
		GenerateRelatorio instRelatorio = new GenerateRelatorio();

		// Consulta virá do banco - apenas teste
		List<Orcamento> lista = new ArrayList();
		Orcamento inst = new Orcamento();
		inst.setAno(2015);
		lista.add(inst);

		byte[] result = instRelatorio.gerarRelatorio(lista, request, "teste");
		return result;
	}

	public DtoRetornoPaginado<DtoOrcamentoPesquisa> listAll(Integer pagina, DtoOrcamentoPesquisa dto)
			throws IllegalAccessException {

		// Retorno Banco
		DtoRetornoPaginado<Orcamento> retorno = _orcamentoDao.listAll(pagina, dto);

		// Lista Tratada em DTO
		DtoRetornoPaginado<DtoOrcamentoPesquisa> instTratada = new DtoRetornoPaginado<DtoOrcamentoPesquisa>();
		List<DtoOrcamentoPesquisa> listaFormatada = new ArrayList<DtoOrcamentoPesquisa>();
		for (Orcamento item : retorno.getLista()) {
			DtoOrcamentoPesquisa objL = new DtoOrcamentoPesquisa();
			objL.setId(item.getId());
			objL.setDataCadastro(item.getData());
			objL.setSubTotal("200,00");
			objL.setCliente(item.getCliente());

			// Tratativa que verifica se virou ordem de serviço
			String gerouOs = "";
			if (item.getGerouOs() == true) {
				gerouOs = "Sim";
			} else {
				gerouOs = "Não";
			}
			objL.setGerouOs(gerouOs);

			listaFormatada.add(objL);
		}

		instTratada.setLista(listaFormatada);
		instTratada.setNumeroPaginas(retorno.getNumeroPaginas());
		instTratada.setQtdRegistroPagina(retorno.qtdRegistroPagina);
		instTratada.setQtdTotalDeRegistros(retorno.getQtdTotalDeRegistros());

		return instTratada;
	}

	public Serializable salvarOrcamento(Object dto) {

		// Serealize to GSON
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		Gson gson = gsonBuilder.create();
		String jsonInString = dto.toString();
		DtoSalvarOrcamento objectToPersist = gson.fromJson(jsonInString, DtoSalvarOrcamento.class);

		// Create Table Main
		Orcamento instOrcamento = new Orcamento();
		instOrcamento.setData(new Date());
		Cliente cliente = _clienteDao.getObj(objectToPersist.getClienteId());
		if (cliente != null) {
			instOrcamento.setCliente(cliente);
		}
		instOrcamento.setVeiculoPlaca(objectToPersist.getVeiculoPlaca());
		instOrcamento.setMarca(objectToPersist.getMarca());
		instOrcamento.setModelo(objectToPersist.getModelo());
		instOrcamento.setCor(objectToPersist.getCor());
		instOrcamento.setAno(objectToPersist.getAno());
		instOrcamento.setKm(objectToPersist.getKm());
		instOrcamento.setGerouOs(false);
		instOrcamento.setCodStatus(1);
		instOrcamento.setFormaPagamento(objectToPersist.getFormaPagamento());
		instOrcamento.setObs(objectToPersist.getObs());

		// Tabela Intermediate to item "Peça"
		if (objectToPersist.getListPecas().size() > 0) {
			for (DtoItemOrcamento item : objectToPersist.getListPecas()) {
				OrcamentoItem novoIn = new OrcamentoItem();
				novoIn.setCodItem(item.getId());
				novoIn.setTipoItem(item.getTipoItem());
				novoIn.setQuantidade(item.getQuantidade());
				instOrcamento.AdicionarFilhos(novoIn);
			}
		}

		// Tabela Intermediate to item "Serviço"
		if (objectToPersist.getListServicos().size() > 0) {
			for (DtoItemOrcamento item : objectToPersist.getListServicos()) {
				OrcamentoItem novoIn = new OrcamentoItem();
				novoIn.setCodItem(item.getId());
				novoIn.setTipoItem(item.getTipoItem());
				novoIn.setQuantidade(item.getQuantidade());
				instOrcamento.AdicionarFilhos(novoIn);
			}
		}

		// Persist Main (Single transaction)

		return _orcamentoDao.persist(instOrcamento);

	}

	public DtoListaPeca getPesquisaPeca(String nome) {

		List<Peca> retorno = _pecaDao.lista(nome);

		for (Peca item : retorno) {
			Double d = Double.parseDouble(item.getValor());
			Locale ptBr = new Locale("pt", "BR");
			String valorEmReal = NumberFormat.getCurrencyInstance(ptBr).format(d);
			item.setValor(valorEmReal);
		}

		DtoListaPeca list = new DtoListaPeca();
		list.setLista(retorno);
		list.setQtdTotalDeRegistros(retorno.size());
		return list;

	}

	public DtoListaPeca getPesquisaServico(String nome) {

		List<Servico> retorno = _servicoDao.lista(nome);

		for (Servico item : retorno) {
			Double d = Double.parseDouble(item.getValor());
			Locale ptBr = new Locale("pt", "BR");
			String valorEmReal = NumberFormat.getCurrencyInstance(ptBr).format(d);
			item.setValor(valorEmReal);
		}

		DtoListaPeca list = new DtoListaPeca();
		list.setLista(retorno);
		list.setQtdTotalDeRegistros(retorno.size());
		return list;
	}

	public Cliente getCliente(String cpf) {
		return _clienteDao.getPorCpf(cpf);
	}

	public void enviarOrcamentoPorEmail(Integer idOrcamento, HttpServletRequest request) {
		Orcamento orcamento = _orcamentoDao.getObj(idOrcamento);

		if (orcamento != null) {

			// Gerar PDF
			byte[] bytes = null;
			try {
				bytes = exportPdfFile(request);
			} catch (JRException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// Invocar Envio de Email
			SendMail sm = new SendMail("smtp.gmail.com", "465");
			sm.sendMail("esigomsistema@gmail.com", orcamento.getCliente().getEmail(), "Seu Orçamento Chegou!",
					orcamento.getCliente().getNome() + ", seu orçamento chegou!", bytes);
		}
	}
}