package eu.winwinit.bcc.model;

import java.io.Serializable;

public class RichiestaArticolo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idArticolo;
	private int quantita;
	
	public int getIdArticolo() {
		return idArticolo;
	}
	
	public void setIdArticolo(int idArticolo) {
		this.idArticolo = idArticolo;
	}
	
	public int getQuantita() {
		return quantita;
	}
	
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
}
