package com.github.mo_ink.eoc.handler;

import com.github.mo_ink.eoc.EOC;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {
    public static final int GUIEOCManual = 0;

    public GuiHandler()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(EOC.instance, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID){
            case GUIEOCManual:
                return null;
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        switch (ID){
            case GUIEOCManual:
                return null;
            default:
                return null;
        }
    }
}
