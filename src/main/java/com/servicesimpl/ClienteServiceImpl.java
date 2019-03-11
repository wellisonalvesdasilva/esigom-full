package com.servicesimpl;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.daoapi.ClienteDao;
import com.dtoREL.ClienteREL;
import com.dtos.DtoRetornoPaginado;
import com.entities.Cliente;
import com.dtos.DtoClientePesquisa;
import com.servicesapi.ClienteService;

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

	public DtoRetornoPaginado<Cliente> list(Integer pagina, DtoClientePesquisa dto) {
		DtoRetornoPaginado<Cliente> retorno = _clienteDao.list(pagina, dto);
		return retorno;
	}

	/*
	 * public boolean saveOrUpdate(Cliente users) throws
	 * NoSuchAlgorithmException, IllegalAccessException,
	 * InvocationTargetException {
	 * users.setDataDeCadastro(Calendar.getInstance().getTime());
	 * 
	 * if (users.getId() != null) { _clienteDao.merge(users); } else {
	 * 
	 * String s = users.getSenha(); MessageDigest m =
	 * MessageDigest.getInstance("MD5"); m.update(s.getBytes(), 0, s.length());
	 * 
	 * users.setSenha(new BigInteger(1, m.digest()).toString(16));
	 * _clienteDao.persist(users); } return true; }
	 */

	public Boolean deletar(Integer cod) {
		return _clienteDao.deletar(cod);
	}

	public Object getObj(Integer id, String login, String senha) throws NoSuchAlgorithmException {
		return _clienteDao.getObj(id, login, senha);
	}

	/*
	 * public void alterarSenha(Integer cod, String novaSenha) throws Exception
	 * {
	 * 
	 * Cliente objLocalizado = _clienteDao.getObj(cod, null, null);
	 * 
	 * if (objLocalizado != null) {
	 * 
	 * // Senha padrão de 1 a 6 - quando nada for informado if
	 * (novaSenha.equals("0")) { novaSenha = "123456"; } // Converter a senha em
	 * MD5 String s = novaSenha; MessageDigest m =
	 * MessageDigest.getInstance("MD5"); m.update(s.getBytes(), 0, s.length());
	 * 
	 * objLocalizado.setSenha(new BigInteger(1, m.digest()).toString(16));
	 * 
	 * _clienteDao.merge(objLocalizado);
	 * 
	 * } }
	 */

}