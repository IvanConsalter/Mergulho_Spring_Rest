package com.ivanconsalter.algalog.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Problema {
	
	private Integer status;
	private LocalDateTime dataHora;
	private String titulo;
	
	private List<Campo> campos;
	
	public Problema() {
	}
	
}
