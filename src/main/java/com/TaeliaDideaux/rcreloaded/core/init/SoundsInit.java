package com.TaeliaDideaux.rcreloaded.core.init;

import com.TaeliaDideaux.rcreloaded.RatchetAndClankReloadedMod;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SoundsInit {

	private SoundsInit() {}

	public static final DeferredRegister<SoundEvent> 	SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, RatchetAndClankReloadedMod.MODID);
	public static final RegistryObject<SoundEvent> 		BOLT_CRATE_BREAKING = SOUNDS.register("block.bolt_crate.break", () -> new SoundEvent(new ResourceLocation(RatchetAndClankReloadedMod.MODID, "block.bolt_crate.break")));
	
	public static final Lazy<SoundEvent> 				BLARG_STATION_LAZY = Lazy.of(() -> new SoundEvent(new ResourceLocation(RatchetAndClankReloadedMod.MODID, "item.blarg_station_disc")));
	public static final Lazy<SoundEvent> 				EUDORA_CLIFFS_LAZY = Lazy.of(() -> new SoundEvent(new ResourceLocation(RatchetAndClankReloadedMod.MODID, "item.eudora_cliffs_disc")));
	public static final Lazy<SoundEvent> 				KERWAN_FITNESS_LAZY = Lazy.of(() -> new SoundEvent(new ResourceLocation(RatchetAndClankReloadedMod.MODID, "item.kerwan_fitness_disc")));
	public static final Lazy<SoundEvent> 				KERWAN_METROPOLIS_LAZY = Lazy.of(() -> new SoundEvent(new ResourceLocation(RatchetAndClankReloadedMod.MODID, "item.kerwan_metropolis_disc")));
	public static final Lazy<SoundEvent> 				NOVALIS_TOBRUK_LAZY = Lazy.of(() -> new SoundEvent(new ResourceLocation(RatchetAndClankReloadedMod.MODID, "item.novalis_tobruk_disc")));
	public static final Lazy<SoundEvent> 				VELDIN_KYZIL_LAZY = Lazy.of(() -> new SoundEvent(new ResourceLocation(RatchetAndClankReloadedMod.MODID, "item.veldin_kyzil_disc")));
	
	public final RegistryObject<SoundEvent> 			BLARG_STATION_DISC = SOUNDS.register("item.blarg_station_disc.disc", BLARG_STATION_LAZY);
	public final RegistryObject<SoundEvent> 			EUDORA_CLIFFS_DISC = SOUNDS.register("item.eudora_cliffs_disc.disc", EUDORA_CLIFFS_LAZY);
	public final RegistryObject<SoundEvent> 			KERWAN_FITNESS_DISC = SOUNDS.register("item.kerwan_fitness_disc.disc", KERWAN_FITNESS_LAZY);
	public final RegistryObject<SoundEvent> 			KERWAN_METROPOLIS_DISC = SOUNDS.register("item.kerwan_metropolis_disc.disc", KERWAN_METROPOLIS_LAZY);
	public final RegistryObject<SoundEvent> 			NOVALIS_TOBRUK_DISC = SOUNDS.register("item.novalis_tobruk_disc.disc", NOVALIS_TOBRUK_LAZY);
	public final RegistryObject<SoundEvent> 			VELDIN_KYZIL_DISC = SOUNDS.register("item.veldin_kyzil_disc.disc", VELDIN_KYZIL_LAZY);
}
