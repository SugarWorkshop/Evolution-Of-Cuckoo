package com.github.mo_ink.eoc.client.manual;

import com.github.zi_jing.cuckoolib.client.render.GLUtils;
import com.github.zi_jing.cuckoolib.util.math.Vector2i;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.util.ResourceLocation;

import java.awt.image.BufferedImage;
import java.io.IOException;

class ElementImage extends Element {

    private final int width;
    private final int height;
    private final ResourceLocation location;
    private final int realWidth;
    private final int realHeight;

    ElementImage(ResourceLocation location, int windowWidth, int windowHeight) throws IOException {
        BufferedImage orgImage = TextureUtil.readBufferedImage(Minecraft.getMinecraft().getResourceManager().getResource(location).getInputStream());
        this.width = orgImage.getWidth();
        this.height = orgImage.getHeight();
        Vector2i size = new Vector2i(width, height);
        size.scaleToSize(windowWidth, windowHeight);
        this.realWidth = size.getX();
        this.realHeight = size.getY();
        this.location = location;
    }

    @Override
    protected Type getType() {
        return Type.IMAGE;
    }

    @Override
    protected int getHeight() {
        return realHeight;
    }

    @Override
    protected void draw(int x, int y, DocumentRenderer renderer) {
        GLUtils.bindTexture(this.location);
        GLUtils.drawScaledCustomSizeModalRect(x + renderer.width / 2 - realWidth / 2, y, 0, 0, width, height, realWidth, realHeight, width, height);
    }

    @Override
    protected void remove() {

    }
}
