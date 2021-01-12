package eu.winwinit.bcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eu.winwinit.bcc.entities.Articolo;

@Repository("articoloRepository")
public interface ArticoloRepository extends JpaRepository<Articolo, Integer> {
	
	@Query("Select a from Articolo a where nome like ?1%")
	List<Articolo> findByName(String nome);
	
	
}
