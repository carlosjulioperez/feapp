package ec.cjpq.fe.util;

import java.util.logging.Level;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil
{
    private static final SessionFactory sessionFactory;

    static
    {
        try
        {
        	//Apagar el log de hibernate
    		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);

            // Create the SessionFactory from hibernate.cfg.xml
            //sessionFactory = new Configuration().configure().buildSessionFactory();
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        catch (Throwable ex)
        {
            // Make sure you log the exception, as it might be swallowed
            System.err
                    .println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
