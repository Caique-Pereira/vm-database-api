package br.com.visualmix.database.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.visualmix.database.api.service.CasadinhaService;
import br.com.visualmix.visualstore.databsp.base.dtos.CasadinhaDTO;

@RestController
@RequestMapping("api/casadinhas")
public class CasadinhaController {

	@Autowired
    public CasadinhaService service;
    
	 @GetMapping("/listAll")
	 public List<CasadinhaDTO> getAllProducts() {
	        return service.getAllProducts();
	    }
}
