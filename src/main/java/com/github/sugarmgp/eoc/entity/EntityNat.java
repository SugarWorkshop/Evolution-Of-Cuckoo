package com.github.sugarmgp.eoc.entity;

import com.github.sugarmgp.eoc.utils.EnumNPCLevel;
import com.github.sugarmgp.eoc.utils.RandomCreator;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityNat extends EntityNPCBase {
    public EntityNat(World worldIn) {
        super(worldIn, Items.STONE_SWORD, EnumNPCLevel.C);
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        this.dropNPCItem(new ItemStack(Blocks.COBBLESTONE, RandomCreator.randomTenth(5)));
        super.dropFewItems(wasRecentlyHit, lootingModifier);
    }
}