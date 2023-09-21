package br.com.visualmix.database.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.visualmix.database.api.service.KitCapaService;
import br.com.visualmix.visualstore.databsp.md.dtos.KitcapaDTO;

@RestController
@RequestMapping("api/kitCapas")
public class KitCapaController {
	
	@Autowired
    public KitCapaService service;
    
	 @GetMapping("/listAll")
	 public List<KitcapaDTO> getAllKitCovers() {
	        return service.getAllKitCovers();
	    }
	 
	 @GetMapping("/listLast")
	 public KitcapaDTO getLastKitCover() {
	        return service.getLastKitCover();
	    }
}
