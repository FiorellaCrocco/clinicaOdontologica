package com.company.ClinicaOdontologica.controller;

import com.company.ClinicaOdontologica.dto.PacienteDTO;
import com.company.ClinicaOdontologica.entity.Paciente;
import com.company.ClinicaOdontologica.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
//@CrossOrigin
public class PacienteController {

    PacienteService pacienteService;

    // Constructor de PacienteController que permite la inyección de dependencias.
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    // En la url "/paciente/listar" retorno una lista de PacienteDTO
    @GetMapping("/listar")
    public List<PacienteDTO> obtenerPacientes(){
        List<PacienteDTO> listaPacientes = pacienteService.buscarTodos();
        return listaPacientes;
    }

    // En la url "/paciente/{id}" retorno el pacienteDTO deseado (segun el ID) y si no lo encuentra se dispara una Exception
    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> obtenerUnPaciente(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    // En la url "/paciente/guardar" hacemos un POST para guardar el Paciente
    @PostMapping("/guardar")
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.guardar(paciente));
    }

    // En la url "/paciente/modificar" actualizamos un paciente ya existente
    @PutMapping("/modificar")
    public ResponseEntity<Paciente> actualizarUnPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.actualizar(paciente));
    }

    // En la url "/paciente/{id}" utilizamos el metodo DELETE para eliminar un paciente segun su ID.
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarUnPaciente(@PathVariable Long id) throws Exception {
        pacienteService.eliminar(id);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado");
    }

}
