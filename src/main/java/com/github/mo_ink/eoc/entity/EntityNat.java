package com.github.mo_ink.eoc.entity;

import com.github.mo_ink.eoc.utils.RandomCreator;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityNat extends EntityNPCBase {
    public EntityNat(World worldIn) {
        super(worldIn);
        this.experienceValue *= 1.5;
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        this.entityDropItem(new ItemStack(Items.STICK, RandomCreator.randomTenth(5)), 0.3F);
        this.entityDropItem(new ItemStack(Items.ARROW, RandomCreator.randomTenth(3)), 0.3F);
        super.dropFewItems(wasRecentlyHit, lootingModifier);
    }

    protected void setEquipmentBasedOnDifficulty() {
        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
    }
}