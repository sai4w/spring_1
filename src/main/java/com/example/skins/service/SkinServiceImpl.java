package com.example.skins.service;

import java.util.List;

import com.example.skins.entities.Type;
import com.example.skins.entities.Skin;
import com.example.skins.repos.TypeRepository;
import com.example.skins.repos.SkinRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SkinServiceImpl implements SkinService {
	@Autowired
	SkinRepository skinRepository;

	@Autowired
	TypeRepository typeRepository;

	@Override
	public Skin saveSkin(Skin p) {
		return skinRepository.save(p);
	}

	@Override
	public Skin updateSkin(Skin p) {
		return skinRepository.save(p);
	}

	@Override
	public void deleteSkin(Skin p) {
		skinRepository.delete(p);
	}

	@Override
	public void deleteSkinById(Long id) {
		skinRepository.deleteById(id);
	}

	@Override
	public Skin getSkin(Long id) {
		return skinRepository.findById(id).get();
	}

	@Override
	public List<Skin> getAllSkins() {
		return skinRepository.findAll();
	}

	@Override
	public Page<Skin> getAllSkinsParPage(int page, int size) {
		return skinRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Skin> findByNomSkinContains(String nom) {
		return skinRepository.findByNomSkinContains(nom);
	}

	@Override
	public List<Skin> findByNomPrix(String nom, Double prix) {
		return skinRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Skin> findByType(Type type) {
		return skinRepository.findByTypeContains(type);
	}

	@Override
	public List<Skin> findByTypeIdType(Long id) {
		return skinRepository.findByTypeIdType(id);
	}

	@Override
	public List<Skin> findByOrderByNomSkinAsc() {
		return skinRepository.findByOrderByNomSkinAsc();
	}

	@Override
	public List<Skin> trierSkinsNomsPrix() {
		return skinRepository.trierSkinsNomsPrix();
	}

	@Override
	public List<Skin> findByNomSkin(String nom) {
		return skinRepository.findByNomSkin(nom);
	}

	@Override
	public List<Skin> findByNomTypeContains(String type) {

		return skinRepository.findByNomTypeContains(type);
	}

	@Override
	public List<Type> getAllTypes() {

		return typeRepository.findAll();
	}

}
