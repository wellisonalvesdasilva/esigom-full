package model;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "venda")
public class Venda {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "dth_negociacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataNegociacao;

	@Column(name = "cod_status")
	private Integer codStatus;

	@OneToOne
	@JoinColumn(name = "orcamento_id")
	private Orcamento orcamento;

	@Column(name = "tipo_venda")
	private Integer tipoVenda;

	@Column(name = "forma_pagamento")
	private Integer formaPagamento;

	@JsonIgnore
	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<VendaItem> vendaItens = new ArrayList<VendaItem>();

	public Integer getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(Integer formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataNegociacao() {
		return dataNegociacao;
	}

	public void setDataNegociacao(Date dataNegociacao) {
		this.dataNegociacao = dataNegociacao;
	}

	public Integer getCodStatus() {
		return codStatus;
	}

	public void setCodStatus(Integer codStatus) {
		this.codStatus = codStatus;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public Integer getTipoVenda() {
		return tipoVenda;
	}

	public void setTipoVenda(Integer tipoVenda) {
		this.tipoVenda = tipoVenda;
	}

	public List<VendaItem> getVendaItens() {
		return vendaItens;
	}

	public void setVendaItens(List<VendaItem> vendaItens) {
		this.vendaItens = vendaItens;
	}

}