package br.com.visualmix.database.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.visualmix.visualstore.databsp.md.dtos.LojaDTO;
import br.com.visualmix.visualstore.databsp.md.repositories.LojaRepository;

@Service
public class LojaService {
	
	@Autowired 
	public LojaRepository repo;

	public List<LojaDTO> getAllStores() {
		
		List<LojaDTO> listLojaDto = new ArrayList<>();
		repo.findAll().forEach(loja -> {
			listLojaDto.add(loja.toDto());
		}); 
		 return listLojaDto;
	}
	
	public LojaDTO getLastStore() {
		
		List<LojaDTO> listLojaDto = new ArrayList<>();
		repo.findAll().forEach(loja -> {
			listLojaDto.add(loja.toDto());
		}); 
		
	     return listLojaDto.get(listLojaDto.size() -1);
	}

	
}
