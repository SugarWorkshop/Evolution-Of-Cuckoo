package com.github.mo_ink.eoc.items;

import com.github.mo_ink.eoc.EOC;
import com.github.mo_ink.eoc.EOCTab;
import com.github.mo_ink.eoc.handler.PotionHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFunnyApple extends ItemFood {
    public ItemFunnyApple() {
        super(5, 0.4f, false);
        String name = "funny_apple";
        this.setRegistryName(name);
        this.setUnlocalizedName(EOC.MODID + "." + name);
        this.setMaxStackSize(64);
        this.setAlwaysEdible();
        this.setCreativeTab(EOCTab.EOC_TAB);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            int amplifier;
            if (stack.getCount() >= 32)
                amplifier = 2;
            else if (stack.getCount() >= 16)
                amplifier = 1;
            else
                amplifier = 0;
            player.addPotionEffect(new PotionEffect(PotionHandler.POTION_FUNNY, 300, amplifier));
        }
    }
}
