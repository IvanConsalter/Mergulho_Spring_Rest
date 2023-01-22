package com.ivanconsalter.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ivanconsalter.algalog.api.mapper.EntregaMapper;
import com.ivanconsalter.algalog.api.model.dto.EntregaDTO;
import com.ivanconsalter.algalog.api.model.input.EntregaInput;
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
	private EntregaMapper entregaMapper;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public EntregaDTO solicitar(@Valid @RequestBody EntregaInput entregaInput) {
		Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(entregaMapper.toEntity(entregaInput));
		return entregaMapper.toDTO(entregaSolicitada);
	}
	
	@GetMapping
	public List<EntregaDTO> listar() {
		List<Entrega> listEntrega = entregaRepository.findAll(); 
		
		return entregaMapper.toListDTO(listEntrega);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<EntregaDTO> obterPorId(@PathVariable Long id) {
		return entregaRepository.findById(id)
				.map( entrega -> ResponseEntity.ok(entregaMapper.toDTO(entrega)))
				.orElse(ResponseEntity.notFound().build());
	}

}
