package services;

import java.io.Serializable;

import dto.DtoClientePesquisa;
import dto.DtoListaPeca;
import dto.DtoOrcamentoPesquisa;
import dto.DtoRetornoPaginado;
import model.Cliente;
import model.Orcamento;
import net.sf.jasperreports.engine.JRException;

public interface OrcamentoService {
	DtoListaPeca getPesquisaPeca(String nome);

	DtoListaPeca getPesquisaServico(String nome);

	Serializable salvarOrcamento(Object dto);

	Cliente getCliente(String cpf);

	DtoRetornoPaginado<DtoOrcamentoPesquisa> listAll(Integer pagina, DtoOrcamentoPesquisa dto) throws IllegalAccessException;
}