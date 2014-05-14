package com.teste.londres.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;

import com.teste.londres.dao.LinhaDao;
import com.teste.londres.entidades.Linha;
import com.teste.londres.utils.AbstractDaoImpl;

/**
 * @author Jonathan
 * @version 11/05/2014
 *
 */
@Component
public class LinhaDaoImpl extends AbstractDaoImpl<Linha> implements LinhaDao{
	
	/** session */
	private final Session session;
	
	public LinhaDaoImpl(Session session){
		super(session);
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	public List<Linha> listAll(){
		Transaction transaction = session.beginTransaction();
		
		try{
			List<Linha> result = session.createCriteria(Linha.class).list();
			transaction.commit();
			return result;
		}catch(Exception erro){
			transaction.rollback();
			System.err.print(erro.getMessage());
			return null;
		}
	}
	
	@Override
	public boolean persiste(List<Linha> lista) {
		Transaction transaction = session.beginTransaction();
		
		try{
			for(Linha linha : lista){
				session.persist(linha);
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
