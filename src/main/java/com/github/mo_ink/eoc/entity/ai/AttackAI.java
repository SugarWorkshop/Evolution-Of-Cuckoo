package com.github.mo_ink.eoc.entity.ai;

import com.github.mo_ink.eoc.entity.EntityNPCBase;
import com.google.common.base.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityHorse;

import javax.annotation.Nullable;

public class AttackAI { //整理实体AI
    EntityAINearestAttackableTarget aiAttackAllLiving;
    EntityAINearestAttackableTarget aiAttackMob;
    EntityAINearestAttackableTarget aiAttackMobAndHorse;
    EntityAINearestAttackableTarget aiAttackMobWithoutAlderman;
    EntityAINearestAttackableTarget aiAttackMobAndHorseWithoutAlderman;
    EntityAIAttackWithBow aiArrowAttack;
    EntityAIAttackMelee aiAttackOnCollide;

    public AttackAI(EntityNPCBase npcIn) {
        initAI(npcIn);
    }

    private void initAI(EntityNPCBase npcIn) {
        aiAttackAllLiving = new EntityAINearestAttackableTarget(npcIn, EntityLivingBase.class, 10, true, false, new Predicate<Entity>() {
            public boolean apply(@Nullable Entity entity) {
                return true;
            }
        });
        aiAttackMob = new EntityAINearestAttackableTarget(npcIn, EntityLiving.class, 10, true, false, new Predicate<Entity>() {
            public boolean apply(@Nullable Entity entity) {
                return entity instanceof IMob && !entity.isInvisible();
            }
        });
        aiAttackMobAndHorse = new EntityAINearestAttackableTarget(npcIn, EntityLiving.class, 10, true, false, new Predicate<Entity>() {
            public boolean apply(@Nullable Entity entity) {
                return (entity instanceof IMob || entity instanceof EntityHorse) && !entity.isInvisible();
            }
        });
        aiAttackMobWithoutAlderman = new EntityAINearestAttackableTarget(npcIn, EntityLiving.class, 10, true, false, new Predicate<Entity>() {
            public boolean apply(@Nullable Entity entity) {
                return entity instanceof IMob && !entity.isInvisible() && !(entity instanceof EntityEnderman);
            }
        });
        aiAttackMobAndHorseWithoutAlderman = new EntityAINearestAttackableTarget(npcIn, EntityLiving.class, 10, true, false, new Predicate<Entity>() {
            public boolean apply(@Nullable Entity entity) {
                return (entity instanceof IMob || entity instanceof EntityHorse) && !entity.isInvisible() && !(entity instanceof EntityEnderman);
            }
        });
        aiArrowAttack = new EntityAIAttackWithBow(npcIn, 0.12D, 16, 16.0F);
        aiAttackOnCollide = new EntityAIAttackMelee(npcIn, 0.62D, true) {
            public void resetTask() {
                super.resetTask();
                npcIn.setSwingingArms(false);
            }

            public void startExecuting() {
                super.startExecuting();
                npcIn.setSwingingArms(true);
            }
        };
    }

    public EntityAINearestAttackableTarget getAIAttackAllLiving() {
        return aiAttackAllLiving;
    }

    public EntityAINearestAttackableTarget getAIAttackMob() {
        return aiAttackMob;
    }

    public EntityAINearestAttackableTarget getAIAttackMobAndHorse() {
        return aiAttackMobAndHorse;
    }

    public EntityAINearestAttackableTarget getAIAttackMobWithoutAlderman() {
        return aiAttackMobWithoutAlderman;
    }

    public EntityAINearestAttackableTarget getAIAttackMobAndHorseWithoutAlderman() {
        return aiAttackMobAndHorseWithoutAlderman;
    }

    public EntityAIAttackWithBow getAIArrowAttack() {
        return aiArrowAttack;
    }

    public EntityAIAttackMelee getAIAttackOnCollide() {
        return aiAttackOnCollide;
    }
}
