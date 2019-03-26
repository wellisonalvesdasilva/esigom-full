package com.servicesImpl;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ClienteDao;
import com.dao.PecaDao;
import com.dao.ServicoDao;
import com.dto.DtoListaPeca;
import com.model.Cliente;
import com.model.Peca;
import com.model.Servico;
import com.services.OrcamentoService;

@Service
public class OrcamentoServiceImpl implements OrcamentoService {

	@Autowired
	PecaDao _pecaDao;

	@Autowired
	ServicoDao _servicoDao;

	@Autowired
	ClienteDao _clienteDao;

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