package com.ivanconsalter.algalog.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivanconsalter.algalog.domain.model.Cliente;
import com.ivanconsalter.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listarTodos() {

		return clienteRepository.findAll();
	}
	
	@GetMapping(path = "/nome")
	public List<Cliente> listarPorNome() {
		
		return clienteRepository.findByNomeContaining("J");
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Cliente> obterPorId(@PathVariable Long id) {
		
		return clienteRepository.findById(id)
//				.map(cliente -> ResponseEntity.ok(cliente))
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
				
				
//		Optional<Cliente> cliente = clienteRepository.findById(id);
//		
//		if(cliente.isPresent()) {
//			return ResponseEntity.ok(cliente.get());
//		}
//		
//		return ResponseEntity.notFound().build();
	}

}
