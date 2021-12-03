package com.ESNLEADER.app;



import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;


@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"num_affaire"})})
public class Affaire {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAffaire;
	@Column(name="titre")
	private String titre;
	@Column(name="description")
	private String description;
	@Column(name="date_prev_fin")
	private LocalDate datePrevFin;
	@Column(name="discipline")
	private String discipline;
	@Column(name="site")
	private String site;
	@Generated(GenerationTime.INSERT)
	@Column(name="num_affaire",columnDefinition = "serial", updatable = false)
	private int numAffaire;
	@Column(name="date_creation")
	private LocalDate dateCreation;
	@Column(name="cout")
	private int cout;
	
	public Long getIdAffaire() {
		return idAffaire;
	}
	
	public Affaire() {
		super();
	}
	public void setIdAffaire(Long idAffaire) {
		this.idAffaire = idAffaire;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDatePrevFin() {
		return datePrevFin;
	}
	public void setDatePrevFin(LocalDate datePrevFin) {
		this.datePrevFin = datePrevFin;
	}
	public String getDiscipline() {
		return discipline;
	}
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
	public int getNumAffaire() {
		return numAffaire;
	}

	public void setNumAffaire(int numAffaire) {
		this.numAffaire = numAffaire;
	}

	public LocalDate getDateCreation() {
		return dateCreation.now();
	}
	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}
	public int getCout() {
		return cout;
	}
	public void setCout(int cout) {
		this.cout = cout;
	}

	
}

