package com.daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import com.model.Orcamento;
import com.dao.OrcamentoDao;

@Repository
@Transactional
public class OrcamentoDaoImpl implements OrcamentoDao {

	@Autowired
	SessionFactory session;

	public void persist(Orcamento orcamento) {
		session.getCurrentSession().save(orcamento);
	}

}
