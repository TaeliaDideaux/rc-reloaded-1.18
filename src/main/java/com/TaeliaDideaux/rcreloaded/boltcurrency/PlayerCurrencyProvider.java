package com.TaeliaDideaux.rcreloaded.boltcurrency;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.core.Direction;
import net.minecraft.nbt.IntTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

public class PlayerCurrencyProvider implements ICapabilitySerializable<IntTag> {
	
	private ICurrencyCapability holder;
	private final LazyOptional<ICurrencyCapability> lazyOptional = LazyOptional.of(() -> this.holder);
	
	public PlayerCurrencyProvider(ICurrencyCapability holder) {
		this.holder = holder;
	}
	
	@Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return CurrencyCapability.CURRENCY_CAPABILITY.orEmpty(cap, lazyOptional);
    }
	
	@Override
    public IntTag serializeNBT() {
        return IntTag.valueOf(this.holder.getBolts());
    }
	
	@Override
    public void deserializeNBT(IntTag nbt) {
        if (holder == null)
            throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");
        holder.setBolts(nbt.getAsInt());
    }
}