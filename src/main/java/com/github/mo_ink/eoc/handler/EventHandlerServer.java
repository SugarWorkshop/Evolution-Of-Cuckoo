package com.github.mo_ink.eoc.handler;

import com.github.mo_ink.eoc.items.armor.ItemFunnyArmorBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber
public class EventHandlerServer {
    @SubscribeEvent
    public static void onPlayerJoin(EntityJoinWorldEvent event) {
        Entity entity = event.getEntity();
        if (entity instanceof EntityPlayer && !entity.world.isRemote) {
            String message = "eoc.welcome";
            TextComponentTranslation text = new TextComponentTranslation(message, entity.getName());
            entity.sendMessage(text);
        }
    }

    @SubscribeEvent
    public static void onCuckooArmor(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;
        if (!player.world.isRemote) {
            int count = 0;
            for (ItemStack is : player.getArmorInventoryList()) {
                if (is.getItem() instanceof ItemFunnyArmorBase) {
                    count++;
                }
            }
            if (count != 0) {
                player.addPotionEffect(new PotionEffect(PotionHandler.POTION_FUNNY, 300, count - 1, false, false));
            }
        }
    }
}
