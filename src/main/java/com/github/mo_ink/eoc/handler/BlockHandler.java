package com.github.mo_ink.eoc.handler;

import com.github.mo_ink.eoc.blocks.BlockCuckooOre;
import com.github.mo_ink.eoc.blocks.BlockFunnyOre;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class BlockHandler {
    public static final BlockFunnyOre BLOCK_FUNNY_ORE = new BlockFunnyOre();
    public static final BlockCuckooOre BLOCK_CUCKOO_ORE = new BlockCuckooOre();

    @SubscribeEvent
    public static void onRegistry(RegistryEvent.Register<Block> event) {
        IForgeRegistry<Block> registry = event.getRegistry();
        registry.register(BLOCK_FUNNY_ORE);
        registry.register(BLOCK_CUCKOO_ORE);
    }
}
