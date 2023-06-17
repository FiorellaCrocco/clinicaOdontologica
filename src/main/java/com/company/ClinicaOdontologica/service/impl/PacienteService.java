package com.company.ClinicaOdontologica.service.impl;


import com.company.ClinicaOdontologica.dto.PacienteDTO;
import com.company.ClinicaOdontologica.entity.Paciente;
import com.company.ClinicaOdontologica.repository.IPacienteRepository;
import com.company.ClinicaOdontologica.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {

    // Repositorio de Pacientes utilizado para acceder a la base de datos.
    private IPacienteRepository iPacienteRepository;

    // Para la conversión de objetos.
    private ObjectMapper objectMapper;

    // Constructor de PacienteService que permite la inyección de dependencias.
    @Autowired
    public PacienteService(IPacienteRepository iPacienteRepository, ObjectMapper objectMapper) {
        this.iPacienteRepository = iPacienteRepository;
        this.objectMapper = objectMapper;
    }

    // Actualizo un Paciente en la base de datos.
    @Override
    public Paciente actualizar(Paciente paciente) {
        eliminar(paciente.getId());
        guardar(paciente);
        return paciente;
    }

    // Busco un Paciente por su Id, si lo encuentro retorno el PacienteDTO, sino, muestro la exception.
    @Override
    public PacienteDTO buscarPorId(Long id) throws Exception {
        Optional<Paciente> found = iPacienteRepository.findById(id);
        if(found.isPresent())
            return objectMapper.convertValue(found, PacienteDTO.class);
        else
            throw new Exception("El paciente no existe");
    }

    // Busco todos los Pacientes en la base de datos y retorno una lista de tipo PacienteDTO con los Pacientes encontrados.
    @Override
    public List<PacienteDTO> buscarTodos() {
        ObjectMapper mapper = new ObjectMapper();
        List<PacienteDTO> pacienteDTOS = new ArrayList<>();
        for (Paciente p : iPacienteRepository.findAll()){
            pacienteDTOS.add(mapper.convertValue(p,PacienteDTO.class));
        }
        return pacienteDTOS;
    }

    // Guardo un Paciente en la base de datos utilizando el método save de JpaRepository.
    public Paciente guardar(Paciente paciente){
        return iPacienteRepository.save(paciente);
    }

    // Busco por Id un Paciente en la base de datos y lo elimino utilizando el método deleteById de JpaRepository.
    public void eliminar(Long id){
        iPacienteRepository.deleteById(id);
    }

}
