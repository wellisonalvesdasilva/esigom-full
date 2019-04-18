package dao;
import java.io.Serializable;

import dto.DtoVendaPesquisa;
import dto.DtoRetornoPaginado;
import model.Venda;

public interface VendaDao {

public DtoRetornoPaginado<Venda> listAll(Integer pagina, DtoVendaPesquisa dto) throws IllegalAccessException;

	//Serializable persist(Venda venda);

//	boolean deletar(Integer id);

	//Peca getObj(Integer id);

//	void merge(Peca peca);

}