package com.diaZero.registerIncident.domain.exception;

public class IncidentNotFoundException extends EntityNotFoundException{

	private static final long serialVersionUID = 1L;

	public IncidentNotFoundException(String msg) {
		super(msg);
	}
	
	public IncidentNotFoundException(Long incidentId) {
		this(String.format("It was not possible to find a record with the incident with the code %d", incidentId));
	}
	
}
