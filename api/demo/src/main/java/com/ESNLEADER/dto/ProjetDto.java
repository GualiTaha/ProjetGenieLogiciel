package com.ESNLEADER.dto;

import java.util.List;


import com.ESNLEADER.model.Collaborateurs;
import com.ESNLEADER.model.Technologies;

public class ProjetDto {

	private Long idProjet;
	private String client;
	private String description;
	private String duree;
	private String nom_projet;
	private String type_projet;
	private List<Technologies> technologies;
	private List<Collaborateurs> collaborateurs;
	public Long getIdProjet() {
		return idProjet;
	}
	public void setIdProjet(Long idProjet) {
		this.idProjet = idProjet;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDuree() {
		return duree;
	}
	public void setDuree(String duree) {
		this.duree = duree;
	}
	public String getNom_projet() {
		return nom_projet;
	}
	public void setNom_projet(String nom_projet) {
		this.nom_projet = nom_projet;
	}
	public String getType_projet() {
		return type_projet;
	}
	public void setType_projet(String type_projet) {
		this.type_projet = type_projet;
	}
	public List<Technologies> getTechnologies() {
		return technologies;
	}
	public void setTechnologies(List<Technologies> technologies) {
		this.technologies = technologies;
	}
	public List<Collaborateurs> getCollaborateurs() {
		return collaborateurs;
	}
	public void setCollaborateurs(List<Collaborateurs> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}
	
	
	
}
