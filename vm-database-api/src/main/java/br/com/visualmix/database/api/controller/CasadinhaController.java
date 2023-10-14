package br.com.visualmix.database.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.visualmix.visualstore.databsp.md.dtos.CasadinhaDTO;
import br.com.visualmix.visualstore.db.services.bsp.CasadinhaService;

@RestController
@RequestMapping("api/casadinhas")
public class CasadinhaController {

	@Autowired
    public CasadinhaService service;
    
	 @GetMapping("/listAll")
	 public List<CasadinhaDTO> getAllMarrieds() {
	        return service.getAllMarrieds();
	    }
	 
	 @GetMapping("/listLast")
	 public CasadinhaDTO getLastMarried() {
	        return service.getLastMarried();
	    }
}
