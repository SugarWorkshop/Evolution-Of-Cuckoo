package io.github.sugarmgp.eoc.item;

import io.github.sugarmgp.eoc.EOC;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class ItemFunnyApple extends Item {
    private static final Food food = (new Food.Builder())
            .saturation(0.4f)
            .hunger(5)
            .effect(() -> new EffectInstance(Effects.REGENERATION, 160, 2), 1)
            .effect(() -> new EffectInstance(Effects.HEALTH_BOOST, 400, 1), 1)
            .setAlwaysEdible()
            .build();

    public ItemFunnyApple() {
        super(new Properties().food(food).group(EOC.ITEMGROUP));
    }
}
