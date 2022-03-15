package com.ivanconsalter.algalog.domain.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ivanconsalter.algalog.domain.model.Cliente;
import com.ivanconsalter.algalog.domain.model.Entrega;
import com.ivanconsalter.algalog.domain.model.StatusEntrega;
import com.ivanconsalter.algalog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SolicitacaoEntregaService {

	private CatalagoClienteService catalagoClienteService;
	private EntregaRepository entregaRepository;
	
	@Transactional
	public Entrega solicitar(Entrega entrega) {
		
		Cliente cliente = catalagoClienteService.buscar(entrega.getCliente().getId());
		
		entrega.setCliente(cliente);
		entrega.setStatus(StatusEntrega.PENDENTE);
		entrega.setDataPedido(LocalDateTime.now());
		
		return entregaRepository.save(entrega);
	}
}
