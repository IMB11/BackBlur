package com.mineblock11.blur;

import io.wispforest.owo.client.OwoClient;
import io.wispforest.owo.ui.core.Color;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.impl.client.screen.ScreenEventFactory;
import net.fabricmc.fabric.impl.client.screen.ScreenExtensions;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;

public class BlurMain implements ClientModInitializer {
    public static com.mineblock11.blur.BlurConfig CONFIG;
    @Override
    public void onInitializeClient() {
        CONFIG = com.mineblock11.blur.BlurConfig.createAndLoad();
        ScreenEvents.BEFORE_INIT.register((client, screen, scaledWidth, scaledHeight) -> {
            ScreenEvents.beforeRender(screen).register((screen1, matrices, mouseX, mouseY, tickDelta) -> {
                if(client.world != null) {
                    initiateBlur(matrices, 0, 0, screen1.width, screen1.height);
                }
            });
        });

    }

    public static void initiateBlur(MatrixStack matrices, int x, int y, int width, int height) {
        // TODO: tint color, different strength and quality.

        int quality = CONFIG.quality();
        int strength = CONFIG.strength();
        Color tintColor = CONFIG.tintColor();
        Color actualColor = new Color(tintColor.red(), tintColor.green(), tintColor.blue(), CONFIG.tintStrength());

        DrawableHelper.fill(matrices, x, y, width, height, actualColor.argb());

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
