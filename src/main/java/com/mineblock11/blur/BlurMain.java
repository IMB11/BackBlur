package com.mineblock11.blur;

import io.wispforest.owo.client.OwoClient;
import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.ui.core.Color;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;

public class BlurUI implements ClientModInitializer {
    public static com.mineblock11.blur.BlurConfig CONFIG = com.mineblock11.blur.BlurConfig.createAndLoad();
    @Override
    public void onInitializeClient() {}

    public static void initiateBlur(MatrixStack matrices, int x, int y, int width, int height) {
        // TODO: tint color, different strength and quality.

        int quality = CONFIG.quality();
        int strength = CONFIG.strength();
        int tint = CONFIG.tint().argb();

        DrawableHelper.fill(matrices, x, y, width, height, tint);

        var buffer = Tessellator.getInstance().getBuffer();
        var matrix = matrices.peek().getPositionMatrix();

        buffer.begin(VertexFormat.DrawMode.QUADS, VertexFormats.POSITION);
        buffer.vertex(matrix, x, y, 0).next();
        buffer.vertex(matrix, x, y + height, 0).next();
        buffer.vertex(matrix, x + width, y + height, 0).next();
        buffer.vertex(matrix, x + width, y, 0).next();

        OwoClient.BLUR_PROGRAM.setParameters(16, quality, strength);
        OwoClient.BLUR_PROGRAM.use();

        Tessellator.getInstance().draw();
    }
}
