package com.diaZero.registerIncident.api.dto;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class IncidentOutputDTO {

	private Long id;
	private String name;
	private String description;
	private OffsetDateTime createdAt;
	private OffsetDateTime updateAt;
	private OffsetDateTime closedAt;
	private String active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public OffsetDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(OffsetDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public OffsetDateTime getClosedAt() {
		return closedAt;
	}

	public void setClosedAt(OffsetDateTime closedAt) {
		this.closedAt = closedAt;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	

}
