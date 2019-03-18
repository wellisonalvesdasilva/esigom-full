package com.servicesapi;

import com.dtos.DtoRetornoPaginado;
import com.dtos.DtoServicoPesquisa;
import com.entities.Servico;

public interface ServicoService {

	public DtoRetornoPaginado<Servico> listAll(Integer pagina, DtoServicoPesquisa dto);

	public void salvar(Servico servico);

	Boolean deletar(Integer cod);

	public boolean editar(Servico servico);

	Object getObj(Integer id);

}