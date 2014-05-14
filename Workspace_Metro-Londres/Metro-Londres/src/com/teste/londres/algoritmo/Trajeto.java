package com.teste.londres.algoritmo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Jonathan
 * @version 13/05/2014
 *
 */
@XmlRootElement(name="Trajeto")
@XmlSeeAlso(value={Station.class})
@XmlType(propOrder={"estacaoOrigem", "estacaoDestino", "menorCaminho"})
public class Trajeto implements Serializable{
	
	/** serialVersionUID */
	private static final long serialVersionUID = 8446076075323927456L;

	/** estacaoOrigem */
	private Station estacaoOrigem;
	
	/** estacaoDestino */
	private Station estacaoDestino;
	
	/** menorCaminho */
	private List<Station> menorCaminho;

	/**
	 * @return the estacaoOrigem
	 */
	public Station getEstacaoOrigem() {
		return estacaoOrigem;
	}

	/**
	 * @return the estacaoDestino
	 */
	public Station getEstacaoDestino() {
		return estacaoDestino;
	}

	/**
	 * @return the menorCaminho
	 */
	public List<Station> getMenorCaminho() {
		return menorCaminho;
	}

	/**
	 * @param estacaoOrigem the estacaoOrigem to set
	 */
	public void setEstacaoOrigem(Station estacaoOrigem) {
		this.estacaoOrigem = estacaoOrigem;
	}

	/**
	 * @param estacaoDestino the estacaoDestino to set
	 */
	public void setEstacaoDestino(Station estacaoDestino) {
		this.estacaoDestino = estacaoDestino;
	}

	/**
	 * @param menorCaminho the menorCaminho to set
	 */
	public void setMenorCaminho(List<Station> menorCaminho) {
		this.menorCaminho = menorCaminho;
	}

	
}
