package io.github.sugarmgp.eoc.item.tool;

import io.github.sugarmgp.eoc.EOC;
import io.github.sugarmgp.eoc.util.ModItemTier;
import net.minecraft.item.AxeItem;

public class ItemCuckooAxe extends AxeItem implements ICuckooTool {
    public ItemCuckooAxe() {
        super(
                ModItemTier.CUCKOO,
                5.0F,
                -3.0F,
                new Properties().group(EOC.ITEMGROUP)
        );
    }
}
