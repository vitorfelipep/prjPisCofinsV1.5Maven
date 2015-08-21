package br.com.milano.persistence.dao;

import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import br.com.milano.modelo.Filtro;

public class PisConfisPdf extends DaoMasan{
	
	@SuppressWarnings("unchecked")
	public void pdfCompetencia(Filtro f){
		try{
			open();
			
			SimpleDateFormat dti = new SimpleDateFormat("dd/MM/yyyy");
			//System.out.println(dti.format(f.getDataFinal()));
			
			@SuppressWarnings("rawtypes")
			HashMap parametros = new HashMap();  
			parametros.put("dataInicial", dti.format(f.getDataInicial()));
			parametros.put("dataFinal", dti.format(f.getDataFinal()));
			
			
			System.out.println(parametros);
			
			//Saida Teste
//			JasperPrint print = JasperFillManager.fillReport("C:/Users/vitor.felipe/workspace/prjPisCofinsV1.5Maven/WebContent/Relatorio/pdfPisCofinsCompetencia.jasper", parametros, con);
//			JasperExportManager.exportReportToPdfFile(print, "C:/Users/vitor.felipe/workspace/prjPisCofinsV1.5Maven/WebContent/Relatorio/relatorioPdf.pdf");
//			
//			Thread.sleep(5000);													
//	        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/prjPisCofinsV1.5Maven/Relatorio/relatorioPdf.pdf"); 
//			
			
			//Link de Produção
			JasperPrint print = JasperFillManager.fillReport("/var/lib/tomcat7/webapps/prjPisCofinsV1.5Maven/Relatorio/pdfPisCofinsCompetencia.jasper", parametros, con);
			JasperExportManager.exportReportToPdfFile(print, "/var/lib/tomcat7/webapps/prjPisCofinsV1.5Maven/Relatorio/relatorioPdf.pdf");
		
			Thread.sleep(5000);													
	        FacesContext.getCurrentInstance().getExternalContext().redirect("http://192.168.15.164:8080/prjPisCofinsV1.5Maven/Relatorio/relatorioPdf.pdf"); 
			
	        close();
			
		}catch(Exception e){
			e.printStackTrace();
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erro!",  "Erro ao importar o arquivo PDF, erro interno! por favor contate a TI Milano de desenvolvimento!"));
		}
	}
	
	@SuppressWarnings("unchecked")
	public void pdfRegimeCaixa(Filtro f){
		
		try{
			open();
			
			SimpleDateFormat dti = new SimpleDateFormat("dd/MM/yyyy");
			//System.out.println(dti.format(f.getDataFinal()));
			
			@SuppressWarnings("rawtypes")
			HashMap parametros = new HashMap();  
			parametros.put("dataInicial", dti.format(f.getDataInicial()));
			parametros.put("dataFinal", dti.format(f.getDataFinal()));
			
			
			System.out.println(parametros);
			
			//Saida Teste
//			JasperPrint print = JasperFillManager.fillReport("C:/Users/vitor.felipe/workspace/prjPisCofinsV1.5Maven/WebContent/Relatorio/pdfPorRegimeCaixa.jasper", parametros, con);
//			JasperExportManager.exportReportToPdfFile(print, "C:/Users/vitor.felipe/workspace/prjPisCofinsV1.5Maven/WebContent/Relatorio/porRegimeCaixa.pdf");
//			
//			Thread.sleep(5000);													
//	        FacesContext.getCurrentInstance().getExternalContext().redirect("http://localhost:8080/prjPisCofinsV1.5Maven/Relatorio/porRegimeCaixa.pdf"); 
//			
			
			//Link de Produção
			JasperPrint print = JasperFillManager.fillReport("/var/lib/tomcat7/webapps/prjPisCofinsV1.5Maven/Relatorio/pdfPorRegimeCaixa.jasper", parametros, con);
			JasperExportManager.exportReportToPdfFile(print, "/var/lib/tomcat7/webapps/prjPisCofinsV1.5Maven/Relatorio/relatorioPdf.pdf");
		
			Thread.sleep(5000);													
	        FacesContext.getCurrentInstance().getExternalContext().redirect("http://192.168.15.164:8080/prjPisCofinsV1.5Maven/Relatorio/relatorioPdf.pdf"); 
			
	        close();
			
		}catch(Exception e){
			e.printStackTrace();
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erro!",  "Erro ao importar o arquivo PDF, erro interno! por favor contate a TI Milano de desenvolvimento!"));
		}
	}
}
