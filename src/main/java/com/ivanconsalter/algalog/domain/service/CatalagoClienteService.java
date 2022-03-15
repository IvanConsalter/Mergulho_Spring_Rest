package com.ivanconsalter.algalog.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivanconsalter.algalog.domain.exception.NegocioException;
import com.ivanconsalter.algalog.domain.model.Cliente;
import com.ivanconsalter.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CatalagoClienteService {

	private ClienteRepository clienteRepository;
	
	public Cliente buscar(Long id) {
		return clienteRepository.findById(id)
				.orElseThrow( () -> new NegocioException("Cliente não encontrado!"));
	}
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		
		boolean emailExistente = clienteRepository.findByEmail(cliente.getEmail())
				.stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
		
		if(emailExistente) {
			throw new NegocioException("Já existe um cliente cadastrado com esse email!");
		}
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}
}
