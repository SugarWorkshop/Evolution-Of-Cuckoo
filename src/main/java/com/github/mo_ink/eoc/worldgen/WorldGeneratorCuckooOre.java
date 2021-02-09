package com.github.mo_ink.eoc.worldgen;

import com.github.mo_ink.eoc.handler.BlockHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

public class WorldGeneratorCuckooOre extends WorldGenerator {
    private final WorldGenerator cuckooOreGenerator = new WorldGenMinable(BlockHandler.BLOCK_CUCKOO_ORE.getDefaultState(), 9);

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {
        if (TerrainGen.generateOre(world, rand, this, pos, OreGenEvent.GenerateMinable.EventType.CUSTOM)) {
            for (int i = 0; i < 2; ++i) {
                int posX = pos.getX() + rand.nextInt(16);
                int posY = 16 + rand.nextInt(16);
                int posZ = pos.getZ() + rand.nextInt(16);
                BlockPos blockpos = new BlockPos(posX, posY, posZ);
                Biome biomeGenBase = world.getBiomeForCoordsBody(blockpos);
                if (biomeGenBase.getRainfall() < rand.nextInt(65536)) {
                    cuckooOreGenerator.generate(world, rand, blockpos);
                }
            }
        }
        return true;
    }
}
