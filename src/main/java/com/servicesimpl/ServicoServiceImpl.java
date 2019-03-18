package com.servicesimpl;

import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daoapi.ServicoDao;
import com.dtos.DtoRetornoPaginado;
import com.dtos.DtoServicoPesquisa;
import com.entities.Servico;
import com.servicesapi.ServicoService;

@Service
public class ServicoServiceImpl implements ServicoService {

	@Autowired
	ServicoDao _servicoDao;

	public DtoRetornoPaginado<Servico> listAll(Integer pagina, DtoServicoPesquisa dto) {
		DtoRetornoPaginado<Servico> retorno = _servicoDao.listAll(pagina, dto);
		return retorno;
	}

	public void salvar(Servico servico) {

		String valor = servico.getValor().replace("R$", "");
		servico.setValor(valor);

		_servicoDao.persist(servico);
	}

	public Boolean deletar(Integer cod) {
		return _servicoDao.deletar(cod);
	}

	public boolean editar(Servico servico) {

		Servico getServicoDatabase = _servicoDao.getObj(servico.getId());

		if (getServicoDatabase != null) {

			String valor = servico.getValor().replace("R$", "");
			servico.setValor(valor);

			_servicoDao.merge(servico);
			return true;
		}
		return false;
	}

	public Servico getObj(Integer id) {

		Servico objLocalizado = _servicoDao.getObj(id);

		if (objLocalizado != null) {

			Double d = Double.parseDouble(objLocalizado.getValor());
			Locale ptBr = new Locale("pt", "BR");
			String valorEmReal = NumberFormat.getCurrencyInstance(ptBr).format(d);

			objLocalizado.setValor(valorEmReal.replace(",", "."));

			return objLocalizado;
		}

		return null;
	}

}