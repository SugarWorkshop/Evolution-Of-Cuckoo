package com.github.sugarmgp.eoc.items.tools;

import com.github.sugarmgp.eoc.EOC;
import com.github.sugarmgp.eoc.EOCTab;
import com.github.sugarmgp.eoc.utils.ToolMaterials;
import net.minecraft.item.ItemPickaxe;

public class ItemCuckooPickaxe extends ItemPickaxe implements ICuckooTools {
    public ItemCuckooPickaxe() {
        super(ToolMaterials.CUCKOO);
        String name = "cuckoo_pickaxe";
        this.setUnlocalizedName(EOC.MODID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(EOCTab.EOC_TAB);
        this.setMaxStackSize(1);
    }
}
