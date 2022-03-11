package com.ivanconsalter.algalog.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivanconsalter.algalog.domain.model.Cliente;
import com.ivanconsalter.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ClienteController {

	private ClienteRepository clienteRepository;
	
	@GetMapping(path = "/clientes")
	public List<Cliente> listarTodos() {

		return clienteRepository.findAll();
	}

}
