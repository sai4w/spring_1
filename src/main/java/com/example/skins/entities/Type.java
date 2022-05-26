package com.example.skins.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idType;

    private String nomType;
    private String descriptionType;
    @JsonIgnore
    @OneToMany(mappedBy = "type")
    private List<Skin> skins;
    public Long getIdType() {
        return idType;
    }
    public void setIdType(Long idType) {
        this.idType = idType;
    }
    public String getNomType() {
        return nomType;
    }
    public void setNomType(String nomType) {
        this.nomType = nomType;
    }
    public String getDescriptionType() {
        return descriptionType;
    }
    public void setDescriptionType(String descriptionType) {
        this.descriptionType = descriptionType;
    }
    public List<Skin> getSkins() {
        return skins;
    }
    public void setSkins(List<Skin> skins) {
        this.skins = skins;
    }
    
}
