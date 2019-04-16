package dao;
import java.io.Serializable;

import dto.DtoOrdemServicoPesquisa;
import dto.DtoRetornoPaginado;
import model.OrdemServico;

public interface OrdemServicoDao {

public DtoRetornoPaginado<DtoOrdemServicoPesquisa> listAll(Integer pagina, DtoOrdemServicoPesquisa dto) throws IllegalAccessException;

	//Serializable persist(OrdemServico OrdemServico);

//	boolean deletar(Integer id);

	//Peca getObj(Integer id);

//	void merge(Peca peca);

}