package com.newjumper.densemekanism.world;

import com.newjumper.densemekanism.DenseMekanism;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class DensePlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, DenseMekanism.MOD_ID);

    public static final RegistryObject<PlacedFeature> DENSE_FLUORITE = PLACED_FEATURES.register("dense_fluorite", () -> new PlacedFeature(DenseConfiguredFeatures.ORE_DENSE_FLUORITE.getHolder().get(), commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(23)))));
    public static final RegistryObject<PlacedFeature> DENSE_FLUORITE_BURIED = PLACED_FEATURES.register("dense_fluorite_buried", () -> new PlacedFeature(DenseConfiguredFeatures.ORE_DENSE_FLUORITE_BURIED.getHolder().get(), commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(4)))));
    public static final RegistryObject<PlacedFeature> DENSE_LEAD = PLACED_FEATURES.register("dense_lead", () -> new PlacedFeature(DenseConfiguredFeatures.ORE_DENSE_LEAD.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-24), VerticalAnchor.absolute(64)))));
    public static final RegistryObject<PlacedFeature> DENSE_OSMIUM_UPPER = PLACED_FEATURES.register("dense_osmium_upper", () -> new PlacedFeature(DenseConfiguredFeatures.ORE_DENSE_OSMIUM_UPPER.getHolder().get(), commonOrePlacement(65, HeightRangePlacement.triangle(VerticalAnchor.absolute(72), VerticalAnchor.belowTop(-24)))));
    public static final RegistryObject<PlacedFeature> DENSE_OSMIUM_MIDDLE = PLACED_FEATURES.register("dense_osmium_middle", () -> new PlacedFeature(DenseConfiguredFeatures.ORE_DENSE_OSMIUM_MIDDLE.getHolder().get(), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(56)))));
    public static final RegistryObject<PlacedFeature> DENSE_OSMIUM_SMALL = PLACED_FEATURES.register("dense_osmium_small", () -> new PlacedFeature(DenseConfiguredFeatures.ORE_DENSE_OSMIUM_SMALL.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(64)))));
    public static final RegistryObject<PlacedFeature> DENSE_TIN_SMALL = PLACED_FEATURES.register("dense_tin_small", () -> new PlacedFeature(DenseConfiguredFeatures.ORE_DENSE_TIN_SMALL.getHolder().get(), commonOrePlacement(14, HeightRangePlacement.triangle(VerticalAnchor.absolute(-20), VerticalAnchor.absolute(94)))));
    public static final RegistryObject<PlacedFeature> DENSE_TIN_LARGE = PLACED_FEATURES.register("dense_tin_large", () -> new PlacedFeature(DenseConfiguredFeatures.ORE_DENSE_TIN_LARGE.getHolder().get(), commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(72)))));
    public static final RegistryObject<PlacedFeature> DENSE_URANIUM_BURIED = PLACED_FEATURES.register("dense_uranium_buried", () -> new PlacedFeature(DenseConfiguredFeatures.ORE_DENSE_URANIUM_BURIED.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-24), VerticalAnchor.aboveBottom(56)))));
    public static final RegistryObject<PlacedFeature> DENSE_URANIUM_SMALL = PLACED_FEATURES.register("dense_uranium_small", () -> new PlacedFeature(DenseConfiguredFeatures.ORE_DENSE_URANIUM_SMALL.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(8)))));

    public static List<PlacementModifier> orePlacement(PlacementModifier pModifier, PlacementModifier pHeightRange) {
        return List.of(pModifier, InSquarePlacement.spread(), pHeightRange, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int pAttempts, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pAttempts), pHeightRange);
    }
}
