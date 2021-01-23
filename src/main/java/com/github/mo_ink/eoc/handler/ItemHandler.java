package com.github.mo_ink.eoc.handler;

import com.github.mo_ink.eoc.item.ItemFunnyApple;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class ItemHandler {

    public static final ItemFunnyApple ITEM_FUNNY_APPLE = new ItemFunnyApple();

    @SubscribeEvent
    public static void onRegister(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(ITEM_FUNNY_APPLE);
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegistry(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ITEM_FUNNY_APPLE, 0, new ModelResourceLocation(ITEM_FUNNY_APPLE.getRegistryName(), "inventory"));
    }
}