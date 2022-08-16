package io.github.sugarmgp.eoc.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;

public class BlockFunnyBlock extends Block {
    public BlockFunnyBlock() {
        super(Properties
                .create(Material.IRON, MaterialColor.GOLD)
                .hardnessAndResistance(5)
                .sound(SoundType.METAL)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2)
        );
    }
}
