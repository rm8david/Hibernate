package database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    //getSession
    public  SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            createSessionFactory();
        }
        return sessionFactory;
    }

    private  void createSessionFactory() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    //close session
    public void closeSessionFactory(){
        sessionFactory.close();
        sessionFactory = null;
    }
}
