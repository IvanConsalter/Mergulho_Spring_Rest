package com.ivanconsalter.algalog.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ivanconsalter.algalog.domain.model.Cliente;
import com.ivanconsalter.algalog.domain.repository.ClienteRepository;
import com.ivanconsalter.algalog.domain.service.CatalagoClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

	private ClienteRepository clienteRepository;
	private CatalagoClienteService catalagoClienteService;
	
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
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		return catalagoClienteService.salvar(cliente);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Cliente> atualizar(
			@PathVariable Long id,
			@Valid @RequestBody Cliente cliente) {
		
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(id);
		cliente = catalagoClienteService.salvar(cliente);
		
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		catalagoClienteService.excluir(id);
		
		return ResponseEntity.noContent().build();
	}

}
