package io.github.sugarmgp.eoc;

import io.github.sugarmgp.eoc.handler.ItemHandler;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(EOC.MODID)
public class EOC {

    public static final ItemGroup ITEMGROUP = new EOCItemGroup();
    public static final String MODID = "eoc";
    private static final Logger LOGGER = LogManager.getLogger("EvolutionOfCuckoo");

    public EOC() {
        ItemHandler.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}