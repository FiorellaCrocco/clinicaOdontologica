package com.company.ClinicaOdontologica.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter  // Creamos los Getters y Setters
@JsonIgnoreProperties(ignoreUnknown = true)   // Definimos que se ignoren los atributos que no están detallados abajo (El ID)

public class OdontologoDTO {

    private String nombre, apellido, matricula;

    public OdontologoDTO() {
    }

    public OdontologoDTO(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}
