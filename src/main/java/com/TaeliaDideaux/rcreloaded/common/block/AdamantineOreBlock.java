package com.TaeliaDideaux.rcreloaded.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;

public class AdamantineOreBlock extends OreBlock {
	
	private final UniformInt xpRange;

	public AdamantineOreBlock(Properties properties) {
		super(properties);
	    this.xpRange = UniformInt.of(7, 12);
	}
	
	@Override public int getExpDrop(BlockState state, LevelReader world, BlockPos pos, int fortune, int silktouch) { return silktouch == 0 ? this.xpRange.sample(RANDOM) : 0; }
}