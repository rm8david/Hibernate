package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="librerias")
public class Libreria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String dueño;
    @Column
    private String direccion;
    @ManyToMany
    @JoinTable(name= "librerias_libros",
                joinColumns = @JoinColumn(name="id_libreria"),
                inverseJoinColumns = @JoinColumn(name = "id_libro"))
    private List<Libro> listaLibros;

    public Libreria(String nombre, String dueño, String direccion) {
        this.nombre = nombre;
        this.dueño = dueño;
        this.direccion = direccion;
    }
    @Override
    public String toString() {
        return "Nombre: " + nombre + " Dueño"+ dueño +" Direccion: " + direccion;
    }
    public String mostrarDatos(){
        return "Nombre: " + nombre + " Dueño"+ dueño +" Direccion: " + direccion
                + "Libros: \n" + recorrerListado() ;
    }
    public String recorrerListado(){
        StringBuilder listado = new StringBuilder();
        for (Libro libro : listaLibros) {
            listado.append(libro.mostrarDatos()).append("\n");
        }
        return listado.toString();
    }
}
