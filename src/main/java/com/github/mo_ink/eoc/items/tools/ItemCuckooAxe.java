package com.github.mo_ink.eoc.items.tools;

import com.github.mo_ink.eoc.EOC;
import com.github.mo_ink.eoc.EOCTab;
import com.github.mo_ink.eoc.utils.ToolMaterials;
import net.minecraft.item.ItemAxe;

public class ItemCuckooAxe extends ItemAxe implements ICuckooTools {
    public ItemCuckooAxe() {
        super(ToolMaterials.CUCKOO, 9.0F, -3.2F);
        String name = "cuckoo_axe";
        this.setUnlocalizedName(EOC.MODID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(EOCTab.EOC_TAB);
        this.setMaxStackSize(1);
    }
}
