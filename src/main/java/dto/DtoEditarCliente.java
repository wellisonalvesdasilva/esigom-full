package dto;

import model.Cliente;

public class DtoEditarCliente extends Cliente {

	private String dataFormatada;

	public String getDataFormatada() {
		return dataFormatada;
	}

	public void setDataFormatada(String dataFormatada) {
		this.dataFormatada = dataFormatada;
	}

}
