package com.teste.londres.algoritmo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Jonathan
 * @version 13/05/2014
 *
 */
@XmlRootElement(name="Estacao")
@XmlType(propOrder={"nome"})
public class Station implements Comparable<Station>, Serializable{
	
	/** serialVersionUID */
	private static final long serialVersionUID = -8835834451229593970L;

	/** identificador */
	private Long identificador;
	
	/** nome */
	private String nome;
	
	/** visitada */
	private Boolean visitada;
	
	/** estacaoAnterior */
	private Station estacaoAnterior;
	
	/** tempoDistancia */
	private Integer tempoDistancia;

	/** estacoesVizinhas */
	private List<Station> estacoesVizinhas;
	
	/** linhasOrigem */
	private List<Integer> linhasOrigem;
	
	/** linhaEscolhida */
	private Integer linhaEscolhida;
	
	
	
	
	/**
	 * @return the tempoDistancia
	 */
	public Integer getTempoDistancia() {
		return tempoDistancia;
	}

	/**
	 * @param tempoDistancia the tempoDistancia to set
	 */
	public void setTempoDistancia(Integer tempoDistancia) {
		this.tempoDistancia = tempoDistancia;
	}

	/**
	 * @return the estacoesVizinhas
	 */
	public List<Station> getEstacoesVizinhas() {
		return estacoesVizinhas;
	}

	/**
	 * @param estacoesVizinhas the estacoesVizinhas to set
	 */
	public void setEstacoesVizinhas(List<Station> estacoesVizinhas) {
		this.estacoesVizinhas = estacoesVizinhas;
	}

	/**
	 * @return the identificador
	 */
	public Long getIdentificador() {
		return identificador;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(Long identificador) {
		this.identificador = identificador;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the visitada
	 */
	public Boolean getVisitada() {
		return visitada;
	}

	/**
	 * @param visitada the visitada to set
	 */
	public void setVisitada(Boolean visitada) {
		this.visitada = visitada;
	}

	/**
	 * @return the estacaoAnterior
	 */
	public Station getEstacaoAnterior() {
		return estacaoAnterior;
	}

	/**
	 * @param estacaoAnterior the estacaoAnterior to set
	 */
	public void setEstacaoAnterior(Station estacaoAnterior) {
		this.estacaoAnterior = estacaoAnterior;
	}

	/**
	 * @return the linhasOrigem
	 */
	public List<Integer> getLinhasOrigem() {
		return linhasOrigem;
	}

	/**
	 * @param linhasOrigem the linhasOrigem to set
	 */
	public void setLinhasOrigem(List<Integer> linhasOrigem) {
		this.linhasOrigem = linhasOrigem;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Station){
			if(((Station)obj).getIdentificador().equals(this.identificador)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}

	@Override
	public int compareTo(Station station) {
        if(this.getTempoDistancia() < station.getTempoDistancia()) return -1;
		else if(this.getTempoDistancia().equals(station.getTempoDistancia())) return 0;
		
		return 1;
	}

	/**
	 * @return the linhaEscolhida
	 */
	public Integer getLinhaEscolhida() {
		return linhaEscolhida;
	}

	/**
	 * @param linhaEscolhida the linhaEscolhida to set
	 */
	public void setLinhaEscolhida(Integer linhaEscolhida) {
		this.linhaEscolhida = linhaEscolhida;
	}
}
