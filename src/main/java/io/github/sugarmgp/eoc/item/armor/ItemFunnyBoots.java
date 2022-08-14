package io.github.sugarmgp.eoc.item.armor;

import io.github.sugarmgp.eoc.EOC;
import io.github.sugarmgp.eoc.util.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class ItemFunnyBoots extends ArmorItem {
    public ItemFunnyBoots() {
        super(ModArmorMaterial.FUNNY, EquipmentSlotType.FEET, new Properties().group(EOC.ITEMGROUP));
    }
}
