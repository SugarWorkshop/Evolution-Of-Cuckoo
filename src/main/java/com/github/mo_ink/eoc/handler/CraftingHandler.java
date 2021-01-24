package com.github.mo_ink.eoc.handler;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class CraftingHandler {
    public CraftingHandler() {
        registerOreDictionary();
        registerSmelting();
    }

    public void registerOreDictionary() {
        OreDictionary.registerOre("ingotFunny", ItemHandler.ITEM_FUNNY_INGOT);
    }

    public void registerSmelting() {
        GameRegistry.addSmelting(new ItemStack(ItemHandler.ITEM_FUNNY_ORE), new ItemStack(ItemHandler.ITEM_FUNNY_INGOT), 4);
    }
}
