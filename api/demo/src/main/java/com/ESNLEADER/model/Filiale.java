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


@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames = {"idFiliale"})})
public class Filiale {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long idFiliale;
	@Column(name="adresse")
	private String adresse;
	@Column(name="email")
	private String email;
	@Column(name="telephone")
	private String tel;
	@Column(name="nomFiliale")
	private String nomFiliale;
	

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name ="Filiale_fk",referencedColumnName = "idFiliale")
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
	
	public void setProjets(List<Projet> projets) {
		this.projets = projets;
	}
	public List<Projet> getProjets() {
		return projets;
	}
}
