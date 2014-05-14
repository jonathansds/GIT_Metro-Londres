package com.teste.londres.utils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

/**
 * @author Jonathan
 * @version 11/05/2014
 *
 */
@SuppressWarnings("deprecation")
@ApplicationScoped
@Component
public class SessionFactoryUtil{

	/** sessionFactory */
	private static SessionFactory sessionFactory;
	
	@PostConstruct
	public void constroi(){
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}
	
	@PreDestroy
	public void destroi(){
		sessionFactory.close();
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
