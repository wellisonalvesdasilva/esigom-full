package dao;

import java.util.List;

import dto.DtoClientePesquisa;
import dto.DtoRetornoPaginado;
import model.Cliente;

public interface ClienteDao {

	public DtoRetornoPaginado<Cliente> list(Integer pagina, DtoClientePesquisa dto);

	public List<Cliente> lista();

	Cliente getObj(Integer id);

	Cliente getPorCpf(String cpf);
	
	boolean deletar(Integer id);

	void merge(Cliente users);

	void persist(Cliente users);
}