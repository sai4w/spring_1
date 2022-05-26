package com.example.skins.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

import javax.validation.Valid;

import com.example.skins.entities.Type;
import com.example.skins.entities.Skin;
import com.example.skins.service.TypeService;
import com.example.skins.service.SkinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SkinController {
	@Autowired
	SkinService skinService;
	@Autowired
	TypeService typeService;

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		modelMap.addAttribute("skin", new Skin());
		modelMap.addAttribute("mode", "new");
		List<Type> types = typeService.getAllTypes();
		modelMap.addAttribute("typess", types);
		return "formskin";
	}

	@RequestMapping("/saveSkin")
	public String saveSkin(@Valid Skin skin, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "formskin";

		skinService.saveSkin(skin);
		return "redirect:/ListeSkins";
	}

	@RequestMapping("/ListeSkins")
	public String listeSkins(ModelMap modelMap,

			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size)

	{
		Page<Skin> skins = skinService.getAllSkinsParPage(page, size);
		modelMap.addAttribute("skins", skins);

		modelMap.addAttribute("pages", new int[skins.getTotalPages()]);
		Page<Type> types = typeService.getAllTypesParPage(page, size);
		modelMap.addAttribute("types", types);
		modelMap.addAttribute("pages", new int[types.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("currentPage", page);

		return "listeSkins";
	}

	@RequestMapping("/supprimerSkin")
	public String supprimerSkin(@RequestParam("id") Long id,

			ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size)

	{
		skinService.deleteSkinById(id);
		Page<Skin> skins = skinService.getAllSkinsParPage(page, size);

		modelMap.addAttribute("skins", skins);
		List<Type> types = skinService.getAllTypes();
		modelMap.addAttribute("types", types);
		modelMap.addAttribute("pages", new int[skins.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		
		return "listeSkins";
	}

	@RequestMapping("/modifierSkin")
	public String editerSkin(@RequestParam("id") Long id, ModelMap modelMap) {
		Skin skin = skinService.getSkin(id);
		modelMap.addAttribute("skin", skin);
		modelMap.addAttribute("mode", "edit");

		List<Type> types = typeService.getAllTypes();

		modelMap.addAttribute("types", types);
		return "formskin";
	}

	@RequestMapping("/updateSkin")
	public String updateskin(@ModelAttribute("skin") Skin skin, @RequestParam("date") String date, ModelMap modelMap)
			throws ParseException

	{

		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		skin.setDateCreation(dateCreation);
		skinService.updateSkin(skin);
		List<Skin> skins = skinService.getAllSkins();
		modelMap.addAttribute("skins", skins);
		List<Type> types = skinService.getAllTypes();
		modelMap.addAttribute("types", types);
		return "listeSkins";

	}

	@RequestMapping("/chercherNom")
	public String chercherskin(@RequestParam("nomSkin") String nom, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size)

	{

		List<Skin> skins = skinService.findByNomSkinContains(nom);

		modelMap.addAttribute("skins", skins);
		List<Type> types = skinService.getAllTypes();
		modelMap.addAttribute("type", types);

		return "listeSkins";
	}

	@RequestMapping("/chercherType")
	public String chercherType(@RequestParam("idType") int idType, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {

		List<Skin> skins = skinService.getAllSkins();
		skins = skins.stream().filter(x -> x.getType().getIdType() == idType).collect(Collectors.toList());
		modelMap.addAttribute("skins", skins);
		List<Type> types = skinService.getAllTypes();
		modelMap.addAttribute("types", types);
		modelMap.addAttribute("currentPage", page);

		return "listeSkins";
	}

}