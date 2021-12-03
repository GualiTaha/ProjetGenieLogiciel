package com.ESNLEADER.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"idProjet"})})
public class Projet {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long idProjet;
	@Column(name="client")
	private String client;
	@Column(name="description")
	private String description;
	@Column(name="duree")
	private String duree;
	@Column(name="nom_projet")
	private String nom_projet;
	@Column(name="type_projet")
	private String type_projet;
	
	@Fetch(value = FetchMode.SUBSELECT)
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name ="Projet_fk",referencedColumnName = "idProjet")
	private List<Technologies> technologies;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name ="Projet_fk",referencedColumnName = "idProjet")

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
	
	public List<Collaborateurs> getCollaborateurs() {
		return collaborateurs;
	}
	public List<Technologies> getTechnologies() {
		return technologies;
	}
	public void setCollaborateurs(List<Collaborateurs> collaborateurs) {
		this.collaborateurs = collaborateurs;
	}
	public void setTechnologies(List<Technologies> technologies) {
		this.technologies = technologies;
	}
	
}
