package dto;

import java.util.List;

import model.Orcamento;

public class DtoSalvarOrcamento extends Orcamento {

	public List<DtoItemOrcamento> listPecas;
	public List<DtoItemOrcamento> listServicos;

	public List<DtoItemOrcamento> getListPecas() {
		return listPecas;
	}

	public void setListPecas(List<DtoItemOrcamento> listPecas) {
		this.listPecas = listPecas;
	}

	public List<DtoItemOrcamento> getListServicos() {
		return listServicos;
	}

	public void setListServicos(List<DtoItemOrcamento> listServicos) {
		this.listServicos = listServicos;
	}

}
