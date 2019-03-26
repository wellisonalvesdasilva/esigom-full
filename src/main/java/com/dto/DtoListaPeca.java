package com.dto;

import java.util.List;

public class DtoListaPeca<T> {
	public int qtdTotalDeRegistros;
	public List<T> lista;

	public int getQtdTotalDeRegistros() {
		return qtdTotalDeRegistros;
	}

	public void setQtdTotalDeRegistros(int qtdTotalDeRegistros) {
		this.qtdTotalDeRegistros = qtdTotalDeRegistros;
	}

	public List<T> getLista() {
		return lista;
	}

	public void setLista(List<T> lista) {
		this.lista = lista;
	}

}