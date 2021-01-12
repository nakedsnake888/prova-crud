package eu.winwinit.bcc.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import eu.winwinit.bcc.entities.Articolo;

import java.util.List;


/**
 * The persistent class for the articoli database table.
 * 
 */
@Entity
@Table(name="articoli")
public class Articolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descrizione;

	private int giacenza;

	private String nome;

	private float prezzo;

	//bi-directional many-to-one association to DettaglioOrdine
	@OneToMany(mappedBy="articoli")
	private List<DettaglioOrdine> dettaglioOrdini; 

	public Articolo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getGiacenza() {
		return this.giacenza;
	}

	public void setGiacenza(int giacenza) {
		this.giacenza = giacenza;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	@JsonIgnore
	public List<DettaglioOrdine> getDettaglioOrdini() {
		return this.dettaglioOrdini;
	}

	public void setDettaglioOrdini(List<DettaglioOrdine> dettaglioOrdini) {
		this.dettaglioOrdini = dettaglioOrdini;
	}

	public DettaglioOrdine addDettaglioOrdini(DettaglioOrdine dettaglioOrdini) {
		getDettaglioOrdini().add(dettaglioOrdini);
		dettaglioOrdini.setArticoli(this);

		return dettaglioOrdini;
	}

	public DettaglioOrdine removeDettaglioOrdini(DettaglioOrdine dettaglioOrdini) {
		getDettaglioOrdini().remove(dettaglioOrdini);
		dettaglioOrdini.setArticoli(null);

		return dettaglioOrdini;
	}
	
	public void replaceArticolo(Articolo articolo) {
		System.out.println(articolo.getPrezzo());
		if(articolo.getNome() != null) this.nome = articolo.getNome();
		if(articolo.getDescrizione() != null) this.descrizione = articolo.getDescrizione();
		if(articolo.getPrezzo() != 0.0f) this.prezzo = articolo.getPrezzo();
		if(articolo.getGiacenza() >= 0) this.giacenza = articolo.getGiacenza();	
	}

}