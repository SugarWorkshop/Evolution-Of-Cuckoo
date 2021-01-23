package com.github.mo_ink.eoc.handler;

import com.github.mo_ink.eoc.potion.PotionFunny;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class PotionHandler {
    public static final Potion POTION_FUNNY = new PotionFunny();

    @SubscribeEvent
    public static void onPotionRegistry(RegistryEvent.Register<Potion> event) {
        IForgeRegistry<Potion> registry = event.getRegistry();
        registry.register(POTION_FUNNY);
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        DamageSource source = event.getSource(); //伤害原因
        EntityLivingBase target = event.getEntityLiving(); //被伤害目标
        Potion potion = POTION_FUNNY; //滑稽药水效果
        PotionEffect effect = target.getActivePotionEffect(potion); //滑稽药水效果
        if (!"outOfWorld".equals(source.getDamageType()) && !"eoc.funnyDied".equals(source.getDamageType()) && target.isPotionActive(potion)) { //如果不是掉出世界或滑稽死亡且玩家有滑稽效果
            target.setHealth(target.getHealth() + event.getAmount() / 3 * (effect.getAmplifier() + 1)); //增加生命值
            event.setAmount(0); //将伤害调为0
        }
    }

    @SubscribeEvent
    public static void onPlayerAttack(AttackEntityEvent event) {
        EntityPlayer player = event.getEntityPlayer(); //玩家
        Potion potion = POTION_FUNNY; //滑稽药水效果
        PotionEffect effect = player.getActivePotionEffect(potion); //滑稽药水效果
        Item item = player.getHeldItemMainhand().getItem();

        float damage = 0;
        if (item instanceof ItemTool) //如果是工具（镐、斧、铲）
            damage = (Item.ToolMaterial.valueOf(((ItemTool) item).getToolMaterialName())).getAttackDamage() + 3;
        else if (item instanceof ItemSword)  //如果是剑
            damage = ((ItemSword) item).getAttackDamage() + 3;
        else if (item instanceof ItemHoe) //如果是锄头
            damage = (Item.ToolMaterial.valueOf(((ItemHoe) item).getMaterialName())).getAttackDamage() + 3;
        damage += 1;

        if (player.isPotionActive(potion)) { //若玩家有滑稽效果
            player.sendMessage(new TextComponentString(Float.toString(damage)));
            player.sendMessage(new TextComponentString(Float.toString(damage / 2 * (effect.getAmplifier() + 1))));
            player.attackEntityFrom(DamageSourceHandler.FUNNY_DIED, damage / 2 * (effect.getAmplifier() + 1)); //减少生命值
        }
    }
}
