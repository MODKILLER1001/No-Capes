package com.modkiller1001.nocapes.config;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.annotation.Nullable;

import com.modkiller1001.nocapes.NoCapes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.fabricmc.loader.api.FabricLoader;

public class NoCapesConfig {
        private static final Path CONFIG_FILE = FabricLoader.getInstance().getConfigDir().resolve("NoCapes.json");
        private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        private static NoCapesConfig INSTANCE;
        protected boolean vanillaCapeShown = false, migratorCapeShown = false;

        protected static NoCapesConfig getInstance() {
            if (INSTANCE == null) {
                loadConfig();
            }
    
            return INSTANCE;
        }

        /**
	 * Loads (or reloads) the config from local file, or creates default one if that fails.
	 * Re-searializes validated {@link #INSTANCE} object back into the file.
	 */

	public static void loadConfig() {
		NoCapes.LOGGER.info(INSTANCE == null ? "Loading config..." : "Reloading config...");

		INSTANCE = readFile();

		if (INSTANCE == null) {
			INSTANCE = new NoCapesConfig();
		}

		writeFile(INSTANCE);
	}

    /**
	 * Writes current config instance into local file.
	 */

	public static void saveConfig() {
		if (INSTANCE != null) {
			writeFile(INSTANCE);
		}
	}

    @Nullable
	private static NoCapesConfig readFile() {
		if (!Files.isRegularFile(CONFIG_FILE))
			return null;

		try (BufferedReader reader = Files.newBufferedReader(CONFIG_FILE)) {
			return GSON.fromJson(reader, NoCapesConfig.class);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	private static void writeFile(NoCapesConfig instance) {
		try (BufferedWriter writer = Files.newBufferedWriter(CONFIG_FILE)) {
			GSON.toJson(instance, writer);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

    /**
	 * @return True if vanilla cape should be shown.
	 *
	 * This is false by default.
	 */

	public static boolean vanillaCapeShown() {
		return getInstance().vanillaCapeShown;
	}

	/**
	 * @return True if migrator cape should be shown.
	 *
	 * This is false by default.
	 */

	public static boolean migratorCapeShown() {
		return getInstance().migratorCapeShown;
	}

}