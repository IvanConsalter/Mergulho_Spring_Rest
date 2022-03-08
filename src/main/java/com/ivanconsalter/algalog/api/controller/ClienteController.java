package com.ivanconsalter.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ivanconsalter.algalog.domain.model.Cliente;

@RestController
public class ClienteController {
	
	@GetMapping(path = "/clientes")
	public List<Cliente> listarTodos() {
		
		Cliente cliente1 = new Cliente(1L, "João", "99 99999-9999", "joao@gmail.com");
		Cliente cliente2 = new Cliente(2L, "Maria", "88 88888-8888", "maria@gmail.com");
		
		return Arrays.asList(cliente1, cliente2);
	}

}
