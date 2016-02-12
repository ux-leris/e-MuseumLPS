package com.lpsmuseum.dao;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This class provides utilitaries methods to work with <b>Hibernate</b>
 * implementation of <b>Java Persistence API</b>.
 */
public class PersistenceUtil {

	/**
	 * This fields represents the <u>unique</u> <code>EntityManagerFactory
	 * </code> for the entire application.
	 * @see EntityManagerFactory
	 */
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
	/**
	 * Provides a easy way to get a <code>EntityManager</code>.
	 * 
	 * @return a new created <code>EntityManager</code> by the <u>factory</u>.
	 */
	public static EntityManager getEntityManager() {
		return getFactory().createEntityManager();
	}

	/**
	 * Provides access to the <u>singleton</u> <code>EntityManagerFactory
	 * </code> of the application.
	 * 
	 * @return a unique <code>EntityManagerFactory</code>.
	 */
	private static EntityManagerFactory getFactory() {
		//if(emf == null) emf = Persistence.createEntityManagerFactory("museum-eclipselink");
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("museum-hibernate");
		}
		return emf;
	}

	// TODO @PreDestroy public static void closeFactory javadoc
	@PreDestroy
	public static void closeFactory() {
		emf.close();
	}
}
