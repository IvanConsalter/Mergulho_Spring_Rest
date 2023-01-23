package com.ivanconsalter.algalog.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ivanconsalter.algalog.domain.model.Entrega;
import com.ivanconsalter.algalog.domain.model.Ocorrencia;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OcorrenciaService {
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao, Entrega entrega) {
		return entrega.adicionarOcorrencia(descricao);
	}
	
}
