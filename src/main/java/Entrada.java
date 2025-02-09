import controller.LibroController;
import dao.LibreriaDAO;
import database.HibernateUtil;
import model.Autor;
import model.Editorial;
import model.Libreria;
import model.Libro;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Entrada {

    public static void main(String[] args) {

        LibroController libroController = new LibroController();

        //El thread sleep es porque si lanzo todas las consultas a la vez, da errores
        try {
            // Dar de alta 3 autores
            libroController.insertarAutores();
            Thread.sleep(1000);
            // Dar de alta 2 editoriales
            libroController.insertarEditoriales();
            Thread.sleep(1000);
            // Dar de alta 8 libros
            libroController.insertarLibros();
            Thread.sleep(1000);

            //Añadir 2 librerias con 4 libros asociados cada una, previamente dados de alta
            LibreriaDAO libreriaDAO = new LibreriaDAO();
            libreriaDAO.addLibreria();
            Thread.sleep(1000);

            //Mostrar todos los datos de los libros, con su editorial y su autor
            System.out.println("Mostrar todos los datos de los libros, con su editorial y su autor");
            libroController.mostrarDatosLibros();
            Thread.sleep(1000);
            System.out.println("------------------------------------");

            //Mostrar todos los autores dados de alta, con sus libros asociados
            System.out.println("Mostrar todos los autores dados de alta, con sus libros asociados");
            libroController.mostrarAutoresLibros();
            Thread.sleep(1000);
            System.out.println("------------------------------------");
            //Mostrar todos los libros dados de alta y en la libreria en la que están
            System.out.println("Mostrar todos los libros dados de alta y en la libreria en la que están");
            libroController.mostrarLibreriasLibros();
            Thread.sleep(1000);
            System.out.println("------------------------------------");

            //Mostrar los libros dados de alta y la libreria en la que estan
            System.out.println("Mostrar los libros dados de alta y la libreria en la que estan");
            libroController.mostrarLibreriasLibros();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
