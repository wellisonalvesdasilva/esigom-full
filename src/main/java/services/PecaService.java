package services;

import java.lang.reflect.InvocationTargetException;

import dto.DtoPecaPesquisa;
import dto.DtoRetornoPaginado;
import model.Cliente;
import model.Peca;

public interface PecaService {

	public DtoRetornoPaginado<Peca> listAll(Integer pagina, DtoPecaPesquisa dto) throws IllegalAccessException, InvocationTargetException;

	public void salvar(Peca peca);

	public boolean editar(Peca peca);

	Boolean deletar(Integer cod);

	Object getObj(Integer id) throws IllegalAccessException, InvocationTargetException;

}