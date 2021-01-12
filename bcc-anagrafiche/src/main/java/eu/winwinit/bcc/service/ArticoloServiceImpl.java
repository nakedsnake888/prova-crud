package eu.winwinit.bcc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.winwinit.bcc.entities.Articolo;
import eu.winwinit.bcc.repository.ArticoloRepository;

@Service("articoloService")
public class ArticoloServiceImpl implements ArticoloService {
	
	@Autowired
	private ArticoloRepository articoloRepository;

	@Override
	public List<Articolo> findByName(String nome) {
		return articoloRepository.findByName(nome);
	}
	
	@Override
	public Articolo findById(Integer id) {
		return articoloRepository.findById(id).get();
	}
	
	@Override
	public void save(Articolo articolo) {
		articoloRepository.save(articolo);
	}
	
	@Override
	public void delete(Articolo articolo) {
		articoloRepository.delete(articolo);
	}

}
