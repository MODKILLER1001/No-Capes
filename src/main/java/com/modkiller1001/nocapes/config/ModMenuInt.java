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

			//FREE CAPES SECTION

			ConfigCategory freecapes = builder.getOrCreateCategory(Component.translatable("nocapes.options.category.freecapes"));

			freecapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.vanilla"), NoCapesConfig.getInstance().vanillaCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().vanillaCapeShown = newValue)
					.build());

			freecapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.migrator"), NoCapesConfig.getInstance().migratorCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().migratorCapeShown = newValue)
					.build());

			//MINECON CAPES SECTION

			ConfigCategory mineconcapes = builder.getOrCreateCategory(Component.translatable("nocapes.options.category.mineconcapes"));

			mineconcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.minecon2011"), NoCapesConfig.getInstance().minecon2011CapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().minecon2011CapeShown = newValue)
					.build());

			mineconcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.minecon2012"), NoCapesConfig.getInstance().minecon2012CapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().minecon2012CapeShown = newValue)
					.build());

			mineconcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.minecon2013"), NoCapesConfig.getInstance().minecon2013CapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().minecon2013CapeShown = newValue)
					.build());

			mineconcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.minecon2015"), NoCapesConfig.getInstance().minecon2015CapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().minecon2015CapeShown = newValue)
					.build());

			mineconcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.minecon2016"), NoCapesConfig.getInstance().minecon2016CapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().minecon2016CapeShown = newValue)
					.build());

			//MOJANG CAPES SECTION

			ConfigCategory mojangcapes = builder.getOrCreateCategory(Component.translatable("nocapes.options.category.mojangcapes"));

			mojangcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.mojangStudios"), NoCapesConfig.getInstance().mojangStudiosCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().mojangStudiosCapeShown = newValue)
					.build());

			mojangcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.mojang"), NoCapesConfig.getInstance().mojangCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().mojangCapeShown = newValue)
					.build());

			mojangcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.mojangClassic"), NoCapesConfig.getInstance().mojangClassicCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().mojangClassicCapeShown = newValue)
					.build());

			//REWARD CAPES SECTION

			ConfigCategory rewardcapes = builder.getOrCreateCategory(Component.translatable("nocapes.options.category.rewardcapes"));

			rewardcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.scrollsChamp"), NoCapesConfig.getInstance().scrollsChampCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().scrollsChampCapeShown = newValue)
					.build());

			rewardcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.cobalt"), NoCapesConfig.getInstance().cobaltCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().cobaltCapeShown = newValue)
					.build());

			rewardcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.mojiraModerator"), NoCapesConfig.getInstance().mojiraModeratorCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().mojiraModeratorCapeShown = newValue)
					.build());

			rewardcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.realmsMapmaker"), NoCapesConfig.getInstance().realmsMapmakerCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().realmsMapmakerCapeShown = newValue)
					.build());

			rewardcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.translator"), NoCapesConfig.getInstance().translatorCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().translatorCapeShown = newValue)
					.build());

			rewardcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.translatorChinese"), NoCapesConfig.getInstance().translatorChineseCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().translatorChineseCapeShown = newValue)
					.build());

			rewardcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.translatorJapanese"), NoCapesConfig.getInstance().translatorJapaneseCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().translatorJapaneseCapeShown = newValue)
					.build());

			builder.setSavingRunnable(() -> {
					NoCapesConfig.saveConfig();
					NoCapesConfig.loadConfig();
			});
			return builder.build();
		};
	}
}