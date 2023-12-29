package com.newjumper.densemekanism;

import com.newjumper.densemekanism.content.DenseBlocks;
import com.newjumper.densemekanism.content.DenseMekanismCreativeTab;
import com.newjumper.densemekanism.datagen.assets.DenseMekBlockStateProvider;
import com.newjumper.densemekanism.datagen.assets.DenseMekItemModelProvider;
import com.newjumper.densemekanism.datagen.assets.ENLanguageProvider;
import com.newjumper.densemekanism.datagen.data.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DenseMekanism.MOD_ID)
public class DenseMekanism {
    public static final String MOD_ID = "densemekanism";

    public DenseMekanism() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        DenseMekanismCreativeTab.CREATIVE_MODE_TABS.register(eventBus);
        DenseBlocks.BLOCKS.register(eventBus);
        DenseBlocks.ITEMS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
        eventBus.addListener(DenseMekanismCreativeTab::buildCreativeTab);
        eventBus.addListener(this::generateData);
    }

    public void generateData(final GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        // assets
        generator.addProvider(event.includeClient(), new DenseMekBlockStateProvider(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new DenseMekItemModelProvider(packOutput, fileHelper));
        generator.addProvider(event.includeClient(), new ENLanguageProvider(packOutput));

        // data
        DenseMekBlockTagsProvider blockTags = new DenseMekBlockTagsProvider(packOutput, event.getLookupProvider(), fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new DenseMekItemTagsProvider(packOutput, event.getLookupProvider(), blockTags, fileHelper));

        generator.addProvider(event.includeServer(), new DenseMekRegistriesGenerator(packOutput, event.getLookupProvider()));
        generator.addProvider(event.includeServer(), new DenseMekLootTableProvider(packOutput));
        generator.addProvider(event.includeServer(), new SmeltingRecipesProvider(packOutput));
    }
}
