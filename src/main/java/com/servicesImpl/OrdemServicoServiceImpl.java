package com.servicesImpl;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.PecaDao;
import com.model.Peca;
import com.services.OrdemServicoService;

@Service
public class OrdemServicoServiceImpl implements OrdemServicoService {

	@Autowired
	PecaDao _pecaDao;

	public List<Peca> getPesquisaPeca(String nome) {

		List<Peca> retorno = _pecaDao.lista(nome);

		for (Peca item : retorno) {
			Double d = Double.parseDouble(item.getValorVenda());
			Locale ptBr = new Locale("pt", "BR");
			String valorEmReal = NumberFormat.getCurrencyInstance(ptBr).format(d);
			item.setValorVenda(valorEmReal);
		}

		return retorno;

	}

}