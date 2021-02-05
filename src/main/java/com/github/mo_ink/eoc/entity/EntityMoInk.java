package com.github.mo_ink.eoc.entity;

import com.github.mo_ink.eoc.handler.ItemHandler;
import com.github.mo_ink.eoc.utils.RandomCreator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class EntityMoInk extends EntityNPCBase {
    private static DataParameter<Byte> SPRINKLED = EntityDataManager.createKey(EntityMoInk.class, DataSerializers.BYTE);

    public EntityMoInk(World worldIn) {
        super(worldIn);
        this.experienceValue *= 2.5;
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        this.entityDropItem(new ItemStack(Items.DIAMOND, RandomCreator.randomTenth(1)), 0.3F);
        super.dropFewItems(wasRecentlyHit, lootingModifier);
    }

    @Override
    protected void setEquipmentBasedOnDifficulty() {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        if (canSprinkle(player)) {
            if (!player.capabilities.isCreativeMode) {
                itemstack.shrink(1);
            }
            for (int i = 1; i <= 16; i++) {
                this.entityDropItem(new ItemStack(Items.SUGAR, 1), 1.5F);
                this.playSound(SoundEvents.ENTITY_ITEM_PICKUP, 0.25F, 1.0F);
            }
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
        if (mainItem.equals(Items.SUGAR) && offItem.equals(ItemHandler.ITEM_FUNNY_INGOT) && player.isSneaking() && !isSprinkled())
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