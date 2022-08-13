package io.github.sugarmgp.eoc.handler;

import io.github.sugarmgp.eoc.EOC;
import io.github.sugarmgp.eoc.item.ItemCuckooIngot;
import io.github.sugarmgp.eoc.item.ItemFunnyApple;
import io.github.sugarmgp.eoc.item.ItemFunnyIngot;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemHandler {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, EOC.MODID);

    public static final RegistryObject<Item> itemCuckooIngot = ITEMS.register("cuckoo_ingot", ItemCuckooIngot::new);
    public static final RegistryObject<Item> itemFunnyApple = ITEMS.register("funny_apple", ItemFunnyApple::new);
    public static final RegistryObject<Item> itemFunnyIngot = ITEMS.register("funny_ingot", ItemFunnyIngot::new);
}
