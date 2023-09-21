package br.com.visualmix.database.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.visualmix.visualstore.databsp.md.dtos.KitcapaDTO;
import br.com.visualmix.visualstore.databsp.md.repositories.KitcapaRepository;

@Service
public class KitCapaService {
	
	@Autowired
	public KitcapaRepository repo;
	
	public List<KitcapaDTO> getAllKitCovers() {
	
		List<KitcapaDTO> listKitcapaDto = new ArrayList<>();
		repo.findAll().forEach(kitCapa -> {
			listKitcapaDto.add(kitCapa.toDto());
		}); 
		 return listKitcapaDto;
	}
	
	public KitcapaDTO getLastKitCover() {
		
		List<KitcapaDTO> listKitcapaDto = new ArrayList<>();
		repo.findAll().forEach(kitCapa -> {
			listKitcapaDto.add(kitCapa.toDto());
		}); 
		
	     return listKitcapaDto.get(listKitcapaDto.size() -1);
	}
	
}
