package com.ivanconsalter.algalog.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ivanconsalter.algalog.api.dto.EntregaDTO;
import com.ivanconsalter.algalog.domain.model.Entrega;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class EntregaMapper {
	
	private ModelMapper modelMapper;
	
	public EntregaDTO toDTO(Entrega entrega) {
		return modelMapper.map(entrega, EntregaDTO.class);
	}
	
	public List<EntregaDTO> toListDTO(List<Entrega> listEntrega) {
		return listEntrega.stream()
			.map(this::toDTO)
			.collect(Collectors.toList());
	}

}
