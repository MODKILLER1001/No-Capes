package com.modkiller1001.nocapes.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;

import net.minecraft.network.chat.Component;

public class ModMenuInt implements ModMenuApi {
    @Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return parent -> {
			ConfigBuilder builder = ConfigBuilder.create()
				.setParentScreen(parent)
				.setTitle(Component.translatable("nocapes.options"));
			ConfigEntryBuilder entryBuilder = builder.entryBuilder();

			ConfigCategory general = builder.getOrCreateCategory(Component.translatable("nocapes.options.category.general"));

			general.addEntry(entryBuilder.startTextDescription(Component.translatable("nocapes.options.info.relog")).build());
			
			general.addEntry(entryBuilder.startBooleanToggle(
				Component.translatable("nocapes.cape.vanilla"), NoCapesConfig.getInstance().vanillaCapeShown)
				.setDefaultValue(false)
				.setSaveConsumer(newValue -> NoCapesConfig.getInstance().vanillaCapeShown = newValue)
				.build());

			general.addEntry(entryBuilder.startBooleanToggle(
				Component.translatable("nocapes.cape.migrator"), NoCapesConfig.getInstance().migratorCapeShown)
				.setDefaultValue(false)
				.setSaveConsumer(newValue -> NoCapesConfig.getInstance().migratorCapeShown = newValue)
				.build());

			builder.setSavingRunnable(() -> {
					NoCapesConfig.saveConfig();
					NoCapesConfig.loadConfig();
			});
			return builder.build();
		};
	}
}