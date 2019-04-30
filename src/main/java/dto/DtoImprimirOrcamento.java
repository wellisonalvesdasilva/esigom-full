package dto;

import java.util.Date;
import java.util.List;

public class DtoImprimirOrcamento<T> {

	// Dados do Orçamento
	public Integer numeroOrcamento;
	public Date emitidoEm;

	// Dados do Cliente
	public String nome;
	public String telefone;
	public String cpf;
	public String email;
	public String rg;
	public String endereco;
	public String bairro;
	public String cidade;
	public String estado;
	public String cep;

	// Produto/Serviço
	public List<T> lista;

	// Observações
	public String formaPagamento;
	public String obs;

	public Integer getNumeroOrcamento() {
		return numeroOrcamento;
	}

	public void setNumeroOrcamento(Integer numeroOrcamento) {
		this.numeroOrcamento = numeroOrcamento;
	}

	public Date getEmitidoEm() {
		return emitidoEm;
	}

	public void setEmitidoEm(Date emitidoEm) {
		this.emitidoEm = emitidoEm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public List<T> getLista() {
		return lista;
	}

	public void setLista(List<T> lista) {
		this.lista = lista;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

}
