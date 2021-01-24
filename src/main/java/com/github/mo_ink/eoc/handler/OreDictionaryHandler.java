package com.github.mo_ink.eoc.handler;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryHandler {
    public OreDictionaryHandler(FMLPreInitializationEvent event) {
        OreDictionary.registerOre("ingotFunny", ItemHandler.ITEM_FUNNY_INGOT);
    }
}
