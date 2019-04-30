package reports;

import java.io.FileNotFoundException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class GenerateRelatorio<T> {

	public byte[] gerarRelatorio(List<T> lista, HttpServletRequest request, String nomeRelatorio) throws JRException, FileNotFoundException {

		String fullPath = request.getSession().getServletContext()
				.getRealPath("/WEB-INF/reports/" + nomeRelatorio + ".jrxml");

		JasperReport report;
		report = JasperCompileManager.compileReport(fullPath);
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
		return JasperExportManager.exportReportToPdf(print);

	}
}
