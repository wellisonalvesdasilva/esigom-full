package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orcamento")
public class Orcamento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "data")
	private Date data;

	@Column(name = "veiculo_placa")
	private String veiculoPlaca;

	@Column(name = "marca")
	private String marca;

	@Column(name = "cor")
	private String cor;

	@Column(name = "modelo")
	private String modelo;

	@Column(name = "ano")
	private Integer ano;

	@Column(name = "km")
	private Integer km;

	@Column(name = "cliente_id", insertable = false, updatable = false)
	private Integer clienteId;

	@OneToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Integer getClienteId() {
		return clienteId;
	}

	public void setClienteId(Integer clienteId) {
		this.clienteId = clienteId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getVeiculoPlaca() {
		return veiculoPlaca;
	}

	public void setVeiculoPlaca(String veiculoPlaca) {
		this.veiculoPlaca = veiculoPlaca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getKm() {
		return km;
	}

	public void setKm(Integer km) {
		this.km = km;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}