package io.github.sugarmgp.eoc.entity;

import io.github.sugarmgp.eoc.util.EnumNPCLevel;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class EntitySugarMGP extends EntityNPCBase {
    public EntitySugarMGP(EntityType<? extends TameableEntity> typeIn, World worldIn) {
        super(typeIn, worldIn, Items.DIAMOND_SWORD, EnumNPCLevel.A);
    }
}
