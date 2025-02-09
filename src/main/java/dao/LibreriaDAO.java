package dao;

import database.HibernateUtil;
import model.Libreria;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class LibreriaDAO {
    private Session sesion;

    //Añadir 2 librerias con 4 libros asociados a cada una
    public void addLibreria() {
        Libreria libreria1 = new Libreria("Micron", "Paco", "Calle batallas");
        Libreria libreria2 = new Libreria("Magic Winter", "Lucia", "Calle esteban jordan");
        List<Libro> listadoLibros = new ArrayList<Libro>();
        sesion = new HibernateUtil().getSessionFactory().getCurrentSession();
        sesion.beginTransaction();
        //Listamos los 8 libros que tenemos
        listadoLibros = sesion.createQuery("from Libro",Libro.class).list();
        //creamos dos sublistas con 4 libros cada una
        List<Libro> subLibros1 = new ArrayList<>();
        List<Libro> subLibros2 = new ArrayList<>();
        for (int i= 0; i<4;i++){
            subLibros1.add(listadoLibros.get(i));
        }
        for (int i = 4; i<8; i++){
            subLibros2.add(listadoLibros.get(i));
        }
        libreria1.setListaLibros(subLibros1);
        libreria2.setListaLibros(subLibros2);
        sesion.persist(libreria1);
        sesion.persist(libreria2);
        sesion.getTransaction().commit();
        sesion.close();
    }

    public void mostrarDatosLibros(){
        sesion = new HibernateUtil().getSessionFactory().getCurrentSession();
        sesion.beginTransaction();
        Query<Libreria> query = sesion.createQuery("from Libreria", Libreria.class);
        List<Libreria> librerias = query.list();
        for (Libreria libreria : librerias) {
            System.out.println(libreria.mostrarDatos());
        }
        sesion.getTransaction().commit();
        sesion.close();
    }
}
