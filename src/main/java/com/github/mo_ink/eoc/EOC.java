package com.github.mo_ink.eoc;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = EOC.MODID, name = EOC.NAME, version = EOC.VERSION)
public class EOC {
    public static final String MODID = "eoc";
    public static final String NAME = "Evolution Of Cuckoo";
    public static final String VERSION = "@EOCVERSION@";
    @Mod.Instance
    public static EOC instance;
    @SidedProxy(clientSide = "com.github.mo_ink.eoc.ClientProxy", serverSide = "com.github.mo_ink.eoc.CommonProxy")
    public static CommonProxy proxy;
    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
