package com.github.sugarmgp.eoc.utils;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockMaterials extends Material {
    public static final Material GOLD = (new BlockMaterials(MapColor.GOLD)).setRequiresTool();

    public BlockMaterials(MapColor color) {
        super(color);
    }
}
