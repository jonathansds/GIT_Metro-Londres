package com.teste.londres.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;

import com.teste.londres.dao.EstacaoDao;
import com.teste.londres.entidades.Estacao;
import com.teste.londres.utils.AbstractDaoImpl;

/**
 * @author Jonathan
 * @version 11/05/2014
 *
 */
@Component
public class EstacaoDaoImpl extends AbstractDaoImpl<Estacao> implements EstacaoDao{
	
	/** session */
	private final Session session;
	
	public EstacaoDaoImpl(Session session){
		super(session);
		this.session = session;
	}
	
	@SuppressWarnings("unchecked")
	public List<Estacao> listAll(){
		Transaction transaction = session.beginTransaction();
		
		try{
			List<Estacao> result = session.createCriteria(Estacao.class).list();
			transaction.commit();
			return result;
		}catch(Exception erro){
			transaction.rollback();
			System.err.print(erro.getMessage());
			return null;
		}
	}
}
