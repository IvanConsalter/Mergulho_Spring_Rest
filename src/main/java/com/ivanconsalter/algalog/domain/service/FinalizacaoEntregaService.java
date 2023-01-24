package com.ivanconsalter.algalog.domain.service;

import org.springframework.stereotype.Service;

import com.ivanconsalter.algalog.domain.model.Entrega;
import com.ivanconsalter.algalog.domain.repository.EntregaRepository;
import com.ivanconsalter.algalog.domain.service.util.BuscarEntregaServiceUtil;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {
	
	private BuscarEntregaServiceUtil buscarEntregaServiceUtil;
	
	private EntregaRepository entregaRepository;
	
	public void finalizar(Long entregaId) {
		Entrega entrega = buscarEntregaServiceUtil.buscar(entregaId);
		
		entrega.finalizar();
		entregaRepository.save(entrega);
		
	}

}
