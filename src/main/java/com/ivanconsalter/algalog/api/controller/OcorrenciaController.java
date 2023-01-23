package com.ivanconsalter.algalog.api.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ivanconsalter.algalog.api.mapper.OcorrenciaMapper;
import com.ivanconsalter.algalog.api.model.dto.OcorrenciaDTO;
import com.ivanconsalter.algalog.api.model.input.OcorrenciaInput;
import com.ivanconsalter.algalog.domain.model.Ocorrencia;
import com.ivanconsalter.algalog.domain.service.OcorrenciaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {
	
	private OcorrenciaService ocorrenciaService;
	
	private OcorrenciaMapper ocorrenciaMapper;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public OcorrenciaDTO registrar(
			@PathVariable Long entregaId,
			@Valid @RequestBody OcorrenciaInput ocorrenciaInput
		) {
		
		Ocorrencia ocorrenciaRegistrada = ocorrenciaService.registrar(entregaId, ocorrenciaInput.getDescricao());
		
		return ocorrenciaMapper.toDTO(ocorrenciaRegistrada);
	}
	
}
