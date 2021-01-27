package com.github.mo_ink.eoc;

import com.github.mo_ink.eoc.handler.CraftingHandler;
import com.github.mo_ink.eoc.handler.EntityHandler;
import com.github.mo_ink.eoc.handler.WorldGeneratorHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        EntityHandler.register();
        EntityHandler.registerSpawn();
    }

    public void init(FMLInitializationEvent event) {
        new CraftingHandler();
        new WorldGeneratorHandler();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
