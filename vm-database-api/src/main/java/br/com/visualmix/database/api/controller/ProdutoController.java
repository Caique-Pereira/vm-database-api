package br.com.visualmix.database.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.visualmix.visualstore.databsp.md.dtos.ProdutosDTO;
import br.com.visualmix.database.api.service.ProdutoService;

@RestController
@RequestMapping("api/produtos")
public class ProdutoController {

	@Autowired
    public ProdutoService service;
    
	 @GetMapping("/listAll")
	 public List<ProdutosDTO> getAllProducts() {
	        return service.getAllProducts();
	    }
	 
	 @GetMapping("/listLast")
	 public ProdutosDTO getLastProduct() {
	        return service.getLastProduct();
	    }
	
}
