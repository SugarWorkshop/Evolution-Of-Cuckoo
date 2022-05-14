package com.github.sugarmgp.eoc.entity;

import com.github.sugarmgp.eoc.utils.EnumNPCLevel;
import com.github.sugarmgp.eoc.utils.RandomCreator;
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