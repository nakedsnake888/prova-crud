package eu.winwinit.bcc.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the dettaglio_ordini database table.
 * 
 */
@Embeddable
public class DettaglioOrdinePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_ordine", insertable=false, updatable=false)
	private int idOrdine;

	@Column(name="id_articolo", insertable=false, updatable=false)
	private int idArticolo;

	public DettaglioOrdinePK() {
	}
	public int getIdOrdine() {
		return this.idOrdine;
	}
	public void setIdOrdine(int idOrdine) {
		this.idOrdine = idOrdine;
	}
	public int getIdArticolo() {
		return this.idArticolo;
	}
	public void setIdArticolo(int idArticolo) {
		this.idArticolo = idArticolo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DettaglioOrdinePK)) {
			return false;
		}
		DettaglioOrdinePK castOther = (DettaglioOrdinePK)other;
		return 
			(this.idOrdine == castOther.idOrdine)
			&& (this.idArticolo == castOther.idArticolo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idOrdine;
		hash = hash * prime + this.idArticolo;
		
		return hash;
	}
}