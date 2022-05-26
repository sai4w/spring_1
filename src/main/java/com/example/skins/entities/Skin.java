package com.example.skins.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Skin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSkin;
	
	private String nomSkin;
	@Min(value = 10)
	 @Max(value = 10000)
	private Double prixSkin;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent

	private Date dateCreation;
	@ManyToOne
	private Type type;
	public Skin() {
		super();
	}

	

	

	public Type getType() {
		return type;
	}





	public void setType(Type type) {
		this.type = type;
	}





	public Long getIdSkin() {
		return idSkin;
	}

	public void setIdSkin(Long idSkin) {
		this.idSkin = idSkin;
	}

	public String getNomSkin() {
		return nomSkin;
	}

	public void setNomSkin(String nomSkin) {
		this.nomSkin = nomSkin;
	}

	public Double getPrixSkin() {
		return prixSkin;
	}

	public void setPrixSkin(Double prixSkin) {
		this.prixSkin = prixSkin;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


}