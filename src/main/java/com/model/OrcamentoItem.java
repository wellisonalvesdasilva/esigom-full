package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "orcamento_item")

public class OrcamentoItem implements Serializable {

	// Colunas para inserção
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "cod_orcamento", insertable = false, updatable = false)
	private Integer codOrcamento;

	@Column(name = "cod_item")
	private Integer codItem;

	@Column(name = "tipo_item")
	private Integer tipoItem;

	@Column(name = "quantidade")
	private Integer quantidade;

	// Relacionamentos para navegação
	@ManyToOne
	@JoinColumn(name = "cod_orcamento")
	private Orcamento orcamento;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodOrcamento() {
		return codOrcamento;
	}

	public void setCodOrcamento(Integer codOrcamento) {
		this.codOrcamento = codOrcamento;
	}

	public Integer getCodItem() {
		return codItem;
	}

	public void setCodItem(Integer codItem) {
		this.codItem = codItem;
	}

	public Integer getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(Integer tipoItem) {
		this.tipoItem = tipoItem;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}