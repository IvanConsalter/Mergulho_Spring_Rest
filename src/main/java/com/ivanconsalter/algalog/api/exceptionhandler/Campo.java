package com.ivanconsalter.algalog.api.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Campo {
	
	private String nome;
	private String mensagem;
	
	public Campo() {
	}

}
