package com.github.mo_ink.eoc.items.armor;

import com.github.mo_ink.eoc.EOC;
import com.github.mo_ink.eoc.EOCTab;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemFunnyHelmet extends ItemFunnyArmorBase {
    public ItemFunnyHelmet() {
        super(EntityEquipmentSlot.HEAD);
        String name = "funny_helmet";
        this.setUnlocalizedName(EOC.MODID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(EOCTab.EOC_TAB);
        this.setMaxStackSize(1);
    }
}
