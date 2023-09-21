package br.com.visualmix.database.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.visualmix.visualstore.databsp.md.dtos.AcessoPerfilDTO;
import br.com.visualmix.visualstore.databsp.md.repositories.AcessoPerfilRepository;

@Service
public class AcessoPerfilService {
	
	@Autowired
	public AcessoPerfilRepository repo;
	
	public List<AcessoPerfilDTO> getAllAccessProfiles() {
	
		List<AcessoPerfilDTO> listAcessoPerfilDto = new ArrayList<>();
		repo.findAll().forEach(acessoPerfil -> {
			listAcessoPerfilDto.add(acessoPerfil.toDto());
		}); 
		 return listAcessoPerfilDto;
	}
	
	public AcessoPerfilDTO getLastAccessProfile() {
		
		List<AcessoPerfilDTO> listAcessoPerfilDto = new ArrayList<>();
		repo.findAll().forEach(acessoPerfil -> {
			listAcessoPerfilDto.add(acessoPerfil.toDto());
		}); 
		
	     return listAcessoPerfilDto.get(listAcessoPerfilDto.size() -1);
	}


}
