package com.company.ClinicaOdontologica.service;



import com.company.ClinicaOdontologica.entity.Domicilio;

import java.util.List;

public interface IDomicilioService {

    Domicilio actualizar (Domicilio domicilio);

    Domicilio buscarPorId (Long id) ;

    List<Domicilio> buscarTodos();

    Domicilio guardar(Domicilio domicilio);

    void eliminar(Long id);
}
