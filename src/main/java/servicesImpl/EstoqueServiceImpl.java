package servicesImpl;
import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.EstoqueDao;
import dto.DtoEstoquePesquisa;
import dto.DtoRetornoPaginado;
import model.Estoque;
import services.EstoqueService;

@Service
public class EstoqueServiceImpl implements EstoqueService {

	@Autowired
	EstoqueDao _estoqueDao;

	public DtoRetornoPaginado<Estoque> listAll(Integer pagina, DtoEstoquePesquisa dto)
			throws IllegalAccessException, InvocationTargetException {
		return _estoqueDao.listAll(pagina, dto);
	}
/*
	public void salvar(Estoque Estoque) {
		Estoque.setDth_cadastro(new Date());
		_EstoqueDao.persist(Estoque);
	}

	public Boolean deletar(Integer cod) {
		return _EstoqueDao.deletar(cod);
	}

	public boolean editar(Estoque Estoque) {

		Estoque getEstoque = _EstoqueDao.getObj(Estoque.getId());

		if (getEstoque != null) {

			String valor = Estoque.getValor().replace("R$", "");
			Estoque.setValor(valor);
			Estoque.setDth_cadastro(getEstoque.getDth_cadastro());

			_EstoqueDao.merge(Estoque);
			return true;
		}
		return false;
	}

	public Estoque getObj(Integer id) {

		Estoque objLocalizado = _EstoqueDao.getObj(id);

		if (objLocalizado != null) {

			Double d = Double.parseDouble(objLocalizado.getValor());
			Locale ptBr = new Locale("pt", "BR");
			String valorEmReal = NumberFormat.getCurrencyInstance(ptBr).format(d);

			objLocalizado.setValor(valorEmReal.replace(",", "."));

			return objLocalizado;
		}

		return null;
	}
*/
}