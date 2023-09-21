package br.com.visualmix.database.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.visualmix.database.api.service.CupomService;
import br.com.visualmix.visualstore.databsp.md.dtos.CupomDTO;

@RestController
@RequestMapping("api/cupom")
public class CupomController {
	
	@Autowired
    public CupomService service;
    
	 @GetMapping("/listAll")
	 public List<CupomDTO> getAllcoupons() {
	        return service.getAllcoupons();
	    }
	 
	 @GetMapping("/listLast")
	 public CupomDTO getLastcoupon() {
	        return service.getLastcoupon();
	    }

}
