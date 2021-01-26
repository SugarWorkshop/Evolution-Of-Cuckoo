package com.github.mo_ink.eoc.entity;

import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityBaozi extends EntityNPCBase {
    public EntityBaozi(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        ItemStack egg = new ItemStack(Items.SPAWN_EGG, 1);
        ItemMonsterPlacer.applyEntityIdToItemStack(egg, new ResourceLocation("eoc:entity.baozi"));
        this.entityDropItem(egg, 0.0F);
        super.dropFewItems(wasRecentlyHit, lootingModifier);
    }

    @Override
    protected void setEquipmentBasedOnDifficulty() {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
    }
}