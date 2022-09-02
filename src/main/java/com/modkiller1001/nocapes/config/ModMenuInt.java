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

			freecapes.addEntry(entryBuilder.startTextDescription(Component.translatable("nocapes.options.info.relog")).build());

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

			mineconcapes.addEntry(entryBuilder.startTextDescription(Component.translatable("nocapes.options.info.relog")).build());

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

			mojangcapes.addEntry(entryBuilder.startTextDescription(Component.translatable("nocapes.options.info.relog")).build());

			mojangcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.mojangstudios"), NoCapesConfig.getInstance().mojangstudiosCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().mojangstudiosCapeShown = newValue)
					.build());

			mojangcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.mojang"), NoCapesConfig.getInstance().mojangCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().mojangCapeShown = newValue)
					.build());

			mojangcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.mojangclassic"), NoCapesConfig.getInstance().mojangclassicCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().mojangclassicCapeShown = newValue)
					.build());

			//REWARD CAPES SECTION

			ConfigCategory rewardcapes = builder.getOrCreateCategory(Component.translatable("nocapes.options.category.rewardcapes"));

			rewardcapes.addEntry(entryBuilder.startTextDescription(Component.translatable("nocapes.options.info.relog")).build());

			rewardcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.scrollschamp"), NoCapesConfig.getInstance().scrollschampCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().scrollschampCapeShown = newValue)
					.build());

			rewardcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.cobalt"), NoCapesConfig.getInstance().cobaltCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().cobaltCapeShown = newValue)
					.build());

			rewardcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.mojiramoderator"), NoCapesConfig.getInstance().mojiramoderatorCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().mojiramoderatorCapeShown = newValue)
					.build());

			rewardcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.mapmaker"), NoCapesConfig.getInstance().mapmakerCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().mapmakerCapeShown = newValue)
					.build());

			rewardcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.translator"), NoCapesConfig.getInstance().translatorCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().translatorCapeShown = newValue)
					.build());

			rewardcapes.addEntry(entryBuilder.startBooleanToggle(
					Component.translatable("nocapes.cape.translatorchinese"), NoCapesConfig.getInstance().translatorchineseCapeShown)
					.setDefaultValue(true)
					.setSaveConsumer(newValue -> NoCapesConfig.getInstance().translatorchineseCapeShown = newValue)
					.build());

			builder.setSavingRunnable(() -> {
					NoCapesConfig.saveConfig();
					NoCapesConfig.loadConfig();
			});
			return builder.build();
		};
	}
}