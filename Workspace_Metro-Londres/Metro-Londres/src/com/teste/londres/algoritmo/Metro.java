package com.teste.londres.algoritmo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

import com.teste.londres.entidades.Estacao;
import com.teste.londres.entidades.Linha;
import com.teste.londres.entidades.Rota;

/**
 * @author Jonathan
 * @version 13/05/2014
 *
 */
@ApplicationScoped
@Component
public class Metro {
	
	/** estacoes */
	private List<Estacao> estacoes;
	
	/** qtdTotalEstacoes */
	private Integer qtdTotalEstacoes;
	
	/** linhasDefinicao */
	private List<Rota> linhasDefinicao;
	
	/** stations */
	private Map<Long, Station> stations;
	
	/** linhas */
	private List<Linha> linhas;

	/** rotasDefinidas */
	private List<Trajeto> rotasDefinidas;

	
	
	/**
	 * define
	 */
	public void define(){
		qtdTotalEstacoes = 0;
		stations = new HashMap<Long, Station>();
		List<Station> estacoesVizinhas;
		List<Integer> linhasOrigem;
		Station station;
		
		
		for(Estacao estacao : estacoes){
			station = new Station();
			linhasOrigem = new ArrayList<Integer>();
			
			station.setIdentificador(estacao.getId());
			station.setNome(estacao.getName());
			station.setTempoDistancia(999999999);
			station.setVisitada(false);
			
			stations.put(estacao.getId(), station);
			qtdTotalEstacoes++;
		}
		
		Iterator<Entry<Long, Station>> it = stations.entrySet().iterator();
	    while (it.hasNext()) {
	    	linhasOrigem = new ArrayList<Integer>();
	    	estacoesVizinhas = new ArrayList<Station>();
	        Map.Entry<Long, Station> pairs = (Map.Entry<Long, Station>)it.next();
	        
	        for(Linha linha : linhas){
				if(linha.getStation1().equals(pairs.getKey().intValue())){
					linhasOrigem.add(new Integer(linha.getLine()));
					estacoesVizinhas.add(stations.get(linha.getStation2().longValue()));
				}else if(linha.getStation2().equals(pairs.getKey().intValue())){
					linhasOrigem.add(new Integer(linha.getLine()));
					estacoesVizinhas.add(stations.get(linha.getStation1().longValue()));
				}
			}
	        
	        pairs.getValue().setEstacoesVizinhas(estacoesVizinhas);
	        pairs.getValue().setLinhasOrigem(linhasOrigem);
	    }
	}
	
	/**
	 * inicializaDistancias
	 */
	public void inicializaDistancias(){
		Iterator<Entry<Long, Station>> it = stations.entrySet().iterator();
		Map.Entry<Long, Station> pairs;
	    while (it.hasNext()) {
	        pairs = (Map.Entry<Long, Station>)it.next();
	        pairs.getValue().setTempoDistancia(999999999);
	    }
	}
	
	
	/**
	 * @return the estacoes
	 */
	public List<Estacao> getEstacoes() {
		return estacoes;
	}

	/**
	 * @return the rotasDefinidas
	 */
	public List<Trajeto> getRotasDefinidas() {
		return rotasDefinidas;
	}

	/**
	 * @param estacoes the estacoes to set
	 */
	public void setEstacoes(List<Estacao> estacoes) {
		this.estacoes = estacoes;
	}

	/**
	 * @param rotasDefinidas the rotasDefinidas to set
	 */
	public void setRotasDefinidas(List<Trajeto> rotasDefinidas) {
		this.rotasDefinidas = rotasDefinidas;
	}

	/**
	 * @return the linhas
	 */
	public List<Linha> getLinhas() {
		return linhas;
	}

	/**
	 * @param linhas the linhas to set
	 */
	public void setLinhas(List<Linha> linhas) {
		this.linhas = linhas;
	}

	/**
	 * @return the linhasDefinicao
	 */
	public List<Rota> getLinhasDefinicao() {
		return linhasDefinicao;
	}

	/**
	 * @param linhasDefinicao the linhasDefinicao to set
	 */
	public void setLinhasDefinicao(List<Rota> linhasDefinicao) {
		this.linhasDefinicao = linhasDefinicao;
	}


	/**
	 * @return the stations
	 */
	public Map<Long, Station> getStations() {
		return stations;
	}


	/**
	 * @param stations the stations to set
	 */
	public void setStations(Map<Long, Station> stations) {
		this.stations = stations;
	}


	/**
	 * @return the qtdTotalEstacoes
	 */
	public Integer getQtdTotalEstacoes() {
		return qtdTotalEstacoes;
	}


	/**
	 * @param qtdTotalEstacoes the qtdTotalEstacoes to set
	 */
	public void setQtdTotalEstacoes(Integer qtdTotalEstacoes) {
		this.qtdTotalEstacoes = qtdTotalEstacoes;
	}

}
