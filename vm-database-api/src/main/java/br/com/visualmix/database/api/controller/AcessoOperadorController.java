package br.com.visualmix.database.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.visualmix.database.api.service.AcessoOperadorService;
import br.com.visualmix.visualstore.databsp.md.dtos.AcessoOperadoresDTO;

@RestController
@RequestMapping("api/acessoOperador")
public class AcessoOperadorController {

	@Autowired
    public AcessoOperadorService service;
    
	 @GetMapping("/listAll")
	 public List<AcessoOperadoresDTO> getAllAccessOperators() {
	        return service.getAllAccessOperators();
	    }
	 
	 @GetMapping("/listLast")
	 public AcessoOperadoresDTO getLastAccessOperator() {
	        return service.getLastAccessOperator();
	    }
	 
	
	
}
