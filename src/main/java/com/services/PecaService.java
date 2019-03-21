package com.services;

import java.lang.reflect.InvocationTargetException;

import com.dto.DtoPecaPesquisa;
import com.dto.DtoRetornoPaginado;
import com.model.Cliente;
import com.model.Peca;

public interface PecaService {

	public DtoRetornoPaginado<Peca> listAll(Integer pagina, DtoPecaPesquisa dto) throws IllegalAccessException, InvocationTargetException;

	public void salvar(Peca peca);

	public boolean editar(Peca peca);

	Boolean deletar(Integer cod);

	Object getObj(Integer id) throws IllegalAccessException, InvocationTargetException;

}