package br.com.visualmix.database.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.visualmix.database.api.service.AcessoPerfilService;
import br.com.visualmix.visualstore.databsp.md.dtos.AcessoPerfilDTO;

@RestController
@RequestMapping("api/acessoPerfil")
public class AcessoPerfilController {

	@Autowired
    public AcessoPerfilService service;
    
	 @GetMapping("/listAll")
	 public List<AcessoPerfilDTO> getAllAccessProfiles() {
	        return service.getAllAccessProfiles();
	    }
	 
	 @GetMapping("/listLast")
	 public AcessoPerfilDTO getLastAccessProfile() {
	        return service.getLastAccessProfile();
	    }


}
