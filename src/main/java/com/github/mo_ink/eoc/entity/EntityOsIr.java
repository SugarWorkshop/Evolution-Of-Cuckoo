package com.github.mo_ink.eoc.entity;

import com.github.mo_ink.eoc.utils.EnumNPCLevel;
import com.github.mo_ink.eoc.utils.RandomCreator;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityOsIr extends EntityNPCBase {
    public EntityOsIr(World worldIn) {
        super(worldIn, Items.GOLDEN_SWORD, EnumNPCLevel.C);
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        this.dropNPCItem(new ItemStack(Items.GOLD_INGOT, RandomCreator.randomTenth(4)));
        super.dropFewItems(wasRecentlyHit, lootingModifier);
    }
}