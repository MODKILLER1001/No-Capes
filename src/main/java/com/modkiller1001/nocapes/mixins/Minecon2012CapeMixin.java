package com.modkiller1001.nocapes.mixins;

import com.modkiller1001.nocapes.config.NoCapesConfig;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SkinManager.class)
public abstract class Minecon2012CapeMixin {
    @Inject(
            at = @At("HEAD"),
            method = "registerTexture(Lcom/mojang/authlib/minecraft/MinecraftProfileTexture;Lcom/mojang/authlib/minecraft/MinecraftProfileTexture$Type;Lnet/minecraft/client/resources/SkinManager$SkinTextureCallback;)Lnet/minecraft/resources/ResourceLocation;",
            cancellable = true)
    protected void filterCapes(MinecraftProfileTexture texture, MinecraftProfileTexture.Type type, SkinManager.SkinTextureCallback callback, CallbackInfoReturnable<ResourceLocation> info) {
        if (type == MinecraftProfileTexture.Type.CAPE || type == MinecraftProfileTexture.Type.ELYTRA) {
            if (texture.getUrl().equals("http://textures.minecraft.net/texture/a2e8d97ec79100e90a75d369d1b3ba81273c4f82bc1b737e934eed4a854be1b6") && !NoCapesConfig.minecon2012CapeShown()) {
                //System.out.printf("DEBUG");
                info.cancel();
            }
        }
    }
}