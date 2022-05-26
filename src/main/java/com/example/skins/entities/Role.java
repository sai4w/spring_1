package com.example.skins.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Role {
@Id
@GeneratedValue (strategy=GenerationType.IDENTITY)
private Long role_id;
private String role;
public Long getRole_id() {
	return role_id;
}
public void setRole_id(Long role_id) {
	this.role_id = role_id;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

}
