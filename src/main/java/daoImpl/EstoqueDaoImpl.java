package daoImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import model.Estoque;
import dao.EstoqueDao;
import dto.DtoEstoquePesquisa;
import dto.DtoRetornoPaginado;

@Repository
@Transactional
public class EstoqueDaoImpl implements EstoqueDao {

	@Autowired
	SessionFactory session;

	/*
	 * public Estoque getPorCpf(String cpf) { try { Estoque objRetorno =
	 * (Estoque) session.getCurrentSession()
	 * .createQuery("from Estoque as c where c.cpf like '%" + cpf +
	 * "%'").list().get(0);
	 * 
	 * return objRetorno; } catch (Exception e) { return null; } }
	 * 
	 * @SuppressWarnings("unchecked") public List<Estoque> lista() { return
	 * session.getCurrentSession().createQuery("from Estoque").list(); }
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public DtoRetornoPaginado<Estoque> listAll(Integer pagina, DtoEstoquePesquisa dto) {

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
				parametrosAdicionais = parametrosAdicionais + "order by u." + dto.getColunaParaOrdenar() + " desc";
			} else {
				parametrosAdicionais = "as u order by u." + dto.getColunaParaOrdenar() + " desc";
			}
		}

		// Consulta sem filtro
		Integer quantidade = 0;
		if (filtros == "") {
			// Quantidade Total de Registros
			quantidade = session.getCurrentSession().createQuery("from Estoque as e inner join fetch e.peca").list().size();
			inst.setQtdTotalDeRegistros(quantidade);

			// Quantidade de Registros Encontrados na Página
			inst.setQtdRegistroPagina(session.getCurrentSession().createQuery("from Estoque as e inner join fetch e.peca").setMaxResults(offset)
					.setFirstResult(pagina * offset).list().size());
		}

		// Lista
		List<Estoque> listaParaFormatar = new ArrayList<Estoque>();

		if (parametrosAdicionais != "") {
			listaParaFormatar = (List<Estoque>) session.getCurrentSession()
					.createQuery("from Estoque " + parametrosAdicionais).setMaxResults(offset)
					.setFirstResult(pagina * offset).list();

			if (filtros != "") {
				inst.setQtdRegistroPagina(
						session.getCurrentSession().createQuery("from Estoque as e inner join fetch e.peca " + parametrosAdicionais)
								.setMaxResults(offset).setFirstResult(pagina * offset).list().size());
				quantidade = session.getCurrentSession().createQuery("from Estoque as e inner join fetch e.peca" + parametrosAdicionais).list()
						.size();
				inst.setQtdTotalDeRegistros(quantidade);
			}
		} else {
			listaParaFormatar = (List<Estoque>) session.getCurrentSession()
					.createQuery("from Estoque as e inner join fetch e.peca order by e.id asc").setMaxResults(offset)
					.setFirstResult(pagina * offset).list();
		}
		if (quantidade > 0) {
			Double quantidadeFormatada = quantidade.doubleValue() / offset;
			inst.setNumeroPaginas((int) Math.ceil(quantidadeFormatada));
		}

		inst.setLista(listaParaFormatar);
		return inst;
	}
/*
	public boolean deletar(Integer id) {
		Estoque ObjLocalizado = (Estoque) session.getCurrentSession()
				.createQuery("from Estoque as e where u.id = " + id).list().get(0);
		if (ObjLocalizado != null) {
			session.getCurrentSession().delete(ObjLocalizado);
			return true;
		}
		return false;
	}

	public Estoque getObj(Integer id) {

		Estoque ObjLocalizado = null;
		ObjLocalizado = (Estoque) session.getCurrentSession().createQuery("from Estoque as e where e.id = " + id).list()
				.get(0);

		if (ObjLocalizado != null) {
			return ObjLocalizado;
		}

		return null;
	}

	public void merge(Estoque Estoques) {
		session.getCurrentSession().update(Estoques);
	}

	public void persist(Estoque Estoque) {
		session.getCurrentSession().save(Estoque);
	}
*/
}
