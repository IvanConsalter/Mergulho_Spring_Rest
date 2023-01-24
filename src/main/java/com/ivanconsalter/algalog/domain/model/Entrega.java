package com.ivanconsalter.algalog.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.ivanconsalter.algalog.domain.exception.NegocioException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Entrega {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Cliente cliente;
	
	@Embedded
	private Destinatario destinatario;
	
	private BigDecimal taxa;
	
	@Enumerated(EnumType.STRING)
	private StatusEntrega status;
	
	private OffsetDateTime dataPedido;
	
	private OffsetDateTime dataFinalizacao;
	
	@OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL)
	private List<Ocorrencia> listOcorrencia = new ArrayList<Ocorrencia>();
	
	public Ocorrencia adicionarOcorrencia(String descricao) {
		Ocorrencia ocorrencia = new Ocorrencia();
		ocorrencia.setDescricao(descricao);
		ocorrencia.setEntrega(this);
		ocorrencia.setDataRegistro(OffsetDateTime.now());
		
		this.getListOcorrencia().add(ocorrencia);
		
		return ocorrencia;
		
	}

	public void finalizar() {
		if(naoPodeSerFinalizada()) {
			throw new NegocioException("Entrega não pode ser finalizada.");
		}
		
		this.setStatus(StatusEntrega.FINALIZADA);
		this.setDataFinalizacao(OffsetDateTime.now());
	}
	
	private boolean podeSerFinalizada() {
		return StatusEntrega.PENDENTE.equals(this.getStatus());
	}
	
	private boolean naoPodeSerFinalizada() {
		return !podeSerFinalizada();
	}
}
