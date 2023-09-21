package br.com.visualmix.database.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.visualmix.visualstore.databsp.md.dtos.AcessoOperadoresDTO;
import br.com.visualmix.visualstore.databsp.md.repositories.AcessoOperadoresRepository;

@Service
public class AcessoOperadorService {
	
	@Autowired
	public AcessoOperadoresRepository repo;
	
	public List<AcessoOperadoresDTO> getAllAccessOperators() {
	
		List<AcessoOperadoresDTO> listAcessoOperadorDto = new ArrayList<>();
		repo.findAll().forEach(Operador -> {
			listAcessoOperadorDto.add(Operador.toDto());
		}); 
		 return listAcessoOperadorDto;
	}
	
	
	public AcessoOperadoresDTO getLastAccessOperator() {
		
		List<AcessoOperadoresDTO> listAcessoOperadorDto = new ArrayList<>();
		repo.findAll().forEach(Operador -> {
			listAcessoOperadorDto.add(Operador.toDto());
		}); 
		
	     return listAcessoOperadorDto.get(listAcessoOperadorDto.size() -1);
	}
	
	


}
