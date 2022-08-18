package io.github.sugarmgp.eoc.util;

import net.minecraft.client.resources.I18n;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;

public enum EnumNPCLevel {
    A("eoc.npc_level.a", 25, 28.0D, 2.0D, 0.8D, ParticleTypes.INSTANT_EFFECT, 3, 2),
    B("eoc.npc_level.b", 20, 24.0D, 1.5D, 0.75D, ParticleTypes.FLAME, 2, 1),
    C("eoc.npc_level.c", 15, 20.0D, 1.0D, 0.7D, ParticleTypes.CLOUD, 1, 0);

    private final String descriptionTranslationKey;
    private final int experienceValue;
    private final double maxHealth;
    private final double attackDamage;
    private final double movementSpeed;
    private final BasicParticleType particleType;
    private final int particleTimes;

    private final int regenerationLevel;

    EnumNPCLevel(String descriptionTranslationKey, int experienceValue, double maxHealth, double attackDamage, double movementSpeed, BasicParticleType particleType, int particleTimes, int regenerationLevel) {
        this.descriptionTranslationKey = descriptionTranslationKey;
        this.experienceValue = experienceValue;
        this.maxHealth = maxHealth;
        this.attackDamage = attackDamage;
        this.movementSpeed = movementSpeed;
        this.particleType = particleType;
        this.particleTimes = particleTimes;
        this.regenerationLevel = regenerationLevel;
    }

    public String getDisplayName() {
        return I18n.format(this.descriptionTranslationKey);
    }

    public int getExperienceValue() {
        return this.experienceValue;
    }

    public double getAttackDamage() {
        return this.attackDamage;
    }

    public double getMovementSpeed() {
        return this.movementSpeed;
    }

    public double getMaxHealth() {
        return this.maxHealth;
    }

    public BasicParticleType getParticleType() {
        return this.particleType;
    }

    public int getParticleTimes() {
        return this.particleTimes;
    }

    public int getRegenerationLevel() {
        return this.regenerationLevel;
    }
}
