package eu.winwinit.bcc.controllers;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.winwinit.bcc.constants.AuthorityRolesConstants;
import eu.winwinit.bcc.entities.Articolo;
import eu.winwinit.bcc.service.ArticoloService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.*;
import io.swagger.v3.oas.annotations.media.*;

@Api(description="API per la gestione degli articoli", tags = "Articoli")
@RestController
@RequestMapping("/articoli")
public class ArticoliController {
	
	@Autowired
	ArticoloService articoloService;
	
	@Operation(summary = "Cerca Articoli per nome",
            description = "Questo metodo permette di cercare gli Articoli per nome.",
            responses = {
            		@ApiResponse(
            				description = "OK",
                            content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Articolo.class)))	
            })
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Articolo>> cercaArticoloPerNome (
			@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
			@RequestParam(value="name") String name
			) {
		
		List<Articolo> articoli = articoloService.findByName(name);
		
		return new ResponseEntity<>(articoli, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Articolo> cercaArticoloPerId (
			@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
			@PathVariable Integer id
			) {
		
		Articolo articolo = articoloService.findById(id);
		
		if(articolo == null) throw new EntityNotFoundException();
		
		return new ResponseEntity<>(articolo, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> creaArticolo (
    		@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
    		@RequestBody Articolo articolo
    		) {
		System.out.println(articolo.getDescrizione());
		articoloService.save(articolo);
		return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> modificaArticolo (
    		@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
    		@RequestBody Articolo articolo,
    		@PathVariable Integer id
    		) {
		
		Articolo oldArticolo = articoloService.findById(id);
		oldArticolo.replaceArticolo(articolo);
		articoloService.save(oldArticolo);
		return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteArticolo (
    		@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
    		@PathVariable Integer id
    		) {
		
		Articolo oldArticolo = articoloService.findById(id);
		articoloService.delete(oldArticolo);
		return new ResponseEntity<>(HttpStatus.OK.getReasonPhrase(), HttpStatus.OK);
	}
	
	
}
