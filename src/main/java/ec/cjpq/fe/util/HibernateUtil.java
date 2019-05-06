package ec.cjpq.fe.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
                
            // Properties props = new Properties();
            // props.load(ClassLoader.getSystemClassLoader().getResourceAsStream("dbConnection.properties"));
            //
            // Configuration conf = new Configuration();
            // conf.configure("hibernate.cfg.xml");
            //
            // conf.setProperty("hibernate.connection.url"      , props.getProperty("hibernate.connection.url"));
            // conf.setProperty("hibernate.connection.username" , props.getProperty("hibernate.connection.username"));
            // conf.setProperty("hibernate.connection.password" , props.getProperty("hibernate.connection.password"));
            
			// Create the SessionFactory from hibernate.cfg.xml
			return new Configuration().configure().buildSessionFactory();
			//return new Configuration().configure("hibernate.cfg.xml").addProperties(props).buildSessionFactory();
			//return conf.buildSessionFactory();
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
