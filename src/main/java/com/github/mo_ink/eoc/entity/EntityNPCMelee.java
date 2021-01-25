package com.github.mo_ink.eoc.entity;

import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.world.World;

public abstract class EntityNPCMelee extends EntityNPCBase {
    public EntityNPCMelee(World worldIn) {
        super(worldIn);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAIAttackMelee(this, 0.65D, true));
        super.initEntityAI();
    }
}
