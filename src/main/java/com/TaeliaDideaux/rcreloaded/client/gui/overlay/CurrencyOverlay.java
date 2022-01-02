package com.TaeliaDideaux.rcreloaded.client.gui.overlay;

import com.TaeliaDideaux.rcreloaded.boltcurrency.CurrencyCapability;
import com.TaeliaDideaux.rcreloaded.boltcurrency.CurrencyStorage;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.world.entity.player.Player;

public class CurrencyOverlay extends GuiComponent {
	
	private static final Minecraft MC = Minecraft.getInstance();
	private static final Font font = MC.font;
	
	@SuppressWarnings("resource")
	public static void render(PoseStack matriStack) {
		Player player = Minecraft.getInstance().player;
		int bolts = 0;
		if (player != null) { bolts = player.getCapability(CurrencyCapability.CURRENCY_CAPABILITY).orElse(new CurrencyStorage()).getBolts(); }
		font.draw(matriStack, "Bolts : " + bolts, MC.getWindow().getGuiScaledWidth()-130, 20, 14737632);
	}
}