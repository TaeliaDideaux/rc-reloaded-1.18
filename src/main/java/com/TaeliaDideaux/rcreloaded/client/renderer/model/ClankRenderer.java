package com.TaeliaDideaux.rcreloaded.client.renderer.model;

import com.TaeliaDideaux.rcreloaded.common.entity.Clank;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class ClankRenderer<Type extends Clank> extends GeoEntityRenderer<Type> {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ClankRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new ClankModel());
		this.shadowRadius = 0.7F;
	}
}