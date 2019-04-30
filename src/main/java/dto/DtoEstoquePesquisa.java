package dto;

import model.Estoque;

public class DtoEstoquePesquisa extends Estoque {

	public String colunaParaOrdenar;

	public String getColunaParaOrdenar() {
		return colunaParaOrdenar;
	}

	public void setColunaParaOrdenar(String colunaParaOrdenar) {
		this.colunaParaOrdenar = colunaParaOrdenar;
	}

}
