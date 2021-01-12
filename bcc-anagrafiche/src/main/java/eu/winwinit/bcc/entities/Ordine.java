package eu.winwinit.bcc.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import eu.winwinit.bcc.model.OrdineModel;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ordini_articoli database table.
 * 
 */
@Entity
@Table(name="ordini_articoli")
public class Ordine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String cliente;

	private Timestamp data; 

	//bi-directional many-to-one association to DettaglioOrdine
	@OneToMany(mappedBy="ordiniArticoli")
	private List<DettaglioOrdine> dettaglioOrdini;

	public Ordine() {
	}
	

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCliente() {
		return this.cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public Timestamp getData() {
		return this.data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public List<DettaglioOrdine> getDettaglioOrdini() {
		return this.dettaglioOrdini;
	}

	public void setDettaglioOrdini(List<DettaglioOrdine> dettaglioOrdini) {
		this.dettaglioOrdini = dettaglioOrdini;
	}

	public DettaglioOrdine addDettaglioOrdini(DettaglioOrdine dettaglioOrdini) {
		getDettaglioOrdini().add(dettaglioOrdini);
		dettaglioOrdini.setOrdiniArticoli(this);

		return dettaglioOrdini;
	}

	public DettaglioOrdine removeDettaglioOrdini(DettaglioOrdine dettaglioOrdini) {
		getDettaglioOrdini().remove(dettaglioOrdini);
		dettaglioOrdini.setOrdiniArticoli(null);

		return dettaglioOrdini;
	}

}