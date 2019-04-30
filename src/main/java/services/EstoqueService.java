package services;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import dto.DtoEstoquePesquisa;
import dto.DtoRetornoPaginado;
import model.Estoque;
import model.Estoque;
import net.sf.jasperreports.engine.JRException;

public interface EstoqueService {

	public DtoRetornoPaginado<Estoque> listAll(Integer pagina, DtoEstoquePesquisa dto) throws IllegalAccessException, InvocationTargetException;

/* 	public void exportPdfFile() throws JRException, IOException, Exception;
	
	public void salvar(Estoque Estoque);
	
	public boolean editar(Estoque Estoque);

	Boolean deletar(Integer cod);

	Object getObj(Integer id) throws IllegalAccessException, InvocationTargetException;
*/
}