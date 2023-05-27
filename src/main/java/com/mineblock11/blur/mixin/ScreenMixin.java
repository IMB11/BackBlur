//package com.mineblock11.blur.mixin;
//
//import com.mineblock11.blur.BlurMain;
//import net.minecraft.client.MinecraftClient;
//import net.minecraft.client.gui.screen.Screen;
//import net.minecraft.client.util.math.MatrixStack;
//import org.jetbrains.annotations.Nullable;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//
//@Mixin(Screen.class)
//public class ScreenMixin {
//    @Shadow @Nullable protected MinecraftClient client;
//
//    @Shadow public int width;
//
//    @Shadow public int height;
//
//    @Inject(method = "render", at = @At("HEAD"))
//    public void renderBlur(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
//        if(this.client != null) {
//            if(this.client.world != null) {
//                BlurMain.initiateBlur(matrices, 0, 0, this.width, this.height);
//            }
//        }
//    }
//}
