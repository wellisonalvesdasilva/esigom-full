package daoImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import model.OrdemServico;
import dao.OrdemServicoDao;
import dto.DtoOrdemServicoPesquisa;
import dto.DtoRetornoPaginado;

@Repository
@Transactional
public class OrdemServicoDaoImpl implements OrdemServicoDao {

	@Autowired
	SessionFactory session;
/*
	@SuppressWarnings("unchecked")
	public List<OrdemServico> lista(String nome) {
		return session.getCurrentSession().createQuery("from OrdemServico as os where p.descricao like '%" + nome + "%'").list();
	}
*/
	@SuppressWarnings({ "unchecked", "unused" })
	public DtoRetornoPaginado<DtoOrdemServicoPesquisa> listAll(Integer pagina, DtoOrdemServicoPesquisa dto) {

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
				parametrosAdicionais = "as os order by os." + dto.getColunaParaOrdenar() + " desc";
			}
		}

		// Consulta sem filtro
		Integer quantidade = 0;
		if (filtros == "") {
			// Quantidade Total de Registros
			quantidade = session.getCurrentSession().createQuery("from OrdemServico as os inner join fetch os.orcamento").list().size();
			inst.setQtdTotalDeRegistros(quantidade);

			// Quantidade de Registros Encontrados na Página
			inst.setQtdRegistroPagina(session.getCurrentSession().createQuery("from OrdemServico as os inner join fetch os.orcamento").setMaxResults(offset)
					.setFirstResult(pagina * offset).list().size());
		}

		// Lista
		List<OrdemServico> listaParaFormatar = new ArrayList<OrdemServico>();

		if (parametrosAdicionais != "") {
			listaParaFormatar = (List<OrdemServico>) session.getCurrentSession()
					.createQuery("from OrdemServico " + parametrosAdicionais).setMaxResults(offset)
					.setFirstResult(pagina * offset).list();

			if (filtros != "") {
				inst.setQtdRegistroPagina(session.getCurrentSession().createQuery("from OrdemServico " + parametrosAdicionais)
						.setMaxResults(offset).setFirstResult(pagina * offset).list().size());
				quantidade = session.getCurrentSession().createQuery("from OrdemServico " + parametrosAdicionais).list().size();
				inst.setQtdTotalDeRegistros(quantidade);
			}
		} else {
			listaParaFormatar = (List<OrdemServico>) session.getCurrentSession().createQuery("from OrdemServico as os inner join fetch os.orcamento order by os.id asc")
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
		OrdemServico ObjLocalizado = (OrdemServico) session.getCurrentSession().createQuery("from OrdemServico as os where u.id = " + id).list()
				.get(0);
		if (ObjLocalizado != null) {
			session.getCurrentSession().delete(ObjLocalizado);
			return true;
		}
		return false;
	}

	public OrdemServico getObj(Integer id) {

		OrdemServico ObjLocalizado = null;
		ObjLocalizado = (OrdemServico) session.getCurrentSession().createQuery("from OrdemServico as os where u.id = " + id).list()
				.get(0);

		if (ObjLocalizado != null) {
			return ObjLocalizado;
		}

		return null;
	}

	public void merge(OrdemServico OrdemServico) {
		session.getCurrentSession().update(OrdemServico);
	}

	public void persist(OrdemServico OrdemServico) {
		session.getCurrentSession().save(OrdemServico);
	}*/
}
