package com.github.mo_ink.eoc;

import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

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

    @EventHandler
    public void addBrandings(FMLLoadCompleteEvent e) {
        List<String> brandings = new ArrayList<>(FMLCommonHandler.instance().getBrandings(true));
        brandings.add(0, "§bEvolution §cOf §eCuckoo §r" + VERSION);
        ReflectionHelper.setPrivateValue(FMLCommonHandler.class, FMLCommonHandler.instance(), brandings, "brandings");
    }

    public static Logger getLogger(){
        return logger;
    }
}
