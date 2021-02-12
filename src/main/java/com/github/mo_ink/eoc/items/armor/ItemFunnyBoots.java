package com.github.mo_ink.eoc.items.armor;

import com.github.mo_ink.eoc.EOC;
import com.github.mo_ink.eoc.EOCTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFunnyBoots extends ItemFunnyArmorBase {
    public ItemFunnyBoots() {
        super(EntityEquipmentSlot.FEET);
        String name = "funny_boots";
        this.setUnlocalizedName(EOC.MODID + "." + name);
        this.setRegistryName(name);
        this.setCreativeTab(EOCTab.EOC_TAB);
        this.setMaxStackSize(1);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack item) {
        if (!world.isRemote) {
            player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 300, 0));
            player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 300, 1));
        }
    }
}
