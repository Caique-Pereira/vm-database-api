package br.com.visualmix.database.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.visualmix.database.api.service.ProcessosResultadoService;
import br.com.visualmix.visualstore.databsp.md.dtos.ProcessosResultadoDTO;

@RestController
@RequestMapping("api/processosResultados")
public class ProcessosResultadoController {

	@Autowired
    public ProcessosResultadoService service;
    
	 @GetMapping("/listAll")
	 public List<ProcessosResultadoDTO> getAllProcessesResults() {
	        return service.getAllProcessesResults();
	    }
	 
	 @GetMapping("/listLast")
	 public ProcessosResultadoDTO getLastProcessesResult() {
	        return service.getLastProcessesResult();
	    }
}
