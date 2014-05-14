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
@Entity(name="rotas")
public class Rota implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -7575456203330333226L;
	
	/** id */
	private Long id;
	
	/** linha */
	private Integer line;
	
	/** nome */
	private String name;
	
	/** cor */
	private String colour;
	
	/** divisa */
	private String stripe;

	
	
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
	 * @return the linha
	 */
	@Column(name="linha")
	public Integer getLine() {
		return line;
	}

	/**
	 * @return the nome
	 */
	@Column(name="nome")
	public String getName() {
		return name;
	}

	/**
	 * @return the cor
	 */
	@Column(name="cor")
	public String getColour() {
		return colour;
	}

	/**
	 * @return the divisa
	 */
	@Column(name="fachada")
	public String getStripe() {
		return stripe;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param linha the linha to set
	 */
	public void setLine(Integer line) {
		this.line = line;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param cor the cor to set
	 */
	public void setColour(String colour) {
		this.colour = colour;
	}

	/**
	 * @param divisa the divisa to set
	 */
	public void setStripe(String stripe) {
		this.stripe = stripe;
	}

	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && obj instanceof Rota){
			if(((Rota)obj).getId().equals(this.id)){
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}
