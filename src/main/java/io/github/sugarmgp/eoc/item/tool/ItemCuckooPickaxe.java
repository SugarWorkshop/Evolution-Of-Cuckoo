package io.github.sugarmgp.eoc.item.tool;

import io.github.sugarmgp.eoc.EOC;
import io.github.sugarmgp.eoc.util.ModItemTier;
import net.minecraft.item.PickaxeItem;

public class ItemCuckooPickaxe extends PickaxeItem implements ICuckooTool {
    public ItemCuckooPickaxe() {
        super(
                ModItemTier.CUCKOO,
                1,
                -2.8F,
                new Properties().group(EOC.ITEMGROUP)
        );
    }
}
