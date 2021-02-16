package com.github.mo_ink.eoc.items;

import com.github.mo_ink.eoc.EOC;
import com.github.mo_ink.eoc.EOCTab;
import net.minecraft.item.Item;

public class ItemFunnyPlate extends Item {
    public ItemFunnyPlate() {
        super();
        String name = "funny_plate";
        this.setRegistryName(name);
        this.setUnlocalizedName(EOC.MODID + "." + name);
        this.setMaxStackSize(64);
        this.setCreativeTab(EOCTab.EOC_TAB);
    }
}
