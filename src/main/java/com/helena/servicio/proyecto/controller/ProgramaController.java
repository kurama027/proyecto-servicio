package com.helena.servicio.proyecto.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.helena.servicio.proyecto.entity.Programa;
import com.helena.servicio.proyecto.entity.Proyecto;
import com.helena.servicio.proyecto.service.ProgramaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class ProgramaController {
	@Autowired
	private ProgramaService progser;
	
	@GetMapping("/listar-programa")
	public ResponseEntity<?> findAll(HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta.");
        result.put("data", progser.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK); 	
	}
	
	@GetMapping("/ver-programa/{id}")
	public Programa detalle(@PathVariable Long id) { 
		return progser.findById(id);
	}
	
	@PostMapping("/crear-programa")
    public ResponseEntity<?> save(@RequestBody Programa prog, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Programa data = progser.save(prog);

        result.put("success", true);
        result.put("message", "Registro creado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    } 
	
	@PutMapping("/actualiza-programa/{id}")
    public ResponseEntity<?> update(@RequestBody Programa prog, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Programa data = progser.findById(prog.getID_PROGRAMA());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe Programa con Id: " + prog.getID_PROGRAMA());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            progser.save(prog);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos del Proyecto.");
            result.put("data",prog);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }  
	
	@DeleteMapping("/eliminar-programa/{ID_PROGRAMA}")
    public ResponseEntity<?> delete(@PathVariable(value = "ID_PROGRAMA") Long ID_PROGRAMA, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Programa data = progser.findById(ID_PROGRAMA);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con id: " + ID_PROGRAMA);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            progser.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
