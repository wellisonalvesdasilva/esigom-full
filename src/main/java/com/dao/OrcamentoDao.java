package com.dao;


import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import com.dto.DtoPecaPesquisa;
import com.dto.DtoRetornoPaginado;
import com.model.Orcamento;
import com.model.Peca;
import com.model.Servico;

public interface OrcamentoDao {

	//public DtoRetornoPaginado<Peca> listAll(Integer pagina, DtoPecaPesquisa dto) throws IllegalAccessException, InvocationTargetException;

	void persist(Orcamento orcamento);

//	boolean deletar(Integer id);

	//Peca getObj(Integer id);

//	void merge(Peca peca);

}