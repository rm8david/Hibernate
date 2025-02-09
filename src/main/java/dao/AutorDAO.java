package dao;

import database.HibernateUtil;
import model.Autor;
import org.hibernate.Session;

import java.util.HashMap;
import java.util.List;

public class AutorDAO {
    private Session session;
    //Metodo para añadir un autor
    public void addAutor(Autor autor){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(autor);
        session.getTransaction().commit();
        session.close();
    }
    //Metodo para mostrar cada autor con sus libros
    public void mostarAutoresLibros(){
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Autor> autores = session.createQuery("from Autor",Autor.class).list();
        for (Autor autor : autores){
            System.out.println(autor.mostrarDatos());
        }
        session.getTransaction().commit();
        session.close();
    }
}
