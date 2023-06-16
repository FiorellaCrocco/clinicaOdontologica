package com.company.ClinicaOdontologica.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "TURNOS") // Establecemos el nombre de la tabla en la BD
@Getter @Setter  // Creamos los Getters y Setters

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

    public Turno() {
    }

    public Turno(Long id, Paciente paciente, Odontologo odontologo, LocalDateTime fecha) {
        this.id = id;
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
