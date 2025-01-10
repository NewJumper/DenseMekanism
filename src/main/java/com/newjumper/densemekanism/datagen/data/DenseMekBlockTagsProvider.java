package com.newjumper.densemekanism.datagen.data;

import com.newjumper.densemekanism.DenseMekanism;
import com.newjumper.densemekanism.content.DenseBlocks;
import com.newjumper.densemekanism.content.DenseMekanismTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class DenseMekBlockTagsProvider extends BlockTagsProvider {
    public DenseMekBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, DenseMekanism.MOD_ID, existingFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).addTags(DenseMekanismTags.Blocks.DENSE_STONE_ORES, DenseMekanismTags.Blocks.DENSE_DEEPSLATE_ORES);
        tag(BlockTags.NEEDS_STONE_TOOL).addTags(DenseMekanismTags.Blocks.DENSE_STONE_ORES, DenseMekanismTags.Blocks.DENSE_DEEPSLATE_ORES);

        tag(Tags.Blocks.ORES).addTags(DenseMekanismTags.Blocks.DENSE_STONE_ORES, DenseMekanismTags.Blocks.DENSE_DEEPSLATE_ORES);
        tag(Tags.Blocks.ORE_RATES_DENSE).addTags(DenseMekanismTags.Blocks.DENSE_STONE_ORES, DenseMekanismTags.Blocks.DENSE_DEEPSLATE_ORES);
        tag(Tags.Blocks.ORES_IN_GROUND_STONE).addTag(DenseMekanismTags.Blocks.DENSE_STONE_ORES);
        tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).addTag(DenseMekanismTags.Blocks.DENSE_DEEPSLATE_ORES);

        tag(DenseMekanismTags.Blocks.DENSE_STONE_ORES).add(DenseBlocks.DENSE_FLUORITE_ORE.get(), DenseBlocks.DENSE_LEAD_ORE.get(), DenseBlocks.DENSE_OSMIUM_ORE.get(), DenseBlocks.DENSE_TIN_ORE.get(), DenseBlocks.DENSE_URANIUM_ORE.get());
        tag(DenseMekanismTags.Blocks.DENSE_DEEPSLATE_ORES).add(DenseBlocks.DENSE_DEEPSLATE_FLUORITE_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_LEAD_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_OSMIUM_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_TIN_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_URANIUM_ORE.get());

        tag(DenseMekanismTags.Blocks.FLUORITE_ORES).add(DenseBlocks.DENSE_FLUORITE_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_FLUORITE_ORE.get());
        tag(DenseMekanismTags.Blocks.LEAD_ORES).add(DenseBlocks.DENSE_LEAD_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_LEAD_ORE.get());
        tag(DenseMekanismTags.Blocks.OSMIUM_ORES).add(DenseBlocks.DENSE_OSMIUM_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_OSMIUM_ORE.get());
        tag(DenseMekanismTags.Blocks.TIN_ORES).add(DenseBlocks.DENSE_TIN_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_TIN_ORE.get());
        tag(DenseMekanismTags.Blocks.URANIUM_ORES).add(DenseBlocks.DENSE_URANIUM_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_URANIUM_ORE.get());
    }
}
