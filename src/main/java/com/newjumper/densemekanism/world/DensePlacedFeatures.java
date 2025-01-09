package com.newjumper.densemekanism.world;

import com.newjumper.densemekanism.DenseMekanism;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class DensePlacedFeatures {
    public static final ResourceKey<PlacedFeature> DENSE_FLUORITE = create("dense_fluorite");
    public static final ResourceKey<PlacedFeature> DENSE_FLUORITE_BURIED = create("dense_fluorite_buried");
    public static final ResourceKey<PlacedFeature> DENSE_LEAD = create("dense_lead");
    public static final ResourceKey<PlacedFeature> DENSE_OSMIUM_UPPER = create("dense_osmium_upper");
    public static final ResourceKey<PlacedFeature> DENSE_OSMIUM_MIDDLE = create("dense_osmium_middle");
    public static final ResourceKey<PlacedFeature> DENSE_OSMIUM_SMALL = create("dense_osmium_small");
    public static final ResourceKey<PlacedFeature> DENSE_TIN_SMALL = create("dense_tin_small");
    public static final ResourceKey<PlacedFeature> DENSE_TIN_LARGE = create("dense_tin_large");
    public static final ResourceKey<PlacedFeature> DENSE_URANIUM_BURIED = create("dense_uranium_buried");
    public static final ResourceKey<PlacedFeature> DENSE_URANIUM_SMALL = create("dense_uranium_small");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);

        PlacementUtils.register(context, DENSE_FLUORITE, features.getOrThrow(DenseConfiguredFeatures.ORE_DENSE_FLUORITE), countPlacement(5, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(23))));
        PlacementUtils.register(context, DENSE_FLUORITE_BURIED, features.getOrThrow(DenseConfiguredFeatures.ORE_DENSE_FLUORITE_BURIED), countPlacement(3, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(4))));
        PlacementUtils.register(context, DENSE_LEAD, features.getOrThrow(DenseConfiguredFeatures.ORE_DENSE_LEAD), countPlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-24), VerticalAnchor.absolute(64))));
        PlacementUtils.register(context, DENSE_OSMIUM_UPPER, features.getOrThrow(DenseConfiguredFeatures.ORE_DENSE_OSMIUM_UPPER), countPlacement(65, HeightRangePlacement.triangle(VerticalAnchor.absolute(72), VerticalAnchor.belowTop(-24))));
        PlacementUtils.register(context, DENSE_OSMIUM_MIDDLE, features.getOrThrow(DenseConfiguredFeatures.ORE_DENSE_OSMIUM_MIDDLE), countPlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(56))));
        PlacementUtils.register(context, DENSE_OSMIUM_SMALL, features.getOrThrow(DenseConfiguredFeatures.ORE_DENSE_OSMIUM_SMALL), countPlacement(8, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64))));
        PlacementUtils.register(context, DENSE_TIN_SMALL, features.getOrThrow(DenseConfiguredFeatures.ORE_DENSE_TIN_SMALL), countPlacement(14, HeightRangePlacement.triangle(VerticalAnchor.absolute(-20), VerticalAnchor.absolute(94))));
        PlacementUtils.register(context, DENSE_TIN_LARGE, features.getOrThrow(DenseConfiguredFeatures.ORE_DENSE_TIN_LARGE), countPlacement(12, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(72))));
        PlacementUtils.register(context, DENSE_URANIUM_BURIED, features.getOrThrow(DenseConfiguredFeatures.ORE_DENSE_URANIUM_BURIED), countPlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-24), VerticalAnchor.aboveBottom(56))));
        PlacementUtils.register(context, DENSE_URANIUM_SMALL, features.getOrThrow(DenseConfiguredFeatures.ORE_DENSE_URANIUM_SMALL), countPlacement(4, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(8))));
    }

    private static List<PlacementModifier> countPlacement(int attempts, PlacementModifier heightRange) {
        return List.of(CountPlacement.of(attempts), InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    private static ResourceKey<PlacedFeature> create(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(DenseMekanism.MOD_ID, name));
    }
}
