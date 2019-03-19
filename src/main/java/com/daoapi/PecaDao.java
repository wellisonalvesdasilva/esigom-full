package com.daoapi;

import com.dtos.DtoPecaPesquisa;
import com.dtos.DtoRetornoPaginado;
import com.entities.Peca;
import com.entities.Servico;

public interface PecaDao {

	public DtoRetornoPaginado<Peca> listAll(Integer pagina, DtoPecaPesquisa dto);

	void persist(Peca peca);

	boolean deletar(Integer id);

	Peca getObj(Integer id);

	void merge(Peca peca);

}