package com.TaeliaDideaux.rcreloaded.boltcurrency;

import com.TaeliaDideaux.rcreloaded.RatchetAndClankReloadedMod;
import com.TaeliaDideaux.rcreloaded.core.init.CurrencyPacket;
import com.TaeliaDideaux.rcreloaded.core.init.NetworkInit;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerChangedDimensionEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.PlayerRespawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.network.PacketDistributor;

public class PlayerCurrencyStorage extends CurrencyStorage {
	
	private final ServerPlayer player;
	
	public PlayerCurrencyStorage(ServerPlayer player) { this.player = player; }
	
	@Override
	public void setBolts(int value) {
		super.setBolts(value);
		this.sync();
	}

	@Override
	public void addBolts(int value) {
		this.setBolts(this.getBolts() + value);
		this.sync();
	}

	@Override
	public void useBolts(int value) {
		this.setBolts(this.getBolts() - value);
		this.sync();
	}	

	public void sync() {
		if(player.connection != null) {
			player.getCapability(CurrencyCapability.CURRENCY_CAPABILITY).ifPresent(capability -> NetworkInit.CHANNEL.send( PacketDistributor.PLAYER.with(()-> this.player), new CurrencyPacket(capability) ));
		}
	}
	
	
	@Mod.EventBusSubscriber(modid = RatchetAndClankReloadedMod.MODID, bus = Bus.FORGE)
    public static class ForgeBusSubscriber {
    	
        @SubscribeEvent
        public static void loginEvent(PlayerLoggedInEvent event) {
        	PlayerCurrencyStorage storage = new PlayerCurrencyStorage((ServerPlayer)event.getPlayer());
        	storage.sync();
        }
        
        
        @SubscribeEvent
        public static void respawnEvent(PlayerRespawnEvent event) {
        	PlayerCurrencyStorage storage = new PlayerCurrencyStorage((ServerPlayer)event.getPlayer());
        	storage.sync();
        }
        
        
        @SubscribeEvent
        public static void dimensionEvent(PlayerChangedDimensionEvent event) {
        	PlayerCurrencyStorage storage = new PlayerCurrencyStorage((ServerPlayer)event.getPlayer());
        	storage.sync();
        }
    }
}