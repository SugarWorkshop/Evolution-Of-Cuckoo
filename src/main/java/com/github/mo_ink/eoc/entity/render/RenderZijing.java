package com.github.mo_ink.eoc.entity.render;

import com.github.mo_ink.eoc.EOC;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderZijing<T extends EntityLiving> extends RenderNPCBase<T> {

    public RenderZijing(RenderManager rendermanagerIn) {
        super(rendermanagerIn);
    }

    @Override
    protected ResourceLocation getEntityTexture(T entity) {
        return new ResourceLocation(EOC.MODID + ":textures/entity/zijing.png");
    }

}
