package com.github.sugarmgp.eoc.items;

import com.github.sugarmgp.eoc.EOC;
import com.github.sugarmgp.eoc.EOCTab;
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
