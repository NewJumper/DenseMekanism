package com.newjumper.densemekanism;

import com.newjumper.densemekanism.content.DenseBlocks;
import com.newjumper.densemekanism.content.DenseMekanismCreativeTab;
import com.newjumper.densemekanism.datagen.assets.DenseMekBlockStateProvider;
import com.newjumper.densemekanism.datagen.assets.DenseMekItemModelProvider;
import com.newjumper.densemekanism.datagen.assets.ENLanguageProvider;
import com.newjumper.densemekanism.datagen.data.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

@Mod(DenseMekanism.MOD_ID)
public class DenseMekanism {
    public static final String MOD_ID = "densemekanism";

    public DenseMekanism(IEventBus eventBus) {
        DenseMekanismCreativeTab.CREATIVE_MODE_TABS.register(eventBus);
        DenseBlocks.BLOCKS.register(eventBus);
        DenseBlocks.ITEMS.register(eventBus);

        eventBus.addListener(DenseMekanismCreativeTab::buildCreativeTab);
        eventBus.addListener(this::generateData);
    }

    public void generateData(final GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();

        // assets
        generator.addProvider(event.includeClient(), new DenseMekBlockStateProvider(output, fileHelper));
        generator.addProvider(event.includeClient(), new DenseMekItemModelProvider(output, fileHelper));
        generator.addProvider(event.includeClient(), new ENLanguageProvider(output));

        // data
        DenseMekBlockTagsProvider blockTags = new DenseMekBlockTagsProvider(output, lookup, fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new DenseMekItemTagsProvider(output, lookup, blockTags, fileHelper));

        generator.addProvider(event.includeServer(), new DenseMekRegistriesGenerator(output, lookup));
        generator.addProvider(event.includeServer(), new DenseMekLootTableProvider(output, lookup));
        generator.addProvider(event.includeServer(), new SmeltingRecipesProvider(output, lookup));
    }
}
