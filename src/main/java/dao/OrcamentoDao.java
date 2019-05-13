package dao;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import dto.DtoListaItensOrcamentoREL;
import dto.DtoOrcamentoPesquisa;
import dto.DtoRetornoPaginado;
import model.Orcamento;

public interface OrcamentoDao {

	public DtoRetornoPaginado<Orcamento> listAll(Integer pagina, DtoOrcamentoPesquisa dto)
			throws IllegalAccessException;

	public DtoListaItensOrcamentoREL getAll(HttpServletRequest request);

	Serializable persist(Orcamento orcamento);

	// boolean deletar(Integer id);

	Orcamento getObj(Integer id);

	// void merge(Peca peca);

}