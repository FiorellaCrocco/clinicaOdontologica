package com.company.ClinicaOdontologica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "PACIENTES") // Establecemos el nombre de la tabla en la BD
@Getter @Setter  // Creamos los Getters y Setters
@NoArgsConstructor // Constructor sin parámetros
@AllArgsConstructor // Constructor con todos los parámetros

public class Paciente {
    // Establecemos el Id como Primary Key de tipo indentity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre, apellido, DNI, email;
    private LocalDate fechaAlta;

    // Establecemos la relación con la tabla Domicilio del tipo muchos a uno, y definimos como Foreign Key el Id de Domicilio
    // Utilizamos el patrón LAZY para establecer la inicialización al momento de recibir una solicitud
    // Utilizamos la propiedad nulleable true dado que puede existir un paciente sin turno
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="domicilio_id")
    private Domicilio domicilio;

    public Paciente(String nombre, String apellido, String DNI, String email, Domicilio domicilio, LocalDate fechaAlta) {
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
