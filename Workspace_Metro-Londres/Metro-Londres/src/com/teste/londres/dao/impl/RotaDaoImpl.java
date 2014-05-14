package com.teste.londres.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;

import com.teste.londres.dao.RotaDao;
import com.teste.londres.entidades.Rota;
import com.teste.londres.utils.AbstractDaoImpl;

/**
 * @author Jonathan
 * @version 11/05/2014
 *
 */
@Component
public class RotaDaoImpl extends AbstractDaoImpl<Rota> implements RotaDao{
	
	/** session */
	private final Session session;
	
	public RotaDaoImpl(Session session){
		super(session);
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	public List<Rota> listAll(){
		Transaction transaction = session.beginTransaction();
		
		try{
			List<Rota> result = session.createCriteria(Rota.class).list();
			transaction.commit();
			return result;
		}catch(Exception erro){
			transaction.rollback();
			System.err.print(erro.getMessage());
			return null;
		}
	}
	
	@Override
	public boolean persiste(List<Rota> lista) {
		Transaction transaction = session.beginTransaction();
		
		try{
			for(Rota rota : lista){
				session.persist(rota);
			}
			session.flush();
			transaction.commit();
			return true;
		}catch(Exception erro){
			erro.printStackTrace();
			transaction.rollback();
			return false;
		}
	}
}
