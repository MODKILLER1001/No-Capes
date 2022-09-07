package com.modkiller1001.nocapes;

import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.modkiller1001.nocapes.config.NoCapesConfig;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;
import java.util.UUID;

public class NoCapes implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final ResourceLocation CHANNEL = new ResourceLocation("nocapes", "sync");

	// Cache each player and their capes, so we don't constantly have to make requests
	private static final Map<UUID, String> CACHED_CAPES = Maps.newHashMap();

	@Override
	public void onInitialize() {
		LOGGER.info("NoCapes!!!");

		NoCapesConfig.loadConfig();
	}

	// Gets the cape URL from cache, if not cached, fetch it
	public static String getCapeURL(GameProfile profile) {
		// Get the value from the cached profiles
		UUID id = profile.getId();
		String capeUrl = CACHED_CAPES.get(id);

		// If the value is not cached, fetch it
		if (capeUrl == null) {
			// Get the cape texture of the current player
			Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> map = Maps.newHashMap();
			map.putAll(Minecraft.getInstance().getMinecraftSessionService().getTextures(profile, false));
			MinecraftProfileTexture capeTexture = map.get(MinecraftProfileTexture.Type.CAPE);

			// Set value based on null
			capeUrl = capeTexture == null ? "" : capeTexture.getUrl();

			CACHED_CAPES.put(id, capeUrl);
		}

		return capeUrl;
	}

	public static boolean shouldRenderCape(String capeUrl) {
		// If after fetching, it is empty, it means this player has no cape
		if (capeUrl.equals("")) {
			return false;
		}

		// Check for each blacklisted cape, this could be turned into an iterable list
		// Somewhat big switch statement
		switch (capeUrl) {
			// The cobalt cape
			case "http://textures.minecraft.net/texture/ca35c56efe71ed290385f4ab5346a1826b546a54d519e6a3ff01efa01acce81" -> {
				return NoCapesConfig.cobaltCapeShown();
			}

			// Migrator cape
			case "http://textures.minecraft.net/texture/2340c0e03dd24a11b15a8b33c2a7e9e32abb2051b2481d0ba7defd635ca7a933" -> {
				return NoCapesConfig.migratorCapeShown();
			}

			// Minecon2011 cape
			case "http://textures.minecraft.net/texture/953cac8b779fe41383e675ee2b86071a71658f2180f56fbce8aa315ea70e2ed6" -> {
				return NoCapesConfig.minecon2011CapeShown();
			}

			// Minecon2012 cape
			case "http://textures.minecraft.net/texture/a2e8d97ec79100e90a75d369d1b3ba81273c4f82bc1b737e934eed4a854be1b6" -> {
				return NoCapesConfig.minecon2012CapeShown();
			}

			// Minecon2013 cape
			case "http://textures.minecraft.net/texture/153b1a0dfcbae953cdeb6f2c2bf6bf79943239b1372780da44bcbb29273131da" -> {
				return NoCapesConfig.minecon2013CapeShown();
			}

			// Minecon2015 cape
			case "http://textures.minecraft.net/texture/b0cc08840700447322d953a02b965f1d65a13a603bf64b17c803c21446fe1635" -> {
				return NoCapesConfig.minecon2015CapeShown();
			}

			// Minecon2016 cape
			case "http://textures.minecraft.net/texture/e7dfea16dc83c97df01a12fabbd1216359c0cd0ea42f9999b6e97c584963e980" -> {
				return NoCapesConfig.minecon2016CapeShown();
			}

			// Mojang cape
			case "http://textures.minecraft.net/texture/5786fe99be377dfb6858859f926c4dbc995751e91cee373468c5fbf4865e7151" -> {
				return NoCapesConfig.mojangCapeShown();
			}

			// Mojang classic cape
			case "http://textures.minecraft.net/texture/8f120319222a9f4a104e2f5cb97b2cda93199a2ee9e1585cb8d09d6f687cb761" -> {
				return NoCapesConfig.mojangClassicCapeShown();
			}

			// Mojang studios cape
			case "http://textures.minecraft.net/texture/9e507afc56359978a3eb3e32367042b853cddd0995d17d0da995662913fb00f7" -> {
				return NoCapesConfig.mojangStudiosCapeShown();
			}

			// Mojira moderator cape
			case "http://textures.minecraft.net/texture/ae677f7d98ac70a533713518416df4452fe5700365c09cf45d0d156ea9396551" -> {
				return NoCapesConfig.mojiraModeratorCapeShown();
			}

			// Realms mapmaker cape
			case "http://textures.minecraft.net/texture/17912790ff164b93196f08ba71d0e62129304776d0f347334f8a6eae509f8a56" -> {
				return NoCapesConfig.realmsMapmakerCapeShown();
			}

			// Scrolls champ cape
			case "http://textures.minecraft.net/texture/3efadf6510961830f9fcc077f19b4daf286d502b5f5aafbd807c7bbffcaca245" -> {
				return NoCapesConfig.scrollsChampCapeShown();
			}

			// Translator cape
			case "http://textures.minecraft.net/texture/1bf91499701404e21bd46b0191d63239a4ef76ebde88d27e4d430ac211df681e" -> {
				return NoCapesConfig.translatorCapeShown();
			}

			// Chinese translator cape
			case "http://textures.minecraft.net/texture/2262fb1d24912209490586ecae98aca8500df3eff91f2a07da37ee524e7e3cb6" -> {
				return NoCapesConfig.translatorChineseCapeShown();
			}

			// Japanese translator cape
			case "http://textures.minecraft.net/texture/ca29f5dd9e94fb1748203b92e36b66fda80750c87ebc18d6eafdb0e28cc1d05f" -> {
				return NoCapesConfig.translatorJapaneseCapeShown();
			}

			// Vanilla cape
			case "http://textures.minecraft.net/texture/f9a76537647989f9a0b6d001e320dac591c359e9e61a31f4ce11c88f207f0ad4" -> {
				return NoCapesConfig.vanillaCapeShown();
			}

			default -> { return true; }
		}
	}
}