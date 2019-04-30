package services;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import dto.DtoListaPeca;
import dto.DtoOrcamentoPesquisa;
import dto.DtoRetornoPaginado;
import model.Cliente;
import net.sf.jasperreports.engine.JRException;

public interface OrcamentoService {
	DtoListaPeca getPesquisaPeca(String nome);

	DtoListaPeca getPesquisaServico(String nome);

	Serializable salvarOrcamento(Object dto);

	Cliente getCliente(String cpf);

	DtoRetornoPaginado<DtoOrcamentoPesquisa> listAll(Integer pagina, DtoOrcamentoPesquisa dto) throws IllegalAccessException;
	
	public byte[] exportPdfFile(HttpServletRequest request) throws JRException, FileNotFoundException, IOException;

}