package daoImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import model.Venda;
import dao.VendaDao;
import dto.DtoVendaPesquisa;
import dto.DtoRetornoPaginado;

@Repository
@Transactional
public class VendaDaoImpl implements VendaDao {

	@Autowired
	SessionFactory session;

	@SuppressWarnings({ "unchecked", "unused" })
	public DtoRetornoPaginado<Venda> listAll(Integer pagina, DtoVendaPesquisa dto) {

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
			quantidade = session.getCurrentSession().createQuery("from Venda as v").list().size();
			inst.setQtdTotalDeRegistros(quantidade);

			// Quantidade de Registros Encontrados na Página
			inst.setQtdRegistroPagina(session.getCurrentSession().createQuery("from Venda").setMaxResults(offset)
					.setFirstResult(pagina * offset).list().size());
		}

		// Lista
		List<Venda> listaParaFormatar = new ArrayList<Venda>();

		if (parametrosAdicionais != "") {
			listaParaFormatar = (List<Venda>) session.getCurrentSession()
					.createQuery("from Venda " + parametrosAdicionais).setMaxResults(offset)
					.setFirstResult(pagina * offset).list();

			if (filtros != "") {
				inst.setQtdRegistroPagina(session.getCurrentSession().createQuery("from Venda " + parametrosAdicionais)
						.setMaxResults(offset).setFirstResult(pagina * offset).list().size());
				quantidade = session.getCurrentSession().createQuery("from Venda " + parametrosAdicionais).list().size();
				inst.setQtdTotalDeRegistros(quantidade);
			}
		} else {
			listaParaFormatar = (List<Venda>) session.getCurrentSession().createQuery("from Venda as v order by v.id asc")
					.setMaxResults(offset).setFirstResult(pagina * offset).list();
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
		Venda ObjLocalizado = (Venda) session.getCurrentSession().createQuery("from Venda as u where u.id = " + id).list()
				.get(0);
		if (ObjLocalizado != null) {
			session.getCurrentSession().delete(ObjLocalizado);
			return true;
		}
		return false;
	}

	public Venda getObj(Integer id) {

		Venda ObjLocalizado = null;
		ObjLocalizado = (Venda) session.getCurrentSession().createQuery("from Venda as u where u.id = " + id).list()
				.get(0);

		if (ObjLocalizado != null) {
			return ObjLocalizado;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Venda> lista(String nome) {
		return session.getCurrentSession().createQuery("from Venda as v where p.descricao like '%" + nome + "%'").list();
	}
	
	public void merge(Venda Venda) {
		session.getCurrentSession().update(Venda);
	}

	public void persist(Venda Venda) {
		session.getCurrentSession().save(Venda);
	}*/
}
