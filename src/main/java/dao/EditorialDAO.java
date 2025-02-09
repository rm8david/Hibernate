package dao;

import database.HibernateUtil;
import model.Editorial;
import model.Libro;
import org.hibernate.Session;

public class EditorialDAO {
    private Session session;

    // Metodo para dar de alta una editorial

    public void addEditoria(Editorial editorial) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(editorial);
        session.getTransaction().commit();
        session.close();
    }
}
