package com.ESNLEADER.dto;

import java.util.List;


import com.ESNLEADER.model.Filiale;

public class EntrepriseDto {
	
	private Long idEntreprise;
	private String adresse;
	private String nom;
	private String secteur;
	private String site;
	private String numTel;
	private List<Filiale> filiales;
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
