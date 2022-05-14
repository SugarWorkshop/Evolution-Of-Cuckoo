package com.github.sugarmgp.eoc.entity;

import com.github.sugarmgp.eoc.utils.EnumAttackType;
import com.github.sugarmgp.eoc.utils.EnumNPCLevel;
import com.github.sugarmgp.eoc.utils.RandomCreator;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityZijing extends EntityNPCBase {
    public EntityZijing(World worldIn) {
        super(worldIn, Items.BOW, EnumNPCLevel.A, EnumAttackType.Horse);
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        this.dropNPCItem(new ItemStack(Items.STICK, RandomCreator.randomTenth(4)));
        this.dropNPCItem(new ItemStack(Items.ARROW, RandomCreator.randomTenth(2)));
        super.dropFewItems(wasRecentlyHit, lootingModifier);
    }
}