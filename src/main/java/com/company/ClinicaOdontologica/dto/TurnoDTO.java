package com.company.ClinicaOdontologica.dto;


import com.company.ClinicaOdontologica.entity.Odontologo;
import com.company.ClinicaOdontologica.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter  // Creamos los Getters y Setters
@JsonIgnoreProperties(ignoreUnknown = true)   // Definimos que se ignoren los atributos que no están detallados abajo (El ID)

public class TurnoDTO {

    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDateTime fecha;

    public TurnoDTO() {
    }

    public TurnoDTO(Paciente paciente, Odontologo odontologo, LocalDateTime fecha) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha = fecha;
    }
}
