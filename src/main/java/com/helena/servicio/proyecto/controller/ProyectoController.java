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

import com.helena.servicio.proyecto.entity.Proyecto;
import com.helena.servicio.proyecto.service.ProyectoService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
public class ProyectoController {
	@Autowired
	private ProyectoService proser;

	@GetMapping("/listar-proyecto")public ResponseEntity<?> findAll(HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("success", true);
        result.put("message", "Consulta correcta.");
        result.put("data", proser.findAll());
        return new ResponseEntity<>(result, HttpStatus.OK);	
	}
	
	@GetMapping("/ver-proyecto/{id}")
	public Proyecto detalle(@PathVariable Long id) { 
		return proser.findById(id);
	}
	
	@PostMapping("/crear-proyecto")
    public ResponseEntity<?> save(@RequestBody Proyecto proyec, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Proyecto data = proser.save(proyec);

        result.put("success", true);
        result.put("message", "Registro creado correctamente.");
        result.put("data", data);
        return new ResponseEntity<>(result, HttpStatus.OK);
    } 
	
	@PutMapping("/actualiza-proyecto/{id}")
    public ResponseEntity<?> update(@RequestBody Proyecto proyec, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Proyecto data = proser.findById(proyec.getID_PROYECTO());
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe Proyecto con Id: " + proyec.getID_PROYECTO());
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            proser.save(proyec);
            result.put("success", true);
            result.put("message", "Se ha actualizado los datos del Proyecto.");
            result.put("data",proyec);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }  
	
	@DeleteMapping("/eliminar-proyecto/{ID_PROYECTO}")
    public ResponseEntity<?> delete(@PathVariable(value = "ID_PROYECTO") Long ID_PROYECTO, HttpServletRequest request) {
        HashMap<String, Object> result = new HashMap<>();
        Proyecto data = proser.findById(ID_PROYECTO);
        if (data == null) {
            result.put("success", false);
            result.put("message", "No existe registro con id: " + ID_PROYECTO);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        try {
            proser.delete(data);
            result.put("success", true);
            result.put("message", "Se ha eliminado los datos del registro.");
            result.put("data", data);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new Exception(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
