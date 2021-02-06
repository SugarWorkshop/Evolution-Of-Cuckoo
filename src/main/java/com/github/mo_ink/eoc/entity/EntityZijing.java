package com.github.mo_ink.eoc.entity;

import com.github.mo_ink.eoc.utils.EnumNPCLevel;
import com.github.mo_ink.eoc.utils.RandomCreator;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityZijing extends EntityNPCBase {
    public EntityZijing(World worldIn) {
        super(worldIn);
        this.setLevel(EnumNPCLevel.B);
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