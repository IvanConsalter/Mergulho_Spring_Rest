package com.ivanconsalter.algalog.domain.service.util;

import org.springframework.stereotype.Service;

import com.ivanconsalter.algalog.domain.exception.EntidadeNaoEncontradoException;
import com.ivanconsalter.algalog.domain.model.Entrega;
import com.ivanconsalter.algalog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BuscarEntregaServiceUtil {

	private EntregaRepository entregaRepository;
	
	public Entrega buscar(Long id) {
		return entregaRepository.findById(id)
		.orElseThrow( () -> new EntidadeNaoEncontradoException("Entrega não encontrada."));
	}
}
