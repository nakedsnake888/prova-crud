package eu.winwinit.bcc.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


/**
 * The persistent class for the dettaglio_ordini database table.
 * 
 */

@Entity
@Table(name="dettaglio_ordini")
public class DettaglioOrdine implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private DettaglioOrdinePK id;

	private int quantita;

	//bi-directional many-to-one association to Articolo
	@ManyToOne
	@JoinColumn(name="id_articolo", insertable = false, updatable = false)
	private Articolo articoli;

	//bi-directional many-to-one association to Ordine
	@ManyToOne
	@JoinColumn(name="id_ordine", insertable = false, updatable = false)
	@JsonIgnore
	private Ordine ordiniArticoli;

	public DettaglioOrdine() {
	}
	
	@JsonIgnore
	public DettaglioOrdinePK getId() {
		return this.id;
	}
	
	@JsonProperty
	public void setId(DettaglioOrdinePK id) {
		this.id = id;
	}

	public int getQuantita() {
		return this.quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public Articolo getArticoli() {
		return this.articoli;
	}

	public void setArticoli(Articolo articoli) {
		this.articoli = articoli;
	}
	
	public Ordine getOrdiniArticoli() {
		return this.ordiniArticoli;
	}

	public void setOrdiniArticoli(Ordine ordiniArticoli) {
		this.ordiniArticoli = ordiniArticoli;
	}

}