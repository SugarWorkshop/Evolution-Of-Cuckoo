package com.github.sugarmgp.eoc.items.tools;

import com.github.sugarmgp.eoc.EOC;
import com.github.sugarmgp.eoc.EOCTab;
import com.github.sugarmgp.eoc.utils.ToolMaterials;
import net.minecraft.item.ItemHoe;

public class ItemCuckooHoe extends ItemHoe implements ICuckooTools {
    public ItemCuckooHoe() {
        super(ToolMaterials.CUCKOO);
        String name = "cuckoo_hoe";
        this.setUnlocalizedName(EOC.MODID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(EOCTab.EOC_TAB);
        this.setMaxStackSize(1);
    }
}
