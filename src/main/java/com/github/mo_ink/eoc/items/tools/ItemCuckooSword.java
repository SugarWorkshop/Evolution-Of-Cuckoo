package com.github.mo_ink.eoc.items.tools;

import com.github.mo_ink.eoc.EOC;
import com.github.mo_ink.eoc.EOCTab;
import com.github.mo_ink.eoc.utils.ToolMaterials;
import net.minecraft.item.ItemSword;

public class ItemCuckooSword extends ItemSword implements ICuckooTools {
    public ItemCuckooSword() {
        super(ToolMaterials.CUCKOO);
        String name = "cuckoo_sword";
        this.setUnlocalizedName(EOC.MODID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(EOCTab.EOC_TAB);
        this.setMaxStackSize(1);
    }
}
