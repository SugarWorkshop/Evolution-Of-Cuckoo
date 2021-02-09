package com.github.mo_ink.eoc.items.armor;

import com.github.mo_ink.eoc.EOC;
import com.github.mo_ink.eoc.EOCTab;
import net.minecraft.inventory.EntityEquipmentSlot;

public class ItemFunnyBoots extends ItemFunnyArmorBase {
    public ItemFunnyBoots() {
        super(EntityEquipmentSlot.FEET);
        String name = "funny_boots";
        this.setUnlocalizedName(EOC.MODID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(EOCTab.EOC_TAB);
        this.setMaxStackSize(1);
    }
}
