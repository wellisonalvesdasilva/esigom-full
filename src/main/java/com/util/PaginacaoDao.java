/*import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.dtos.DtoRetornoPaginado;
import com.dtos.DtoServicoPesquisa;
import com.entities.Servico;

@SuppressWarnings({ "unchecked", "unused" })
	public DtoRetornoPaginado<Servico> list(Integer pagina, DtoServicoPesquisa dto) {

		// Quantidade � ser pulada
		Integer offset = PaginacaoDao.offset;

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

		// Incluir filtros aos par�metros caso h� algum preenchido
		if (filtros != null || filtros != "") {
			parametrosAdicionais = filtros;
		}

		// Ordena��o
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

			// Quantidade de Registros Encontrados na P�gina
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

			Double d = item.getValor();
			Locale ptBr = new Locale("pt", "BR");
			String valorEmReal = NumberFormat.getCurrencyInstance(ptBr).format(d);
			obj.setValorFormatado((valorEmReal));

			listaDto.add(obj);
		}

		inst.setLista(listaDto);
		return inst;
	}*/