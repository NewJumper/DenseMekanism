package com.newjumper.densemekanism;

import com.newjumper.densemekanism.content.DenseBlocks;
import com.newjumper.densemekanism.datagen.assets.DenseMekBlockStateProvider;
import com.newjumper.densemekanism.datagen.assets.DenseMekItemModelProvider;
import com.newjumper.densemekanism.datagen.assets.ENLanguageProvider;
import com.newjumper.densemekanism.datagen.data.DenseMekBlockTagsProvider;
import com.newjumper.densemekanism.datagen.data.DenseMekItemTagsProvider;
import com.newjumper.densemekanism.world.DenseConfiguredFeatures;
import com.newjumper.densemekanism.world.DensePlacedFeatures;
import net.minecraft.data.DataGenerator;
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

        DenseBlocks.BLOCKS.register(eventBus);
        DenseConfiguredFeatures.CONFIGURED_FEATURES.register(eventBus);
        DensePlacedFeatures.PLACED_FEATURES.register(eventBus);
        DenseBlocks.ITEMS.register(eventBus);

        eventBus.addListener(this::generateData);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void generateData(final GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();

        // assets
        generator.addProvider(event.includeClient(), new DenseMekBlockStateProvider(generator, fileHelper));
        generator.addProvider(event.includeClient(), new DenseMekItemModelProvider(generator, fileHelper));
        generator.addProvider(event.includeClient(), new ENLanguageProvider(generator));

        // data
        DenseMekBlockTagsProvider blockTags = new DenseMekBlockTagsProvider(generator, fileHelper);
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new DenseMekItemTagsProvider(generator, blockTags, fileHelper));

//        generator.addProvider(event.includeServer(), new DenseMekLootTableProvider(generator));
    }
}
