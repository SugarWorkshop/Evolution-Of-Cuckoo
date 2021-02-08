package com.github.mo_ink.eoc.handler;

import com.github.mo_ink.eoc.items.ItemCuckooIngot;
import com.github.mo_ink.eoc.items.ItemFunnyApple;
import com.github.mo_ink.eoc.items.ItemFunnyIngot;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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
    public static final ItemFunnyIngot ITEM_FUNNY_INGOT = new ItemFunnyIngot();
    public static final ItemCuckooIngot ITEM_CUCKOO_INGOT = new ItemCuckooIngot();
    public static final ItemBlock ITEM_FUNNY_ORE = new ItemBlock(BlockHandler.BLOCK_FUNNY_ORE);
    public static final ItemBlock ITEM_CUCKOO_ORE = new ItemBlock(BlockHandler.BLOCK_CUCKOO_ORE);
    public static final ItemBlock ITEM_FUNNY_BLOCK = new ItemBlock(BlockHandler.BLOCK_FUNNY_BLOCK);
    public static final ItemBlock ITEM_CUCKOO_BLOCK = new ItemBlock(BlockHandler.BLOCK_CUCKOO_BLOCK);

    @SubscribeEvent
    public static void onRegister(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();
        registry.register(ITEM_FUNNY_APPLE);
        registry.register(ITEM_FUNNY_INGOT);
        registry.register(ITEM_CUCKOO_INGOT);
        registry.register(ITEM_FUNNY_ORE.setRegistryName(ITEM_FUNNY_ORE.getBlock().getRegistryName()));
        registry.register(ITEM_CUCKOO_ORE.setRegistryName(ITEM_CUCKOO_ORE.getBlock().getRegistryName()));
        registry.register(ITEM_FUNNY_BLOCK.setRegistryName(ITEM_FUNNY_BLOCK.getBlock().getRegistryName()));
        registry.register(ITEM_CUCKOO_BLOCK.setRegistryName(ITEM_CUCKOO_BLOCK.getBlock().getRegistryName()));
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public static void onModelRegistry(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ITEM_FUNNY_APPLE, 0, new ModelResourceLocation(ITEM_FUNNY_APPLE.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ITEM_FUNNY_INGOT, 0, new ModelResourceLocation(ITEM_FUNNY_INGOT.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ITEM_CUCKOO_INGOT, 0, new ModelResourceLocation(ITEM_CUCKOO_INGOT.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ITEM_FUNNY_ORE, 0, new ModelResourceLocation(ITEM_FUNNY_ORE.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ITEM_CUCKOO_ORE, 0, new ModelResourceLocation(ITEM_CUCKOO_ORE.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ITEM_FUNNY_BLOCK, 0, new ModelResourceLocation(ITEM_FUNNY_BLOCK.getRegistryName(), "inventory"));
        ModelLoader.setCustomModelResourceLocation(ITEM_CUCKOO_BLOCK, 0, new ModelResourceLocation(ITEM_CUCKOO_BLOCK.getRegistryName(), "inventory"));
    }
}