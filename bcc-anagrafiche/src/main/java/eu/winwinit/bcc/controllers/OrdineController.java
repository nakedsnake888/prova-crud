package eu.winwinit.bcc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.winwinit.bcc.constants.AuthorityRolesConstants;
import eu.winwinit.bcc.entities.DettaglioOrdine;
import eu.winwinit.bcc.entities.Ordine;
import eu.winwinit.bcc.model.OrdineModel;
import eu.winwinit.bcc.model.RichiestaArticolo;
import eu.winwinit.bcc.service.DettaglioOrdineService;
import eu.winwinit.bcc.service.OrdineService;
import io.swagger.annotations.Api;

@RestController
@Api(description="API per la gestione degli ordini", tags = "Ordini")
@RequestMapping("/ordini")
public class OrdineController {
	
	@Autowired
	OrdineService ordineService;
	
	@Autowired
	DettaglioOrdineService dettaglioOrdineService;
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Ordine> cercaOrdinePerId (
			@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
			@PathVariable Integer id
			) { 
		
		Ordine ordine = ordineService.findById(id);
		
		System.out.println(ordine.getDettaglioOrdini().size());
		
		
		return new ResponseEntity<>(ordine, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Integer> creaOrdine (
    		@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
    		@RequestBody OrdineModel ordineModel
    		) {
		
		Ordine idOrdine = ordineService.save(ordineModel.getOrdine());
		
		for(RichiestaArticolo det: ordineModel.getRichiesteArticolo()) {
			dettaglioOrdineService.save(det, idOrdine);
		}
		
		return new ResponseEntity<Integer>(idOrdine.getId(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteOrdine (
    		@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
    		@PathVariable Integer id
    		) {
		
		Ordine oldOrdine = ordineService.findById(id);
		for(DettaglioOrdine det: oldOrdine.getDettaglioOrdini()) {
			dettaglioOrdineService.delete(det);
		}
		ordineService.delete(oldOrdine);
		return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> modifyOrdine (
    		@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
    		@PathVariable Integer id,
    		@RequestBody Ordine ordine
    		) {
		
		Ordine oldOrdine = ordineService.findById(id);
		oldOrdine.setDettaglioOrdini(null);
		for(DettaglioOrdine det : ordine.getDettaglioOrdini()) {
			det.getId().setIdOrdine(id);
			dettaglioOrdineService.save(det);
		}
		oldOrdine.setDettaglioOrdini(ordine.getDettaglioOrdini());
		oldOrdine.setCliente(ordine.getCliente());
		oldOrdine.setData(ordine.getData());
		ordineService.save(oldOrdine);
		return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
	}
}
