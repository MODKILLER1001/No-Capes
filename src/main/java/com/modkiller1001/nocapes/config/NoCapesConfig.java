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
        protected boolean
				vanillaCapeShown = true,
				migratorCapeShown = true,
				minecon2011CapeShown = true,
				minecon2012CapeShown = true,
				minecon2013CapeShown = true,
				minecon2015CapeShown = true,
				minecon2016CapeShown = true,
				mojangstudiosCapeShown = true,
				mojangCapeShown = true,
				mojangclassicCapeShown = true,
				scrollschampCapeShown = true,
				cobaltCapeShown = true,
				mojiramoderatorCapeShown = true,
				mapmakerCapeShown = true,
				translatorchineseCapeShown = true,
				translatorCapeShown = true;

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
	 * This is true by default.
	 */

	public static boolean vanillaCapeShown() {
		return getInstance().vanillaCapeShown;
	}

	/**
	 * @return True if migrator cape should be shown.
	 *
	 * This is true by default.
	 */

	public static boolean migratorCapeShown() {
		return getInstance().migratorCapeShown;
	}

	/**
	 * @return True if minecon 2011 cape should be shown.
	 *
	 * This is true by default.
	 */

	public static boolean minecon2011CapeShown() {
		return getInstance().minecon2011CapeShown;
	}

	/**
	 * @return True if minecon 2012 cape should be shown.
	 *
	 * This is true by default.
	 */

	public static boolean minecon2012CapeShown() {
		return getInstance().minecon2012CapeShown;
	}

	/**
	 * @return True if minecon 2013 cape should be shown.
	 *
	 * This is true by default.
	 */

	public static boolean minecon2013CapeShown() {
		return getInstance().minecon2013CapeShown;
	}

	/**
	 * @return True if minecon 2015 cape should be shown.
	 *
	 * This is true by default.
	 */

	public static boolean minecon2015CapeShown() {
		return getInstance().minecon2015CapeShown;
	}

	/**
	 * @return True if minecon 2016 cape should be shown.
	 *
	 * This is true by default.
	 */

	public static boolean minecon2016CapeShown() {
		return getInstance().minecon2016CapeShown;
	}

	/**
	 * @return True if mojang studios cape should be shown.
	 *
	 * This is true by default.
	 */

	public static boolean mojangstudiosCapeShown() {
		return getInstance().mojangstudiosCapeShown;
	}

	/**
	 * @return True if mojang cape should be shown.
	 * This cape is the one before mojang studios and it is red/orange
	 *
	 * This is true by default.
	 */

	public static boolean mojangCapeShown() {
		return getInstance().mojangCapeShown;
	}

	/**
	 * @return True if mojang classic cape should be shown.
	 *
	 * This is true by default.
	 */

	public static boolean mojangclassicCapeShown() {
		return getInstance().mojangclassicCapeShown;
	}

	/**
	 * @return True if scrolls champ cape should be shown.
	 *
	 * This is true by default.
	 */

	public static boolean scrollschampCapeShown() {
		return getInstance().scrollschampCapeShown;
	}

	/**
	 * @return True if cobalt cape should be shown.
	 *
	 * This is true by default.
	 */

	public static boolean cobaltCapeShown() {
		return getInstance().cobaltCapeShown;
	}

	/**
	 * @return True if mojira moderator cape should be shown.
	 *
	 * This is true by default.
	 */

	public static boolean mojiramoderatorCapeShown() {
		return getInstance().mojiramoderatorCapeShown;
	}

	/**
	 * @return True if map maker cape should be shown.
	 *
	 * This is true by default.
	 */

	public static boolean mapmakerCapeShown() {
		return getInstance().mapmakerCapeShown;
	}

	/**
	 * @return True if translator cape should be shown.
	 *
	 * This is true by default.
	 */

	public static boolean translatorCapeShown() {
		return getInstance().translatorCapeShown;
	}

	/**
	 * @return True if translator chinese cape should be shown.
	 *
	 * This is true by default.
	 */

	public static boolean translatorchineseCapeShown() {
		return getInstance().translatorchineseCapeShown;
	}
}