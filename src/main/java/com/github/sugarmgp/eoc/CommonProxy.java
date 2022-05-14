package com.github.sugarmgp.eoc;

import com.github.sugarmgp.eoc.handler.CraftingHandler;
import com.github.sugarmgp.eoc.handler.EntityHandler;
import com.github.sugarmgp.eoc.handler.GuiHandler;
import com.github.sugarmgp.eoc.handler.WorldGeneratorHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        EntityHandler.register();
        EntityHandler.registerSpawn();
    }

    public void init(FMLInitializationEvent event) {
        new CraftingHandler();
        new WorldGeneratorHandler();
        NetworkRegistry.INSTANCE.registerGuiHandler(EOC.instance, new GuiHandler());
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
