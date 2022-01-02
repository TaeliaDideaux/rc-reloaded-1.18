package com.TaeliaDideaux.rcreloaded.core.world;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.TaeliaDideaux.rcreloaded.RatchetAndClankReloadedMod;
import com.TaeliaDideaux.rcreloaded.core.init.BlockInit;

import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.levelgen.GenerationStep.Decoration;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

public class OreGeneration {
	
	public static final List<PlacedFeature> OVERWORLD_ORES = new ArrayList<>();
	public static final List<PlacedFeature> NETHER_ORES = new ArrayList<>();
	
	public static void registerOres() {
		
		final ConfiguredFeature<?, ?> raritaniumOre = FeatureUtils.register("raritanium_ore",
				Feature.ORE.configured(new OreConfiguration(List.of(
						OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, BlockInit.RARITANIUM_ORE.get().defaultBlockState()),
						OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, BlockInit.DEEPSLATE_RARITANIUM_ORE.get().defaultBlockState())), 4)));
		final ConfiguredFeature<?, ?> adamantineOre = FeatureUtils.register("adamantine_ore",
				Feature.ORE.configured(new OreConfiguration(List.of(
						OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, BlockInit.ADAMANTINE_ORE.get().defaultBlockState())), 4)));
		
		final PlacedFeature placedRaritaniumOre = PlacementUtils.register("raritanium_ore", raritaniumOre.placed(
				HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(30)),InSquarePlacement.spread(), CountPlacement.of(4)));
		final PlacedFeature placedAdamantineOre = PlacementUtils.register("adamantine_ore", adamantineOre.placed(
				HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(15)), InSquarePlacement.spread(), CountPlacement.of(4)));

		OVERWORLD_ORES.add(placedRaritaniumOre);
		NETHER_ORES.add(placedAdamantineOre);
	}
	
	@Mod.EventBusSubscriber(modid = RatchetAndClankReloadedMod.MODID, bus = Bus.FORGE)
	public static class ForgeBusSubscriber {
		
		@SubscribeEvent
		public static void biomeLoading(BiomeLoadingEvent event) {
			List<Supplier<PlacedFeature>> features = event.getGeneration().getFeatures(Decoration.UNDERGROUND_ORES);
			switch (event.getCategory()) {
				case NETHER -> OreGeneration.NETHER_ORES.forEach(ore -> features.add(()->ore));
				default -> OreGeneration.OVERWORLD_ORES.forEach(ore -> features.add(()->ore));
			}
		}
	}
}
