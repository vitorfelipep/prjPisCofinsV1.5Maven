package br.com.milano.controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
	
import br.com.milano.modelo.Filtro;
import br.com.milano.persistence.dao.PisCofinsExcel;
import br.com.milano.persistence.dao.PisConfisPdf;

@ManagedBean(name="filtroMB") 
@RequestScoped
public class Controle {
	
	private Filtro filtro;//Clase modelo do formulário.
	
	//Contrutor
	public Controle() {
		this.filtro = new Filtro();
	}
	

	public void gerarPdf(){
		try{
			//Testa se as datas estão sendo preenchidas de forma correta
			if(filtro.getDataInicial() == null || filtro.getDataFinal() == null)
			{
            	 FacesContext context = FacesContext.getCurrentInstance();
                 context.addMessage(null, new FacesMessage("Atenção!",  "Campos data inicial e final são obrigatórios!")); 
            }
			//Testa se a data inicial está maior que a data final
	  		else if(! filtro.getDataFinal().after(filtro.getDataInicial()) && !filtro.getDataFinal().equals(filtro.getDataInicial()))
	  		{
            	 FacesContext context = FacesContext.getCurrentInstance();
                 context.addMessage(null, new FacesMessage("Atenção!",  "Campos data inicial não pode ser maior que data final, por favor tente novamente!"));	 
            }
			//Testa se a opção não está vazia
	  		else if(filtro.getOpcao() == 0 ){
	  			 FacesContext context = FacesContext.getCurrentInstance();
                 context.addMessage(null, new FacesMessage("Atenção!",  "Campo opção obrigatório! Por favor, selecione uma opção para gerar relatório por competência ou regime de caixa!"));	 
	  		}
	  		else//Verifica qual a opção selecionada para gerar o relatório correspondente
	  			if(filtro.getOpcao() == 1 ){
	            	new PisConfisPdf().pdfCompetencia(filtro);
	            }else{
	            	new PisConfisPdf().pdfRegimeCaixa(filtro);
	    		}
			
		}catch(Exception e){
			e.printStackTrace();
			e.getMessage();
		}
	}
	
	public void gerarExcel(){
		try{
			//Testa se as datas estão sendo preenchidas de forma correta
			if(filtro.getDataInicial() == null || filtro.getDataFinal() == null)
			{
            	 FacesContext context = FacesContext.getCurrentInstance();
                 context.addMessage(null, new FacesMessage("Atenção!",  "Campos data inicial e final são obrigatórios!")); 
            }
			//Testa se a data inicial está maior que a data final
	  		else if(! filtro.getDataFinal().after(filtro.getDataInicial()) && !filtro.getDataFinal().equals(filtro.getDataInicial()))
	  		{
            	 FacesContext context = FacesContext.getCurrentInstance();
                 context.addMessage(null, new FacesMessage("Atenção!",  "Campos data inicial não pode ser maior que data final, por favor tente novamente!"));	 
            }
			//Testa se a opção não está vazia
	  		else if(filtro.getOpcao() == 0 ){
	  			 FacesContext context = FacesContext.getCurrentInstance();
                 context.addMessage(null, new FacesMessage("Atenção!",  "Campo opção obrigatório! Por favor, selecione uma opção para gerar relatório por competência ou regime de caixa!"));	 
	  		}
			//Verifica qual a opção selecionada para gerar o relatório correspondente!
	  		else if(filtro.getOpcao() == 1 )
	  		{
            	new PisCofinsExcel().gerarPisCofinsExcel(filtro);//Relatório excel pis cofins.
            }
	  		else
	  		{
            	new PisCofinsExcel().excelPorRegimeCaixa(filtro);//Relatório Por regime de caixa.
    		}//Fim do bloco de verificação
			
		}catch(Exception e){
			
		}//Fim do try/catch
	}

	public Filtro getFiltro() {
		return filtro;
	}

	public void setFiltro(Filtro filtro) {
		this.filtro = filtro;
	}
}
