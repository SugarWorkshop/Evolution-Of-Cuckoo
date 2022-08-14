package io.github.sugarmgp.eoc.item.tool;

import io.github.sugarmgp.eoc.EOC;
import io.github.sugarmgp.eoc.util.EOCItemTier;
import net.minecraft.item.PickaxeItem;

public class ItemCuckooPickaxe extends PickaxeItem implements ICuckooTool {
    public ItemCuckooPickaxe() {
        super(
                EOCItemTier.CUCKOO,
                1,
                -2.8F,
                new Properties().group(EOC.ITEMGROUP)
        );
    }
}
