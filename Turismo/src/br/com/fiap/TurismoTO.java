package br.com.fiap;

public class TurismoTO {

	public String cidade;
	public String estado;
	public String pais;
	public double valorGasto;
	public String dataVisita;

	public TurismoTO(String cidade, String estado, String pais,
			double valorGasto, String dataVisita) {
		super();
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.valorGasto = valorGasto;
		this.dataVisita = dataVisita;
	}

}