package io.github.sugarmgp.eoc.handler;

import io.github.sugarmgp.eoc.EOC;
import io.github.sugarmgp.eoc.block.BlockCuckooBlock;
import io.github.sugarmgp.eoc.block.BlockCuckooOre;
import io.github.sugarmgp.eoc.block.BlockFunnyBlock;
import io.github.sugarmgp.eoc.block.BlockFunnyOre;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockHandler {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, EOC.MODID);

    public static RegistryObject<Block> blockFunnyOre = BLOCKS.register("funny_ore", BlockFunnyOre::new);
    public static RegistryObject<Block> blockCuckooOre = BLOCKS.register("cuckoo_ore", BlockCuckooOre::new);
    public static RegistryObject<Block> blockFunnyBlock = BLOCKS.register("funny_block", BlockFunnyBlock::new);
    public static RegistryObject<Block> blockCuckooBlock = BLOCKS.register("cuckoo_block", BlockCuckooBlock::new);
}
