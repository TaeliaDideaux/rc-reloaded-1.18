package com.TaeliaDideaux.rcreloaded.core.init;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import com.TaeliaDideaux.rcreloaded.RatchetAndClankReloadedMod;
import com.TaeliaDideaux.rcreloaded.common.block.AdamantineOreBlock;
import com.TaeliaDideaux.rcreloaded.common.block.RaritaniumOreBlock;

public class BlockInit {
	
	private BlockInit() {}
	
	public static final ForgeSoundType 						BOLT_CRATE_SOUND_TYPE = new ForgeSoundType(1.0F, 1.0F,
			() -> SoundsInit.BOLT_CRATE_BREAKING.get(),
			() -> SoundEvents.WOOD_STEP,
			() -> SoundEvents.WOOD_PLACE,
			() -> SoundEvents.WOOD_HIT,
			() -> SoundEvents.WOOD_FALL);
	
	public static final DeferredRegister<Block> 			BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, RatchetAndClankReloadedMod.MODID);

	
	public static final RegistryObject<Block> 				BOLT_CRATE = BLOCKS.register("bolt_crate", () -> new FallingBlock(BlockBehaviour.Properties.of(Material.WOOD).instabreak().sound(BOLT_CRATE_SOUND_TYPE)));
	
	public static final RegistryObject<RaritaniumOreBlock> 	RARITANIUM_ORE = BLOCKS.register("raritanium_ore", () -> new RaritaniumOreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F).requiresCorrectToolForDrops()));
	public static final RegistryObject<RaritaniumOreBlock> 	DEEPSLATE_RARITANIUM_ORE = BLOCKS.register("deepslate_raritanium_ore", () -> new RaritaniumOreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.5F).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
	public static final RegistryObject<AdamantineOreBlock> 	ADAMANTINE_ORE = BLOCKS.register("adamantine_ore", () -> new AdamantineOreBlock(BlockBehaviour.Properties.of(Material.METAL).strength(5.5F).requiresCorrectToolForDrops().sound(SoundType.ANCIENT_DEBRIS)));
	
	public static final RegistryObject<Block> 				RARITANIUM_BLOCK = BLOCKS.register("raritanium_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(4.5F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	public static final RegistryObject<Block> 				ADAMANTINE_BLOCK = BLOCKS.register("adamantine_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(4.5F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
	

}
