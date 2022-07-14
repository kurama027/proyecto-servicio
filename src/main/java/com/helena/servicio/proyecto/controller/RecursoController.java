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

import com.helena.servicio.proyecto.entity.Recurso;
import com.helena.servicio.proyecto.service.RecursoService;

@RestController
public class RecursoController {
	@Autowired
	private RecursoService reser;
	
	@GetMapping("/listar-recurso")
	public ResponseEntity<?> findAll(HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta.");
        result.put("data", reser.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/ver-recurso/{id}")
	public Recurso detalle(@PathVariable Long id) { 
		return reser.findById(id);
	}
	
	@PostMapping("/crear-recurso")
    public ResponseEntity<?> save(@RequestBody Recurso re, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Recurso data = reser.save(re);

        result.put("success", true);
        result.put("message", "Registro creado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    } 
	
	@PutMapping("/actualiza-recurso/{id}")
    public ResponseEntity<?> update(@RequestBody Recurso re, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Recurso data = reser.findById(re.getID_RECURSO());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe Recurso con Id: " + re.getID_RECURSO());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            reser.save(re);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos del Recurso.");
            result.put("data",re);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }  
	
	@DeleteMapping("/eliminar-recurso/{ID_RECURSO}")
    public ResponseEntity<?> delete(@PathVariable(value = "ID_RECURSO") Long ID_RECURSO, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Recurso data = reser.findById(ID_RECURSO);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con id: " + ID_RECURSO);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            reser.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
