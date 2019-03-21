package com.servicesImpl;

import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PecaDao;
import com.dto.DtoPecaPesquisa;
import com.dto.DtoRetornoPaginado;
import com.model.Peca;
import com.services.PecaService;

@Service
public class PecaServiceImpl implements PecaService {

	@Autowired
	PecaDao _pecaDao;

	public DtoRetornoPaginado<Peca> listAll(Integer pagina, DtoPecaPesquisa dto)
			throws IllegalAccessException, InvocationTargetException {
		DtoRetornoPaginado<Peca> retorno = _pecaDao.listAll(pagina, dto);

		for (Peca item : retorno.getLista()) {
			Double d = Double.parseDouble(item.getValorVenda());
			Locale ptBr = new Locale("pt", "BR");
			String valorEmReal = NumberFormat.getCurrencyInstance(ptBr).format(d);
			item.setValorVenda(valorEmReal);
		}

		return retorno;
	}

	public void salvar(Peca peca) {
		peca.setDth_cadastro(new Date());
		_pecaDao.persist(peca);
	}

	public Boolean deletar(Integer cod) {
		return _pecaDao.deletar(cod);
	}

	public boolean editar(Peca peca) {

		Peca getPeca = _pecaDao.getObj(peca.getId());

		if (getPeca != null) {

			String valor = peca.getValorVenda().replace("R$", "");
			peca.setValorVenda(valor);
			peca.setDth_cadastro(getPeca.getDth_cadastro());

			_pecaDao.merge(peca);
			return true;
		}
		return false;
	}

	public Peca getObj(Integer id) {

		Peca objLocalizado = _pecaDao.getObj(id);

		if (objLocalizado != null) {

			Double d = Double.parseDouble(objLocalizado.getValorVenda());
			Locale ptBr = new Locale("pt", "BR");
			String valorEmReal = NumberFormat.getCurrencyInstance(ptBr).format(d);

			objLocalizado.setValorVenda(valorEmReal.replace(",", "."));

			return objLocalizado;
		}

		return null;
	}

}