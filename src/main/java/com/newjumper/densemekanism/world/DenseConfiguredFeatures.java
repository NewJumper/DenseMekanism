package com.newjumper.densemekanism.world;

import com.newjumper.densemekanism.DenseMekanism;
import com.newjumper.densemekanism.content.DenseBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class DenseConfiguredFeatures {
    public static final RuleTest STONE_REPLACEABLES = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    public static final RuleTest DEEPSLATE_REPLACEABLES = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DENSE_FLUORITE = createKey("ore_dense_fluorite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DENSE_FLUORITE_BURIED = createKey("ore_dense_fluorite_buried");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DENSE_LEAD = createKey("ore_dense_lead");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DENSE_OSMIUM_UPPER = createKey("ore_dense_osmium_upper");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DENSE_OSMIUM_MIDDLE = createKey("ore_dense_osmium_middle");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DENSE_OSMIUM_SMALL = createKey("ore_dense_osmium_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DENSE_TIN_SMALL = createKey("ore_dense_tin_small");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DENSE_TIN_LARGE = createKey("ore_dense_tin_large");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DENSE_URANIUM_BURIED = createKey("ore_dense_uranium_buried");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_DENSE_URANIUM_SMALL = createKey("ore_dense_uranium_small");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        List<OreConfiguration.TargetBlockState> DENSE_FLUORITE_TARGET_LIST = List.of(OreConfiguration.target(STONE_REPLACEABLES, DenseBlocks.DENSE_FLUORITE_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, DenseBlocks.DENSE_DEEPSLATE_FLUORITE_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> DENSE_LEAD_TARGET_LIST = List.of(OreConfiguration.target(STONE_REPLACEABLES, DenseBlocks.DENSE_LEAD_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, DenseBlocks.DENSE_DEEPSLATE_LEAD_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> DENSE_OSMIUM_TARGET_LIST = List.of(OreConfiguration.target(STONE_REPLACEABLES, DenseBlocks.DENSE_OSMIUM_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, DenseBlocks.DENSE_DEEPSLATE_OSMIUM_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> DENSE_TIN_TARGET_LIST = List.of(OreConfiguration.target(STONE_REPLACEABLES, DenseBlocks.DENSE_TIN_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, DenseBlocks.DENSE_DEEPSLATE_TIN_ORE.get().defaultBlockState()));
        List<OreConfiguration.TargetBlockState> DENSE_URANIUM_TARGET_LIST = List.of(OreConfiguration.target(STONE_REPLACEABLES, DenseBlocks.DENSE_URANIUM_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_REPLACEABLES, DenseBlocks.DENSE_DEEPSLATE_URANIUM_ORE.get().defaultBlockState()));

        FeatureUtils.register(context, ORE_DENSE_FLUORITE, Feature.ORE, new OreConfiguration(DENSE_FLUORITE_TARGET_LIST, 5));
        FeatureUtils.register(context, ORE_DENSE_FLUORITE_BURIED, Feature.ORE, new OreConfiguration(DENSE_FLUORITE_TARGET_LIST, 6, 1));
        FeatureUtils.register(context, ORE_DENSE_LEAD, Feature.ORE, new OreConfiguration(DENSE_LEAD_TARGET_LIST, 6, 0.5f));
        FeatureUtils.register(context, ORE_DENSE_OSMIUM_UPPER, Feature.ORE, new OreConfiguration(DENSE_OSMIUM_TARGET_LIST, 5, 0.4f));
        FeatureUtils.register(context, ORE_DENSE_OSMIUM_MIDDLE, Feature.ORE, new OreConfiguration(DENSE_OSMIUM_TARGET_LIST, 6, 0.3f));
        FeatureUtils.register(context, ORE_DENSE_OSMIUM_SMALL, Feature.ORE, new OreConfiguration(DENSE_OSMIUM_TARGET_LIST, 4));
        FeatureUtils.register(context, ORE_DENSE_TIN_SMALL, Feature.ORE, new OreConfiguration(DENSE_TIN_TARGET_LIST, 4));
        FeatureUtils.register(context, ORE_DENSE_TIN_LARGE, Feature.ORE, new OreConfiguration(DENSE_TIN_TARGET_LIST, 6, 0.2f));
        FeatureUtils.register(context, ORE_DENSE_URANIUM_BURIED, Feature.ORE, new OreConfiguration(DENSE_URANIUM_TARGET_LIST, 4, 1));
        FeatureUtils.register(context, ORE_DENSE_URANIUM_SMALL, Feature.ORE, new OreConfiguration(DENSE_URANIUM_TARGET_LIST, 6, 0.2f));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(DenseMekanism.MOD_ID, name));
    }
}
