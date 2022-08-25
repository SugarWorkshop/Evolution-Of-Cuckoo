package io.github.sugarmgp.eoc.util;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;

public enum EnumNPCLevel {
    A("eoc.npc_level.a", 25, 28.0D, 2.0D, 0.8D, ParticleTypes.FLAME, 2, Items.DIAMOND_SWORD, Items.DIAMOND_BOOTS),
    B("eoc.npc_level.b", 20, 24.0D, 1.5D, 0.75D, ParticleTypes.INSTANT_EFFECT, 1, Items.IRON_SWORD, Items.IRON_BOOTS),
    C("eoc.npc_level.c", 15, 20.0D, 1.0D, 0.7D, ParticleTypes.SMOKE, 0, Items.STONE_SWORD, Items.CHAINMAIL_BOOTS);

    private final String descriptionTranslationKey;
    private final int experienceValue;
    private final double maxHealth;
    private final double attackDamage;
    private final double movementSpeed;
    private final BasicParticleType particleType;
    private final int regenerationLevel;
    private final Item hand;
    private final Item feet;

    EnumNPCLevel(String descriptionTranslationKey, int experienceValue, double maxHealth, double attackDamage, double movementSpeed, BasicParticleType particleType, int regenerationLevel, Item hand, Item feet) {
        this.descriptionTranslationKey = descriptionTranslationKey;
        this.experienceValue = experienceValue;
        this.maxHealth = maxHealth;
        this.attackDamage = attackDamage;
        this.movementSpeed = movementSpeed;
        this.particleType = particleType;
        this.regenerationLevel = regenerationLevel;
        this.hand = hand;
        this.feet = feet;
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

    public int getRegenerationLevel() {
        return this.regenerationLevel;
    }

    public Item getHand() {
        return this.hand;
    }

    public Item getFeet() {
        return this.feet;
    }

}
