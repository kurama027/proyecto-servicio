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

import com.helena.servicio.proyecto.entity.Taller;
import com.helena.servicio.proyecto.service.TallerService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class TallerController {
	@Autowired
	private TallerService tallser;
	
	@GetMapping("/listar-taller")public ResponseEntity<?> findAll(HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta.");
        result.put("data", tallser.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);	
	}
	
	@GetMapping("/ver-taller/{id}")
	public Taller detalle(@PathVariable Long id) { 
		return tallser.findById(id);
	}
	
	@PostMapping("/crear-taller")
    public ResponseEntity<?> save(@RequestBody Taller tall, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Taller data = tallser.save(tall);

        result.put("success", true);
        result.put("message", "Registro creado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }  
	
	@PutMapping("/actualiza-taller/{id}")
    public ResponseEntity<?> update(@RequestBody Taller tall, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Taller data = tallser.findById(tall.getID_TALLER());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe Taller con Id: " + tall.getID_TALLER());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            tallser.save(tall);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos del Taller.");
            result.put("data",tall);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }  
	
	@DeleteMapping("/eliminar-taller/{ID_TALLER}")
    public ResponseEntity<?> delete(@PathVariable(value = "ID_TALLER") Long ID_TALLER, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Taller data = tallser.findById(ID_TALLER);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con id: " + ID_TALLER);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            tallser.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
