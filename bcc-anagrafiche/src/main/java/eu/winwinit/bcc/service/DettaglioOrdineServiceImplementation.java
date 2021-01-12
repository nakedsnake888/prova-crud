package eu.winwinit.bcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.winwinit.bcc.entities.DettaglioOrdine;
import eu.winwinit.bcc.entities.DettaglioOrdinePK;
import eu.winwinit.bcc.entities.Ordine;
import eu.winwinit.bcc.model.RichiestaArticolo;
import eu.winwinit.bcc.repository.DettaglioOrdineRepository;

@Service("dettaglioOrdineService")
public class DettaglioOrdineServiceImplementation implements DettaglioOrdineService {
	
	@Autowired
	private DettaglioOrdineRepository rep;
	
	@Override
	public void save(RichiestaArticolo det, Ordine ordine) {
		DettaglioOrdine dettaglioOrdine = new DettaglioOrdine();
		DettaglioOrdinePK pk = new DettaglioOrdinePK();
		pk.setIdArticolo(det.getIdArticolo());
		pk.setIdOrdine(ordine.getId());
		dettaglioOrdine.setId(pk);
		dettaglioOrdine.setQuantita(det.getQuantita());
		ordine.getDettaglioOrdini().add(dettaglioOrdine);
		rep.save(dettaglioOrdine);
	}
	
	public void delete(DettaglioOrdine det) {
		rep.delete(det);
	}

	@Override
	public void save(DettaglioOrdine det) {
		rep.save(det);
		
	}

}
