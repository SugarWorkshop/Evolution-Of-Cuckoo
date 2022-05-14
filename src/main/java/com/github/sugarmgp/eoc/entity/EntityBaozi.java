package com.github.sugarmgp.eoc.entity;

import com.github.sugarmgp.eoc.utils.EnumAttackType;
import com.github.sugarmgp.eoc.utils.EnumNPCLevel;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityBaozi extends EntityNPCBase {
    public EntityBaozi(World worldIn) {
        super(worldIn, Items.WOODEN_SWORD, EnumNPCLevel.D, EnumAttackType.All);
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        super.dropFewItems(wasRecentlyHit, lootingModifier);
    }
}