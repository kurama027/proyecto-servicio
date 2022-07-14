package com.helena.servicio.proyecto.serviceIpml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helena.servicio.proyecto.entity.Programa;
import com.helena.servicio.proyecto.repository.ProgramaRepository;
import com.helena.servicio.proyecto.service.ProgramaService;
@Service
public class ProgramaIpml implements ProgramaService{
	@Autowired
	private ProgramaRepository prore;
	@Override
	public List<Programa> findAll() {
		// TODO Auto-generated method stub
		return (List<Programa>)prore.findAll();
	}

	@Override
	public Programa findById(Long id) {
		// TODO Auto-generated method stub
		return prore.findById(id).orElse(null);
	}

	@Override
	public Programa save(Programa prog) {
		// TODO Auto-generated method stub
		return prore.save(prog);
	}

	@Override
	public void delete(Programa prog) {
		// TODO Auto-generated method stub
		prore.delete(prog);
	}

}
