package com.example.skins.service;

import java.util.List;

import com.example.skins.entities.Type;
import com.example.skins.entities.Skin;

import org.springframework.data.domain.Page;

public interface SkinService {

	Skin saveSkin(Skin p);
	Skin updateSkin(Skin p);
	void deleteSkin(Skin p);
	void deleteSkinById(Long id);
	Skin getSkin(Long id);
	List<Skin> getAllSkins();
	List<Skin> findByNomSkinContains(String nom);
	List<Skin> findByNomPrix(String nom, Double prix);
	List<Skin> findByType (Type type);
	List<Skin> findByTypeIdType(Long id);
	List<Skin> findByOrderByNomSkinAsc();
	List<Skin> trierSkinsNomsPrix();
	List<Skin> findByNomSkin(String nom);
	List<Skin> findByNomTypeContains (String nom);
	List<Type> getAllTypes();
	Page<Skin> getAllSkinsParPage(int page, int size);
}
