package com.github.mo_ink.eoc.entity;

import com.github.mo_ink.eoc.utils.EnumNPCLevel;
import com.github.mo_ink.eoc.utils.RandomCreator;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntitySmalldew extends EntityNPCBase {
    public EntitySmalldew(World worldIn) {
        super(worldIn, Items.IRON_SWORD, EnumNPCLevel.B);
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        this.dropNPCItem(new ItemStack(Items.IRON_INGOT, RandomCreator.randomTenth(2)));
        super.dropFewItems(wasRecentlyHit, lootingModifier);
    }
}