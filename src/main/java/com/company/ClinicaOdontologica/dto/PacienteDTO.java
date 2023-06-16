package com.company.ClinicaOdontologica.dto;

import com.company.ClinicaOdontologica.entity.Domicilio;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter  // Creamos los Getters y Setters
@JsonIgnoreProperties(ignoreUnknown = true)   // Definimos que se ignoren los atributos que no están detallados abajo (El ID)

public class PacienteDTO {

    private String nombre, apellido, DNI, email;
    private Domicilio domicilio;

    public PacienteDTO() {
    }

    public PacienteDTO(String nombre, String apellido, String DNI, String email, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.email = email;
        this.domicilio = domicilio;
    }
}
