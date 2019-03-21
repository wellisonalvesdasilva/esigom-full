package com.dto;

public class DtoClientePaginado extends DtoPaginacao {
	private int paginaAtual;

	public int getPaginaAtual() {
		return paginaAtual;
	}

	public void setPaginaAtual(int paginaAtual) {
		this.paginaAtual = paginaAtual;
	}

}