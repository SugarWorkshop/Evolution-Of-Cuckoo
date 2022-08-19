package io.github.sugarmgp.eoc.handler;

import io.github.sugarmgp.eoc.entity.render.RendererSugarMGP;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class RendererHandler {
    @SubscribeEvent
    public static void setupRenderer(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityTypeHandler.entitySugarMGP.get(), (EntityRendererManager manager) -> {
            return new RendererSugarMGP(manager);
        });
    }
}
