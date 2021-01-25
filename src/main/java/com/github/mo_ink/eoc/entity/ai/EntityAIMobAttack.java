package com.github.mo_ink.eoc.entity.ai;

import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.monster.EntityMob;

public class EntityAIMobAttack extends EntityAIAttackMelee {
    private final EntityMob mob;

    public EntityAIMobAttack(EntityMob mobIn, double speedIn, boolean longMemoryIn) {
        super(mobIn, speedIn, longMemoryIn);
        this.mob = mobIn;
    }

    public void startExecuting() {
        super.startExecuting();
    }

    public void resetTask() {
        super.resetTask();
    }

    public void updateTask() {
        super.updateTask();
    }
}
