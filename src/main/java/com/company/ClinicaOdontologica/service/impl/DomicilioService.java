package com.company.ClinicaOdontologica.service.impl;


import com.company.ClinicaOdontologica.entity.Domicilio;
import com.company.ClinicaOdontologica.repository.IDomicilioRepository;
import com.company.ClinicaOdontologica.service.IDomicilioService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService implements IDomicilioService {

    private static final Logger logger = Logger.getLogger(DomicilioService.class);

    // Repositorio de Domicilios utilizado para acceder a la base de datos.
    private IDomicilioRepository iDomicilioRepository;

    // Constructor de DomicilioService que permite la inyección de dependencias.
    @Autowired
    public DomicilioService(IDomicilioRepository iDomicilioRepository) {
        this.iDomicilioRepository = iDomicilioRepository;
    }

    // Actualizo un Domicilio en la base de datos.
    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        logger.info("Domicilio - actualizar: Se va actualizar el domicilio");
        return guardar(domicilio);
    }

    // Busco un Domicilio por su Id, si lo encuentro retorno el Domicilio, sino muestro null.
    @Override
    public Domicilio buscarPorId(Long id) {
        Optional<Domicilio> found = iDomicilioRepository.findById(id); // Utilizo el objeto Optional que permite que "found" devuelva nulo o Domicilio
        logger.info("Domicilio - buscarPorId: Se ha actualizado el domicilio");
        return found.orElse(null);  // Si found no tiene contenido devolvemos null
    }

    // Busco todos los Domicilios en la base de datos y retorno la lista obtenida de los Domicilios  al utilizar el método findAll de JpaRepository.
    @Override
    public List<Domicilio> buscarTodos() {
        logger.info("Domicilio - buscarTodos: Se mostrara la lista de domicilios");
        return iDomicilioRepository.findAll();
    }

    // Guardo un Domicilio en la base de datos utilizando el método save de JpaRepository.
    public Domicilio guardar(Domicilio domicilio){
        logger.info("Domicilio - buscarTodos: Se va agregar el domicilio");
        return iDomicilioRepository.save(domicilio);
    }

    // Busco por Id un Domicilio en la base de datos y lo elimino utilizando el método deleteById de JpaRepository.
    public void eliminar(Long id){
        logger.info("Domicilio - buscarTodos: Se va eliminar el domicilio");
        iDomicilioRepository.deleteById(id);
    }

}
