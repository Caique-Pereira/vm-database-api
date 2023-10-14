package br.com.visualmix.database.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.visualmix.visualstore.databsp.md.dtos.LojaDTO;
import br.com.visualmix.visualstore.db.services.bsp.LojaService;

@RestController
@RequestMapping("api/loja")
public class LojaController {

		@Autowired
	    public LojaService service;
	    
		 @GetMapping("/listAll")
		 public List<LojaDTO> getAllStores() {
		        return service.getAllStores();
		    }
		 
		 @GetMapping("/listLast")
		 public LojaDTO getLastStore() {
		        return service.getLastStore();
		    }
}
