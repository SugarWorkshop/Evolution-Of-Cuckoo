package io.github.sugarmgp.eoc.entity.render;

import io.github.sugarmgp.eoc.EOC;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderSugarMGP extends RenderNPCBase {
    public RenderSugarMGP(EntityRendererManager managerIn) {
        super(managerIn);
    }

    @Override
    public ResourceLocation getEntityTexture(Entity entity) {
        return new ResourceLocation(EOC.MODID, "textures/entity/sugarmgp.png");
    }
}
