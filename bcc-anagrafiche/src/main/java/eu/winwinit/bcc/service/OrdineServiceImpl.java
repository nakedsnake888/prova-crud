package eu.winwinit.bcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.winwinit.bcc.entities.Ordine;
import eu.winwinit.bcc.repository.OrdineRepository;

@Service("ordineService")
public class OrdineServiceImpl implements OrdineService {
	
	@Autowired
	private OrdineRepository ordineRepository;
	
	public Ordine findById(Integer id) {
		return ordineRepository.findById(id).get();
	}
	
	public Ordine save(Ordine ordine) {
		Ordine o = ordineRepository.save(ordine);
		return o;
	}
	
	public void delete(Ordine ordine) {
		ordineRepository.delete(ordine);
	}
}
