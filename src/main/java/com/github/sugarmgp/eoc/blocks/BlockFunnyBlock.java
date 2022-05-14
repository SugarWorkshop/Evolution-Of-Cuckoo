package com.github.sugarmgp.eoc.blocks;

import com.github.sugarmgp.eoc.EOC;
import com.github.sugarmgp.eoc.EOCTab;
import com.github.sugarmgp.eoc.utils.BlockMaterials;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;

public class BlockFunnyBlock extends Block {
    public BlockFunnyBlock() {
        super(BlockMaterials.GOLD);
        String name = "funny_block";
        this.setSoundType(SoundType.METAL);
        this.setHardness(4F);
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(EOCTab.EOC_TAB);
        this.setRegistryName(name);
        this.setUnlocalizedName(EOC.MODID + "." + name);
    }
}
