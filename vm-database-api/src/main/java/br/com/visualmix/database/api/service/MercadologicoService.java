package br.com.visualmix.database.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.visualmix.visualstore.databsp.md.dtos.MercadologicosDTO;
import br.com.visualmix.visualstore.databsp.md.repositories.MercadologicosRepository;

@Service
public class MercadologicoService {
	
	@Autowired
	public MercadologicosRepository repo;
	
	public List<MercadologicosDTO> getAllMarketing() {
	
		List<MercadologicosDTO> listMarketingDto = new ArrayList<>();
		repo.findAll().forEach(marketing -> {
			listMarketingDto.add(marketing.toDto());
		}); 
		 return listMarketingDto;
	}
	
	public MercadologicosDTO getLastMarketing() {
		
		List<MercadologicosDTO> listMarketingDto = new ArrayList<>();
		repo.findAll().forEach(marketing -> {
			listMarketingDto.add(marketing.toDto());
		}); 
		
	     return listMarketingDto.get(listMarketingDto.size() -1);
	}

}
