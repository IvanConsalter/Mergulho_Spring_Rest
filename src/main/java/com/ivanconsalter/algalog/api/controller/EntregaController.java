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

import com.ivanconsalter.algalog.api.dto.DestinatarioDTO;
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
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
		
		return solicitacaoEntregaService.solicitar(entrega);
	}
	
	@GetMapping
	public List<Entrega> listar() {
		return entregaRepository.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<EntregaDTO> obterPorId(@PathVariable Long id) {
		return entregaRepository.findById(id)
				.map( entrega -> {
					EntregaDTO entregaDTO = new EntregaDTO();
					entregaDTO.setId(entrega.getId());
					entregaDTO.setNomeCliente(entrega.getCliente().getNome());
					entregaDTO.setDestinatario(new DestinatarioDTO());
					entregaDTO.getDestinatario().setNome(entrega.getDestinatario().getNome());
					entregaDTO.getDestinatario().setLogradouro(entrega.getDestinatario().getLogradouro());
					entregaDTO.getDestinatario().setNumero(entrega.getDestinatario().getNumero());
					entregaDTO.getDestinatario().setComplemento(entrega.getDestinatario().getComplemento());
					entregaDTO.getDestinatario().setBairro(entrega.getDestinatario().getBairro());
					entregaDTO.setTaxa(entrega.getTaxa());
					entregaDTO.setStatus(entrega.getStatus());
					entregaDTO.setDataPedido(entrega.getDataPedido());
					entregaDTO.setDataFinalizacao(entrega.getDataFinalizacao());
					
					return ResponseEntity.ok().body(entregaDTO);
				})
				.orElse(ResponseEntity.notFound().build());
	}

}
