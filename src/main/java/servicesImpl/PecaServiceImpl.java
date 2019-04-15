package servicesImpl;
import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.PecaDao;
import dto.DtoPecaPesquisa;
import dto.DtoRetornoPaginado;
import model.Peca;
import services.PecaService;

@Service
public class PecaServiceImpl implements PecaService {

	@Autowired
	PecaDao _pecaDao;

	public DtoRetornoPaginado<Peca> listAll(Integer pagina, DtoPecaPesquisa dto)
			throws IllegalAccessException, InvocationTargetException {
		DtoRetornoPaginado<Peca> retorno = _pecaDao.listAll(pagina, dto);

		for (Peca item : retorno.getLista()) {
			Double d = Double.parseDouble(item.getValor());
			Locale ptBr = new Locale("pt", "BR");
			String valorEmReal = NumberFormat.getCurrencyInstance(ptBr).format(d);
			item.setValor(valorEmReal);
		}

		return retorno;
	}

	public void salvar(Peca peca) {
		peca.setDth_cadastro(new Date());
		_pecaDao.persist(peca);
	}

	public Boolean deletar(Integer cod) {
		return _pecaDao.deletar(cod);
	}

	public boolean editar(Peca peca) {

		Peca getPeca = _pecaDao.getObj(peca.getId());

		if (getPeca != null) {

			String valor = peca.getValor().replace("R$", "");
			peca.setValor(valor);
			peca.setDth_cadastro(getPeca.getDth_cadastro());

			_pecaDao.merge(peca);
			return true;
		}
		return false;
	}

	public Peca getObj(Integer id) {

		Peca objLocalizado = _pecaDao.getObj(id);

		if (objLocalizado != null) {

			Double d = Double.parseDouble(objLocalizado.getValor());
			Locale ptBr = new Locale("pt", "BR");
			String valorEmReal = NumberFormat.getCurrencyInstance(ptBr).format(d);

			objLocalizado.setValor(valorEmReal.replace(",", "."));

			return objLocalizado;
		}

		return null;
	}

}