package ec.cjpq.fe.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    // private static final SessionFactory sessionFactory;
    // private static Properties dbConnectionProperties = new Properties();
    // static {
    //     try {
    //         //Apagar el log de hibernate
    //         //java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
    //
    //         dbConnectionProperties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("dbConnection.properties"));
    //
    //         // Create the SessionFactory from hibernate.cfg.xml
    //         //sessionFactory = new Configuration().configure().buildSessionFactory();
    //         //sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    //         // https://stackoverflow.com/questions/22616043/java-lang-noclassdeffounderror-org-hibernate-cfg-annotationconfiguration/23850005
    //         sessionFactory = new Configuration().mergeProperties(dbConnectionProperties).configure().buildSessionFactory();
    //     } catch (Throwable ex) {
    //         // Make sure you log the exception, as it might be swallowed
    //         System.err .println("Initial SessionFactory creation failed." + ex);
    //         throw new ExceptionInInitializerError(ex);
    //     }
    // }
    //
    // public static SessionFactory getSessionFactory() {
    //     return sessionFactory;
    // }
    private static StandardServiceRegistry registry;
    private static Properties dbConnectionProperties = new Properties();
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                dbConnectionProperties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("dbConnection.properties"));

                // Create registry
                registry = new StandardServiceRegistryBuilder().configure().build();
                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);
                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();
                // Create SessionFactory
                sessionFactory = metadata.mergeProperties(dbConnectionProperties).getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }
    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
} 
