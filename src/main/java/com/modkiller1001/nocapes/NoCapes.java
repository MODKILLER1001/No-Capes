package com.modkiller1001.nocapes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.modkiller1001.nocapes.config.NoCapesConfig;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

public class NoCapes implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final ResourceLocation CHANNEL = new ResourceLocation("nocapes", "sync");

	@Override
	public void onInitialize() {
		LOGGER.info("NoCapes!!!");

		NoCapesConfig.loadConfig();
	}
}