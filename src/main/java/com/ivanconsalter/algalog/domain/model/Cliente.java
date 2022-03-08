package com.ivanconsalter.algalog.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Cliente {
	
	private Long id;
	private String nome;
	private String email;
	private String telefone;

}
