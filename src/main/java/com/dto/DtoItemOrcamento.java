package com.dto;

public class DtoItemOrcamento {

	public Integer id;
	public Integer quantidade;
	private String subTotal;
	public Integer tipoItem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}

	public Integer getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(Integer tipoItem) {
		this.tipoItem = tipoItem;
	}

}
