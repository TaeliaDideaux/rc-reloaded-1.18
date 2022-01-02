package com.TaeliaDideaux.rcreloaded.client.event;

import com.TaeliaDideaux.rcreloaded.boltcurrency.CurrencyCapability;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class CurrencyModificationHandler {
	
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		event.player.getCapability(CurrencyCapability.CURRENCY_CAPABILITY);
	}

}
