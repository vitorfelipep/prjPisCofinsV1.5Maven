package br.com.milano.modelo;

import java.util.Date;

//Classe modelo do filtro
public class Filtro {
	private Date dataInicial;
	private Date dataFinal;
	private int opcao = 0;
	
	public Filtro() {
		// TODO Auto-generated constructor stub
	}
	
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public int getOpcao() {
		return opcao;
	}
	public void setOpcao(int opcao) {
		this.opcao = opcao;
	}

	@Override
	public String toString() {
		return "FiltroModel [dataInicial=" + dataInicial + ", dataFinal="
				+ dataFinal + ", opcao=" + opcao + "]";
	}
}
