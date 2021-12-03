package com.ESNLEADER.dto;

import java.util.List;



import com.ESNLEADER.model.Projet;

public class FilialeDto {

	private Long idFiliale;
	private String adresse;
	private String email;
	private String tel;
	private String nomFiliale;
	private List<Projet> projets;
	public Long getIdFiliale() {
		return idFiliale;
	}
	public void setIdFiliale(Long idFiliale) {
		this.idFiliale = idFiliale;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getNomFiliale() {
		return nomFiliale;
	}
	public void setNomFiliale(String nomFiliale) {
		this.nomFiliale = nomFiliale;
	}
	public List<Projet> getProjets() {
		return projets;
	}
	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}
	
	
	
}
