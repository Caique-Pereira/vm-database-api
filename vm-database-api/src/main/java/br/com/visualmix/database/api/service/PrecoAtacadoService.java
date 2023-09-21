package br.com.visualmix.database.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.visualmix.visualstore.databsp.md.dtos.PrecoAtacintCapaDTO;
import br.com.visualmix.visualstore.databsp.md.models.PrecoAtacadoCapa;
import br.com.visualmix.visualstore.databsp.md.repositories.PrecoAtacintCapaRepository;

@Service
public class PrecoAtacadoService {
	@Autowired
	public PrecoAtacintCapaRepository repo;
	
	public List<PrecoAtacintCapaDTO> getAllPriceWholesale() {
	
		List<PrecoAtacintCapaDTO> listatacadoDto = new ArrayList<>();
		repo.findAll().forEach(atacado -> {
			listatacadoDto.add(atacado.toDto());
		}); 
		 return listatacadoDto;
	}
	
	public PrecoAtacintCapaDTO getLastPriceWholesale() {
		
		List<PrecoAtacintCapaDTO> listatacadoDto = new ArrayList<>();
		repo.findAll().forEach(atacado -> {
			listatacadoDto.add(atacado.toDto());
		}); 
		
	     return listatacadoDto.get(listatacadoDto.size() -1);
	}
	

}
