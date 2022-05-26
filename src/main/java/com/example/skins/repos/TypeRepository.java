package com.example.skins.repos;

import java.util.List;

import com.example.skins.entities.Type;
import com.example.skins.entities.Skin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource(path = "rest")
public interface TypeRepository extends JpaRepository<Type, Long> {

	
}
