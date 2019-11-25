package ec.cjpq.fe.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
            
            Properties properties = new Properties();
            try {
                properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("dbConnection.properties"));
            } catch(Exception e) {
                e.printStackTrace();
            }

			// Create the SessionFactory from hibernate.cfg.xml
			//return new Configuration().configure().buildSessionFactory();
			return new Configuration().configure("hibernate.cfg.xml").addProperties(properties).buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}

}
