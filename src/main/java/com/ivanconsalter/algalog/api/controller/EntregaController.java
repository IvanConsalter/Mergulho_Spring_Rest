package com.ivanconsalter.algalog.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ivanconsalter.algalog.api.dto.EntregaDTO;
import com.ivanconsalter.algalog.domain.model.Entrega;
import com.ivanconsalter.algalog.domain.repository.EntregaRepository;
import com.ivanconsalter.algalog.domain.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/entregas")
public class EntregaController {
	
	private EntregaRepository entregaRepository;
	private SolicitacaoEntregaService solicitacaoEntregaService;
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
		
		return solicitacaoEntregaService.solicitar(entrega);
	}
	
	@GetMapping
	public List<EntregaDTO> listar() {
		List<Entrega> listEntrega = entregaRepository.findAll(); 
		List<EntregaDTO> listEntregaDTO = new ArrayList<EntregaDTO>();
		
		listEntrega.forEach(entrega -> {
			listEntregaDTO.add(modelMapper.map(entrega, EntregaDTO.class));
		});
		return listEntregaDTO;
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<EntregaDTO> obterPorId(@PathVariable Long id) {
		return entregaRepository.findById(id)
				.map( entrega -> {
					EntregaDTO entregaDTO = modelMapper.map(entrega, EntregaDTO.class);
					
					return ResponseEntity.ok().body(entregaDTO);
				})
				.orElse(ResponseEntity.notFound().build());
	}

}
