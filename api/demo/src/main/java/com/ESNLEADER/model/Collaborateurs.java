package com.ESNLEADER.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"idCollaborateur"})})
public class Collaborateurs {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long idCollaborateur;
	@Column(name="anciennete")
	private String anciennete;
	@Column(name="formation")
	private String formation;
	@Column(name="grade")
	private String grade;
	@Column(name="name")
	private String name;
	@Column(name="salaire")
	private double salaire;
	
	


	public Long getIdCollaborateur() {
		return idCollaborateur;
	}


	public void setIdCollaborateur(Long idCollaborateur) {
		this.idCollaborateur = idCollaborateur;
	}


	public String getAnciennete() {
		return anciennete;
	}


	public void setAnciennete(String anciennete) {
		this.anciennete = anciennete;
	}


	public String getFormation() {
		return formation;
	}


	public void setFormation(String formation) {
		this.formation = formation;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSalaire() {
		return salaire;
	}


	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}



	
	
}
