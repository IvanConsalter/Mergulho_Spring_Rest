package com.ivanconsalter.algalog.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ivanconsalter.algalog.domain.exception.NegocioException;
import com.ivanconsalter.algalog.domain.model.Entrega;
import com.ivanconsalter.algalog.domain.model.Ocorrencia;
import com.ivanconsalter.algalog.domain.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OcorrenciaService {

	private EntregaRepository entregaRepository;
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega = entregaRepository.findById(entregaId)
				.orElseThrow( () -> new NegocioException("Entrega não encontrada."));
		
		return entrega.adicionarOcorrencia(descricao);
	}
}
