package io.github.sugarmgp.eoc.item.tool;

import io.github.sugarmgp.eoc.EOC;
import io.github.sugarmgp.eoc.util.ModItemTier;
import net.minecraft.item.ShovelItem;

public class ItemCuckooShovel extends ShovelItem implements ICuckooTool {
    public ItemCuckooShovel() {
        super(
                ModItemTier.CUCKOO,
                1.5F,
                -3.0F,
                new Properties().group(EOC.ITEMGROUP)
        );
    }
}
