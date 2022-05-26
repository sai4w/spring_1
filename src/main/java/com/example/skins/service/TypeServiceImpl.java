package com.example.skins.service;

import java.util.List;

import com.example.skins.entities.Type;
import com.example.skins.repos.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public  class TypeServiceImpl implements TypeService {
	@Autowired
	TypeRepository typeRepository;
	
	@Override
	public List<Type> getAllTypes() {
		return typeRepository.findAll();
	}
	 @Override
	    public Type saveType(Type type) {
	        return typeRepository.save(type);
	    }
	 @Override
	    public Page<Type> getAllTypesParPage(int page, int size) {
	    return typeRepository.findAll(PageRequest.of(page, size));
	    }
	 
	 @Override
	    public void deleteTypeById(Long id) {
	        typeRepository.deleteById(id);
	    }
	 
	 @Override
	    public Type getType(Long id) {
	        return typeRepository.findById(id).get();
	    }
	 @Override
	    public Type updateType(Type type) {
	        return typeRepository.save(type);
	    }


}
