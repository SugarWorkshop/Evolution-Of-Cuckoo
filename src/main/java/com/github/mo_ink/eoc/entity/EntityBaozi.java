package com.github.mo_ink.eoc.entity;

import com.github.mo_ink.eoc.utils.RandomCreator;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityBaozi extends EntityNPCBase {
    public EntityBaozi(World worldIn) {
        super(worldIn);
        this.experienceValue = 0;
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        this.entityDropItem(new ItemStack(Blocks.PLANKS, RandomCreator.randomTenth(7)), 0.3F);
        super.dropFewItems(wasRecentlyHit, lootingModifier);
    }

    @Override
    protected void setEquipmentBasedOnDifficulty() {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
    }
}