package com.github.mo_ink.eoc.entity;

import com.github.mo_ink.eoc.utils.EnumNPCLevel;
import com.github.mo_ink.eoc.utils.RandomCreator;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityZijing extends EntityNPCBase {
    public EntityZijing(World worldIn) {
        super(worldIn, Items.BOW, EnumNPCLevel.A, true);
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        this.entityDropItem(new ItemStack(Items.STICK, RandomCreator.randomTenth(5)), 0.3F);
        this.entityDropItem(new ItemStack(Items.ARROW, RandomCreator.randomTenth(3)), 0.3F);
        super.dropFewItems(wasRecentlyHit, lootingModifier);
    }
}