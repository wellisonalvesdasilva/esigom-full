package dto;

import java.util.Date;
import model.Orcamento;

public class DtoOrdemServicoPesquisa {
	public Integer id;
	public Date dataGeracao;
	public Date dataEntrega;
	private String responsavelTecnico;
	private String garantiaDias;
	private Orcamento orcamento;
	public String colunaParaOrdenar;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataGeracao() {
		return dataGeracao;
	}

	public void setDataGeracao(Date dataGeracao) {
		this.dataGeracao = dataGeracao;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getResponsavelTecnico() {
		return responsavelTecnico;
	}

	public void setResponsavelTecnico(String responsavelTecnico) {
		this.responsavelTecnico = responsavelTecnico;
	}

	public String getGarantiaDias() {
		return garantiaDias;
	}

	public void setGarantiaDias(String garantiaDias) {
		this.garantiaDias = garantiaDias;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public String getColunaParaOrdenar() {
		return colunaParaOrdenar;
	}

	public void setColunaParaOrdenar(String colunaParaOrdenar) {
		this.colunaParaOrdenar = colunaParaOrdenar;
	}

}
