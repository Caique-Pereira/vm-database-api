package br.com.visualmix.database.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.visualmix.visualstore.databsp.md.dtos.LojasDTO;
import br.com.visualmix.visualstore.databsp.md.repositories.LojasRepository;

@Service
public class LojasService {

	@Autowired
	public LojasRepository repo;
	
	public List<LojasDTO> getAllStores() {
	
		List<LojasDTO> listLojasDto = new ArrayList<>();
		repo.findAll().forEach(loja -> {
			listLojasDto.add(loja.toDto());
		}); 
		 return listLojasDto;
	}
	
	public LojasDTO getLastStore() {
		
		List<LojasDTO> listLojasDto = new ArrayList<>();
		repo.findAll().forEach(loja -> {
			listLojasDto.add(loja.toDto());
		}); 
		
	     return listLojasDto.get(listLojasDto.size() -1);
	}
	
}
