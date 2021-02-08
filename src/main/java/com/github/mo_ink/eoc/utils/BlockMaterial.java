package com.github.mo_ink.eoc.utils;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockMaterial extends Material {
    public static final Material IRON = (new BlockMaterial(MapColor.IRON)).setRequiresTool();
    public static final Material GOLD = (new BlockMaterial(MapColor.GOLD)).setRequiresTool();

    public BlockMaterial(MapColor color) {
        super(color);
    }
}
