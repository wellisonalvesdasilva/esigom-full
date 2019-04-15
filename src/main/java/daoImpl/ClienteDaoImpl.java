package daoImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SessionFactory;
import model.Cliente;
import dao.ClienteDao;
import dto.DtoClientePesquisa;
import dto.DtoRetornoPaginado;

@Repository
@Transactional
public class ClienteDaoImpl implements ClienteDao {

	@Autowired
	SessionFactory session;

	public Cliente getPorCpf(String cpf) {
		try {
			Cliente objRetorno = (Cliente) session.getCurrentSession()
					.createQuery("from Cliente as c where c.cpf like '%" + cpf + "%'").list().get(0);

			return objRetorno;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> lista() {
		return session.getCurrentSession().createQuery("from Cliente").list();
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public DtoRetornoPaginado<Cliente> list(Integer pagina, DtoClientePesquisa dto) {

		// Quantidade á ser pulada
		Integer offset = 10;

		@SuppressWarnings("rawtypes")
		DtoRetornoPaginado inst = new DtoRetornoPaginado();

		// # Preparar dados para retorno
		String parametrosAdicionais = "";
		String filtros = "";
		String ordenacao = "";

		// Prepara Filtros
		if (dto.getCod() != null) {
			filtros = "as u where u.id='" + dto.getCod() + "'";
		}

		if (dto.getNome() != "" && dto.getNome() != null) {
			if (filtros != "") {
				filtros = filtros + " and u.nome='" + dto.getNome() + "'";
			} else {
				filtros = "as u where u.nome='" + dto.getNome() + "'";
			}
		}

		if (dto.getCpf() != "" && dto.getCpf() != null) {
			if (filtros != "") {
				filtros = filtros + " and u.cpf='" + dto.getCpf() + "'";
			} else {
				filtros = "as u where u.cpf='" + dto.getCpf() + "'";
			}
		}

		if (dto.getRg() != "" && dto.getRg() != null) {
			if (filtros != "") {
				filtros = filtros + " and u.rg='" + dto.getRg() + "'";
			} else {
				filtros = "as u where u.rg='" + dto.getRg() + "'";
			}
		}

		if (dto.getEmail() != "" && dto.getEmail() != null) {
			if (filtros != "") {
				filtros = filtros + " and u.email='" + dto.getEmail() + "'";
			} else {
				filtros = "as u where u.email='" + dto.getEmail() + "'";
			}
		}

		if (dto.getCnpj() != "" && dto.getCnpj() != null) {
			if (filtros != "") {
				filtros = filtros + " and u.cnpj='" + dto.getCnpj() + "'";
			} else {
				filtros = "as u where u.cnpj='" + dto.getCnpj() + "'";
			}
		}

		if (dto.getTp_pessoa() != null && dto.getTp_pessoa() != "") {
			if (filtros != "") {
				filtros = filtros + " and u.tp_pessoa='" + dto.getTp_pessoa() + "'";
			} else {
				filtros = "as u where u.tp_pessoa='" + dto.getTp_pessoa() + "'";
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
			quantidade = session.getCurrentSession().createQuery("from Cliente as u").list().size();
			inst.setQtdTotalDeRegistros(quantidade);

			// Quantidade de Registros Encontrados na Página
			inst.setQtdRegistroPagina(session.getCurrentSession().createQuery("from Cliente").setMaxResults(offset)
					.setFirstResult(pagina * offset).list().size());
		}

		// Lista
		List<Cliente> listaParaFormatar = new ArrayList<Cliente>();

		if (parametrosAdicionais != "") {
			listaParaFormatar = (List<Cliente>) session.getCurrentSession()
					.createQuery("from Cliente " + parametrosAdicionais).setMaxResults(offset)
					.setFirstResult(pagina * offset).list();

			if (filtros != "") {
				inst.setQtdRegistroPagina(
						session.getCurrentSession().createQuery("from Cliente " + parametrosAdicionais)
								.setMaxResults(offset).setFirstResult(pagina * offset).list().size());
				quantidade = session.getCurrentSession().createQuery("from Cliente " + parametrosAdicionais).list()
						.size();
				inst.setQtdTotalDeRegistros(quantidade);
			}
		} else {
			listaParaFormatar = (List<Cliente>) session.getCurrentSession()
					.createQuery("from Cliente as u order by u.id asc").setMaxResults(offset)
					.setFirstResult(pagina * offset).list();
		}
		if (quantidade > 0) {
			Double quantidadeFormatada = quantidade.doubleValue() / offset;
			inst.setNumeroPaginas((int) Math.ceil(quantidadeFormatada));
		}

		List<DtoClientePesquisa> listaDto = new ArrayList<DtoClientePesquisa>();

		for (Cliente item : listaParaFormatar) {
			DtoClientePesquisa obj = new DtoClientePesquisa();

			obj.setCod(item.getId());
			obj.setNome(item.getNome());
			obj.setEmail(item.getEmail());

			String tipoDePessoa = "";
			if (item.getTp_pessoa() == 1) {
				tipoDePessoa = "Pessoa F�sica";
			} else if (item.getTp_pessoa() == 2) {
				tipoDePessoa = "Pessoa Jur�dica";
			}
			obj.setTp_pessoa(tipoDePessoa);
			obj.setCelular(item.getCelular());
			obj.setTelefone(item.getTelefone());

			listaDto.add(obj);
		}

		inst.setLista(listaDto);
		return inst;
	}

	public boolean deletar(Integer id) {
		Cliente ObjLocalizado = (Cliente) session.getCurrentSession()
				.createQuery("from Cliente as u where u.id = " + id).list().get(0);
		if (ObjLocalizado != null) {
			session.getCurrentSession().delete(ObjLocalizado);
			return true;
		}
		return false;
	}

	public Cliente getObj(Integer id) {

		Cliente ObjLocalizado = null;
		ObjLocalizado = (Cliente) session.getCurrentSession().createQuery("from Cliente as u where u.id = " + id).list()
				.get(0);

		if (ObjLocalizado != null) {
			return ObjLocalizado;
		}

		return null;
	}

	public void merge(Cliente clientes) {
		session.getCurrentSession().update(clientes);
	}

	public void persist(Cliente cliente) {
		session.getCurrentSession().save(cliente);
	}

}
