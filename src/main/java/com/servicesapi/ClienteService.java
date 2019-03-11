package com.servicesapi;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import com.dtos.DtoRetornoPaginado;
import com.entities.Cliente;
import com.dtos.DtoClientePesquisa;

import net.sf.jasperreports.engine.JRException;

public interface ClienteService {

	public void exportPdfFile() throws JRException, IOException, Exception;

	public DtoRetornoPaginado<Cliente> list(Integer pagina, DtoClientePesquisa dto);

	public void salvar(Cliente cliente);

	Boolean deletar(Integer cod);

	Object getObj(Integer id, String login, String senha) throws NoSuchAlgorithmException;

	/* void alterarSenha(Integer cod, String novaSenha) throws Exception; */

}