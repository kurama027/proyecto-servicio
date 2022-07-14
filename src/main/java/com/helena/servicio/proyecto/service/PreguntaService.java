package com.helena.servicio.proyecto.service;

import java.util.List;

import com.helena.servicio.proyecto.entity.Pregunta;


public interface PreguntaService {
	public List<Pregunta> findAll();
	public Pregunta findById(Long id);
	public Pregunta save(Pregunta pre); 
	public void delete(Pregunta pre);
}


