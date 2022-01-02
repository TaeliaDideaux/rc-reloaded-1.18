package com.TaeliaDideaux.rcreloaded.core.init;

import com.TaeliaDideaux.rcreloaded.core.BaseToolMaterial;

import net.minecraft.world.item.Tier;

public class ToolMaterialInit {
	
	private ToolMaterialInit() {}

	public static final Tier RARITANIUM = new BaseToolMaterial(6, 3, 5, 25, -1, null);
	public static final Tier ADAMANTINE = new BaseToolMaterial(9, 3, 6, 30, -1, null);
}
