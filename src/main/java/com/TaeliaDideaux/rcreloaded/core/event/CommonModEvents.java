package com.TaeliaDideaux.rcreloaded.core.event;

import com.TaeliaDideaux.rcreloaded.RatchetAndClankReloadedMod;
import com.TaeliaDideaux.rcreloaded.common.entity.Clank;
import com.TaeliaDideaux.rcreloaded.core.init.EntityInit;
import com.TaeliaDideaux.rcreloaded.core.world.OreGeneration;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = RatchetAndClankReloadedMod.MODID, bus = Bus.MOD)
public class CommonModEvents {
	
	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(EntityInit.CLANK.get(), Clank.createAttributes().build());
	}
	
	@SubscribeEvent
	public static void commonSetup(FMLCommonSetupEvent event) {
		event.enqueueWork(OreGeneration::registerOres);
	}

}