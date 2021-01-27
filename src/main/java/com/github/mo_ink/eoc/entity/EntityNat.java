package com.github.mo_ink.eoc.entity;

import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityNat extends EntityNPCBase {
    public EntityNat(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        ItemStack egg = new ItemStack(Items.SPAWN_EGG, 1);
        ItemMonsterPlacer.applyEntityIdToItemStack(egg, new ResourceLocation("eoc:entity.nat"));
        this.entityDropItem(new ItemStack(Items.STICK, (int) Math.round(Math.random() * 5)), 0.3F);
        this.entityDropItem(new ItemStack(Items.ARROW, (int) Math.round(Math.random() * 3)), 0.3F);
        super.dropFewItems(wasRecentlyHit, lootingModifier);
    }

    protected void setEquipmentBasedOnDifficulty() {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
    }
}