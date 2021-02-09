package com.github.mo_ink.eoc.entity;

import com.github.mo_ink.eoc.handler.ItemHandler;
import com.github.mo_ink.eoc.utils.EnumNPCLevel;
import com.github.mo_ink.eoc.utils.RandomCreator;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import java.util.Timer;
import java.util.TimerTask;

public class EntityMoInk extends EntityNPCBase {
    private static DataParameter<Byte> SPRINKLED = EntityDataManager.createKey(EntityMoInk.class, DataSerializers.BYTE);

    public EntityMoInk(World worldIn) {
        super(worldIn, ItemHandler.ITEM_CUCKOO_SWORD, EnumNPCLevel.A);
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        this.entityDropItem(new ItemStack(Items.DIAMOND, RandomCreator.randomTenth(1)), 0.3F);
        super.dropFewItems(wasRecentlyHit, lootingModifier);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        if (canSprinkle(player)) {
            if (!player.capabilities.isCreativeMode) {
                itemstack.shrink(1);
            }
            EntityMoInk thisIn = this;
            new Timer().schedule(new TimerTask() {
                private int count = 0;
                private float high = 0.15F;

                @Override
                public void run() {
                    if (count >= 16) {
                        this.cancel();
                        return;
                    }
                    if (!thisIn.world.isRemote) {
                        thisIn.world.getMinecraftServer().addScheduledTask(() -> {
                            thisIn.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 1.2F, 1.0F);
                            thisIn.entityDropItem(new ItemStack(Items.SUGAR, 1), 1.65F + high);
                            thisIn.world.playSound(null, thisIn.posX, thisIn.posY, thisIn.posZ, SoundEvents.ENTITY_FIREWORK_LAUNCH, SoundCategory.AMBIENT, 0.8F, 1.0F);
                        });
                    } else {
                        Minecraft.getMinecraft().addScheduledTask(() -> {
                            thisIn.playEffect(EnumParticleTypes.FIREWORKS_SPARK, thisIn.posX, thisIn.posY + high - 0.1F, thisIn.posZ, 8);
                        });
                    }
                    count++;
                    high += 0.08F;
                }
            }, 0, 250);
            setSprinkled((byte) 1);
            return true;
        }
        return super.processInteract(player, hand);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(SPRINKLED, (byte) 0);
    }

    public byte getSprinkled() {
        return this.getDataManager().get(SPRINKLED);
    }

    public boolean isSprinkled() {
        if (getSprinkled() == (byte) 0) {
            return false;
        }
        return true;
    }

    public void setSprinkled(byte b) {
        this.getDataManager().set(SPRINKLED, b);
    }

    public boolean canSprinkle(EntityPlayer player) {
        Item mainItem = player.getHeldItem(EnumHand.MAIN_HAND).getItem();
        Item offItem = player.getHeldItem(EnumHand.OFF_HAND).getItem();
        if (mainItem.equals(Items.SUGAR) && offItem.equals(ItemHandler.ITEM_FUNNY_INGOT) && player.isSneaking() && !this.isSprinkled() && this.isTamed())
            return true;
        return false;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setByte("Sprinkled", getSprinkled());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        setSprinkled(compound.getByte("Sprinkled"));
    }
}