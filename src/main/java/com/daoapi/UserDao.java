package com.daoapi;

import java.util.List;

import com.entities.Usuario;

public interface UserDao {

	Usuario findById(int id);

	Usuario findBySSO(String sso);

	void save(Usuario user);

	void deleteBySSO(String sso);

	List<Usuario> findAllUsers();

}
