package com.company.ClinicaOdontologica.controller;

import com.company.ClinicaOdontologica.dto.TurnoDTO;
import com.company.ClinicaOdontologica.entity.Turno;
import com.company.ClinicaOdontologica.service.impl.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turno")
//@CrossOrigin
public class TurnoController {

    TurnoService turnoService;

    // Constructor de TurnoController que permite la inyección de dependencias.
    @Autowired
    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    }

    // En la url "/turno/listar" retorno una lista de TurnoDTO
    @GetMapping("/listar")
    public List<TurnoDTO> buscarTurnos(){
        List<TurnoDTO> listarTurnos = turnoService.buscarTodos();
        return listarTurnos;
    }

    // En la url "/turno/{id}" retorno el turnoDTO deseado (segun el ID) y si no lo encuentra se dispara una Exception
    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscarUnTurno(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(turnoService.buscarPorId(id));
    }

    // En la url "/turno/guardar" hacemos un POST para guardar el Turno
    @PostMapping("/guardar")
    public ResponseEntity<Turno> guardarTurno(@RequestBody Turno turno){
        return ResponseEntity.ok(turnoService.guardar(turno));
    }

    // En la url "/turno/modificar" actualizamos un turno ya existente
    @PutMapping("/modificar")
    public ResponseEntity<Turno> actualizarUnTurnos(@RequestBody Turno turno){
        return ResponseEntity.ok(turnoService.actualizar(turno));
    }

    // En la url "/turno/{id}" utilizamos el metodo DELETE para eliminar un turno segun su ID.
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarTurno(@PathVariable Long id) throws Exception {
        turnoService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
    }

}
