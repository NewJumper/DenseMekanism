package com.newjumper.densemekanism.world;

import com.newjumper.densemekanism.DenseMekanism;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class DenseBiomeModifiers {
    public static final ResourceKey<BiomeModifier> DENSE_FLUORITE = create("dense_fluorite");
    public static final ResourceKey<BiomeModifier> DENSE_FLUORITE_BURIED = create("dense_fluorite_buried");
    public static final ResourceKey<BiomeModifier> DENSE_LEAD = create("dense_lead");
    public static final ResourceKey<BiomeModifier> DENSE_OSMIUM_UPPER = create("dense_osmium_upper");
    public static final ResourceKey<BiomeModifier> DENSE_OSMIUM_MIDDLE = create("dense_osmium_middle");
    public static final ResourceKey<BiomeModifier> DENSE_OSMIUM_SMALL = create("dense_osmium_small");
    public static final ResourceKey<BiomeModifier> DENSE_TIN_SMALL = create("dense_tin_small");
    public static final ResourceKey<BiomeModifier> DENSE_TIN_LARGE = create("dense_tin_large");
    public static final ResourceKey<BiomeModifier> DENSE_URANIUM_BURIED = create("dense_uranium_buried");
    public static final ResourceKey<BiomeModifier> DENSE_URANIUM_SMALL = create("dense_uranium_small");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(DENSE_FLUORITE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_FLUORITE)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_FLUORITE_BURIED, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_FLUORITE_BURIED)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_LEAD, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_LEAD)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_OSMIUM_UPPER, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_OSMIUM_UPPER)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_OSMIUM_MIDDLE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_OSMIUM_MIDDLE)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_OSMIUM_SMALL, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_OSMIUM_SMALL)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_TIN_SMALL, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_TIN_SMALL)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_TIN_LARGE, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_TIN_LARGE)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_URANIUM_BURIED, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_URANIUM_BURIED)), GenerationStep.Decoration.UNDERGROUND_ORES));
        context.register(DENSE_URANIUM_SMALL, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(BiomeTags.IS_OVERWORLD), HolderSet.direct(placedFeatures.getOrThrow(DensePlacedFeatures.DENSE_URANIUM_SMALL)), GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    public static ResourceKey<BiomeModifier> create(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(DenseMekanism.MOD_ID, name));
    }
}
