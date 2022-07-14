package com.helena.servicio.proyecto.service;

import java.util.List;

import com.helena.servicio.proyecto.entity.Taller;

public interface TallerService {
	public List<Taller> findAll();
	public Taller findById(Long id);
	public Taller save(Taller tall); 
	public void delete(Taller tall);

}
