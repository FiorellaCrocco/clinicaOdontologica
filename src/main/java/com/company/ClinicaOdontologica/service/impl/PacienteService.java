package com.company.ClinicaOdontologica.service.impl;


import com.company.ClinicaOdontologica.dto.PacienteDTO;
import com.company.ClinicaOdontologica.entity.Paciente;
import com.company.ClinicaOdontologica.repository.IPacienteRepository;
import com.company.ClinicaOdontologica.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IPacienteService {

    private static final Logger logger = Logger.getLogger(PacienteService.class);

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
        logger.info("Paciente - actualizar: Se va actualizar el paciente");
        return guardar(paciente);
    }

    // Busco un Paciente por su Id, si lo encuentro retorno el PacienteDTO, sino, muestro la exception.
    @Override
    public PacienteDTO buscarPorId(Long id) throws Exception {
        objectMapper.registerModule(new JavaTimeModule()); // Se utiliza para solucionar el error "not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310""
        Optional<Paciente> found = iPacienteRepository.findById(id);  // Utilizo el objeto Optional que permite que "found" devuelva nulo o Paciente
        if(found.isPresent()) {  // Evaluamos si found tiene contenido
            logger.info("Paciente - buscarPorId: Se encontro el paciente y se convertira a DTO para ser devuelto");
            return objectMapper.convertValue(found, PacienteDTO.class);  // Convertimos a found que es de tipo Paciente a PacienteDTO.
        } else {
            logger.warn("Paciente - buscarPorId: No se encontro ningun paciente con ese ID");
            throw new Exception("El paciente no existe");
        }
    }

    // Busco todos los Pacientes en la base de datos y retorno una lista de tipo PacienteDTO con los Pacientes encontrados.
    @Override
    public List<PacienteDTO> buscarTodos() {
        objectMapper.registerModule(new JavaTimeModule()); // Se utiliza para solucionar el error "not supported by default: add Module "com.fasterxml.jackson.datatype:jackson-datatype-jsr310" "
        List<PacienteDTO> pacienteDTOS = new ArrayList<>();  // Creamos un ArrayList de tipo PacienteDTO
        for (Paciente p : iPacienteRepository.findAll()){    // Iteramos el array
            logger.info("Paciente - buscarTodos: Se esta iterando el array de pacientes");
            pacienteDTOS.add(objectMapper.convertValue(p,PacienteDTO.class));  // En cada iteración convertimos el objeto de tipo Paciente a PacienteDTO y lo agregamos al ArrayList
        }
        return pacienteDTOS;
    }

    // Guardo un Paciente en la base de datos utilizando el método save de JpaRepository.
    public Paciente guardar(Paciente paciente){
        logger.info("Paciente - guardar: Se va agregar el paciente");
        return iPacienteRepository.save(paciente);
    }

    // Busco por Id un Paciente en la base de datos y lo elimino utilizando el método deleteById de JpaRepository.
    public void eliminar(Long id){
        logger.info("Paciente - eliminar: Se va eliminar el paciente");
        iPacienteRepository.deleteById(id);
    }

}
