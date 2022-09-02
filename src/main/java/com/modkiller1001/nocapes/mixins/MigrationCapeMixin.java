package com.modkiller1001.nocapes.mixins;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.resources.ResourceLocation;

import com.modkiller1001.nocapes.config.NoCapesConfig;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SkinManager.class)
public abstract class MigrationCapeMixin {
    @Inject(
            at = @At("HEAD"),
            method = "registerTexture(Lcom/mojang/authlib/minecraft/MinecraftProfileTexture;Lcom/mojang/authlib/minecraft/MinecraftProfileTexture$Type;Lnet/minecraft/client/resources/SkinManager$SkinTextureCallback;)Lnet/minecraft/resources/ResourceLocation;",
            cancellable = true)
    protected void filterCapes(MinecraftProfileTexture texture, MinecraftProfileTexture.Type type, SkinManager.SkinTextureCallback callback, CallbackInfoReturnable<ResourceLocation> info) {
        if (type == MinecraftProfileTexture.Type.CAPE || type == MinecraftProfileTexture.Type.ELYTRA) {
            if (texture.getUrl().equals("http://textures.minecraft.net/texture/2340c0e03dd24a11b15a8b33c2a7e9e32abb2051b2481d0ba7defd635ca7a933") && !NoCapesConfig.migratorCapeShown()) {
                //System.out.printf("DEBUG");
                info.cancel();
            }
        }
    }
}