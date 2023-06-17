package com.company.ClinicaOdontologica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ODONTOLOGOS") // Establecemos el nombre de la tabla en la BD
@Getter @Setter  // Creamos los Getters y Setters
@NoArgsConstructor // Constructor sin parámetros
@AllArgsConstructor // Constructor con todos los parámetros

public class Odontologo {

    // Establecemos el Id como Primary Key de tipo secuencia
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Odontologo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", matricula='" + matricula + '\'' +
                '}';
    }

    /*  =============================== MODIFICADO ===============================
    // Establecemos la relación con la tabla Turno del tipo uno a muchos, y definimos como Foreign Key el Id de Turno
    // Utilizamos el patrón LAZY para establecer la inicialización al momento de recibir una solicitud
    // Utilizamos Cascade.ALL para que se apliquen automáticamente las operaciones CRUD de Paciente en la entidad Turno.
    // Utilizamos la propiedad nulleable true dado que puede existir un odontologo sin turno
//    @OneToMany(fetch=FetchType.LAZY, mappedBy = "odontologo", cascade = CascadeType.ALL)
//    //@JoinColumn(name = "turno_id", nullable = true)
//    private List<Turno> turnos;
 */

}
