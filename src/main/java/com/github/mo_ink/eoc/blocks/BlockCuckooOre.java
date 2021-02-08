package com.github.mo_ink.eoc.blocks;

import com.github.mo_ink.eoc.EOC;
import com.github.mo_ink.eoc.EOCTab;
import com.github.mo_ink.eoc.handler.ItemHandler;
import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockCuckooOre extends BlockOre {
    public BlockCuckooOre() {
        super(MapColor.STONE);
        String name = "cuckoo_ore";
        this.setSoundType(SoundType.STONE);
        this.setHardness(2.5F);
        this.setHarvestLevel("pickaxe", 2);
        this.setCreativeTab(EOCTab.EOC_TAB);
        this.setRegistryName(name);
        this.setUnlocalizedName(EOC.MODID + "." + name);
    }

    @Nonnull
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ItemHandler.ITEM_CUCKOO_INGOT;
    }

    @Override
    public int quantityDropped(Random random) {
        return 1;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (fortune > 0) {
            int bonusFactor = Math.max(random.nextInt(fortune + 2) - 1, 0);
            return this.quantityDropped(random) * (bonusFactor + 1);
        } else {
            return this.quantityDropped(random);
        }
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        Random random = world instanceof World ? ((World) world).rand : new Random();
        return MathHelper.getInt(random, 2, 6);
    }

    @Override
    public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
        return new ItemStack(this);
    }

    @Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
        return true;
    }

    @Override
    public ItemStack getSilkTouchDrop(IBlockState state) {
        return new ItemStack(this);
    }
}
