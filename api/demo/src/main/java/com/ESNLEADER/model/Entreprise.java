package com.ESNLEADER.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


import javax.persistence.GenerationType;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"idEntreprise"})})
public class Entreprise {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long idEntreprise;
	@Column(name="adresse")
	private String adresse;
	@Column(name="nom")
	private String nom;
	@Column(name="secteur")
	private String secteur;
	@Column(name="site")
	private String site;
	@Column(name="numTel")
	private String numTel;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name ="Entreprise_fk",referencedColumnName = "idEntreprise")
	private List<Filiale> filiales;
	
	
	public Entreprise() {
	}


	public Long getIdEntreprise() {
		return idEntreprise;
	}


	public void setIdEntreprise(Long idEntreprise) {
		this.idEntreprise = idEntreprise;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getSecteur() {
		return secteur;
	}


	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}


	public String getSite() {
		return site;
	}


	public void setSite(String site) {
		this.site = site;
	}


	public String getNumTel() {
		return numTel;
	}


	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}


	public List<Filiale> getFiliales() {
		return filiales;
	}


	public void setFiliales(List<Filiale> filiales) {
		this.filiales = filiales;
	}
	
	
	
}
