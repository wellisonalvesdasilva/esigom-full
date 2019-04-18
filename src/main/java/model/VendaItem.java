package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "venda_pagamento")
public class VendaItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "cod_venda", insertable = false, updatable = false)
	private Integer codVenda;

	@ManyToOne
	@JoinColumn(name = "cod_venda")
	private Venda venda;

	@Column(name = "valor")
	private Double valor;

	@Column(name = "dth_pagamento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dthPagamento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(Integer codVenda) {
		this.codVenda = codVenda;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getDthPagamento() {
		return dthPagamento;
	}

	public void setDthPagamento(Date dthPagamento) {
		this.dthPagamento = dthPagamento;
	}

}
