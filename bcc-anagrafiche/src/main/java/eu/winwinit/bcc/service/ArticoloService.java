package eu.winwinit.bcc.service;

import java.util.List;

import eu.winwinit.bcc.entities.Articolo;

public interface ArticoloService {
	
	public List<Articolo> findByName(String nome);
	
	public Articolo findById(Integer id);
	
	public void save(Articolo articolo);
	
	public void delete(Articolo articolo);
	
}
