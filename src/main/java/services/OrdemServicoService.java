package services;
import java.io.Serializable;
import dto.DtoOrdemServicoPesquisa;
import dto.DtoRetornoPaginado;

public interface OrdemServicoService {
	
	//Serializable saveOrdemServico(Object dto);

	DtoRetornoPaginado<DtoOrdemServicoPesquisa> listAll(Integer pagina, DtoOrdemServicoPesquisa dto)
			throws IllegalAccessException;
}