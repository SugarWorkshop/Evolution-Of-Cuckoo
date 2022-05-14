package com.github.sugarmgp.eoc.items;

import com.github.sugarmgp.eoc.EOC;
import com.github.sugarmgp.eoc.EOCTab;
import com.github.sugarmgp.eoc.handler.GuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemEOCManual extends Item {
    public ItemEOCManual() {
        super();
        String name = "eoc_manual";
        this.setRegistryName(name);
        this.setUnlocalizedName(EOC.MODID + "." + name);
        this.setMaxStackSize(1);
        this.setCreativeTab(EOCTab.EOC_TAB);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        BlockPos pos = playerIn.getPosition();

        playerIn.openGui(EOC.instance, GuiHandler.GUIEOCManual, worldIn, pos.getX(), pos.getY(), pos.getZ());

        return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
}
