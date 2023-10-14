package br.com.visualmix.database.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.visualmix.visualstore.databsp.md.dtos.FornecedoresDTO;
import br.com.visualmix.visualstore.db.services.bsp.FornercedorService;

@RestController
@RequestMapping("api/fornecedor")
public class FornecedorController {
	
	@Autowired
    public FornercedorService service;
    
	 @GetMapping("/listAll")
	 public List<FornecedoresDTO> getAllSuppliers() {
	        return service.getAllSuppliers();
	    }
	 
	 @GetMapping("/listLast")
	 public FornecedoresDTO getLastSupplier() {
	        return service.getLastSupplier();
	    }

}
