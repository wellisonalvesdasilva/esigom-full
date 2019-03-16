package com.daoapi;
import com.dtos.DtoRetornoPaginado;
import com.dtos.DtoServicoPesquisa;
import com.entities.Servico;

public interface ServicoDao {

	public DtoRetornoPaginado<Servico> list(Integer pagina, DtoServicoPesquisa dto);
/*
	public List<Cliente> lista();

	Cliente getObj(Integer id);

	boolean deletar(Integer id);

	void merge(Cliente users);

	void persist(Cliente users);
*/}