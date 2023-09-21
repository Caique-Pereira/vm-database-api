package br.com.visualmix.database.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.visualmix.visualstore.databsp.md.dtos.ProdutosDTO;
import br.com.visualmix.visualstore.databsp.md.repositories.ProdutosRepository;

@Service
public class ProdutoService {
	
	@Autowired
	public ProdutosRepository repo;
	
	public List<ProdutosDTO> getAllProducts() {
	
		List<ProdutosDTO> listProdutoDto = new ArrayList<>();
		repo.findAll().forEach(produto -> {
			listProdutoDto.add(produto.toDto());
		}); 
		 return listProdutoDto;
	}
	
	public ProdutosDTO getLastProduct() {
		
		List<ProdutosDTO> listProdutoDto = new ArrayList<>();
		repo.findAll().forEach(produto -> {
			listProdutoDto.add(produto.toDto());
		}); 
		
	     return listProdutoDto.get(listProdutoDto.size() -1);
	}


}
