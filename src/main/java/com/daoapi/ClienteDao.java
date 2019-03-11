package com.daoapi;

import java.security.NoSuchAlgorithmException;

import java.util.List;

import com.dtos.DtoRetornoPaginado;
import com.entities.Cliente;
import com.dtos.DtoClientePesquisa;

public interface ClienteDao {

	public DtoRetornoPaginado<Cliente> list(Integer pagina, DtoClientePesquisa dto);

	public List<Cliente> lista();

	Cliente getObj(Integer id, String login, String senha) throws NoSuchAlgorithmException;

	boolean deletar(Integer id);

	void merge(Cliente users);

	void persist(Cliente users);
}