package model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


@Entity
@Table(name="editoriales")
public class Editorial  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;
    @Column
    private String direccion;
    @OneToMany(mappedBy = "editorial", fetch = FetchType.EAGER)
    private List<Libro> listaLibros;


    public Editorial(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Editorial(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Editorial{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + '}';
    }
}
