package com.eli.trumpetskeleton.entity;

import com.eli.trumpetskeleton.TrumpetRegistry;
import com.eli.trumpetskeleton.entity.goal.TrumpetAttackGoal;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

public class TrumpetSkeletonEntity extends SkeletonEntity {

    public TrumpetSkeletonEntity(EntityType<? extends TrumpetSkeletonEntity> type, World worldIn) {
        super(type, worldIn);
        this.setActiveHand(Hand.MAIN_HAND);
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(TrumpetRegistry.TRUMPET_ITEM.get()));
        if (rand.nextFloat() > 0.7f) {
            this.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(TrumpetRegistry.TRUMPET_ITEM.get()));
        }
    }

    @Override
    public void registerGoals() {
        this.goalSelector.addGoal(1, new RestrictSunGoal(this));
        this.goalSelector.addGoal(3, new FleeSunGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, WolfEntity.class, 6.0f, 1.0D, 1.2D));
        this.goalSelector.addGoal(4, new TrumpetAttackGoal(this, 1.2D, 40, 12.0f, TrumpetRegistry.TRUMPET_DOOT));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 12.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolemEntity.class, true));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return TrumpetRegistry.SKELETON_DOOT.get();
    }

    @Override
    public void playAmbientSound() {
        if (!isAggressive()) {
            if (this.getAmbientSound() != null) {
                this.playSound(this.getAmbientSound(), 0.25f, 0.9f + rand.nextFloat() * 0.2f);
            }
        }
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(TrumpetRegistry.TRUMPET_SKELETON_SPAWN_EGG.get());
    }

    @Override
    @ParametersAreNonnullByDefault
    protected void setEquipmentBasedOnDifficulty(DifficultyInstance difficulty) {
        this.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.GOLDEN_HELMET));
    }
}
