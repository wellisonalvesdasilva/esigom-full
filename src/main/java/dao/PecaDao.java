package dao;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import dto.DtoPecaPesquisa;
import dto.DtoRetornoPaginado;
import model.Peca;

public interface PecaDao {

	public DtoRetornoPaginado<Peca> listAll(Integer pagina, DtoPecaPesquisa dto)
			throws IllegalAccessException, InvocationTargetException;

	List<Peca> lista(String nome);

	void persist(Peca peca);

	boolean deletar(Integer id);

	Peca getObj(Integer id);

	void merge(Peca peca);

}