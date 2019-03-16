package com.servicesimpl;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
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
		DtoRetornoPaginado<Servico> retorno = _servicoDao.list(pagina, dto);
		return retorno;
	}
/*
	public void salvar(Servico servico) {
		servico.setDth_cadastro(new Date());
		_ServicoDao.persist(Servico);
	}

	public boolean editar(Servico Servico) {

		Servico instPesquisa = _ServicoDao.getObj(Servico.getId());

		if (instPesquisa != null) {
			_ServicoDao.merge(Servico);
			return true;
		}
		return false;
	}

	public Boolean deletar(Integer cod) {
		return _ServicoDao.deletar(cod);
	}

	public DtoEditarServico getObj(Integer id) throws IllegalAccessException, InvocationTargetException {

		Servico objLocalizado = _servicoDao.getObj(id);

		if (objLocalizado != null) {
			DtoEditarServico Servico = new DtoEditarServico();
			BeanUtils.copyProperties(Servico, objLocalizado);

			Date data = Servico.getDt_nascimento();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String dataFormatada = formato.format(data);
			Servico.setDataFormatada(dataFormatada);

			return Servico;
		}

		return null;
	}*/

}