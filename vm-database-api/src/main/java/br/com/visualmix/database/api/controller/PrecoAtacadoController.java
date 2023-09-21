package br.com.visualmix.database.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.visualmix.database.api.service.PrecoAtacadoService;
import br.com.visualmix.visualstore.databsp.md.dtos.PrecoAtacintCapaDTO;

@RestController
@RequestMapping("api/precoAtacado")
public class PrecoAtacadoController {
	
	@Autowired
    public PrecoAtacadoService service;
    
	 @GetMapping("/listAll")
	 public List<PrecoAtacintCapaDTO> getAllPriceWholesale() {
	        return service.getAllPriceWholesale();
	    }
	 
	 @GetMapping("/listLast")
	 public PrecoAtacintCapaDTO getLastPriceWholesale() {
	        return service.getLastPriceWholesale();
	    }


}
