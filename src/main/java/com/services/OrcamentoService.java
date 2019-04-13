package com.services;

import java.io.Serializable;

import com.dto.DtoListaPeca;
import com.model.Cliente;
import net.sf.jasperreports.engine.JRException;

public interface OrcamentoService {
	DtoListaPeca getPesquisaPeca(String nome);

	DtoListaPeca getPesquisaServico(String nome);

	Boolean salvarOrcamento(Object dto);

	Cliente getCliente(String cpf);
}