package com.dao;

import java.util.List;

import com.model.Usuario;

public interface UserDao {

	Usuario findById(int id);

	Usuario findBySSO(String sso);

	void save(Usuario user);

	void deleteBySSO(String sso);

	List<Usuario> findAllUsers();

}
