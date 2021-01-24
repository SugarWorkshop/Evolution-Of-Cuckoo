package com.github.mo_ink.eoc;

import com.github.mo_ink.eoc.handler.EntityHandler;
import com.github.mo_ink.eoc.handler.OreDictionaryHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        EntityHandler.register();
        new OreDictionaryHandler(event);
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
