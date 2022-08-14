package io.github.sugarmgp.eoc.item.armor;

import io.github.sugarmgp.eoc.EOC;
import io.github.sugarmgp.eoc.util.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class ItemFunnyChestplate extends ArmorItem {
    public ItemFunnyChestplate() {
        super(ModArmorMaterial.FUNNY, EquipmentSlotType.CHEST, new Properties().group(EOC.ITEMGROUP));
    }
}
