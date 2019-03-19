package com.dtos;

import com.entities.Peca;
import com.entities.Servico;

public class DtoPecaPesquisa extends Peca {

	public String valorFormatado;
	public String colunaParaOrdenar;

	public String getValorFormatado() {
		return valorFormatado;
	}

	public void setValorFormatado(String valorFormatado) {
		this.valorFormatado = valorFormatado;
	}

	public String getColunaParaOrdenar() {
		return colunaParaOrdenar;
	}

	public void setColunaParaOrdenar(String colunaParaOrdenar) {
		this.colunaParaOrdenar = colunaParaOrdenar;
	}

}
