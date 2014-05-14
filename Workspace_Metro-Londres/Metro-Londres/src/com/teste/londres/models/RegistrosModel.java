package com.teste.londres.models;

import java.util.List;

import com.teste.londres.algoritmo.Station;
import com.teste.londres.entidades.Estacao;
import com.teste.londres.entidades.Linha;
import com.teste.londres.entidades.Rota;

/**
 * @author Jonathan
 * @version 12/05/2014
 *
 */
public class RegistrosModel {
	
	/** estacoes */
	private List<Estacao> estacoes;
	
	/** linhas */
	private List<Linha> linhas;
	
	/** rotas */
	private List<Rota> rotas;
	
	/** stations */
	private List<Station> stations;
	
	/** numeroLinhas */
	private List<Integer> numeroLinhas;

	/**
	 * @return the estacoes
	 */
	public List<Estacao> getEstacoes() {
		return estacoes;
	}

	/**
	 * @return the linhas
	 */
	public List<Linha> getLinhas() {
		return linhas;
	}

	/**
	 * @return the rotas
	 */
	public List<Rota> getRotas() {
		return rotas;
	}

	/**
	 * @param estacoes the estacoes to set
	 */
	public void setEstacoes(List<Estacao> estacoes) {
		this.estacoes = estacoes;
	}

	/**
	 * @param linhas the linhas to set
	 */
	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
	}

	/**
	 * @param rotas the rotas to set
	 */
	public void setRotas(List<Rota> rotas) {
		this.rotas = rotas;
	}

	/**
	 * @return the stations
	 */
	public List<Station> getStations() {
		return stations;
	}

	/**
	 * @return the numeroLinhas
	 */
	public List<Integer> getNumeroLinhas() {
		return numeroLinhas;
	}

	/**
	 * @param stations the stations to set
	 */
	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	/**
	 * @param numeroLinhas the numeroLinhas to set
	 */
	public void setNumeroLinhas(List<Integer> numeroLinhas) {
		this.numeroLinhas = numeroLinhas;
	}
}
