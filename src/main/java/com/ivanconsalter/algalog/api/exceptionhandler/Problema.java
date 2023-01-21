package com.ivanconsalter.algalog.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(value = Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
public class Problema {
	
	private Integer status;
	private OffsetDateTime dataHora;
	private String titulo;
	
	private List<Campo> campos;
	
	public Problema() {
	}

	public Problema(Integer status, OffsetDateTime dataHora, String titulo) {
		this.status = status;
		this.dataHora = dataHora;
		this.titulo = titulo;
	}
	
}
