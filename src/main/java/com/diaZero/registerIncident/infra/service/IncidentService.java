package com.diaZero.registerIncident.infra.service;

import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.diaZero.registerIncident.domain.exception.IncidentNotFoundException;
import com.diaZero.registerIncident.domain.model.Incident;
import com.diaZero.registerIncident.domain.model.IncidentRepository;

@Service
public class IncidentService {

	@Autowired
	private IncidentRepository repository;
	
	private Incident incidentResponse;

	public List<Incident> listAll() {
		return repository.findAll();
	}
	
	public Incident findIncident(Long id) {
		incidentResponse = repository.findById(id)
				.orElseThrow(() -> new IncidentNotFoundException(id));
		return incidentResponse;
	}

	public Incident save(Incident incident) {
		incident.setActive("ativo");
		return repository.save(incident);
	}

	public Incident update(Long id, Incident incident) {

		incidentResponse = findIncident(id);
		incident.setUpdateAt(OffsetDateTime.now());
		
		BeanUtils.copyProperties(incident, incidentResponse, "id", "active", "createdAt");
		return repository.save(incidentResponse);
	}

	public void delete(Long id) {
		
		try {
			incidentResponse = findIncident(id);
			incidentResponse.setActive("inativo");
			repository.save(incidentResponse);
		}catch(EmptyResultDataAccessException e) {
			throw new IncidentNotFoundException(id);
		}
	}

	
	
}
