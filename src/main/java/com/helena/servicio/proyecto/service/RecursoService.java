package com.helena.servicio.proyecto.service;

import java.util.List;

import com.helena.servicio.proyecto.entity.Recurso;


public interface RecursoService {
	public List<Recurso> findAll();
	public Recurso findById(Long id);
	public Recurso save(Recurso re); 
	public void delete(Recurso re);

}
