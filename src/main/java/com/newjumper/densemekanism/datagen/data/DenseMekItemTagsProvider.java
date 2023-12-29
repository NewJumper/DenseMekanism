package com.newjumper.densemekanism.datagen.data;

import com.newjumper.densemekanism.DenseMekanism;
import com.newjumper.densemekanism.content.DenseMekanismTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class DenseMekItemTagsProvider extends ItemTagsProvider {
    public DenseMekItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, TagsProvider<Block> blockTags, ExistingFileHelper existingFileHelper) {
        super(output, lookup, blockTags.contentsGetter(), DenseMekanism.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(Tags.Blocks.ORE_RATES_DENSE, Tags.Items.ORE_RATES_DENSE);
        copy(Tags.Blocks.ORES_IN_GROUND_STONE, Tags.Items.ORES_IN_GROUND_STONE);
        copy(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE, Tags.Items.ORES_IN_GROUND_DEEPSLATE);

        copy(DenseMekanismTags.Blocks.DENSE_STONE_ORES, DenseMekanismTags.Items.DENSE_STONE_ORES);
        copy(DenseMekanismTags.Blocks.DENSE_DEEPSLATE_ORES, DenseMekanismTags.Items.DENSE_DEEPSLATE_ORES);
    }
}
