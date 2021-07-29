package com.diaZero.registerIncident.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diaZero.registerIncident.api.dto.IncidentInputDTO;
import com.diaZero.registerIncident.api.dto.IncidentOutputDTO;
import com.diaZero.registerIncident.domain.exception.EntityNotFoundException;
import com.diaZero.registerIncident.domain.model.Incident;
import com.diaZero.registerIncident.domain.model.IncidentRepository;
import com.diaZero.registerIncident.infra.service.IncidentService;

@RestController
@RequestMapping(value = "/incidents")
public class IncidentController {
	
	private Incident incident;

	@Autowired
	private IncidentService service;
	
	@Autowired
	private IncidentRepository repository;

	@GetMapping
	public ResponseEntity<List<IncidentOutputDTO>> listAll() {
		
		List<IncidentOutputDTO> listDto = toCollectionModel(service.listAll());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping(value = "/active")
	public ResponseEntity<List<IncidentOutputDTO>> listAllActive(@RequestParam String active) {
		
		List<IncidentOutputDTO> listDto = toCollectionModel(repository.findDistinctByActive(active));
		return ResponseEntity.ok().body(listDto);
	}
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<IncidentOutputDTO> findOne(@PathVariable Long id) {		
		
		IncidentOutputDTO dto = toModel(service.findIncident(id));		
		return ResponseEntity.ok(dto);
	}

	

	@PostMapping
	public ResponseEntity<?> addIncident(@RequestBody IncidentInputDTO incidentInputDTO) {
		try {
			incident = toDomainObject(incidentInputDTO);
			IncidentOutputDTO dto = toModel(service.save(incident));
			return ResponseEntity.status(HttpStatus.CREATED).body(dto);
		}catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<IncidentOutputDTO> updateIncident(@PathVariable Long id, @RequestBody IncidentInputDTO incidentInputDTO) {
		
		incident = toDomainObject(incidentInputDTO);
		IncidentOutputDTO incidentResponse = toModel(service.update(id, incident));
		return ResponseEntity.status(HttpStatus.CREATED).body(incidentResponse);
	}

	@DeleteMapping(value = "/{idIncident}")
	public ResponseEntity<?> deleteIncident(@PathVariable Long idIncident) {
		try {
			service.delete(idIncident);
			return ResponseEntity.noContent().build();
		}catch(EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	private IncidentOutputDTO toModel(Incident incident) {
		IncidentOutputDTO dto = new IncidentOutputDTO();
		
		dto.setId(incident.getId());
		dto.setName(incident.getName());
		dto.setDescription(incident.getDescription());
		dto.setCreatedAt(incident.getCreatedAt());
		dto.setUpdateAt(incident.getUpdateAt());
		dto.setClosedAt(incident.getClosedAt());
		dto.setActive(incident.getActive());
		return dto;
	}
	
	private List<IncidentOutputDTO> toCollectionModel(List<Incident> listIncident){
		return listIncident.stream()
				.map(incident -> toModel(incident))
				.collect(Collectors.toList());
	}
	
	private Incident toDomainObject(IncidentInputDTO incidentInputDTO) {
		Incident incident = new Incident();
		
		incident.setId(incidentInputDTO.getId());
		incident.setName(incidentInputDTO.getName());
		incident.setDescription(incidentInputDTO.getDescription());
		incident.setCreatedAt(incidentInputDTO.getCreatedAt());
		incident.setUpdateAt(incidentInputDTO.getUpdateAt());
		incident.setClosedAt(incidentInputDTO.getClosedAt());
		incident.setActive(incidentInputDTO.getActive());
		
		return incident;
	}

}
