package com.newjumper.densemekanism.datagen.data;

import com.newjumper.densemekanism.DenseMekanism;
import com.newjumper.densemekanism.world.DenseBiomeModifiers;
import com.newjumper.densemekanism.world.DenseConfiguredFeatures;
import com.newjumper.densemekanism.world.DensePlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DenseMekRegistriesGenerator extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, DenseBiomeModifiers::bootstrap)
            .add(Registries.CONFIGURED_FEATURE, DenseConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, DensePlacedFeatures::bootstrap);

    public DenseMekRegistriesGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(DenseMekanism.MOD_ID));
    }
}
