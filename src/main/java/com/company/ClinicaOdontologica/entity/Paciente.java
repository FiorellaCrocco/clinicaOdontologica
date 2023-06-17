package com.company.ClinicaOdontologica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PACIENTES") // Establecemos el nombre de la tabla en la BD
@Getter @Setter  // Creamos los Getters y Setters
@NoArgsConstructor // Constructor sin parámetros
@AllArgsConstructor // Constructor con todos los parámetros

public class Paciente {
    // Establecemos el Id como Primary Key de tipo secuencia
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre, apellido, DNI, email;
    private Date fechaAlta;

    // Establecemos la relación con la tabla Domicilio del tipo muchos a uno, y definimos como Foreign Key el Id de Domicilio
    // Utilizamos el patrón LAZY para establecer la inicialización al momento de recibir una solicitud
    // Utilizamos la propiedad nulleable true dado que puede existir un paciente sin turno
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="domicilio_id")
    private Domicilio domicilio;

    public Paciente(String nombre, String apellido, String DNI, String email, Domicilio domicilio, Date fechaAlta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.email = email;
        this.domicilio = domicilio;
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", DNI='" + DNI + '\'' +
                ", domicilio=" + domicilio +
                ", fechaAlta=" + fechaAlta +
                '}';
    }

    /*  =============================== MODIFICADO ===============================
    // Establecemos la relación con la tabla Turno del tipo uno a uno, y definimos como Foreign Key el Id de Turno
    // Utilizamos el patrón LAZY para establecer la inicialización al momento de recibir una solicitud
    // Utilizamos Cascade.ALL para que se apliquen automáticamente las operaciones CRUD de Paciente en la entidad Turno.
    // Utilizamos la propiedad nulleable true dado que puede existir un paciente sin turno
//    @OneToOne(fetch=FetchType.LAZY, mappedBy = "paciente",cascade = CascadeType.ALL)
//    //@JoinColumn(name = "turno_id", nullable = true)
//    private Turno turno;
     */

}
