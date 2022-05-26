package com.example.skins.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomSkin", types = { Skin.class })
public interface SkinProjection {
public String getNomSkin();
}
