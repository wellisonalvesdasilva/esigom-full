package dto;

import java.util.Date;

import model.Cliente;

public class DtoOrcamentoPesquisa {

	public Integer id;
	public Date dataCadastro;
	private Cliente cliente;
	private String gerouOs;
	private String subTotal;
	public String colunaParaOrdenar;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getGerouOs() {
		return gerouOs;
	}

	public void setGerouOs(String gerouOs) {
		this.gerouOs = gerouOs;
	}

	public String getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(String subTotal) {
		this.subTotal = subTotal;
	}

	public String getColunaParaOrdenar() {
		return colunaParaOrdenar;
	}

	public void setColunaParaOrdenar(String colunaParaOrdenar) {
		this.colunaParaOrdenar = colunaParaOrdenar;
	}

}
