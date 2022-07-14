package com.helena.servicio.proyecto.serviceIpml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.helena.servicio.proyecto.entity.Taller;
import com.helena.servicio.proyecto.repository.TallerRepository;
import com.helena.servicio.proyecto.service.TallerService;
@Service
public class Tallerlpml implements TallerService{
	@Autowired
	private TallerRepository tallery;

	@Override
	public List<Taller> findAll() {
		// TODO Auto-generated method stub
		return (List<Taller>)tallery.findAll();
	}

	@Override
	public Taller findById(Long id) {
		// TODO Auto-generated method stub
		return tallery.findById(id).orElse(null);
	}

	@Override
	public Taller save(Taller tall) {
		// TODO Auto-generated method stub
		return tallery.save(tall);
	}

	@Override
	public void delete(Taller tall) {
		// TODO Auto-generated method stub
		tallery.delete(tall);
	}

}
