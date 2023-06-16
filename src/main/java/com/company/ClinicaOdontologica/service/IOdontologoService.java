package com.company.ClinicaOdontologica.service;



import com.company.ClinicaOdontologica.dto.OdontologoDTO;
import com.company.ClinicaOdontologica.entity.Odontologo;

import java.util.List;

public interface IOdontologoService {

    Odontologo actualizar (Odontologo odontologo);

    OdontologoDTO buscarPorId(Long id) throws Exception;

    List<OdontologoDTO> buscarTodos();

}
