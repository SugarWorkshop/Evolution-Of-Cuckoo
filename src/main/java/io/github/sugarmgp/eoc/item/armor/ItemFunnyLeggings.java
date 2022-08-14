package io.github.sugarmgp.eoc.item.armor;

import io.github.sugarmgp.eoc.EOC;
import io.github.sugarmgp.eoc.util.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class ItemFunnyLeggings extends ArmorItem {
    public ItemFunnyLeggings() {
        super(ModArmorMaterial.FUNNY, EquipmentSlotType.LEGS, new Properties().group(EOC.ITEMGROUP));
    }
}
