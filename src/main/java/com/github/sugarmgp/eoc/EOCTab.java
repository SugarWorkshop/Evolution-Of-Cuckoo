package com.github.sugarmgp.eoc;

import com.github.sugarmgp.eoc.handler.ItemHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class EOCTab extends CreativeTabs {
    public static final EOCTab EOC_TAB = new EOCTab();

    public EOCTab() {
        super("eoc.tab");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemHandler.ITEM_FUNNY_CHESTPLATE);
    }
}
