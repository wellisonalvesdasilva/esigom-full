package services;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import dto.DtoVendaPesquisa;
import dto.DtoRetornoPaginado;
import model.Venda;

import net.sf.jasperreports.engine.JRException;

public interface VendaService {

	//public void exportPdfFile() throws JRException, IOException, Exception;

	public DtoRetornoPaginado<Venda> listAll(Integer pagina, DtoVendaPesquisa dto) throws IllegalAccessException;

//	public void salvar(Venda Venda);
	
	//public boolean editar(Venda Venda);

	//Boolean deletar(Integer cod);

//	Object getObj(Integer id) throws IllegalAccessException, InvocationTargetException;

}