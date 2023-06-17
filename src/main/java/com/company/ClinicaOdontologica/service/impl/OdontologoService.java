package com.company.ClinicaOdontologica.service.impl;


import com.company.ClinicaOdontologica.dto.OdontologoDTO;
import com.company.ClinicaOdontologica.entity.Odontologo;
import com.company.ClinicaOdontologica.repository.IOdontologoRepository;
import com.company.ClinicaOdontologica.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {

    // Repositorio de Odontólogos utilizado para acceder a la base de datos.
    private IOdontologoRepository iOdontologoRepository;

    // Para la conversión de objetos:
    private ObjectMapper objectMapper;

    // Constructor de OdontologoService que permite la inyección de dependencias.
    @Autowired
    public OdontologoService(IOdontologoRepository iOdontologoRepository, ObjectMapper objectMapper) {
        this.iOdontologoRepository = iOdontologoRepository;
        this.objectMapper = objectMapper;
    }

    // Actualiza un Odontólogo en la base de datos.
    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        eliminar(odontologo.getId());
        guardar(odontologo);
        return odontologo;
    }

    // Busca un Odontólogo por su Id, si lo encuentra retorna el OdontologoDTO, sino muestra la exception.
    @Override
    public OdontologoDTO buscarPorId(Long id) throws Exception {
        Optional<Odontologo> found = iOdontologoRepository.findById(id);
        if(found.isPresent())
            return objectMapper.convertValue(found, OdontologoDTO.class);
        else
            throw new Exception("El odontologo no existe");
    }

    // Busco todos los Odontólogos en la base de datos y retorno una lista de tipo OdontologoDTO con los Odontólogos encontrados.
    @Override
    public List<OdontologoDTO> buscarTodos() {
       List<OdontologoDTO> odontologoDTOS = new ArrayList<>();
       for (Odontologo o : iOdontologoRepository.findAll()){
           odontologoDTOS.add(objectMapper.convertValue(o,OdontologoDTO.class));
       }
        return odontologoDTOS;
    }

    // Guardo un Odontólogo en la base de datos utilizando el método save de JpaRepository.
    public Odontologo guardar(Odontologo odontologo) {
        return iOdontologoRepository.save(odontologo);
    }

    // Busco por Id un Odontólogo en la base de datos y lo elimino utilizando el método deleteById de JpaRepository.
    public void eliminar(Long id) {
        iOdontologoRepository.deleteById(id);
    }

}
