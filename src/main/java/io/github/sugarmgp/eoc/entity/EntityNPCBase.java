package io.github.sugarmgp.eoc.entity;

import io.github.sugarmgp.eoc.util.EnumNPCLevel;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class EntityNPCBase extends TameableEntity {
    private Item mainHandItem;
    private EnumNPCLevel enumNPCLevel;

    public EntityNPCBase(EntityType<? extends TameableEntity> typeIn, World worldIn, Item itemIn, EnumNPCLevel levelIn) {
        super(typeIn, worldIn);
        this.setTamed(false);
        this.setEnumNPCLevel(levelIn);
        this.setItem(itemIn);
        this.getAttributeManager().createInstanceIfAbsent(Attributes.MAX_HEALTH);
        this.getAttributeManager().createInstanceIfAbsent(Attributes.MOVEMENT_SPEED);
        this.getAttributeManager().createInstanceIfAbsent(Attributes.ATTACK_DAMAGE);
    }

    public static AttributeModifierMap.MutableAttribute createAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.7D)
                .createMutableAttribute(Attributes.MAX_HEALTH, 20.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0D);
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.65D, true));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 0.525D, 6F, 12F, true));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 0.315D));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, MobEntity.class, true));
        this.targetSelector.addGoal(5, new ResetAngerGoal(this, true));
    }

    protected void setEquipmentBased() {
        this.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(mainHandItem));
    }

    public Item getItem() {
        return mainHandItem;
    }

    protected void setItem(Item itemIn) {
        this.mainHandItem = itemIn;
        this.setEquipmentBased();
    }

    @Override
    protected int getExperiencePoints(PlayerEntity player) {
        return this.experienceValue + (int) (new Random().nextInt(10) / 9.0 * 5);
    }

    public EnumNPCLevel getEnumNPCLevel() {
        return this.enumNPCLevel;
    }

    protected void setEnumNPCLevel(EnumNPCLevel enumNPCLevel) {
        this.enumNPCLevel = enumNPCLevel;
        this.experienceValue = enumNPCLevel.getExperienceValue();
    }

    @Override
    public EntityNPCBase func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }
}
