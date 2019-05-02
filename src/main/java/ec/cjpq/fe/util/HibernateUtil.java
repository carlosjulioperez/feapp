package ec.cjpq.fe.util;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.AnnotationConfiguration;

/**
 * This code was taken almost in entirety from the Hibernate 3.1 
 * reference manual. The package name and formatting has been 
 * changed only.
 */
public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err .println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
} 
