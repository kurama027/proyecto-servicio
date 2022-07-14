package com.helena.servicio.proyecto.serviceIpml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.helena.servicio.proyecto.entity.Proyecto;
import com.helena.servicio.proyecto.repository.ProyectoRepository;
import com.helena.servicio.proyecto.service.ProyectoService;

@Service
public class ProyectoIpml implements ProyectoService{
	@Autowired
	private ProyectoRepository prostory;

	@Override
	@Transactional(readOnly = true)
	public List<Proyecto> findAll() {
		// TODO Auto-generated method stub
		return (List<Proyecto>)prostory.findAll();
	}

	@Override
	public Proyecto findById(Long id) {
		// TODO Auto-generated method stub
		return prostory.findById(id).orElse(null);
	}

	@Override
	public Proyecto save(Proyecto proy) {
		// TODO Auto-generated method stub
		return prostory.save(proy);
	}

	@Override
	public void delete(Proyecto proy) {
		// TODO Auto-generated method stub
		prostory.delete(proy);
	}
	

}
