package daoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import dao.OrcamentoDao;
import dto.DtoListaItensOrcamentoREL;
import dto.DtoOrcamentoPesquisa;
import dto.DtoRetornoPaginado;
import model.Cliente;
import model.Orcamento;
import model.Orcamento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;

@Repository
@Transactional
public class OrcamentoDaoImpl implements OrcamentoDao {

	@Autowired
	SessionFactory session;

	public DtoListaItensOrcamentoREL getAll(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public Serializable persist(Orcamento orcamento) {
		return session.getCurrentSession().save(orcamento);
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public DtoRetornoPaginado<Orcamento> listAll(Integer pagina, DtoOrcamentoPesquisa dto) {

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

		// Ordena��o
		if (dto.getColunaParaOrdenar() != null && dto.getColunaParaOrdenar() != "") {
			if (parametrosAdicionais != "") {
				parametrosAdicionais = parametrosAdicionais + "order by o." + dto.getColunaParaOrdenar() + " desc";
			} else {
				parametrosAdicionais = "as o order by o." + dto.getColunaParaOrdenar() + " desc";
			}
		}

		// Consulta sem filtro
		Integer quantidade = 0;
		if (filtros == "") {
			// Quantidade Total de Registros
			quantidade = session.getCurrentSession().createQuery("from Orcamento as o inner join fetch o.cliente")
					.list().size();
			inst.setQtdTotalDeRegistros(quantidade);

			// Quantidade de Registros Encontrados na Página
			inst.setQtdRegistroPagina(
					session.getCurrentSession().createQuery("from Orcamento as o inner join fetch o.cliente")
							.setMaxResults(offset).setFirstResult(pagina * offset).list().size());
		}

		// Lista
		List<Orcamento> listaParaFormatar = new ArrayList<Orcamento>();

		if (parametrosAdicionais != "") {
			listaParaFormatar = (List<Orcamento>) session.getCurrentSession()
					.createQuery("from Orcamento as o inner join fetch o.cliente " + parametrosAdicionais)
					.setMaxResults(offset).setFirstResult(pagina * offset).list();

			if (filtros != "") {
				inst.setQtdRegistroPagina(session.getCurrentSession()
						.createQuery("from Orcamento as o inner join fetch o.cliente " + parametrosAdicionais)
						.setMaxResults(offset).setFirstResult(pagina * offset).list().size());
				quantidade = session.getCurrentSession()
						.createQuery("from Orcamento as o inner join fetch o.cliente " + parametrosAdicionais).list()
						.size();
				inst.setQtdTotalDeRegistros(quantidade);
			}
		} else {
			listaParaFormatar = (List<Orcamento>) session.getCurrentSession()
					.createQuery("from Orcamento as o inner join fetch o.cliente order by o.id asc")
					.setMaxResults(offset).setFirstResult(pagina * offset).list();
		}
		if (quantidade > 0) {
			Double quantidadeFormatada = quantidade.doubleValue() / offset;
			inst.setNumeroPaginas((int) Math.ceil(quantidadeFormatada));
		}

		inst.setLista(listaParaFormatar);

		return inst;
	}

}
