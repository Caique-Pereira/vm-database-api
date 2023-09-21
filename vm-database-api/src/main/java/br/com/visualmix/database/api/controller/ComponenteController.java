package br.com.visualmix.database.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.visualmix.database.api.service.ComponenteService;
import br.com.visualmix.visualstore.databsp.md.dtos.ComponentesDTO;

@RestController
@RequestMapping("api/componentes")
public class ComponenteController {

	@Autowired
    public ComponenteService service;
    
	 @GetMapping("/listAll")
	 public List<ComponentesDTO> getAllComponents() {
	        return service.getAllComponents();
	    }
	 
	 @GetMapping("/listLast")
	 public ComponentesDTO getLastComponent() {
	        return service.getLastComponent();
	    }
	
}
