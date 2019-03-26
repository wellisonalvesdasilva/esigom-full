package com.services;

import com.dto.DtoListaPeca;
import com.model.Cliente;
import net.sf.jasperreports.engine.JRException;

public interface OrcamentoService {
	DtoListaPeca getPesquisaPeca(String nome);

	DtoListaPeca getPesquisaServico(String nome);

	Cliente getCliente(String cpf);
}