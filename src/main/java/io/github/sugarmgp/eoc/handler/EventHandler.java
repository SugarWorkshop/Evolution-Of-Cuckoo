package io.github.sugarmgp.eoc.handler;

import io.github.sugarmgp.eoc.worldgen.ModEntityGeneration;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class EventHandler {
    @SubscribeEvent
    public static void onPlayerJoin(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof PlayerEntity && !entity.world.isRemote) {
            PlayerEntity player = (PlayerEntity) entity;
            String message = "eoc.welcome";
            TranslationTextComponent text = new TranslationTextComponent(message, player.getDisplayName());
            player.sendStatusMessage(text, false);
        }
    }

    @SubscribeEvent
    public static void onbBiomeLoading(BiomeLoadingEvent event) {
        ModEntityGeneration.onEntitySpawn(event);
    }
}
