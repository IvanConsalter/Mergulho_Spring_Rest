package com.ivanconsalter.algalog.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ivanconsalter.algalog.api.model.dto.OcorrenciaDTO;
import com.ivanconsalter.algalog.domain.model.Ocorrencia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OcorrenciaMapper {
	
	private ModelMapper modelMapper;
	
	public OcorrenciaDTO toDTO(Ocorrencia ocorrencica) {
		return modelMapper.map(ocorrencica, OcorrenciaDTO.class);
	}

}
