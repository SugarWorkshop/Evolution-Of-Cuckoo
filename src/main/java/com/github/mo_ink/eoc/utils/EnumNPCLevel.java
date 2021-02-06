package com.github.mo_ink.eoc.utils;

import net.minecraft.client.resources.I18n;

public enum EnumNPCLevel {
    A("eoc.enum_npc_level.a", 25),
    B("eoc.enum_npc_level.b", 20),
    C("eoc.enum_npc_level.c", 15),
    D("eoc.enum_npc_level.d", 10),
    SSSSS("eoc.enum_npc_level.sssss", 100000000);

    private final String descriptionTranslationKey;
    private final int experienceValue;

    EnumNPCLevel(String descriptionTranslationKey, int experienceValue) {
        this.descriptionTranslationKey = descriptionTranslationKey;
        this.experienceValue = experienceValue;
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
}
