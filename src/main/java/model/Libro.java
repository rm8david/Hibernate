package model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "libros")
public class Libro implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String titulo;
    @Column
    private double precio;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @ManyToMany(mappedBy = "listaLibros", fetch = FetchType.EAGER)
    private List<Libreria> listaLibrerias;

    public Libro(String titulo, double precio, Editorial editorial, Autor autor) {
        this.titulo = titulo;
        this.precio = precio;
        this.editorial = editorial;
        this.autor = autor;
    }

    public Libro(String titulo, double precio) {
        this.titulo = titulo;
        this.precio = precio;
    }
    public String mostrarDatos(){
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", precio=" + precio ;
    }
    public String mostrarDatosEditorialAutor(){
        return "Libro{" + "id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", editorial=" + editorial + ", autor=" + autor + '}';
    }
    public String mostrarDatosLibreria(){
        return "Libro{" + "id=" + id + ", titulo=" + titulo+ ", precio=" + precio + " \nLibrerias= " + listaLibrerias.toString() + '}';
    }
}
