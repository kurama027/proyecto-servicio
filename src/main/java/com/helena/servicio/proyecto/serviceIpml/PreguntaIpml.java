package com.helena.servicio.proyecto.serviceIpml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helena.servicio.proyecto.entity.Pregunta;
import com.helena.servicio.proyecto.repository.PreguntaRepository;
import com.helena.servicio.proyecto.service.PreguntaService;

@Service
public class PreguntaIpml implements PreguntaService{
	@Autowired
	private PreguntaRepository prere;
	
	@Override
	public List<Pregunta> findAll() {
		// TODO Auto-generated method stub
		return (List<Pregunta>)prere.findAll();
	}

	@Override
	public Pregunta findById(Long id) {
		// TODO Auto-generated method stub
		return prere.findById(id).orElse(null);
	}

	@Override
	public Pregunta save(Pregunta pre) {
		// TODO Auto-generated method stub
		return prere.save(pre);
	}

	@Override
	public void delete(Pregunta pre) {
		// TODO Auto-generated method stub
		prere.delete(pre);
	}

}
