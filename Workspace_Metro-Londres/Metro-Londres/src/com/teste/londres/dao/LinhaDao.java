package com.teste.londres.dao;

import java.util.List;

import com.teste.londres.entidades.Linha;
import com.teste.londres.utils.AbstractDao;

/**
 * @author Jonathan
 * @version 12/05/2014
 *
 */
public interface LinhaDao extends AbstractDao<Linha>{
	
	/**
	 * listAll
	 * @return lista
	 */
	public List<Linha> listAll();

	
	/**
	 * persiste
	 * @param lista
	 * @return se sucesso
	 */
	public boolean persiste(List<Linha> lista);
}
