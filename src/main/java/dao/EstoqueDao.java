package dao;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import dto.DtoEstoquePesquisa;
import dto.DtoRetornoPaginado;
import model.Estoque;

public interface EstoqueDao {

	public DtoRetornoPaginado<Estoque> listAll(Integer pagina, DtoEstoquePesquisa dto)
			throws IllegalAccessException, InvocationTargetException;

	/*List<Estoque> lista(String nome);

	void persist(Estoque Estoque);

	boolean deletar(Integer id);

	Estoque getObj(Integer id);

	void merge(Estoque Estoque);*/

}