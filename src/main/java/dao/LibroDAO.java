package dao;

import database.HibernateUtil;
import model.Autor;
import model.Editorial;
import model.Libro;
import org.hibernate.Session;

import java.util.List;

public class LibroDAO {
    private Session session;

    //metodo para añadir un libro y asignarle editorial y autor
    public void addLibro(Libro libro) {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Editorial editorial = session.createQuery("FROM Editorial WHERE nombre = :nombre", Editorial.class)
                .setParameter("nombre", "Fantasy").uniqueResult();
        Autor autor = session.createQuery("FROM Autor WHERE nombre = :nombre", Autor.class)
                .setParameter("nombre", "Tolkien").uniqueResult();
        libro.setEditorial(editorial);
        libro.setAutor(autor);
        session.merge(libro);
        session.getTransaction().commit();
        session.close();
    }

    //metodo para mostrar todos los datos de cada libro, con su editorial y su autor
    public void mostrarDatosLibros() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Libro> libros = session.createQuery("from Libro", Libro.class).list();
        for (Libro libro : libros) {
            System.out.println(libro);
        }
        session.getTransaction().commit();
        session.close();
    }

    //metodo para mostrar los datos de los libros con su libreria correspondiente
    public void mostrarLibrerias() {
        session = new HibernateUtil().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Libro> libros = session.createQuery("from Libro", Libro.class).list();
        for (Libro libro : libros) {
            System.out.println(libro.mostrarDatosLibreria());
        }
        session.getTransaction().commit();
        session.close();
    }
}
