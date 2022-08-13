package io.github.sugarmgp.eoc;

import io.github.sugarmgp.eoc.handler.ItemHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class EOCItemGroup extends ItemGroup {

    public EOCItemGroup() {
        super("eoc_group");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ItemHandler.itemCuckooIngot.get());
    }
}
