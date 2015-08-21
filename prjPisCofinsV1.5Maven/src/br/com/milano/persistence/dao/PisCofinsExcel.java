package br.com.milano.persistence.dao;


import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import br.com.milano.modelo.Filtro;

@SuppressWarnings("deprecation")
public class PisCofinsExcel extends DaoMasan{
	@SuppressWarnings({  "unchecked" })
	public void gerarPisCofinsExcel(Filtro f){
		try{
			open();
				SimpleDateFormat dti = new SimpleDateFormat("dd/MM/yyyy");

				@SuppressWarnings("rawtypes")
				HashMap parametros = new HashMap();  
				parametros.put("dataInicial", dti.format(f.getDataInicial()));
				parametros.put("dataFinal", dti.format(f.getDataFinal()));
			
				System.out.println(parametros);
				//Link de Teste
//				JasperReport report = JasperCompileManager
//						.compileReport("C:/Users/vitor.felipe/workspace/prjPisCofinsV1.5Maven/WebContent/Relatorio/ExcelPisCofisCompetencia.jrxml");
//				JasperPrint print = JasperFillManager.fillReport(report, parametros, con);
//				
//				JRXlsxExporter exporter = new JRXlsxExporter();
//				exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
//				exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:/Users/vitor.felipe/workspace/prjPisCofinsV1.5Maven/WebContent/Relatorio/RelatorioExcel.xls");
//			    exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE); 
//			    exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE); 
//				
//				exporter.exportReport();
//				
//			        Thread.sleep(6000);
//			        FacesContext.getCurrentInstance().getExternalContext().redirect("http://192.168.14.23:8080/prjPisCofinsV1.5Maven/Relatorio/RelatorioExcel.xls"); 
//			        	
//				
				
			      
				//Link de Produção
				JasperReport report = JasperCompileManager.
						compileReport("/var/lib/tomcat7/webapps/prjPisCofinsV1.5Maven/Relatorio/ExcelPisCofisCompetencia.jrxml");
				JasperPrint print = JasperFillManager.fillReport(report, parametros, con);
				JRXlsxExporter exporter = new JRXlsxExporter();
		        exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
		        exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "/var/lib/tomcat7/webapps/prjPisCofinsV1.5Maven/Relatorio/RelatorioExcel.xls");
		        exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE); 
		        exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE); 
		        
		        exporter.exportReport();
		     			
				
		        Thread.sleep(6000);
		        FacesContext.getCurrentInstance().getExternalContext().redirect("http://192.168.15.164:8080/prjPisCofinsV1.5Maven/Relatorio/RelatorioExcel.xls"); 
		        		
			close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void excelPorRegimeCaixa(Filtro f){
		try{
			open();
				SimpleDateFormat dti = new SimpleDateFormat("dd/MM/yyyy");

				@SuppressWarnings("rawtypes")
				HashMap parametros = new HashMap();  
				parametros.put("dataInicial", dti.format(f.getDataInicial()));
				parametros.put("dataFinal", dti.format(f.getDataFinal()));
			
				System.out.println(parametros);
				
				//Link de Teste
//				JasperReport report = JasperCompileManager
//						.compileReport("C:/Users/vitor.felipe/workspace/prjPisCofinsV1.5Maven/WebContent/Relatorio/ExcePorRegimCaixa.jrxml");
//				JasperPrint print = JasperFillManager.fillReport(report, parametros, con);
//				
//				JRXlsxExporter exporter = new JRXlsxExporter();
//				exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
//				exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "C:/Users/vitor.felipe/workspace/prjPisCofinsV1.5Maven/WebContent/Relatorio/RelatorioExcel.xls");
//			    exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE); 
//			    exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE); 
//				
//				exporter.exportReport();
//				
//			        Thread.sleep(6000);
//			        FacesContext.getCurrentInstance().getExternalContext().redirect("http://192.168.14.23:8080/prjPisCofinsV1.5Maven/Relatorio/RelatorioExcel.xls"); 
//			        	
				
				
			      
				//Link de Produção
				JasperReport report = JasperCompileManager.
						compileReport("/var/lib/tomcat7/webapps/prjPisCofinsV1.5Maven/Relatorio/ExcePorRegimCaixa.jrxml");
				JasperPrint print = JasperFillManager.fillReport(report, parametros, con);
				JRXlsxExporter exporter = new JRXlsxExporter();
		        exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, print);
		        exporter.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, "/var/lib/tomcat7/webapps/prjPisCofinsV1.5Maven/Relatorio/RelatorioExcel.xls");
		        exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE); 
		        exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE); 
		        
		        exporter.exportReport();
		     			
				
		        Thread.sleep(6000);
		        FacesContext.getCurrentInstance().getExternalContext().redirect("http://192.168.15.164:8080/prjPisCofinsV1.5Maven/Relatorio/RelatorioExcel.xls"); 
		        		
			close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
