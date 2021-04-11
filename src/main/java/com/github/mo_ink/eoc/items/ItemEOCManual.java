package com.github.mo_ink.eoc.items;

import com.github.mo_ink.eoc.EOC;
import com.github.mo_ink.eoc.EOCTab;
import net.minecraft.item.Item;

public class ItemEOCManual extends Item {
    public ItemEOCManual() {
        super();
        String name = "eoc_manual";
        this.setRegistryName(name);
        this.setUnlocalizedName(EOC.MODID + "." + name);
        this.setMaxStackSize(1);
        this.setCreativeTab(EOCTab.EOC_TAB);
    }
}
