/*package com.daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;

import com.model.Cliente;
import com.dao.ClienteDao;
import com.dto.DtoClientePesquisa;
import com.dto.DtoRetornoPaginado;

@Repository
@Transactional
public class OrdemServicoDaoImpl implements ClienteDao {

	@Autowired
	SessionFactory session;

	@SuppressWarnings("unchecked")
	public List<OrdemServico> lista() {
		return session.getCurrentSession().createQuery("from Cliente").list();
	}


}
*/