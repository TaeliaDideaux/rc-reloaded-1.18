package com.TaeliaDideaux.rcreloaded;

import com.TaeliaDideaux.rcreloaded.boltcurrency.CurrencyCapability;
import com.TaeliaDideaux.rcreloaded.client.event.CurrencyModificationHandler;
import com.TaeliaDideaux.rcreloaded.client.event.OverlaysRenderer;
import com.TaeliaDideaux.rcreloaded.core.init.BlockInit;
import com.TaeliaDideaux.rcreloaded.core.init.EntityInit;
import com.TaeliaDideaux.rcreloaded.core.init.ItemInit;
import com.TaeliaDideaux.rcreloaded.core.init.NetworkInit;
import com.TaeliaDideaux.rcreloaded.core.init.SoundsInit;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod(RatchetAndClankReloadedMod.MODID)
public class RatchetAndClankReloadedMod {
	
	public static final String MODID = "rcreloaded";
	
	public RatchetAndClankReloadedMod() {
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(CurrencyCapability.class);
		MinecraftForge.EVENT_BUS.register(CurrencyModificationHandler.class);
		MinecraftForge.EVENT_BUS.register(OverlaysRenderer.class);
		
		var bus = FMLJavaModLoadingContext.get().getModEventBus();

		BlockInit.BLOCKS.register(bus);
		ItemInit.ITEMS.register(bus);
		EntityInit.ENTITIES.register(bus);
		SoundsInit.SOUNDS.register(bus);
		
		GeckoLib.initialize();
	}
	
	private void setup(final FMLCommonSetupEvent event) { NetworkInit.init(); }
	
	public static final CreativeModeTab RCRELOADED_TAB = new CreativeModeTab("rcreloadedtab") { @Override public ItemStack makeIcon() { return ItemInit.BOLT_CRATE_ITEM.get().getDefaultInstance(); } };
	public static final CreativeModeTab RCRELOADED_WEAPONS_TAB = new CreativeModeTab("rcreloadedweaponstab") { @Override public ItemStack makeIcon() { return ItemInit.OMNIWRENCH12000.get().getDefaultInstance(); } };
}
