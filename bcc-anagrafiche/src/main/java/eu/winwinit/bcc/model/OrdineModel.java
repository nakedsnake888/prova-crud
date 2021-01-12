package eu.winwinit.bcc.model;

import java.io.Serializable;
import java.util.List;

import eu.winwinit.bcc.entities.Ordine;

public class OrdineModel implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Ordine ordine;
	private List<RichiestaArticolo> richiesteArticolo;
	
	public Ordine getOrdine() {
		return ordine;
	}
	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}
	public List<RichiestaArticolo> getRichiesteArticolo() {
		return richiesteArticolo;
	}
	public void setRichiesteArticolo(List<RichiestaArticolo> richiesteArticolo) {
		this.richiesteArticolo = richiesteArticolo;
	}

}
