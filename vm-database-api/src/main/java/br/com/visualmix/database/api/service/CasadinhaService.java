package br.com.visualmix.database.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.visualmix.visualstore.databsp.base.dtos.CasadinhaDTO;
import br.com.visualmix.visualstore.databsp.base.repositories.CasadinhaRepository;

@Service
public class CasadinhaService {

	@Autowired
	public CasadinhaRepository repo;
	
	public List<CasadinhaDTO> getAllProducts() {
		
		List<CasadinhaDTO> listCasadinhaDto = new ArrayList<>();
		repo.findAll().forEach(casadinha -> {
			listCasadinhaDto.add(casadinha.toDto());
		}); 
		 return listCasadinhaDto;
	}

}
