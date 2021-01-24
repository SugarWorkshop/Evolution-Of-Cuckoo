package com.github.mo_ink.eoc.handler;

import com.github.mo_ink.eoc.worldgen.WorldGeneratorCuckooOre;
import com.github.mo_ink.eoc.worldgen.WorldGeneratorFunnyOre;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WorldGeneratorHandler {
    private static final WorldGenerator generatorFunnyOre = new WorldGeneratorFunnyOre();
    private static final WorldGenerator generatorCuckooOre = new WorldGeneratorCuckooOre();

    private BlockPos pos;

    public WorldGeneratorHandler() {
        MinecraftForge.ORE_GEN_BUS.register(this);
    }

    @SubscribeEvent
    public void onOreGenPost(OreGenEvent.Post event) {
        if (!event.getPos().equals(this.pos)) {
            this.pos = event.getPos();
            generatorFunnyOre.generate(event.getWorld(), event.getRand(), event.getPos());
            generatorCuckooOre.generate(event.getWorld(), event.getRand(), event.getPos());
        }
    }
}
