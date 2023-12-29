package com.newjumper.densemekanism.world;

import com.newjumper.densemekanism.DenseMekanism;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class DenseBiomeModifiers {
    public static final ResourceKey<BiomeModifier> DENSE_FLUORITE = createKey("dense_fluorite");
    public static final ResourceKey<BiomeModifier> DENSE_FLUORITE_BURIED = createKey("dense_fluorite_buried");
    public static final ResourceKey<BiomeModifier> DENSE_LEAD = createKey("dense_lead");
    public static final ResourceKey<BiomeModifier> DENSE_OSMIUM_UPPER = createKey("dense_osmium_upper");
    public static final ResourceKey<BiomeModifier> DENSE_OSMIUM_MIDDLE = createKey("dense_osmium_middle");
    public static final ResourceKey<BiomeModifier> DENSE_OSMIUM_SMALL = createKey("dense_osmium_small");
    public static final ResourceKey<BiomeModifier> DENSE_TIN_SMALL = createKey("dense_tin_small");
    public static final ResourceKey<BiomeModifier> DENSE_TIN_LARGE = createKey("dense_tin_large");
    public static final ResourceKey<BiomeModifier> DENSE_URANIUM_BURIED = createKey("dense_uranium_buried");
    public static final ResourceKey<BiomeModifier> DENSE_URANIUM_SMALL = createKey("dense_uranium_small");

    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(DENSE_FLUORITE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_FLUORITE)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_FLUORITE_BURIED, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_FLUORITE_BURIED)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_LEAD, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_LEAD)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_OSMIUM_UPPER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_OSMIUM_UPPER)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_OSMIUM_MIDDLE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_OSMIUM_MIDDLE)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_OSMIUM_SMALL, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_OSMIUM_SMALL)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_TIN_SMALL, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_TIN_SMALL)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_TIN_LARGE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_TIN_LARGE)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_URANIUM_BURIED, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_URANIUM_BURIED)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_URANIUM_SMALL, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_URANIUM_SMALL)), GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    public static ResourceKey<BiomeModifier> createKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(DenseMekanism.MOD_ID, name));
    }
}
