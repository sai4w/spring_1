package com.example.skins.restcontrollers;

import java.util.List;

import com.example.skins.entities.Skin;
import com.example.skins.service.SkinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class SkinRESTController {
	@Autowired
	SkinService skinService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Skin> getAllSkins() {
		return skinService.getAllSkins();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Skin getSkinById(@PathVariable("id") Long id) {
		return skinService.getSkin(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Skin createSkin(@RequestBody Skin skin) {
		return skinService.saveSkin(skin);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Skin updateSkin(@RequestBody Skin skin) {
		return skinService.updateSkin(skin);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteSkin(@PathVariable("id") Long id) {
		skinService.deleteSkinById(id);
	}

	@RequestMapping(value = "/skinsType/{idType}", method = RequestMethod.GET)
	public List<Skin> getSkinsByTypeId(@PathVariable("idType") Long idType) {
		return skinService.findByTypeIdType(idType);
	}
}
