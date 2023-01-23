package com.ivanconsalter.algalog.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<OcorrenciaDTO> toListDTO(List<Ocorrencia> listOcorrencia) {
		return listOcorrencia.stream()
				.map(this::toDTO)
				.collect(Collectors.toList());
	}

}
