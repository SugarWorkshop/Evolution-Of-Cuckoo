package com.github.mo_ink.eoc.entity;

import com.github.mo_ink.eoc.utils.EnumNPCLevel;
import com.github.mo_ink.eoc.utils.RandomCreator;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityOsIr extends EntityNPCBase {
    public EntityOsIr(World worldIn) {
        super(worldIn);
        this.setLevel(EnumNPCLevel.C);
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        this.entityDropItem(new ItemStack(Items.GOLD_INGOT, RandomCreator.randomTenth(4)), 0.3F);
        super.dropFewItems(wasRecentlyHit, lootingModifier);
    }

    @Override
    protected void setEquipmentBasedOnDifficulty() {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
    }
}