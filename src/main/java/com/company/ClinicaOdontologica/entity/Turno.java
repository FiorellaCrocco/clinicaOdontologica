package com.company.ClinicaOdontologica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TURNOS") // Establecemos el nombre de la tabla en la BD
@Getter @Setter  // Creamos los Getters y Setters
@NoArgsConstructor // Constructor sin parámetros
@AllArgsConstructor // Constructor con todos los parámetros

public class Turno {

    // Establecemos el Id como Primary Key de tipo secuencia
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    // Establecemos la relación con la tabla Paciente del tipo uno a uno, y definimos como Foreign Key el Id de Paciente
    // Utilizamos el patrón LAZY para establecer la inicialización al momento de recibir una solicitud
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="paciente_id")
    private Paciente paciente;

    // Establecemos la relación con la tabla Odontologo del tipo uno a uno, y definimos como Foreign Key el Id de Odontologo
    // Utilizamos el patrón LAZY para establecer la inicialización al momento de recibir una solicitud
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="odontologo_id")
    private Odontologo odontologo;

    private LocalDateTime fecha;

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                ", fecha=" + fecha +
                '}';
    }

    /*  =============================== MODIFICADO ===============================
    // Establecemos la relación con la tabla Paciente del tipo uno a uno, y definimos como Foreign Key el Id de Paciente
    // Utilizamos la anotacion JsonIgnore para evitar un bucle infinito al ser una relación bidireccional
    // Utilizamos el patrón LAZY para establecer la inicialización al momento de recibir una solicitud
    @OneToOne(fetch = FetchType.LAZY)
    //@JsonIgnore
    @JoinColumn(name="paciente_id")
    private Paciente paciente;

    // Establecemos la relación con la tabla Odontologo del tipo muchos a uno, y definimos como Foreign Key el Id de Odontologo
    // Utilizamos la anotacion JsonIgnore para evitar un bucle infinito al ser una relación bidireccional
    // Utilizamos el patrón LAZY para establecer la inicialización al momento de recibir una solicitud
    @ManyToOne(fetch = FetchType.LAZY)
   //@JsonIgnore
    @JoinColumn(name="odontologo_id")
    private Odontologo odontologo;
 */

}
