package com.example.skins.repos;

import java.util.List;

import com.example.skins.entities.Type;
import com.example.skins.entities.Skin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;
@RepositoryRestResource(path = "rest")
public interface SkinRepository extends JpaRepository<Skin, Long> {
	
	
	 List<Skin> findByNomSkinContains(String nom);
	 @Query("select p from Skin p where p.nomSkin like %:nom and p.prixSkin > :prix")
	 List<Skin> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	 @Query("select p from Skin p where p.type = ?1")
	 List<Skin> findByTypeContains (Type type);
	 List<Skin> findByTypeIdType(Long id);
	 List<Skin> findByOrderByNomSkinAsc();
	 @Query("select p from Skin p order by p.nomSkin ASC, p.prixSkin DESC")
	 List<Skin> trierSkinsNomsPrix ();
	 @Query("select p from Skin p  where p.nomSkin like 'PC'")
	 List<Skin> findByNomSkin(@Param("nomSkin") String nom);	
	 @Query("select p from Skin p where p.type.nomType like ?1")
	 List<Skin> findByNomTypeContains(String nom);
}