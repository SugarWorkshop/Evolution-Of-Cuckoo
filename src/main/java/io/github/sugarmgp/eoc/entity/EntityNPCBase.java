package io.github.sugarmgp.eoc.entity;

import com.google.common.base.Predicate;
import io.github.sugarmgp.eoc.handler.ItemHandler;
import io.github.sugarmgp.eoc.util.EnumNPCLevel;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;
import java.util.Random;

public class EntityNPCBase extends TameableEntity {
    private Item mainHandItem;
    private EnumNPCLevel enumNPCLevel;

    public EntityNPCBase(EntityType<? extends TameableEntity> typeIn, World worldIn, Item itemIn, EnumNPCLevel levelIn) {
        super(typeIn, worldIn);
        this.setTamed(false);
        this.setEnumNPCLevel(levelIn);
        this.setItem(itemIn);
        this.changeAttributes();
    }

    public static AttributeModifierMap.MutableAttribute createDefaultAttributes() {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.7D)
                .createMutableAttribute(Attributes.MAX_HEALTH, 30.0D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 1.0D);
    }

    protected void changeAttributes() {
        this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(this.getEnumNPCLevel().getMaxHealth());
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(this.getEnumNPCLevel().getAttackDamage());
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(this.getEnumNPCLevel().getMovementSpeed());
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.65D, true));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 0.525D, 6F, 12F, true));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomWalkingGoal(this, 0.31D));
        this.goalSelector.addGoal(5, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, new OwnerHurtTargetGoal(this));
        this.targetSelector.addGoal(2, new OwnerHurtByTargetGoal(this));
        this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setCallsForHelp());
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, LivingEntity.class, 10, true, false, new Predicate<LivingEntity>() {
            public boolean apply(@Nullable LivingEntity entity) {
                return entity instanceof IMob && !entity.isInvisible();
            }
        }));
        this.targetSelector.addGoal(5, new ResetAngerGoal(this, true));
    }

    @Override
    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getHeldItem(hand);
        Item item = itemStack.getItem();
        if (item.equals(ItemHandler.itemFunnyApple.get())) {
            if (this.isTamed()) {
                if (this.getHealth() < this.getMaxHealth()) {
                    if (!player.isCreative()) {
                        itemStack.shrink(1);
                    }
                    int heal = item.getFood().getHealing();
                    this.heal(heal);
                    this.playEffect(ParticleTypes.HEART, this.getPosX(), this.getPosY() + 0.05, this.getPosZ(), heal);
                }
            } else {
                if (!player.isCreative()) {
                    itemStack.shrink(1);
                }
                if (!net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    if (!this.world.isRemote) {
                        this.setTamedBy(player);
                        this.setAttackTarget(null);
                    } else {
                        this.playEffect(ParticleTypes.HAPPY_VILLAGER, this.getPosX(), this.getPosY() + 0.08F, this.getPosZ(), 10);
                    }
                }
            }
        }
        return super.func_230254_b_(player, hand);
    }

    protected void playEffect(BasicParticleType particleTypes, Double posX, Double posY, Double posZ, int times) {
        for (int i = 1; i <= times; ++i) {
            double d0 = this.rand.nextGaussian() * 0.015D;
            double d1 = this.rand.nextGaussian() * 0.015D;
            double d2 = this.rand.nextGaussian() * 0.015D;
            this.world.addParticle(particleTypes,
                    posX + this.rand.nextDouble() * this.getWidth() * 1.5 - this.getWidth(),
                    posY + 0.4 + this.rand.nextDouble() * this.getHeight(),
                    posZ + this.rand.nextDouble() * this.getWidth() * 1.5 - this.getWidth(),
                    d0, d1, d2
            );
        }
    }

    public boolean shouldAttackEntity(LivingEntity target, LivingEntity owner) {
        if (!(target instanceof CreeperEntity) && !(target instanceof GhastEntity)) {
            if (target instanceof EntityNPCBase) {
                EntityNPCBase entity = (EntityNPCBase) target;
                return !entity.isTamed() || entity.getOwner() != owner;
            } else if (target instanceof PlayerEntity && owner instanceof PlayerEntity && !((PlayerEntity) owner).canAttackPlayer((PlayerEntity) target)) {
                return false;
            } else if (target instanceof AbstractHorseEntity && ((AbstractHorseEntity) target).isTame()) {
                return false;
            } else {
                return !(target instanceof TameableEntity) || !((TameableEntity) target).isTamed();
            }
        } else {
            return false;
        }
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
