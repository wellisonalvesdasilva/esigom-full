package servicesImpl;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.ClienteDao;
import dao.OrdemServicoDao;
import dao.PecaDao;
import dao.ServicoDao;
import dto.DtoClientePesquisa;
import dto.DtoListaPeca;
import dto.DtoOrdemServicoPesquisa;
import dto.DtoRetornoPaginado;
import model.Cliente;
import model.OrdemServico;
import model.Peca;
import model.Servico;
import services.OrdemServicoService;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService {

	@Autowired
	OrdemServicoDao _ordemServicoDao;

	public DtoRetornoPaginado<DtoOrdemServicoPesquisa> listAll(Integer pagina, DtoOrdemServicoPesquisa dto)
			throws IllegalAccessException {
		return _ordemServicoDao.listAll(pagina, dto);
	}

	/*
	 * public Serializable salvarOrdemServico(Object dto) {
	 * 
	 * // Serealize to GSON GsonBuilder gsonBuilder = new GsonBuilder();
	 * gsonBuilder.serializeNulls(); Gson gson = gsonBuilder.create(); String
	 * jsonInString = dto.toString(); DtoSalvarOrdemServico objectToPersist =
	 * gson.fromJson(jsonInString, DtoSalvarOrdemServico.class);
	 * 
	 * // Create Table Main OrdemServico instOrdemServico = new OrdemServico();
	 * instOrdemServico.setData(new Date()); Cliente cliente =
	 * _clienteDao.getObj(objectToPersist.getClienteId()); if (cliente != null)
	 * { instOrdemServico.setCliente(cliente); }
	 * instOrdemServico.setVeiculoPlaca(objectToPersist.getVeiculoPlaca());
	 * instOrdemServico.setMarca(objectToPersist.getMarca());
	 * instOrdemServico.setModelo(objectToPersist.getModelo());
	 * instOrdemServico.setCor(objectToPersist.getCor());
	 * instOrdemServico.setAno(objectToPersist.getAno());
	 * instOrdemServico.setKm(objectToPersist.getKm());
	 * instOrdemServico.setGerouOs(false);
	 * 
	 * // Tabela Intermediate to item "Peça" if
	 * (objectToPersist.getListPecas().size() > 0) { for (DtoItemOrdemServico
	 * item : objectToPersist.getListPecas()) { OrdemServicoItem novoIn = new
	 * OrdemServicoItem(); novoIn.setCodItem(item.getId());
	 * novoIn.setTipoItem(item.getTipoItem());
	 * novoIn.setQuantidade(item.getQuantidade());
	 * instOrdemServico.AdicionarFilhos(novoIn); } }
	 * 
	 * // Tabela Intermediate to item "Serviço" if
	 * (objectToPersist.getListServicos().size() > 0) { for (DtoItemOrdemServico
	 * item : objectToPersist.getListServicos()) { OrdemServicoItem novoIn = new
	 * OrdemServicoItem(); novoIn.setCodItem(item.getId());
	 * novoIn.setTipoItem(item.getTipoItem());
	 * novoIn.setQuantidade(item.getQuantidade());
	 * instOrdemServico.AdicionarFilhos(novoIn); } }
	 * 
	 * // Persist Main (Single transaction)
	 * 
	 * return _OrdemServicoDao.persist(instOrdemServico);
	 * 
	 * }
	 * 
	 * public DtoListaPeca getPesquisaPeca(String nome) {
	 * 
	 * List<Peca> retorno = _pecaDao.lista(nome);
	 * 
	 * for (Peca item : retorno) { Double d =
	 * Double.parseDouble(item.getValor()); Locale ptBr = new Locale("pt",
	 * "BR"); String valorEmReal =
	 * NumberFormat.getCurrencyInstance(ptBr).format(d);
	 * item.setValor(valorEmReal); }
	 * 
	 * DtoListaPeca list = new DtoListaPeca(); list.setLista(retorno);
	 * list.setQtdTotalDeRegistros(retorno.size()); return list;
	 * 
	 * }
	 * 
	 * public DtoListaPeca getPesquisaServico(String nome) {
	 * 
	 * List<Servico> retorno = _servicoDao.lista(nome);
	 * 
	 * for (Servico item : retorno) { Double d =
	 * Double.parseDouble(item.getValor()); Locale ptBr = new Locale("pt",
	 * "BR"); String valorEmReal =
	 * NumberFormat.getCurrencyInstance(ptBr).format(d);
	 * item.setValor(valorEmReal); }
	 * 
	 * DtoListaPeca list = new DtoListaPeca(); list.setLista(retorno);
	 * list.setQtdTotalDeRegistros(retorno.size()); return list; }
	 * 
	 * public Cliente getCliente(String cpf) { return
	 * _clienteDao.getPorCpf(cpf); }
	 */

}