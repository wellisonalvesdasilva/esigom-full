package com.daoapi;

import com.dtos.DtoRetornoPaginado;
import com.dtos.DtoServicoPesquisa;
import com.entities.Servico;

public interface ServicoDao {

	public DtoRetornoPaginado<Servico> listAll(Integer pagina, DtoServicoPesquisa dto);

	void persist(Servico servico);

	boolean deletar(Integer id);

	Servico getObj(Integer id);

	void merge(Servico users);

}