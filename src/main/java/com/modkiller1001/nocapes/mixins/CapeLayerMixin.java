package com.modkiller1001.nocapes.mixins;

import com.modkiller1001.nocapes.NoCapes;
import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.layers.CapeLayer;
import net.minecraft.world.entity.player.PlayerModelPart;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(EnvType.CLIENT)
@Mixin(CapeLayer.class)
public class CapeLayerMixin {
    @Inject(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/client/player/AbstractClientPlayer;FFFFFF)V",
            at = @At("HEAD"),
            cancellable = true)
    private void render(PoseStack poseStack, MultiBufferSource multiBufferSource, int i, AbstractClientPlayer abstractClientPlayer, float f, float g, float h, float j, float k, float l, CallbackInfo info) {
        // The rendering code won't be executed either way if one of these checks fails, thus, we can cancel the rendering early
        if (!abstractClientPlayer.isModelPartShown(PlayerModelPart.CAPE)) {
            info.cancel();
            return;
        }

        String capeUrl = NoCapes.getCapeURL(abstractClientPlayer.getGameProfile());
        if (!NoCapes.shouldRenderCape(capeUrl)) {
            info.cancel();
        }
    }
}