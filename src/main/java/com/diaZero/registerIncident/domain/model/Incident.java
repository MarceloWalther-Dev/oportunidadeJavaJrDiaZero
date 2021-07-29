package com.diaZero.registerIncident.domain.model;

import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
public class Incident {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	private String description;
	
	@CreationTimestamp
    @Column(nullable = false, columnDefinition = "datetime")
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


	public void setActive(String active) {
		this.active = active;
	}

	public String getActive() {
		return active;
	}
	
	
	
}
