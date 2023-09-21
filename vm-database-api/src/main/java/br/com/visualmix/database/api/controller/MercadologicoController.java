package br.com.visualmix.database.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.visualmix.database.api.service.MercadologicoService;
import br.com.visualmix.visualstore.databsp.md.dtos.MercadologicosDTO;

@RestController
@RequestMapping("api/mercadologico")
public class MercadologicoController {
	
	@Autowired
    public MercadologicoService service;
    
	 @GetMapping("/listAll")
	 public List<MercadologicosDTO> getAllMarketing() {
	        return service.getAllMarketing();
	    }
	 
	 @GetMapping("/listLast")
	 public MercadologicosDTO getLastMarketing() {
	        return service.getLastMarketing();
	    }
	
}
