package com.github.mo_ink.eoc.items.tools;

import com.github.mo_ink.eoc.EOC;
import com.github.mo_ink.eoc.EOCTab;
import com.github.mo_ink.eoc.utils.ToolMaterials;
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
