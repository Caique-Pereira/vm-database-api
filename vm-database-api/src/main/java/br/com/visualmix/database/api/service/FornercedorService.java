package br.com.visualmix.database.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.visualmix.visualstore.databsp.md.dtos.FornecedoresDTO;
import br.com.visualmix.visualstore.databsp.md.repositories.FornecedoresRepository;

@Service
public class FornercedorService {
	
	@Autowired
	public FornecedoresRepository repo;
	
	public List<FornecedoresDTO> getAllSuppliers() {
	
		List<FornecedoresDTO> listFornecedorDto = new ArrayList<>();
		repo.findAll().forEach(Fornecedor -> {
			listFornecedorDto.add(Fornecedor.toDto());
		}); 
		 return listFornecedorDto;
	}
	
	public FornecedoresDTO getLastSupplier() {
		
		List<FornecedoresDTO> listFornecedorDto = new ArrayList<>();
		repo.findAll().forEach(Fornecedor -> {
			listFornecedorDto.add(Fornecedor.toDto());
		}); 
		
	     return listFornecedorDto.get(listFornecedorDto.size() -1);
	}

}
