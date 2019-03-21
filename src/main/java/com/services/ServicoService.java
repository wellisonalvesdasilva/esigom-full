package com.services;

import com.dto.DtoRetornoPaginado;
import com.dto.DtoServicoPesquisa;
import com.model.Servico;

public interface ServicoService {

	public DtoRetornoPaginado<Servico> listAll(Integer pagina, DtoServicoPesquisa dto);

	public void salvar(Servico servico);

	Boolean deletar(Integer cod);

	public boolean editar(Servico servico);

	Object getObj(Integer id);

}