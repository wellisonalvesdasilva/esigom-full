package com.dao;

import java.lang.reflect.InvocationTargetException;

import com.dto.DtoPecaPesquisa;
import com.dto.DtoRetornoPaginado;
import com.model.Peca;
import com.model.Servico;

public interface PecaDao {

	public DtoRetornoPaginado<Peca> listAll(Integer pagina, DtoPecaPesquisa dto) throws IllegalAccessException, InvocationTargetException;

	void persist(Peca peca);

	boolean deletar(Integer id);

	Peca getObj(Integer id);

	void merge(Peca peca);

}