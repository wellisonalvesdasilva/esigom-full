package com.dao;

import java.util.List;

import com.dto.DtoClientePesquisa;
import com.dto.DtoRetornoPaginado;
import com.model.Cliente;

public interface ClienteDao {

	public DtoRetornoPaginado<Cliente> list(Integer pagina, DtoClientePesquisa dto);

	public List<Cliente> lista();

	Cliente getObj(Integer id);

	boolean deletar(Integer id);

	void merge(Cliente users);

	void persist(Cliente users);
}