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

    // Establecemos el Id como Primary Key de tipo indentity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Establecemos la relación con la tabla Paciente del tipo muchos a uno, y definimos como Foreign Key el Id de Paciente
    // Utilizamos el patrón LAZY para establecer la inicialización al momento de recibir una solicitud
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="paciente_id", nullable = false)
    private Paciente paciente;

    // Establecemos la relación con la tabla Odontologo del tipo muchos a uno, y definimos como Foreign Key el Id de Odontologo
    // Utilizamos el patrón LAZY para establecer la inicialización al momento de recibir una solicitud
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="odontologo_id", nullable = false)
    private Odontologo odontologo;

    private LocalDateTime fecha;

    public Turno(Paciente paciente, Odontologo odontologo, LocalDateTime fecha) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", odontologo=" + odontologo +
                ", fecha=" + fecha +
                '}';
    }

}
