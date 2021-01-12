package eu.winwinit.bcc.service;

import eu.winwinit.bcc.entities.DettaglioOrdine;
import eu.winwinit.bcc.entities.Ordine;
import eu.winwinit.bcc.model.RichiestaArticolo;

public interface DettaglioOrdineService {
	public void save(RichiestaArticolo det, Ordine ordine);

	public void delete(DettaglioOrdine det);

	public void save(DettaglioOrdine det);
}
