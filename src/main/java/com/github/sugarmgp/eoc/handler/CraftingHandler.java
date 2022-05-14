package com.github.sugarmgp.eoc.handler;

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
        OreDictionary.registerOre("ingotCuckoo", ItemHandler.ITEM_CUCKOO_INGOT);
        OreDictionary.registerOre("oreFunny", ItemHandler.ITEM_FUNNY_ORE);
        OreDictionary.registerOre("oreCuckoo", ItemHandler.ITEM_CUCKOO_ORE);
        OreDictionary.registerOre("blockFunny", ItemHandler.ITEM_FUNNY_BLOCK);
        OreDictionary.registerOre("blockCuckoo", ItemHandler.ITEM_CUCKOO_BLOCK);
    }

    public void registerSmelting() {
        GameRegistry.addSmelting(new ItemStack(ItemHandler.ITEM_FUNNY_ORE), new ItemStack(ItemHandler.ITEM_FUNNY_INGOT), 4);
        GameRegistry.addSmelting(new ItemStack(ItemHandler.ITEM_CUCKOO_ORE), new ItemStack(ItemHandler.ITEM_CUCKOO_INGOT), 6);
    }
}
