package br.com.visualmix.database.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.visualmix.visualstore.databsp.md.dtos.ComponentesDTO;
import br.com.visualmix.visualstore.databsp.md.repositories.ComponentesRepository;

@Service
public class ComponenteService {
	
	@Autowired
	public ComponentesRepository repo;
	
	
	public List<ComponentesDTO> getAllComponents() {
	
		List<ComponentesDTO> listComponenteDto = new ArrayList<>();
		repo.findAll().forEach(componente -> {
			listComponenteDto.add(componente.toDto());
		}); 
		 return listComponenteDto;
	}
	
	public ComponentesDTO getLastComponent() {
		
		List<ComponentesDTO> listComponenteDto = new ArrayList<>();
		repo.findAll().forEach(componente -> {
			listComponenteDto.add(componente.toDto());
		}); 
		
	     return listComponenteDto.get(listComponenteDto.size() -1);
	}
	
	


}
