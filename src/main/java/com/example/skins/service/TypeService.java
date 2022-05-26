package com.example.skins.service;

import java.util.List;

import com.example.skins.entities.Type;

import org.springframework.data.domain.Page;

public interface TypeService {
	List<Type> getAllTypes();

	Type saveType(Type type);
	Page<Type> getAllTypesParPage(int page, int size);
	void deleteTypeById(Long id);
	Type getType(Long id);
	
	Type updateType(Type type);
}
