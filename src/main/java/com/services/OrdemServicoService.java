package com.services;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.dto.DtoClientePesquisa;
import com.dto.DtoRetornoPaginado;
import com.model.Cliente;
import com.model.Peca;

import net.sf.jasperreports.engine.JRException;

public interface OrdemServicoService {
	List<Peca> getPesquisaPeca(String nome);
}