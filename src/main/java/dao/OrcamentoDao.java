package dao;
import java.io.Serializable;

import dto.DtoOrcamentoPesquisa;
import dto.DtoRetornoPaginado;
import model.Orcamento;

public interface OrcamentoDao {

public DtoRetornoPaginado<Orcamento> listAll(Integer pagina, DtoOrcamentoPesquisa dto) throws IllegalAccessException;

	Serializable persist(Orcamento orcamento);

//	boolean deletar(Integer id);

	//Peca getObj(Integer id);

//	void merge(Peca peca);

}