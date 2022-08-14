package io.github.sugarmgp.eoc.item.tool;

import io.github.sugarmgp.eoc.EOC;
import io.github.sugarmgp.eoc.util.EOCItemTier;
import net.minecraft.item.SwordItem;

public class ItemCuckooSword extends SwordItem implements ICuckooTool {
    public ItemCuckooSword() {
        super(
                EOCItemTier.CUCKOO,
                3,
                -2.4F,
                new Properties().group(EOC.ITEMGROUP)
        );
    }
}
