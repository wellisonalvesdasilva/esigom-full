package com.dtoREL;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.List;

import com.entities.Cliente;

public class ClienteREL {

	public void imprimir(List<Cliente> clientes) throws Exception {

		JasperReport report = JasperCompileManager.compileReport("c:/rpt_users.jrxml");
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(clientes));
		JasperExportManager.exportReportToPdfFile(print, "c:/relatorio_usuario.pdf");

	}

}