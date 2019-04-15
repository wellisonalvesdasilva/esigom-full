package dao;
import java.util.List;
import dto.DtoRetornoPaginado;
import dto.DtoServicoPesquisa;
import model.Servico;

public interface ServicoDao {

	List<Servico> lista(String nome);
	
	public DtoRetornoPaginado<Servico> listAll(Integer pagina, DtoServicoPesquisa dto);

	void persist(Servico servico);

	boolean deletar(Integer id);

	Servico getObj(Integer id);

	void merge(Servico users);

}