package com.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daoapi.PecaDao;
import com.dtos.DtoPecaPesquisa;
import com.dtos.DtoRetornoPaginado;
import com.entities.Peca;
import com.servicesapi.PecaService;

@Service
public class PecaServiceImpl implements PecaService {

	@Autowired
	PecaDao _pecaDao;

	public DtoRetornoPaginado<Peca> listAll(Integer pagina, DtoPecaPesquisa dto) {
		DtoRetornoPaginado<Peca> retorno = _pecaDao.listAll(pagina, dto);
		return retorno;
	}

	public void salvar(Peca peca) {
		_pecaDao.persist(peca);
	}

	public Boolean deletar(Integer cod) {
		return _pecaDao.deletar(cod);
	}

	public boolean editar(Peca peca) {

		Peca getPega = _pecaDao.getObj(peca.getId());

		if (getPega != null) {

			String valor = peca.getValorVenda().replace("R$", "");
			peca.setValorVenda(valor);

			_pecaDao.merge(peca);
			return true;
		}
		return false;
	}

	public Peca getObj(Integer id) {

		Peca objLocalizado = _pecaDao.getObj(id);

		if (objLocalizado != null) {

			return objLocalizado;
		}

		return null;
	}

}