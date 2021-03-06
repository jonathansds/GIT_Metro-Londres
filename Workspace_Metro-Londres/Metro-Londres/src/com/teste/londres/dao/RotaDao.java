package com.teste.londres.dao;

import java.util.List;

import com.teste.londres.entidades.Rota;
import com.teste.londres.utils.AbstractDao;

/**
 * @author Jonathan
 * @version 12/05/2014
 *
 */
public interface RotaDao extends AbstractDao<Rota>{
	
	/**
	 * listAll
	 * @return lista
	 */
	public List<Rota> listAll();

	
	/**
	 * persiste
	 * @param lista
	 * @return se sucesso
	 */
	public boolean persiste(List<Rota> lista);
}
