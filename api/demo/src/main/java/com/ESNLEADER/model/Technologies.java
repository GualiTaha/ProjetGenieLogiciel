package com.ESNLEADER.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"idTechnologie"})})
public class Technologies {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long idTechnologie;
	@Column(name="Nom")
	private String Nom;
	


	public Long getIdTechnologie() {
		return idTechnologie;
	}

	public void setIdTechnologie(Long idTechnologie) {
		this.idTechnologie = idTechnologie;
	}

	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}


	

	
	
	
	
	
}
