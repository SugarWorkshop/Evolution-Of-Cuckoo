package io.github.sugarmgp.eoc.item;

import io.github.sugarmgp.eoc.EOC;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class ItemCuckooIngot extends Item {
    public ItemCuckooIngot() {
        super(new Properties().group(EOC.ITEMGROUP).maxStackSize(64));
    }
}
