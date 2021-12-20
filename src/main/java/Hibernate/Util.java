package Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Util
{
    private static final SessionFactory sessionFactory;

    static
    {
        try
        {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable exception)
        {
            System.err.println("Initial SessionFactory creation failed: " + exception);
            throw new ExceptionInInitializerError(exception);
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
