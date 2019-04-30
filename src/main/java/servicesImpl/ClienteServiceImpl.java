package servicesImpl;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClienteDao;
import dto.DtoClientePesquisa;
import dto.DtoEditarCliente;
import dto.DtoRetornoPaginado;
import model.Cliente;
import reports.ClienteREL;
import services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteDao _clienteDao;

	@SuppressWarnings("unchecked")
	public void exportPdfFile() throws Exception {
		ClienteREL novo = new ClienteREL();
		Object retornoBanco = _clienteDao.lista();
		novo.imprimir((List<Cliente>) retornoBanco);
	}

	public DtoRetornoPaginado<Cliente> listAll(Integer pagina, DtoClientePesquisa dto) {

		DtoRetornoPaginado<Cliente> retorno = _clienteDao.list(pagina, dto);

		return retorno;
	}

	public void salvar(Cliente cliente) {
		cliente.setDth_cadastro(new Date());
		_clienteDao.persist(cliente);
	}

	public boolean editar(Cliente cliente) {

		Cliente instPesquisa = _clienteDao.getObj(cliente.getId());

		if (instPesquisa != null) {
			_clienteDao.merge(cliente);
			return true;
		}
		return false;
	}

	public Boolean deletar(Integer cod) {
		return _clienteDao.deletar(cod);
	}

	public DtoEditarCliente getObj(Integer id) throws IllegalAccessException, InvocationTargetException {

		Cliente objLocalizado = _clienteDao.getObj(id);

		if (objLocalizado != null) {
			DtoEditarCliente cliente = new DtoEditarCliente();
			BeanUtils.copyProperties(cliente, objLocalizado);

			Date data = cliente.getDt_nascimento();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			String dataFormatada = formato.format(data);
			cliente.setDataFormatada(dataFormatada);

			return cliente;
		}

		return null;
	}

}