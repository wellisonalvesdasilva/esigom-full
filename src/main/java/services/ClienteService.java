package services;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import dto.DtoClientePesquisa;
import dto.DtoRetornoPaginado;
import model.Cliente;

import net.sf.jasperreports.engine.JRException;

public interface ClienteService {

	public void exportPdfFile() throws JRException, IOException, Exception;

	public DtoRetornoPaginado<Cliente> listAll(Integer pagina, DtoClientePesquisa dto);

	public void salvar(Cliente cliente);
	
	public boolean editar(Cliente cliente);

	Boolean deletar(Integer cod);

	Object getObj(Integer id) throws IllegalAccessException, InvocationTargetException;

}