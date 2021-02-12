package com.github.mo_ink.eoc.items.armor;

import com.github.mo_ink.eoc.EOC;
import com.github.mo_ink.eoc.EOCTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFunnyHelmet extends ItemFunnyArmorBase {
    public ItemFunnyHelmet() {
        super(EntityEquipmentSlot.HEAD);
        String name = "funny_helmet";
        this.setUnlocalizedName(EOC.MODID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(EOCTab.EOC_TAB);
        this.setMaxStackSize(1);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack item) {
        if (!world.isRemote) {
            player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 300, 0));
            player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 300, 0));
        }
    }
}
