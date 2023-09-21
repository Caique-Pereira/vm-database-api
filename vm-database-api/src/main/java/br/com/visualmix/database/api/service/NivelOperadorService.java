package br.com.visualmix.database.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.visualmix.visualstore.databsp.md.dtos.NiveisOperadoresDTO;
import br.com.visualmix.visualstore.databsp.md.repositories.NiveisOperadoresRepository;

@Service
public class NivelOperadorService {
	
	@Autowired
	public NiveisOperadoresRepository repo;
	
	public List<NiveisOperadoresDTO> getAllLevelsOperators() {
	
		List<NiveisOperadoresDTO> listNivelOperadorDto = new ArrayList<>();
		repo.findAll().forEach(nivelOperador -> {
			listNivelOperadorDto.add(nivelOperador.toDto());
		}); 
		 return listNivelOperadorDto;
	}
	
	public NiveisOperadoresDTO getLastLevelsOperators() {
		
		List<NiveisOperadoresDTO> listNivelOperadorDto = new ArrayList<>();
		repo.findAll().forEach(nivelOperador -> {
			listNivelOperadorDto.add(nivelOperador.toDto());
		}); 
		
	     return listNivelOperadorDto.get(listNivelOperadorDto.size() -1);
	}

}
