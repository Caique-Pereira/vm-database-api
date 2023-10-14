package br.com.visualmix.database.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.visualmix.visualstore.databsp.md.dtos.NiveisOperadoresDTO;
import br.com.visualmix.visualstore.db.services.bsp.NivelOperadorService;

@RestController
@RequestMapping("api/niveisOperadores")
public class NivelOperadorController {

	@Autowired
    public NivelOperadorService service;
    
	 @GetMapping("/listAll")
	 public List<NiveisOperadoresDTO> getAllLevelsOperators() {
	        return service.getAllLevelsOperators();
	    }
	 
	 @GetMapping("/listLast")
	 public NiveisOperadoresDTO getLastLevelsOperators() {
	        return service.getLastLevelsOperators();
	    }
	
}
