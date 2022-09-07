package com.modkiller1001.nocapes.mixins;

import com.modkiller1001.nocapes.NoCapes;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Environment(EnvType.CLIENT)
@Mixin(ElytraLayer.class)
public class ElytraLayerMixin {
    @Redirect(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/LivingEntity;FFFFFF)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/AbstractClientPlayer;getElytraTextureLocation()Lnet/minecraft/resources/ResourceLocation;"))
    private ResourceLocation getElytraTextureLocation(AbstractClientPlayer abstractClientPlayer) {
        String capeUrl = NoCapes.getCapeURL(abstractClientPlayer.getGameProfile());
        if (!NoCapes.shouldRenderCape(capeUrl)) {
            return null;
        }

        return abstractClientPlayer.getElytraTextureLocation();
    }

    @Redirect(method = "render(Lcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;ILnet/minecraft/world/entity/LivingEntity;FFFFFF)V",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/client/player/AbstractClientPlayer;getCloakTextureLocation()Lnet/minecraft/resources/ResourceLocation;"))
    private ResourceLocation getCloakTextureLocation(AbstractClientPlayer abstractClientPlayer) {
        String capeUrl = NoCapes.getCapeURL(abstractClientPlayer.getGameProfile());
        if (!NoCapes.shouldRenderCape(capeUrl)) {
            return null;
        }

        return abstractClientPlayer.getCloakTextureLocation();
    }
}