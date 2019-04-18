package dto;

import model.Cliente;
import model.Venda;

public class DtoVendaPesquisa extends Venda {

	public String colunaParaOrdenar;

	public String getColunaParaOrdenar() {
		return colunaParaOrdenar;
	}

	public void setColunaParaOrdenar(String colunaParaOrdenar) {
		this.colunaParaOrdenar = colunaParaOrdenar;
	}

}
