package eu.winwinit.bcc.service;

import eu.winwinit.bcc.entities.Ordine;

public interface OrdineService {
	public Ordine findById(Integer id);
	
	public Ordine save(Ordine ordine);

	public void delete(Ordine oldOrdine);
	
}
