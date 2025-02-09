package model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "autores")
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private LocalDate fecha;

    @OneToMany(mappedBy = "autor",fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor(String nombre, String apellido, LocalDate fecha) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
    }

    public Autor(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha=" + fecha + '}';
    }
    public String mostrarDatos(){
        return "Autor{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", fecha=" + fecha + '}'
                + "Libros: \n" +recorrerListado();
    }
    public String recorrerListado(){
        StringBuilder listado = new StringBuilder();
        for (Libro libro : libros) {
            listado.append(libro.mostrarDatos()).append("\n");
        }
        return listado.toString();
    }
}
