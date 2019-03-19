package com.daoimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import com.daoapi.ClienteDao;
import com.daoapi.PecaDao;
import com.dtos.DtoRetornoPaginado;
import com.entities.Cliente;
import com.entities.Peca;
import com.dtos.DtoClientePesquisa;
import com.dtos.DtoPecaPesquisa;

@Repository
@Transactional
public class PecaDaoImpl implements PecaDao {

	@Autowired
	SessionFactory session;

	@SuppressWarnings("unchecked")
	public List<Peca> lista() {
		return session.getCurrentSession().createQuery("from Peca").list();
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public DtoRetornoPaginado<Peca> listAll(Integer pagina, DtoPecaPesquisa dto) {

		// Quantidade á ser pulada
		Integer offset = 10;

		@SuppressWarnings("rawtypes")
		DtoRetornoPaginado inst = new DtoRetornoPaginado();

		// # Preparar dados para retorno
		String parametrosAdicionais = "";
		String filtros = "";
		String ordenacao = "";

		// Incluir filtros aos parâmetros caso há algum preenchido
		if (filtros != null || filtros != "") {
			parametrosAdicionais = filtros;
		}

		// Ordenação
		if (dto.getColunaParaOrdenar() != null && dto.getColunaParaOrdenar() != "") {
			if (parametrosAdicionais != "") {
				parametrosAdicionais = parametrosAdicionais + "order by p." + dto.getColunaParaOrdenar() + " desc";
			} else {
				parametrosAdicionais = "as p order by u." + dto.getColunaParaOrdenar() + " desc";
			}
		}

		// Consulta sem filtro
		Integer quantidade = 0;
		if (filtros == "") {
			// Quantidade Total de Registros
			quantidade = session.getCurrentSession().createQuery("from Peca as p").list().size();
			inst.setQtdTotalDeRegistros(quantidade);

			// Quantidade de Registros Encontrados na Página
			inst.setQtdRegistroPagina(session.getCurrentSession().createQuery("from Peca").setMaxResults(offset)
					.setFirstResult(pagina * offset).list().size());
		}

		// Lista
		List<Peca> listaParaFormatar = new ArrayList<Peca>();

		if (parametrosAdicionais != "") {
			listaParaFormatar = (List<Peca>) session.getCurrentSession()
					.createQuery("from Peca " + parametrosAdicionais).setMaxResults(offset)
					.setFirstResult(pagina * offset).list();

			if (filtros != "") {
				inst.setQtdRegistroPagina(session.getCurrentSession().createQuery("from Peca " + parametrosAdicionais)
						.setMaxResults(offset).setFirstResult(pagina * offset).list().size());
				quantidade = session.getCurrentSession().createQuery("from Peca " + parametrosAdicionais).list().size();
				inst.setQtdTotalDeRegistros(quantidade);
			}
		} else {
			listaParaFormatar = (List<Peca>) session.getCurrentSession().createQuery("from Peca as u order by u.id asc")
					.setMaxResults(offset).setFirstResult(pagina * offset).list();
		}
		if (quantidade > 0) {
			Double quantidadeFormatada = quantidade.doubleValue() / offset;
			inst.setNumeroPaginas((int) Math.ceil(quantidadeFormatada));
		}

		List<DtoClientePesquisa> listaDto = new ArrayList<DtoClientePesquisa>();
		inst.setLista(listaParaFormatar);
		return inst;
	}

	public boolean deletar(Integer id) {
		Peca ObjLocalizado = (Peca) session.getCurrentSession()
				.createQuery("from Peca as u where u.id = " + id).list().get(0);
		if (ObjLocalizado != null) {
			session.getCurrentSession().delete(ObjLocalizado);
			return true;
		}
		return false;
	}

	public Peca getObj(Integer id) {

		Peca ObjLocalizado = null;
		ObjLocalizado = (Peca) session.getCurrentSession().createQuery("from Peca as u where u.id = " + id).list()
				.get(0);

		if (ObjLocalizado != null) {
			return ObjLocalizado;
		}

		return null;
	}

	public void merge(Peca peca) {
		session.getCurrentSession().update(peca);
	}

	public void persist(Peca peca) {
		session.getCurrentSession().save(peca);
	}



}
