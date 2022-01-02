package com.TaeliaDideaux.rcreloaded.boltcurrency;

import com.TaeliaDideaux.rcreloaded.RatchetAndClankReloadedMod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

public class CurrencyCapability {
	
	public static Capability<ICurrencyCapability> CURRENCY_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {});
	public static final ResourceLocation CAPABILITY_KEY = new ResourceLocation(RatchetAndClankReloadedMod.MODID, "currency");

    @Mod.EventBusSubscriber(modid = RatchetAndClankReloadedMod.MODID, bus = Bus.FORGE)
    public static class ForgeBusSubscriber {
    	
        @SubscribeEvent
        public static void attach(AttachCapabilitiesEvent<Entity> event) {
        	
        	if (event.getObject() instanceof Player) {
        		
        		ICurrencyCapability capability;
        		
        		if (event.getObject() instanceof ServerPlayer) { capability = new PlayerCurrencyStorage((ServerPlayer)event.getObject()); }
        		else										   { capability = new CurrencyStorage(); }
        		
            	PlayerCurrencyProvider provider = new PlayerCurrencyProvider(capability);
            	event.addCapability(CurrencyCapability.CAPABILITY_KEY, provider);	
			}
        }
    }
}