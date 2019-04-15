package daoImpl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;

import dao.ServicoDao;
import dto.DtoRetornoPaginado;
import dto.DtoServicoPesquisa;
import model.Peca;
import model.Servico;

@Repository
@Transactional
public class ServicoDaoImpl implements ServicoDao {

	@Autowired
	SessionFactory session;

	@SuppressWarnings("unchecked")
	public List<Servico> lista(String nome) {
		return session.getCurrentSession().createQuery("from Servico as s where s.descricao like '%" + nome + "%'")
				.list();
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public DtoRetornoPaginado<Servico> listAll(Integer pagina, DtoServicoPesquisa dto) {

		// Quantidade á ser pulada
		Integer offset = 10;

		@SuppressWarnings("rawtypes")
		DtoRetornoPaginado inst = new DtoRetornoPaginado();

		// # Preparar dados para retorno
		String parametrosAdicionais = "";
		String filtros = "";
		String ordenacao = "";

		// Prepara Filtros
		if (dto.getId() != null) {
			filtros = "as u where u.id='" + dto.getId() + "'";
		}

		if (dto.getDescricao() != "" && dto.getDescricao() != null) {
			if (filtros != "") {
				filtros = filtros + " and u.descricao like '%" + dto.getDescricao() + "%'";
			} else {
				filtros = "as u where u.descricao like '%" + dto.getDescricao() + "%'";
			}
		}

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
			quantidade = session.getCurrentSession().createQuery("from Servico as u").list().size();
			inst.setQtdTotalDeRegistros(quantidade);

			// Quantidade de Registros Encontrados na Página
			inst.setQtdRegistroPagina(session.getCurrentSession().createQuery("from Servico").setMaxResults(offset)
					.setFirstResult(pagina * offset).list().size());
		}

		// Lista
		List<Servico> listaParaFormatar = new ArrayList<Servico>();

		if (parametrosAdicionais != "") {
			listaParaFormatar = (List<Servico>) session.getCurrentSession()
					.createQuery("from Servico " + parametrosAdicionais).setMaxResults(offset)
					.setFirstResult(pagina * offset).list();

			if (filtros != "") {
				inst.setQtdRegistroPagina(
						session.getCurrentSession().createQuery("from Servico " + parametrosAdicionais)
								.setMaxResults(offset).setFirstResult(pagina * offset).list().size());
				quantidade = session.getCurrentSession().createQuery("from Servico " + parametrosAdicionais).list()
						.size();
				inst.setQtdTotalDeRegistros(quantidade);
			}
		} else {
			listaParaFormatar = (List<Servico>) session.getCurrentSession()
					.createQuery("from Servico as u order by u.id asc").setMaxResults(offset)
					.setFirstResult(pagina * offset).list();
		}
		if (quantidade > 0) {
			Double quantidadeFormatada = quantidade.doubleValue() / offset;
			inst.setNumeroPaginas((int) Math.ceil(quantidadeFormatada));
		}

		List<DtoServicoPesquisa> listaDto = new ArrayList<DtoServicoPesquisa>();

		for (Servico item : listaParaFormatar) {
			DtoServicoPesquisa obj = new DtoServicoPesquisa();

			obj.setDescricao(item.getDescricao());
			obj.setId(item.getId());

			Double d = Double.parseDouble(item.getValor());
			Locale ptBr = new Locale("pt", "BR");
			String valorEmReal = NumberFormat.getCurrencyInstance(ptBr).format(d);
			obj.setValorFormatado((valorEmReal));

			listaDto.add(obj);
		}

		inst.setLista(listaDto);
		return inst;
	}

	public boolean deletar(Integer id) {
		Servico ObjLocalizado = (Servico) session.getCurrentSession()
				.createQuery("from Servico as u where u.id = " + id).list().get(0);
		if (ObjLocalizado != null) {
			session.getCurrentSession().delete(ObjLocalizado);
			return true;
		}
		return false;
	}

	public Servico getObj(Integer id) {

		Servico ObjLocalizado = null;
		ObjLocalizado = (Servico) session.getCurrentSession().createQuery("from Servico as u where u.id = " + id).list()
				.get(0);

		if (ObjLocalizado != null) {
			return ObjLocalizado;
		}

		return null;
	}

	public void persist(Servico servico) {
		session.getCurrentSession().save(servico);
	}

	public void merge(Servico servico) {
		session.getCurrentSession().update(servico);
	}

}
