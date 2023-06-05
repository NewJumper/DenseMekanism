package com.newjumper.densemekanism.world;

import com.google.common.base.Suppliers;
import com.newjumper.densemekanism.DenseMekanism;
import com.newjumper.densemekanism.content.DenseBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Supplier;

public class DenseConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, DenseMekanism.MOD_ID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> DENSE_FLUORITE_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, DenseBlocks.DENSE_FLUORITE_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, DenseBlocks.DENSE_DEEPSLATE_FLUORITE_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> DENSE_LEAD_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, DenseBlocks.DENSE_LEAD_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, DenseBlocks.DENSE_DEEPSLATE_LEAD_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> DENSE_OSMIUM_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, DenseBlocks.DENSE_OSMIUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, DenseBlocks.DENSE_DEEPSLATE_OSMIUM_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> DENSE_TIN_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, DenseBlocks.DENSE_TIN_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, DenseBlocks.DENSE_DEEPSLATE_TIN_ORE.get().defaultBlockState())));
    public static final Supplier<List<OreConfiguration.TargetBlockState>> DENSE_URANIUM_TARGET_LIST = Suppliers.memoize(() -> List.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, DenseBlocks.DENSE_URANIUM_ORE.get().defaultBlockState()), OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, DenseBlocks.DENSE_DEEPSLATE_URANIUM_ORE.get().defaultBlockState())));

    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_DENSE_FLUORITE = CONFIGURED_FEATURES.register("ore_dense_fluorite", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DENSE_FLUORITE_TARGET_LIST.get(), 5)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_DENSE_FLUORITE_BURIED = CONFIGURED_FEATURES.register("ore_dense_fluorite_buried", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DENSE_FLUORITE_TARGET_LIST.get(), 6, 1)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_DENSE_LEAD = CONFIGURED_FEATURES.register("ore_dense_lead", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DENSE_LEAD_TARGET_LIST.get(), 6, 0.5f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_DENSE_OSMIUM_UPPER = CONFIGURED_FEATURES.register("ore_dense_osmium_upper", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DENSE_OSMIUM_TARGET_LIST.get(), 5, 0.4f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_DENSE_OSMIUM_MIDDLE = CONFIGURED_FEATURES.register("ore_dense_osmium_middle", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DENSE_OSMIUM_TARGET_LIST.get(), 6, 0.3f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_DENSE_OSMIUM_SMALL = CONFIGURED_FEATURES.register("ore_dense_osmium_small", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DENSE_OSMIUM_TARGET_LIST.get(), 4)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_DENSE_TIN_SMALL = CONFIGURED_FEATURES.register("ore_dense_tin_small", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DENSE_TIN_TARGET_LIST.get(), 4)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_DENSE_TIN_LARGE = CONFIGURED_FEATURES.register("ore_dense_tin_large", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DENSE_TIN_TARGET_LIST.get(), 6, 0.2f)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_DENSE_URANIUM_BURIED = CONFIGURED_FEATURES.register("ore_dense_uranium_buried", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DENSE_URANIUM_TARGET_LIST.get(), 4, 1)));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ORE_DENSE_URANIUM_SMALL = CONFIGURED_FEATURES.register("ore_dense_uranium_small", () -> new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(DENSE_URANIUM_TARGET_LIST.get(), 6, 0.2f)));
}
