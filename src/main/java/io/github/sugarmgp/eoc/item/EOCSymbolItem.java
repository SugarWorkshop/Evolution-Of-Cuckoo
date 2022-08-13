package io.github.sugarmgp.eoc.item;

import io.github.sugarmgp.eoc.EOC;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class EOCSymbolItem extends Item {

    public EOCSymbolItem() {
        super(new Properties().group(EOC.ITEMGROUP).maxStackSize(1));
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        // 仅在客户端执行
        if (worldIn.isRemote) {
            playerIn.sendStatusMessage(new TranslationTextComponent("eoc.message.eok_symbol_use"), false);
            playerIn.swingArm(handIn);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
