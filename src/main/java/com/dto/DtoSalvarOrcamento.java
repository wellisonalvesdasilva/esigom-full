package com.dto;

import java.util.List;

import com.model.Orcamento;

public class DtoSalvarOrcamento extends Orcamento {

	private List<DtoArraySalvarOrcamento> listPecas;
	private List<DtoArraySalvarOrcamento> listServicos;

	public List<DtoArraySalvarOrcamento> getListPecas() {
		return listPecas;
	}

	public void setListPecas(List<DtoArraySalvarOrcamento> listPecas) {
		this.listPecas = listPecas;
	}

	public List<DtoArraySalvarOrcamento> getListServicos() {
		return listServicos;
	}

	public void setListServicos(List<DtoArraySalvarOrcamento> listServicos) {
		this.listServicos = listServicos;
	}

}
