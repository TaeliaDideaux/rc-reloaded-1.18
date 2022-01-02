package com.TaeliaDideaux.rcreloaded.core.init;

import java.util.function.Supplier;

import com.TaeliaDideaux.rcreloaded.boltcurrency.CurrencyCapability;
import com.TaeliaDideaux.rcreloaded.boltcurrency.ICurrencyCapability;

import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

public class CurrencyPacket {
	
private final int bolts;
	
	public CurrencyPacket(int currency) {
		this.bolts = currency;
	}
	
	public CurrencyPacket(ICurrencyCapability instance) {
		this.bolts = instance.getBolts(); }
	
	public static void encode(CurrencyPacket packet, FriendlyByteBuf buffer) {
		buffer.writeInt(packet.bolts);
	}
	
	public static CurrencyPacket decode(FriendlyByteBuf buffer) {
		return new CurrencyPacket(buffer.readInt());
	}
	
	@SuppressWarnings("resource")
	public static void handle(CurrencyPacket packet, Supplier<NetworkEvent.Context> contextSupplier){
        NetworkEvent.Context context = contextSupplier.get();
        if(context.getDirection().getReceptionSide() == LogicalSide.CLIENT){
            context.enqueueWork(() -> {
                if (Minecraft.getInstance().player != null) {
                    Minecraft.getInstance().player.getCapability(CurrencyCapability.CURRENCY_CAPABILITY)
                            .ifPresent(capa -> capa.setBolts(packet.bolts));
                }
            });
        }
        context.setPacketHandled(true);
    }
}