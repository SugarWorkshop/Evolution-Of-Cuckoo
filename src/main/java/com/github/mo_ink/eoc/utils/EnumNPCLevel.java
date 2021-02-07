package com.github.mo_ink.eoc.utils;

import net.minecraft.client.resources.I18n;

public enum EnumNPCLevel {
    A("eoc.enum_npc_level.a", 25, 28.0D, 2.0D, 0.8D),
    B("eoc.enum_npc_level.b", 20, 24.0D, 1.5D, 0.75D),
    C("eoc.enum_npc_level.c", 15, 20.0D, 1.0D, 0.7D),
    D("eoc.enum_npc_level.d", 0, 14.0D, 0.5D, 0.55D);

    private final String descriptionTranslationKey;
    private final int experienceValue;
    private final double maxHealth;
    private final double attackDamage;
    private final double movementSpeed;

    EnumNPCLevel(String descriptionTranslationKey, int experienceValue, double maxHealth, double attackDamage, double movementSpeed) {
        this.descriptionTranslationKey = descriptionTranslationKey;
        this.experienceValue = experienceValue;
        this.maxHealth = maxHealth;
        this.attackDamage = attackDamage;
        this.movementSpeed = movementSpeed;
    }

    @Override
    public String toString() {
        return "EnumNPCLevel{" +
                "descriptionTranslationKey='" + this.descriptionTranslationKey + '\'' +
                '}';
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
}
