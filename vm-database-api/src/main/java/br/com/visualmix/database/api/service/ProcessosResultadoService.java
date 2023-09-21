package br.com.visualmix.database.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.visualmix.visualstore.databsp.md.dtos.ProcessosResultadoDTO;
import br.com.visualmix.visualstore.databsp.md.repositories.ProcessosResultadoRepository;

@Service
public class ProcessosResultadoService {

	@Autowired
	public ProcessosResultadoRepository repo;
	
	public List<ProcessosResultadoDTO> getAllProcessesResults() {
	
		List<ProcessosResultadoDTO> listProcessosResultadoDto = new ArrayList<>();
		repo.findAll().forEach(processosResultado -> {
			listProcessosResultadoDto.add(processosResultado.toDto());
		}); 
		 return listProcessosResultadoDto;
	}
	
	public ProcessosResultadoDTO getLastProcessesResult() {
		
		List<ProcessosResultadoDTO> listProcessosResultadoDto = new ArrayList<>();
		repo.findAll().forEach(processosResultado -> {
			listProcessosResultadoDto.add(processosResultado.toDto());
		}); 
		
	     return listProcessosResultadoDto.get(listProcessosResultadoDto.size() -1);
	}

}
