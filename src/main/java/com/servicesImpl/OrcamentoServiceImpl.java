package com.servicesImpl;

import java.text.NumberFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ClienteDao;
import com.dao.OrcamentoDao;
import com.dao.PecaDao;
import com.dao.ServicoDao;
import com.dto.DtoItemOrcamento;
import com.dto.DtoListaPeca;
import com.dto.DtoSalvarOrcamento;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.model.Cliente;
import com.model.Orcamento;
import com.model.OrcamentoItem;
import com.model.Peca;
import com.model.Servico;
import com.services.OrcamentoService;

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

	public Boolean salvarOrcamento(Object dto) {

		// Serealize to GSON
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		Gson gson = gsonBuilder.create();
		String jsonInString = dto.toString();
		DtoSalvarOrcamento objectToPersist = gson.fromJson(jsonInString, DtoSalvarOrcamento.class);

		// Create Table Main
		Orcamento instOrcamento = new Orcamento();
		instOrcamento.setData(new Date());
		instOrcamento.setClienteId(objectToPersist.getClienteId());
		instOrcamento.setVeiculoPlaca(objectToPersist.getVeiculoPlaca());
		instOrcamento.setMarca(objectToPersist.getMarca());
		instOrcamento.setModelo(objectToPersist.getModelo());
		instOrcamento.setCor(objectToPersist.getCor());
		instOrcamento.setAno(objectToPersist.getAno());
		instOrcamento.setKm(objectToPersist.getKm());

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
		_orcamentoDao.persist(instOrcamento);
		return true;
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

}