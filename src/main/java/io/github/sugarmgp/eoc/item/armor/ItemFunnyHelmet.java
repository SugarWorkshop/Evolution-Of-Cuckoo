package io.github.sugarmgp.eoc.item.armor;

import io.github.sugarmgp.eoc.EOC;
import io.github.sugarmgp.eoc.util.ModArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;

public class ItemFunnyHelmet extends ArmorItem {
    public ItemFunnyHelmet() {
        super(ModArmorMaterial.FUNNY, EquipmentSlotType.HEAD, new Properties().group(EOC.ITEMGROUP));
    }
}
