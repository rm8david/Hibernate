package controller;

import dao.AutorDAO;
import dao.EditorialDAO;
import dao.LibreriaDAO;
import dao.LibroDAO;
import model.Autor;
import model.Editorial;
import model.Libro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibroController {

    private AutorDAO autorDAO = new AutorDAO();
    private EditorialDAO editorialDAO = new EditorialDAO();
    private LibroDAO libroDAO = new LibroDAO();
    private LibreriaDAO libreriaDAO = new LibreriaDAO();



    //metodo para insertar 3 autores a traves del AutorDAO
    public void insertarAutores() {
        Autor tolkien = new Autor("Tolkien", "JRR", LocalDate.of(1925, 10, 1));
        Autor king = new Autor("Stephen", "King", LocalDate.of(1950, 8, 10));
        Autor cline = new Autor("Ernest", "Cline", LocalDate.of(1970, 2, 19));

        autorDAO.addAutor(tolkien);
        autorDAO.addAutor(king);
        autorDAO.addAutor(cline);
    }

    //Metodo para insertar 2 editoriales
    public void insertarEditoriales() {
        Editorial fantasy = new Editorial("Fantasy", "Main Street New York");
        Editorial silgmar = new Editorial("Silgmar", "Rank Av. Los Angeles");
        editorialDAO.addEditoria(fantasy);
        editorialDAO.addEditoria(silgmar);
    }

    //Metodo para añadir 8 libros
    public void insertarLibros() {
        List<Libro> libros = new ArrayList<>();
        libros.add(new Libro("The two towers", 22.50));
        libros.add(new Libro("The Hobbit", 35.25));
        libros.add(new Libro("Strafe King", 22.50));
        libros.add(new Libro("Assylum", 12.50));
        libros.add(new Libro("ReadyPlayerOne", 35.50));
        libros.add(new Libro("The corn kids", 14.99));
        libros.add(new Libro("EL sanguinariamiento", 249.50));
        libros.add(new Libro("the apocalypsis", 22.50));

        for (Libro libro : libros) {
            libroDAO.addLibro(libro);
        }

    }

    //Mostrar todos los datos de los libros con autor y editorial
    public void mostrarDatosLibros(){
        libroDAO.mostrarDatosLibros();
    }

    //Mostrar todos los datos de los libros con su libreria
    public void mostrarLibreriasLibros(){
        libroDAO.mostrarLibrerias();
    }

    //mostrar los datos de los autores y sus libros
    public void mostrarAutoresLibros(){
        autorDAO.mostarAutoresLibros();
    }
    //mostrar los datos de cada libreria y sus libros asociados
    public void mostrarLibreriaLibros(){
        libreriaDAO.mostrarDatosLibros();
    }



}
