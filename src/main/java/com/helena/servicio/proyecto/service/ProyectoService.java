package com.helena.servicio.proyecto.service;

import java.util.List;

import com.helena.servicio.proyecto.entity.Proyecto;


public interface ProyectoService {
	public List<Proyecto> findAll();
	public Proyecto findById(Long id);
	public Proyecto save(Proyecto proy); 
	public void delete(Proyecto proy);


}
