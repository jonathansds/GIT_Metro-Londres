package com.teste.londres.utils;


/**
 * @author Jonathan
 * @version 10/05/2014
 *
 * @param <T>
 */
public interface AbstractDao<T> {
	
	/**
	 * insert
	 * @param entidade
	 * @return se inserido
	 */
	public boolean insert(T entidade);
	
	/**
	 * update
	 * @param entidade
	 * @return se atualizado
	 */
	public T update(T entidade);
	
	/**
	 * delete
	 * @param entidade
	 * @return se deletado
	 */
	public boolean delete(T entidade);
}
