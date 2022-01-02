package com.TaeliaDideaux.rcreloaded.client.renderer.model;

import com.TaeliaDideaux.rcreloaded.RatchetAndClankReloadedMod;
import com.TaeliaDideaux.rcreloaded.common.entity.Clank;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ClankModel<Type extends Clank> extends AnimatedGeoModel<Type> {
	
	@Override public ResourceLocation getAnimationFileLocation(Type animatable) { return new ResourceLocation(RatchetAndClankReloadedMod.MODID, "animations/clank.animation.json"); }
	@Override public ResourceLocation getModelLocation(Type object) 			{ return new ResourceLocation(RatchetAndClankReloadedMod.MODID, "geo/clank_model.geo.json"); }
	@Override public ResourceLocation getTextureLocation(Type object) 			{ return new ResourceLocation(RatchetAndClankReloadedMod.MODID, "textures/entities/clank.png"); }
}