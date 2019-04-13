package com.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@Column(name = "cliente_id")
	private Integer clienteId;

/*	@OneToOne
	@JoinColumn(name = "cliente_id", insertable = false, updatable = false)
	private Cliente cliente;*/

	@JsonIgnore
	@OneToMany(mappedBy = "orcamento", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrcamentoItem> orcamentoItens = new ArrayList<OrcamentoItem>();

	public void AdicionarFilhos(OrcamentoItem filho) {
		orcamentoItens.add(filho);
		filho.setOrcamento(this);
	}

	public List<OrcamentoItem> getOrcamentoItens() {
		return orcamentoItens;
	}

	public void setOrcamentoItens(List<OrcamentoItem> orcamentoItens) {
		this.orcamentoItens = orcamentoItens;
	}

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

	/*public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}*/

}