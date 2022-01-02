package com.TaeliaDideaux.rcreloaded.core.init;

import com.TaeliaDideaux.rcreloaded.RatchetAndClankReloadedMod;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class NetworkInit {
	
	public static final String NETWORK_VERSION = "1.0.0";
	
	public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
			new ResourceLocation(RatchetAndClankReloadedMod.MODID, "network"),
			() -> NETWORK_VERSION, version -> version.equals(NETWORK_VERSION),
			version -> version.equals(NETWORK_VERSION));
	
	public static void init() {
		CHANNEL.registerMessage(0, CurrencyPacket.class, CurrencyPacket::encode, CurrencyPacket::decode, CurrencyPacket::handle);
	}
}