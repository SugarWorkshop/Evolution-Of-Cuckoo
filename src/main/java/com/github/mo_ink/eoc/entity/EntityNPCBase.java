package com.github.mo_ink.eoc.entity;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntitySpectralArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

import static com.github.mo_ink.eoc.handler.ItemHandler.ITEM_FUNNY_APPLE;

public abstract class EntityNPCBase extends EntityTameable implements IRangedAttackMob {
    private static final DataParameter<Boolean> SWINGING_ARMS = EntityDataManager.<Boolean>createKey(EntityNPCBase.class, DataSerializers.BOOLEAN);
    private final EntityAIAttackRanged aiArrowAttack = new EntityAIAttackRanged(this, 0.3D, 16, 16.0F);
    private final EntityAIAttackMelee aiAttackOnCollide = new EntityAIAttackMelee(this, 0.65D, false) {
        public void resetTask() {
            super.resetTask();
            EntityNPCBase.this.setSwingingArms(false);
        }

        public void startExecuting() {
            super.startExecuting();
            EntityNPCBase.this.setSwingingArms(true);
        }
    };

    public EntityNPCBase(World worldIn) {
        super(worldIn);
        setTamed(false);
        setSize(0.6F, 1.8F);
        setEquipmentBasedOnDifficulty();
        this.setCombatTask();
    }

    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(SWINGING_ARMS, Boolean.valueOf(false));
    }

    protected abstract void setEquipmentBasedOnDifficulty();

    public void onLivingUpdate() {
        this.updateArmSwingProgress();
        super.onLivingUpdate();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.0D);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
//        this.tasks.addTask(1, new EntityAIAttackMelee(this, 0.65D, true));
//        this.tasks.addTask(1, new EntityAIAttackRanged(this, 0.25D, 15, 15.0F));
        this.tasks.addTask(2, new EntityAIFollowOwner(this, 0.55D, 10.0F, 3.5F));
        this.tasks.addTask(3, new EntityAIWanderAvoidWater(this, 0.45D));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityLiving.class, 10.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(0, new EntityAIOwnerHurtByTarget(this));
        this.targetTasks.addTask(1, new EntityAIOwnerHurtTarget(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityLiving.class, 10, true, false, IMob.MOB_SELECTOR));
        super.initEntityAI();
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) ((int) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));

        if (flag) {
            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    public void setAttackTarget(@Nullable EntityLivingBase entitylivingbaseIn) {
        super.setAttackTarget(entitylivingbaseIn);
    }

    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (this.isTamed()) {
            if (!itemstack.isEmpty()) {
                if (itemstack.getItem() instanceof ItemFood) {
                    ItemFood itemfood = (ItemFood) itemstack.getItem();

                    if (itemfood.equals(ITEM_FUNNY_APPLE)) {
                        if (!player.capabilities.isCreativeMode) {
                            itemstack.shrink(1);
                        }
                        this.heal((float) itemfood.getHealAmount(itemstack));
                        return true;
                    }
                }
            }
        } else if (itemstack.getItem().equals(ITEM_FUNNY_APPLE) || itemstack.getItem().equals(Items.APPLE)) {
            if (!player.capabilities.isCreativeMode) {
                itemstack.shrink(1);
            }

            if (!this.world.isRemote) {
                if (!net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.setTamedBy(player);
                    this.playTameEffect(true);
                    this.setAttackTarget((EntityLivingBase) null);
                }
            }
            return true;
        }
        return super.processInteract(player, hand);
    }

    @Nullable
    @Override
    public EntityAgeable createChild(EntityAgeable ageable) {
        return null;
    }

    public void attackEntityWithRangedAttack(EntityLivingBase target, float distanceFactor) {
        EntityArrow entityarrow = this.getArrow(distanceFactor);
        if (this.getHeldItemMainhand().getItem() instanceof net.minecraft.item.ItemBow)
            entityarrow = ((net.minecraft.item.ItemBow) this.getHeldItemMainhand().getItem()).customizeArrow(entityarrow);
        double d0 = target.posX - this.posX;
        double d1 = target.getEntityBoundingBox().minY + (double) (target.height / 3.0F) - entityarrow.posY;
        double d2 = target.posZ - this.posZ;
        double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
        entityarrow.shoot(d0, d1 + d3 * 0.20000000298023224D, d2, 1.6F, 6);
        this.playSound(SoundEvents.ENTITY_SKELETON_SHOOT, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
        this.world.spawnEntity(entityarrow);
    }

    protected EntityArrow getArrow(float f) {
        ItemStack itemstack = this.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);

        if (itemstack.getItem() == Items.SPECTRAL_ARROW) {
            EntitySpectralArrow entityspectralarrow = new EntitySpectralArrow(this.world, this);
            entityspectralarrow.setEnchantmentEffectsFromEntity(this, f);
            return entityspectralarrow;
        } else {
            EntityArrow entityarrow = new EntityTippedArrow(this.world, this);
            entityarrow.setEnchantmentEffectsFromEntity(this, f);

            if (itemstack.getItem() == Items.TIPPED_ARROW && entityarrow instanceof EntityTippedArrow) {
                ((EntityTippedArrow) entityarrow).setPotionEffect(itemstack);
            }
            return entityarrow;
        }
    }

    public void setCombatTask() {
        if (this.world != null && !this.world.isRemote) {
            this.tasks.removeTask(this.aiAttackOnCollide);
            this.tasks.removeTask(this.aiArrowAttack);
            ItemStack itemstack = this.getHeldItemMainhand();
            if (itemstack.getItem() instanceof net.minecraft.item.ItemBow) {
                this.tasks.addTask(1, this.aiArrowAttack);
            } else {
                this.tasks.addTask(1, this.aiAttackOnCollide);
            }
        }
    }

    public void setItemStackToSlot(EntityEquipmentSlot slotIn, ItemStack stack) {
        super.setItemStackToSlot(slotIn, stack);

        if (!this.world.isRemote && slotIn == EntityEquipmentSlot.MAINHAND) {
            this.setCombatTask();
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean isSwingingArms() {
        return ((Boolean) this.dataManager.get(SWINGING_ARMS)).booleanValue();
    }

    public void setSwingingArms(boolean swingingArms) {
        this.dataManager.set(SWINGING_ARMS, Boolean.valueOf(swingingArms));
    }

    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        livingdata = super.onInitialSpawn(difficulty, livingdata);
        this.setEquipmentBasedOnDifficulty(difficulty);
        this.setEnchantmentBasedOnDifficulty(difficulty);
        this.setCombatTask();
        this.setCanPickUpLoot(this.rand.nextFloat() < 0.55F * difficulty.getClampedAdditionalDifficulty());
        return livingdata;
    }

    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setCombatTask();
    }
}