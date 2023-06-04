package com.newjumper.densemekanism.datagen.data;

import com.newjumper.densemekanism.DenseMekanism;
import com.newjumper.densemekanism.content.DenseBlocks;
import com.newjumper.densemekanism.content.DenseMekanismTags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class DenseMekBlockTagsProvider extends BlockTagsProvider {
    public DenseMekBlockTagsProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, DenseMekanism.MOD_ID, exFileHelper);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE).addTags(DenseMekanismTags.Blocks.DENSE_STONE_ORES, DenseMekanismTags.Blocks.DENSE_DEEPSLATE_ORES);
//        tag(BlockTags.NEEDS_STONE_TOOL).add(DenseBlocks.DENSE_IRON_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_IRON_ORE.get(), DenseBlocks.DENSE_COPPER_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_COPPER_ORE.get(), DenseBlocks.DENSE_LAPIS_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_LAPIS_ORE.get());
//        tag(BlockTags.NEEDS_IRON_TOOL).add(DenseBlocks.DENSE_GOLD_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_GOLD_ORE.get(), DenseBlocks.DENSE_REDSTONE_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_REDSTONE_ORE.get(), DenseBlocks.DENSE_EMERALD_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_EMERALD_ORE.get(), DenseBlocks.DENSE_DIAMOND_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_DIAMOND_ORE.get());

        tag(Tags.Blocks.ORES).addTags(DenseMekanismTags.Blocks.DENSE_STONE_ORES, DenseMekanismTags.Blocks.DENSE_DEEPSLATE_ORES);
        tag(Tags.Blocks.ORE_RATES_DENSE).addTags(DenseMekanismTags.Blocks.DENSE_STONE_ORES, DenseMekanismTags.Blocks.DENSE_DEEPSLATE_ORES);
        tag(Tags.Blocks.ORES_IN_GROUND_STONE).addTag(DenseMekanismTags.Blocks.DENSE_STONE_ORES);
        tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).addTag(DenseMekanismTags.Blocks.DENSE_DEEPSLATE_ORES);

        tag(DenseMekanismTags.Blocks.DENSE_STONE_ORES).add(DenseBlocks.DENSE_FLUORITE_ORE.get(), DenseBlocks.DENSE_LEAD_ORE.get(), DenseBlocks.DENSE_OSMIUM_ORE.get(), DenseBlocks.DENSE_TIN_ORE.get(), DenseBlocks.DENSE_URANIUM_ORE.get());
        tag(DenseMekanismTags.Blocks.DENSE_DEEPSLATE_ORES).add(DenseBlocks.DENSE_DEEPSLATE_FLUORITE_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_LEAD_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_OSMIUM_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_TIN_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_URANIUM_ORE.get());
    }
}
