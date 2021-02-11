package com.github.mo_ink.eoc.handler;

import com.github.mo_ink.eoc.items.tools.ICuckooTools;
import com.github.mo_ink.eoc.potion.PotionFunny;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Random;

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
        EntityLivingBase target = event.getEntityLiving(); //被伤害目标
        if (target.isPotionActive(POTION_FUNNY) && target instanceof EntityPlayer) { //如果目标有滑稽效果且是玩家
            String damageType = event.getSource().getDamageType(); //伤害类型
            int amplifier = target.getActivePotionEffect(POTION_FUNNY).getAmplifier() + 1; //滑稽药水效果
            if (
                    !"outOfWorld".equals(damageType) &&
                            !"eoc.funnyDied".equals(damageType) &&
                            !"inFire".equals(damageType) &&
                            !"onFire".equals(damageType) &&
                            !"lava".equals(damageType) &&
                            !"inWall".equals(damageType) &&
                            !"hotFloor".equals(damageType) &&
                            !"drown".equals(damageType)
            ) {
                target.setHealth(target.getHealth() + event.getAmount() / 5 * amplifier); //增加生命值
                event.setAmount(0); //将伤害调为0
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerAttack(AttackEntityEvent event) {
        EntityPlayer player = event.getEntityPlayer(); //玩家
        if (player.isPotionActive(POTION_FUNNY)) { //若玩家有滑稽效果
            Item item = player.getHeldItemMainhand().getItem(); //玩家手持物品
            int amplifier = player.getActivePotionEffect(POTION_FUNNY).getAmplifier() + 1; //滑稽药水效果
            float playerAttackDamage = (float) player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue(); //玩家攻击伤害

            float damage;
            if (item instanceof ItemTool) {//如果是工具（镐、斧、铲）
                damage = (Item.ToolMaterial.valueOf(((ItemTool) item).getToolMaterialName())).getAttackDamage() + 2.8F + playerAttackDamage;
            } else if (item instanceof ItemSword) {  //如果是剑
                damage = ((ItemSword) item).getAttackDamage() + 2.8F + playerAttackDamage;
            } else if (item instanceof ItemHoe) { //如果是锄头
                damage = (Item.ToolMaterial.valueOf(((ItemHoe) item).getMaterialName())).getAttackDamage() + 2.8F + playerAttackDamage;
            } else { //其他
                damage = playerAttackDamage;
            }

            float amount = damage / 3 * amplifier;
            if (item instanceof ICuckooTools) { //如果是不咕工具则减少扣血
                amount = amount / (new Random().nextInt(10) / 9.0F + 3.5F);
            }
            player.attackEntityFrom(DamageSourceHandler.FUNNY_DIED, amount); //减少生命值
        }
    }
}
