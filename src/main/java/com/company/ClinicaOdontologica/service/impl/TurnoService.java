package com.company.ClinicaOdontologica.service.impl;


import com.company.ClinicaOdontologica.dto.TurnoDTO;
import com.company.ClinicaOdontologica.entity.Turno;
import com.company.ClinicaOdontologica.repository.ITurnoRepository;
import com.company.ClinicaOdontologica.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurnoService implements ITurnoService {

    // Repositorio de Turnos utilizado para acceder a la base de datos.
    private ITurnoRepository iTurnoRepository;

    // Para la conversión de objetos.
    private ObjectMapper objectMapper;

    // Constructor de TurnoService que permite la inyección de dependencias.
    @Autowired
    public TurnoService(ITurnoRepository iTurnoRepository, ObjectMapper objectMapper) {
        this.iTurnoRepository = iTurnoRepository;
        this.objectMapper = objectMapper;
    }

    // Actualizo un Turno en la base de datos.
    @Override
    public Turno actualizar(Turno turno) {
        eliminar(turno.getId());
        guardar(turno);
        return turno;
    }

    // Busco un Turno por su Id, si lo encuentro retorno el TurnoDTO, sino, muestro la exception.
    @Override
    public TurnoDTO buscarPorId(Long id) throws Exception {
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS); // Se utiliza para solucionar el error "SerializationFeature.FAIL_ON_EMPTY_BEANS)"
        Optional<Turno> found = iTurnoRepository.findById(id);
        if(found.isPresent())
            return objectMapper.convertValue(found, TurnoDTO.class);
        else
            throw new Exception("El turno no existe");
    }

    // Busco todos los Turnos en la base de datos y retorno una lista de tipo TurnoDTO con los Turnos encontrados.
    @Override
    public List<TurnoDTO> buscarTodos() {
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS); // Se utiliza para solucionar el error "SerializationFeature.FAIL_ON_EMPTY_BEANS)"
        List<TurnoDTO> turnoDTOS = new ArrayList<>();
        for (Turno t : iTurnoRepository.findAll()){
            turnoDTOS.add(objectMapper.convertValue(t,TurnoDTO.class));
        }
        return turnoDTOS;
    }

    // Guardo un Turno en la base de datos utilizando el método save de JpaRepository.
    public Turno guardar(Turno turno){
        return iTurnoRepository.save(turno);
    }

    // Busco por Id un Turno en la base de datos y lo elimino utilizando el método deleteById de JpaRepository.
    public void eliminar(Long id){
        iTurnoRepository.deleteById(id);
    }

}
