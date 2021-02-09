package com.github.mo_ink.eoc.items.armor;

import com.github.mo_ink.eoc.EOC;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ItemFunnyArmorBase extends ItemArmor {
    public static final ItemArmor.ArmorMaterial FUNNY = EnumHelper.addArmorMaterial("funny",
            EOC.MODID + ":" + "funny", 23, new int[]
                    {2, 6, 7, 3}, 9, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F);

    public ItemFunnyArmorBase(EntityEquipmentSlot equipmentSlotIn) {
        super(FUNNY, FUNNY.ordinal(), equipmentSlotIn);
    }
}
