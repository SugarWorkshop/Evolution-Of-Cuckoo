package com.github.mo_ink.eoc.items;

import com.github.mo_ink.eoc.EOC;
import com.github.mo_ink.eoc.EOCTab;
import net.minecraft.item.Item;

public class ItemCuckooIngot extends Item {
    public ItemCuckooIngot() {
        super();
        String name = "cuckoo_ingot";
        this.setRegistryName(name);
        this.setUnlocalizedName(EOC.MODID + "." + name);
        this.setMaxStackSize(64);
        this.setCreativeTab(EOCTab.EOC_TAB);
    }
}
