package io.github.sugarmgp.eoc.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockCuckooOre extends Block {
    public BlockCuckooOre() {
        super(Properties
                .create(Material.ROCK)
                .hardnessAndResistance(2)
                .sound(SoundType.STONE)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2)
        );
    }
}
