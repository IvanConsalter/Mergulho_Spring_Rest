package com.ivanconsalter.algalog.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ivanconsalter.algalog.domain.model.Entrega;
import com.ivanconsalter.algalog.domain.model.Ocorrencia;
import com.ivanconsalter.algalog.domain.service.util.BuscarEntregaServiceUtil;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OcorrenciaService {

	private BuscarEntregaServiceUtil buscarEntregaServiceUtil;
	
	@Transactional
	public Ocorrencia registrar(Long entregaId, String descricao) {
		Entrega entrega = buscarEntregaServiceUtil.buscar(entregaId);
		
		return entrega.adicionarOcorrencia(descricao);
	}
}
