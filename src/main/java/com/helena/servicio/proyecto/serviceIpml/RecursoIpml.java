package com.helena.servicio.proyecto.serviceIpml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helena.servicio.proyecto.entity.Recurso;
import com.helena.servicio.proyecto.repository.RecursoRepository;
import com.helena.servicio.proyecto.service.RecursoService;
@Service
public class RecursoIpml implements RecursoService{
	@Autowired
	private RecursoRepository rero;
	@Override
	public List<Recurso> findAll() {
		// TODO Auto-generated method stub
		return (List<Recurso>)rero.findAll();
	}

	@Override
	public Recurso findById(Long id) {
		// TODO Auto-generated method stub
		return rero.findById(id).orElse(null);
	}

	@Override
	public Recurso save(Recurso re) {
		// TODO Auto-generated method stub
		return rero.save(re);
	}

	@Override
	public void delete(Recurso re) {
		// TODO Auto-generated method stub
		rero.delete(re);
	}

}
