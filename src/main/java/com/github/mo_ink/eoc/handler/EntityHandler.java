package com.github.mo_ink.eoc.handler;

import com.github.mo_ink.eoc.EOC;
import com.github.mo_ink.eoc.entity.*;
import com.github.mo_ink.eoc.entity.render.*;
import com.github.mo_ink.eoc.utils.EntityRenderFactory;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityHandler {
    public static void register() {

        EntityRegistry.registerModEntity(new ResourceLocation(EOC.MODID, "entity.zijing"), EntityZijing.class,
                "eoc.entity_zijing", 0, EOC.instance, 64, 1, true, 0xFFEC8B, 0x8B8B7A);

        EntityRegistry.registerModEntity(new ResourceLocation(EOC.MODID, "entity.moink"), EntityMoInk.class,
                "eoc.entity_moink", 1, EOC.instance, 64, 1, true, 0xB3FFFF, 0x4D94FF);

        EntityRegistry.registerModEntity(new ResourceLocation(EOC.MODID, "entity.smalldew"), EntitySmalldew.class,
                "eoc.entity_smalldew", 2, EOC.instance, 64, 1, true, 0x0066CC, 0xCCE5FF);

        EntityRegistry.registerModEntity(new ResourceLocation(EOC.MODID, "entity.osir"), EntityOsIr.class,
                "eoc.entity_osir", 3, EOC.instance, 64, 1, true, 0xFF99FF, 0x99FF99);

        EntityRegistry.registerModEntity(new ResourceLocation(EOC.MODID, "entity.nat"), EntityNat.class,
                "eoc.entity_nat", 4, EOC.instance, 64, 1, true, 0x54FF9F, 0x2E8B57);

        EntityRegistry.registerModEntity(new ResourceLocation(EOC.MODID, "entity.baozi"), EntityBaozi.class,
                "eoc.entity_baozi", 5, EOC.instance, 64, 1, true, 0xFF6A6A, 0x00FF7F);
    }

    @SuppressWarnings("unchecked")
    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        registerEntityRender(EntityZijing.class, RenderZijing.class);
        registerEntityRender(EntityMoInk.class, RenderMoInk.class);
        registerEntityRender(EntitySmalldew.class, RenderSmalldew.class);
        registerEntityRender(EntityOsIr.class, RenderOsIr.class);
        registerEntityRender(EntityNat.class, RenderNat.class);
        registerEntityRender(EntityBaozi.class, RenderBaozi.class);
    }

    @SideOnly(Side.CLIENT)
    private static <T extends Entity, E extends Render<T>> void registerEntityRender(Class<T> entityClass, Class<E> render) {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, new EntityRenderFactory<>(render));
    }

    private static void registerEntitySpawn(Class<? extends Entity> entityClass, int spawnWeight, int min,
                                            int max, EnumCreatureType typeOfCreature, Biome... biomes) {
        if (EntityLiving.class.isAssignableFrom(entityClass)) {
            Class<? extends EntityLiving> entityLivingClass = entityClass.asSubclass(EntityLiving.class);
            EntityRegistry.addSpawn(entityLivingClass, spawnWeight, min, max, typeOfCreature, biomes);
        }
    }

    public static void registerSpawn() {
        Biome[] biomes = new Biome[]{
                Biomes.PLAINS,
                Biomes.MUTATED_PLAINS,
                Biomes.FOREST,
                Biomes.MUTATED_FOREST,
                Biomes.EXTREME_HILLS,
                Biomes.EXTREME_HILLS_WITH_TREES,
                Biomes.EXTREME_HILLS_EDGE
        };
        registerEntitySpawn(EntityMoInk.class, 8, 1, 3, EnumCreatureType.CREATURE, biomes);
        registerEntitySpawn(EntityZijing.class, 8, 1, 3, EnumCreatureType.CREATURE, biomes);
        registerEntitySpawn(EntitySmalldew.class, 12, 1, 4, EnumCreatureType.CREATURE, biomes);
        registerEntitySpawn(EntityNat.class, 16, 1, 5, EnumCreatureType.CREATURE, biomes);
        registerEntitySpawn(EntityOsIr.class, 16, 1, 5, EnumCreatureType.CREATURE, biomes);
    }
}