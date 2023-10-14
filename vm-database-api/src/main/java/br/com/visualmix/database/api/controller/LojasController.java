package br.com.visualmix.database.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.visualmix.visualstore.databsp.md.dtos.LojasDTO;
import br.com.visualmix.visualstore.db.services.bsp.LojasService;

@RestController
@RequestMapping("api/lojas")
public class LojasController {

	@Autowired
    public LojasService service;
    
	 @GetMapping("/listAll")
	 public List<LojasDTO> getAllStores() {
	        return service.getAllStores();
	    }
	 
	 @GetMapping("/listLast")
	 public LojasDTO getLastStore() {
	        return service.getLastStore();
	    }

	
	
}
