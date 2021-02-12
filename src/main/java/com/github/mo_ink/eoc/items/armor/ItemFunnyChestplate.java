package com.github.mo_ink.eoc.items.armor;

import com.github.mo_ink.eoc.EOC;
import com.github.mo_ink.eoc.EOCTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFunnyChestplate extends ItemFunnyArmorBase {
    public ItemFunnyChestplate() {
        super(EntityEquipmentSlot.CHEST);
        String name = "funny_chestplate";
        this.setUnlocalizedName(EOC.MODID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(EOCTab.EOC_TAB);
        this.setMaxStackSize(1);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack item) {
        if (!world.isRemote) {
            if (!player.isPotionActive(MobEffects.HEALTH_BOOST)) {
                player.addPotionEffect(new PotionEffect(MobEffects.HEALTH_BOOST, 300, 1));
            }
            if (!player.isPotionActive(MobEffects.REGENERATION)) {
                player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 300, 1));
            }
        }
    }
}
