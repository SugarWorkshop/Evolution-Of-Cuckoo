package com.github.sugarmgp.eoc.items.tools;

import com.github.sugarmgp.eoc.EOC;
import com.github.sugarmgp.eoc.EOCTab;
import com.github.sugarmgp.eoc.utils.ToolMaterials;
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
