package eu.winwinit.bcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.winwinit.bcc.entities.DettaglioOrdine;

@Repository("dettaglioOrdineRepository")
public interface DettaglioOrdineRepository extends JpaRepository<DettaglioOrdine, Integer> {

}
