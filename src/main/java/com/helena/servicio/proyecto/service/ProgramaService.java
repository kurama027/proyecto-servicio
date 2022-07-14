package com.helena.servicio.proyecto.service;

import java.util.List;

import com.helena.servicio.proyecto.entity.Programa;


public interface ProgramaService {
	public List<Programa> findAll();
	public Programa findById(Long id);
	public Programa save(Programa prog); 
	public void delete(Programa prog);
}
