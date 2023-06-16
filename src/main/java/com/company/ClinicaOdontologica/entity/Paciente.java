package com.company.ClinicaOdontologica.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PACIENTES") // Establecemos el nombre de la tabla en la BD
@Getter @Setter  // Creamos los Getters y Setters

public class Paciente {
    // Establecemos el Id como Primary Key de tipo secuencia
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre, apellido, DNI, email;

    // Establecemos la relación con la tabla Domicilio del tipo muchos a uno, y definimos como Foreign Key el Id de Domicilio
    // Utilizamos el patrón LAZY para establecer la inicialización al momento de recibir una solicitud
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="domicilio_id",referencedColumnName = "id")
    private Domicilio domicilio;

    private Date fechaAlta;

    public Paciente() {
    }

    public Paciente(String nombre, String apellido, String DNI, String email, Domicilio domicilio, Date fechaAlta) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.email = email;
        this.domicilio = domicilio;
        this.fechaAlta = fechaAlta;
    }

    public Paciente(Long id, String nombre, String apellido, String DNI, String email, Domicilio domicilio, Date fechaAlta) {
        this.id = id;
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
}
