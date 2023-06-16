package com.company.ClinicaOdontologica.service;



import com.company.ClinicaOdontologica.dto.PacienteDTO;
import com.company.ClinicaOdontologica.entity.Paciente;

import java.util.List;

public interface IPacienteService {

    Paciente actualizar (Paciente paciente);

    PacienteDTO buscarPorId(Long id) throws Exception;

    List<PacienteDTO> buscarTodos();

}
