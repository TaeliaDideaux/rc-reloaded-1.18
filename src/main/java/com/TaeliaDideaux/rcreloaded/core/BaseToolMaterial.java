package com.TaeliaDideaux.rcreloaded.core;

import java.util.function.Supplier;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class BaseToolMaterial implements Tier {
	
	public final float attackDamageBonus, speed;
	public final int enchantability, harvestLevel, durability;
	public final Supplier<Ingredient> repairMaterial;
	
	public BaseToolMaterial(float attackDamageBonus, int enchantability, int harvestLevel, float speed, int durability, Supplier<Ingredient> repairMaterial) {
		this.attackDamageBonus = attackDamageBonus;
		this.enchantability = enchantability;
		this.harvestLevel = harvestLevel;
		this.speed = speed;
		this.durability = durability;
		this.repairMaterial = repairMaterial;
	}

	@Override public int getUses() 						{ return this.durability; }
	@Override public int getLevel() 					{ return this.harvestLevel; }
	@Override public float getSpeed()					{ return this.speed; }
	@Override public int getEnchantmentValue() 			{ return this.enchantability; }
	@Override public float getAttackDamageBonus() 		{ return this.attackDamageBonus; }
	@Override public Ingredient getRepairIngredient() 	{ return this.repairMaterial.get(); }
}
