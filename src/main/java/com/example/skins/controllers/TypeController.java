package com.example.skins.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
public class TypeController {
	  @Autowired
	    TypeService typeService;
	  @Autowired
	    SkinService skinService;
	 @RequestMapping("/createType")
	  public String CreateType(ModelMap modelMap)
	    {
	  
	    modelMap.addAttribute("type",new Type());
	    modelMap.addAttribute("mode","new");
	    
	    return "formType";
	    }
	 
	 @RequestMapping("/saveType")
	    public String saveType(Type type)
	    {
	    typeService.saveType(type);
		return "redirect:/ListeTypes";
	    }
	 
	 @RequestMapping("/ListeTypes")
	    public String listeTypes(ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {
	    	Page<Type> types = typeService.getAllTypesParPage(page, size);
	    	modelMap.addAttribute("types", types);
	    	modelMap.addAttribute("pages", new int[types.getTotalPages()]);
	    	modelMap.addAttribute("currentPage", page);
	    	return "listeTypes";
	    }
	 
	 
	 @RequestMapping("/supprimerType")
	    public String supprimerSkin(@RequestParam("id") Long id,
	    		ModelMap modelMap,
	    		@RequestParam (name="page",defaultValue = "0") int page,
	    		@RequestParam (name="size", defaultValue = "2") int size)
	    {
	        typeService.deleteTypeById(id);
	        Page<Type> types = typeService.getAllTypesParPage(page,size);
	        		modelMap.addAttribute("types", types);
	        		modelMap.addAttribute("pages", new int[types.getTotalPages()]);
	        		modelMap.addAttribute("currentPage", page);
	        		modelMap.addAttribute("size", size);
	        		return "listeTypes";
	    }
	 @RequestMapping("/modifierType")
	    public String editerType(@RequestParam("id") Long id,ModelMap modelMap)
	    {
	    Type t = typeService.getType(id);
	    modelMap.addAttribute("type", t);
	    modelMap.addAttribute("mode", "edit");
	    return "formType";
	    }
	 
	 
	 @RequestMapping("/updateType")
	    public String updateType(@ModelAttribute("type") Type type,ModelMap modelMap) throws ParseException
	    {

	        typeService.updateType(type);
	        List<Type> types = typeService.getAllTypes();
	        modelMap.addAttribute("types", types);
	        return "listeTypes";
	    }
	 @RequestMapping("/chercherType")
	
	    public String chercherType(@RequestParam("nomType") String nom,
	    		ModelMap modelMap)
	    
	    
	    {      
		 
		 		System.out.println(nom);
	    	  List <Skin> skins = skinService.findByNomTypeContains(nom);
	    	  modelMap.addAttribute("typess",skins);
	    	  
	    	  return "chercherType";
	    } 


}
