package com.github.mo_ink.eoc.entity;

import com.github.mo_ink.eoc.utils.EnumNPCLevel;
import com.github.mo_ink.eoc.utils.RandomCreator;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityBaozi extends EntityNPCBase {
    public EntityBaozi(World worldIn) {
        super(worldIn, Items.WOODEN_SWORD, EnumNPCLevel.D);
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        this.dropNPCItem(new ItemStack(Blocks.PLANKS, RandomCreator.randomTenth(7)));
        super.dropFewItems(wasRecentlyHit, lootingModifier);
    }
}