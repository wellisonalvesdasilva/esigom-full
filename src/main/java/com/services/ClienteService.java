package com.services;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.dto.DtoClientePesquisa;
import com.dto.DtoRetornoPaginado;
import com.model.Cliente;

import net.sf.jasperreports.engine.JRException;

public interface ClienteService {

	public void exportPdfFile() throws JRException, IOException, Exception;

	public DtoRetornoPaginado<Cliente> listAll(Integer pagina, DtoClientePesquisa dto);

	public void salvar(Cliente cliente);
	
	public boolean editar(Cliente cliente);

	Boolean deletar(Integer cod);

	Object getObj(Integer id) throws IllegalAccessException, InvocationTargetException;

}