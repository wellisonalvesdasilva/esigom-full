package com.servicesapi;

import java.lang.reflect.InvocationTargetException;
import com.dtos.DtoPecaPesquisa;
import com.dtos.DtoRetornoPaginado;
import com.entities.Cliente;
import com.entities.Peca;

public interface PecaService {

	public DtoRetornoPaginado<Peca> listAll(Integer pagina, DtoPecaPesquisa dto);

	public void salvar(Peca peca);

	public boolean editar(Peca peca);

	Boolean deletar(Integer cod);

	Object getObj(Integer id) throws IllegalAccessException, InvocationTargetException;

}