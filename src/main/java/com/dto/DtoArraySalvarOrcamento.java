package com.dto;

public class DtoArraySalvarOrcamento {

	private Integer id;
	private String quantidade;
	private Double subTotal;
	private Integer tipoItem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public Double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}

	public Integer getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(Integer tipoItem) {
		this.tipoItem = tipoItem;
	}

}
