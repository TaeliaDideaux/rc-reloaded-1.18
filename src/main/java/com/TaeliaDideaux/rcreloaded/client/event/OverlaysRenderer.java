package com.TaeliaDideaux.rcreloaded.client.event;

import com.TaeliaDideaux.rcreloaded.client.gui.overlay.CurrencyOverlay;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class OverlaysRenderer {
	
	@SubscribeEvent
	public static void onOverlaysRendered(RenderGameOverlayEvent event) {
		PoseStack matrixStack = event.getMatrixStack();
		CurrencyOverlay.render(matrixStack);
	}

}
