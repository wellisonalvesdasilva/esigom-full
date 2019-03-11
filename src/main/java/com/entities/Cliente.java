package com.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "email")
	private String email;

	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dt_nascimento;

	@Column(name = "dth_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dth_cadastro;

	private Integer genero;
	private String telefone;
	private String celular;
	private Integer tp_pessoa;
	private String rg;
	private String cpf;
	private String cep;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;

	public Date getDth_cadastro() {
		return dth_cadastro;
	}

	public void setDth_cadastro(Date dth_cadastro) {
		this.dth_cadastro = dth_cadastro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Date dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public Integer getGenero() {
		return genero;
	}

	public void setGenero(Integer genero) {
		this.genero = genero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Integer getTp_pessoa() {
		return tp_pessoa;
	}

	public void setTp_pessoa(Integer tp_pessoa) {
		this.tp_pessoa = tp_pessoa;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}