package io.github.sugarmgp.eoc.item.tool;

import io.github.sugarmgp.eoc.EOC;
import io.github.sugarmgp.eoc.util.EOCItemTier;
import net.minecraft.item.HoeItem;

public class ItemCuckooHoe extends HoeItem implements ICuckooTool {
    public ItemCuckooHoe() {
        super(
                EOCItemTier.CUCKOO,
                -2,
                0.0F,
                new Properties().group(EOC.ITEMGROUP)
        );
    }
}
