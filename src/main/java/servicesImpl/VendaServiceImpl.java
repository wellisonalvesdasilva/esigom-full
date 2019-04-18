package servicesImpl;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ClienteDao;
import dao.VendaDao;
import dto.DtoClientePesquisa;
import dto.DtoEditarCliente;
import dto.DtoRetornoPaginado;
import dto.DtoVendaPesquisa;
import dtoReports.ClienteREL;
import model.Cliente;
import model.Venda;
import services.ClienteService;
import services.VendaService;

@Service
public class VendaServiceImpl implements VendaService {

	@Autowired
	VendaDao _vendaDao;
	
	public DtoRetornoPaginado<Venda> listAll(Integer pagina, DtoVendaPesquisa dto) throws IllegalAccessException {
		DtoRetornoPaginado<Venda> retorno = _vendaDao.listAll(pagina, dto);
		return retorno;
	}

	
/*
	@SuppressWarnings("unchecked")
	public void exportPdfFile() throws Exception {
		ClienteREL novo = new ClienteREL();
		Object retornoBanco = _clienteDao.lista();
		novo.imprimir((List<Cliente>) retornoBanco);
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
	}*/

}