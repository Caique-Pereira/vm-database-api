package br.com.visualmix.database.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.visualmix.visualstore.databsp.md.dtos.CupomDTO;
import br.com.visualmix.visualstore.databsp.md.repositories.CupomRepository;

@Service
public class CupomService {
	
	@Autowired
	public CupomRepository repo;
	
	public List<CupomDTO> getAllcoupons() {
	
		List<CupomDTO> listCupomDto = new ArrayList<>();
		repo.findAll().forEach(cupom -> {
			listCupomDto.add(cupom.toDto());
		}); 
		 return listCupomDto;
	}
	
	public CupomDTO getLastcoupon() {
		
		List<CupomDTO> listCupomDto = new ArrayList<>();
		repo.findAll().forEach(cupom -> {
			listCupomDto.add(cupom.toDto());
		}); 
		
	     return listCupomDto.get(listCupomDto.size() -1);
	}


}
