package com.github.mo_ink.eoc.handler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EventHandlerServer {
    @SubscribeEvent
    public static void onPlayerJoin(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof EntityPlayer && !entity.world.isRemote) {
            String message = "Welcome to Evolution Of Cuckoo , " + entity.getName() + " !";
            TextComponentString text = new TextComponentString(message);
            entity.sendMessage(text);
        }
    }
}
