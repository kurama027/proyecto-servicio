package com.helena.servicio.proyecto.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.helena.servicio.proyecto.entity.Pregunta;
import com.helena.servicio.proyecto.service.PreguntaService;

@RestController
public class PreguntaController {
	@Autowired 
	private PreguntaService preser;
	
	@GetMapping("/listar-pregunta")
	public List<Pregunta>listar(){
		return preser.findAll(); 	
	}
	
	@GetMapping("/ver-pregunta/{id}")
	public Pregunta detalle(@PathVariable Long id) { 
		return preser.findById(id);
	}
	
	@PostMapping("/crear-pregunta")
    public ResponseEntity<?> save(@RequestBody Pregunta preg, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Pregunta data = preser.save(preg);

        result.put("success", true);
        result.put("message", "Registro creado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    } 
	
	@PutMapping("/actualiza-pregunta/{id}")
    public ResponseEntity<?> update(@RequestBody Pregunta preg, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Pregunta data = preser.findById(preg.getID_PREGUNTA());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe Pregunta con Id: " + preg.getID_PREGUNTA());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            preser.save(preg);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos de la Pregunta.");
            result.put("data",preg);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }  
	
	@DeleteMapping("/eliminar-pregunta/{ID_PREGUNTA}")
    public ResponseEntity<?> delete(@PathVariable(value = "ID_PREGUNTA") Long ID_PREGUNTA, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Pregunta data = preser.findById(ID_PREGUNTA);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con id: " + ID_PREGUNTA);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            preser.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
