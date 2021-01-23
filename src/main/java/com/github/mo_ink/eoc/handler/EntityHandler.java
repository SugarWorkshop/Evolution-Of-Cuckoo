package com.github.mo_ink.eoc.handler;

import com.github.mo_ink.eoc.EOC;
import com.github.mo_ink.eoc.entity.*;
import com.github.mo_ink.eoc.entity.render.*;
import com.github.mo_ink.eoc.utils.EntityRenderFactory;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityHandler {
    public static void register() {
        EntityRegistry.registerModEntity(new ResourceLocation(EOC.MODID, "entity.zijing"), EntityZijing.class,
                "eoc.entity_zijing", 0, EOC.instance, 64, 1, true, 0xB3FFFF, 0x4D94FF);

        EntityRegistry.registerModEntity(new ResourceLocation(EOC.MODID, "entity.moink"), EntityMoInk.class,
                "eoc.entity_moink", 1, EOC.instance, 64, 1, true, 0xffffb3, 0x66b2ff);

        EntityRegistry.registerModEntity(new ResourceLocation(EOC.MODID, "entity.bullet"), EntityBullet.class,
                "eoc.entity_bullet", 2, EOC.instance, 128, 1, true);

        EntityRegistry.registerModEntity(new ResourceLocation(EOC.MODID, "entity.smalldew"), EntitySmalldew.class,
                "eoc.entity_smalldew", 3, EOC.instance, 64, 1, true, 0x0066CC, 0xCCE5FF);

        EntityRegistry.registerModEntity(new ResourceLocation(EOC.MODID, "entity.osir"), EntityOsIr.class,
                "eoc.entity_osir", 4, EOC.instance, 64, 1, true, 0xFF99FF, 0x99FF99);

        EntityRegistry.registerModEntity(new ResourceLocation(EOC.MODID, "entity.nat"), EntityNat.class,
                "eoc.entity_nat", 5, EOC.instance, 64, 1, true, 0xFF88FF, 0x88FF88);
    }

    @SuppressWarnings("unchecked")
    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        registerEntityRender(EntityZijing.class, RenderZijing.class);
        registerEntityRender(EntityMoInk.class, RenderMoInk.class);
        registerEntityRender(EntitySmalldew.class, RenderSmalldew.class);
        // registerEntityRender(EntityChenweilin.class, RenderChenweilin.class);
        registerEntityRender(EntityOsIr.class, RenderOsIr.class);
        registerEntityRender(EntityNat.class, RenderNat.class);
    }

    @SideOnly(Side.CLIENT)
    private static <T extends Entity, E extends Render<T>> void registerEntityRender(Class<T> entityClass, Class<E> render) {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, new EntityRenderFactory<>(render));
    }
}