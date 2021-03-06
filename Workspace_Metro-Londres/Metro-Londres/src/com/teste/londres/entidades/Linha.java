package com.teste.londres.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Jonathan
 * @version 12/05/2014
 *
 */
@Entity(name="linhas")
public class Linha implements Serializable{

	/** serialVersionUID */
	private static final long serialVersionUID = 5248761005981238037L;

	/** id */
	private Long id;
	
	/** estacao1 */
	private Integer station1;
	
	/** estacao2 */
	private Integer station2;
	
	/** linha */
	private Integer line;
	
	

	
	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	public Long getId() {
		return id;
	}
	
	/**
	 * @return the estacao1
	 */
	@Column(name="estacao1")
	public Integer getStation1() {
		return station1;
	}

	/**
	 * @return the estacao2
	 */
	@Column(name="estacao2")
	public Integer getStation2() {
		return station2;
	}

	/**
	 * @return the linha
	 */
	@Column(name="linha")
	public Integer getLine() {
		return line;
	}

	/**
	 * @param estacao1 the estacao1 to set
	 */
	public void setStation1(Integer station1) {
		this.station1 = station1;
	}

	/**
	 * @param estacao2 the estacao2 to set
	 */
	public void setStation2(Integer station2) {
		this.station2 = station2;
	}

	/**
	 * @param linha the linha to set
	 */
	public void setLine(Integer line) {
		this.line = line;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Linha){
			if(((Linha)obj).getId().equals(this.id)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.station1 + " - " + station2;
	}
}
