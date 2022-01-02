package com.TaeliaDideaux.rcreloaded.common.entity;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class Clank extends TamableAnimal implements IAnimatable {

	private AnimationFactory factory = new AnimationFactory(this);

	public Clank(EntityType<Clank> entityType, Level level) {
        super(entityType, level);
        this.noCulling = true;
        this.setTame(true);
	}
	
	protected void registerGoals() {
	      this.goalSelector.addGoal(0, new FloatGoal(this));
	      this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
	      this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
	      this.goalSelector.addGoal(0, new FollowOwnerGoal(this, 1.0D, 10.0F, 2.0F, false));
	}
	
	public static AttributeSupplier.Builder createAttributes() {
	     return Mob.createMobAttributes()
	    		 .add(Attributes.MAX_HEALTH, 20.0D)
	    		 .add(Attributes.MOVEMENT_SPEED, 0.25D);
	}
	
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		if (event.isMoving()) { event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.clank.walk", true)); }
		else 				  { event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.clank.idle", true)); }
        
        return PlayState.CONTINUE;
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
	}

	@Override public AnimationFactory getFactory() { return this.factory; }
	@Override public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) { return null; }
}
