package com.github.mo_ink.eoc.handler;

import com.github.mo_ink.eoc.EOC;
import com.github.mo_ink.eoc.entity.EntityMoInk;
import com.github.mo_ink.eoc.entity.EntityZijing;
import com.github.mo_ink.eoc.entity.render.RenderMoInk;
import com.github.mo_ink.eoc.entity.render.RenderZijing;
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
                "eoc.entity_zijing", 1, EOC.instance, 64, 1, true, 0xB3FFFF, 0x4D94FF);

        EntityRegistry.registerModEntity(new ResourceLocation(EOC.MODID, "entity.moink"), EntityMoInk.class,
                "eoc.entity_moink", 2, EOC.instance, 64, 1, true, 0xffffb3, 0x66b2ff);
    }

    @SuppressWarnings("unchecked")
    @SideOnly(Side.CLIENT)
    public static void registerRenders() {
        registerEntityRender(EntityZijing.class, RenderZijing.class);
        registerEntityRender(EntityMoInk.class, RenderMoInk.class);
    }

    @SideOnly(Side.CLIENT)
    private static <T extends Entity, E extends Render<T>> void registerEntityRender(Class<T> entityClass, Class<E> render) {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, new EntityRenderFactory<>(render));
    }
}