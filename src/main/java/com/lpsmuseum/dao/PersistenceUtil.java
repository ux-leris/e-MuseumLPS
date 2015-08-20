package com.lpsmuseum.dao;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
	private static EntityManagerFactory emf = null;
			
	
//	static{
//		String filename = "config.properties";
//		Properties prop = new Properties();
//		InputStream input = PersistenceUtil.class.getClassLoader().getResourceAsStream(filename);
//		try {
//			prop.load(input);
//			String unit = prop.getProperty("provider");
//			emf = Persistence.createEntityManagerFactory(unit);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}	finally {
//			if (input != null) {
//				try {
//					input.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//	}
	
	public static EntityManager getEntityManager(){
		return getFactory().createEntityManager();
	}
	
	private static EntityManagerFactory getFactory(){
		//if(emf == null) emf = Persistence.createEntityManagerFactory("museum-eclipselink");
		if(emf == null) emf = Persistence.createEntityManagerFactory("museum-hibernate");
		return emf;
	}
	
	@PreDestroy
	public static void closeFactory() {
		emf.close();
	}
}
