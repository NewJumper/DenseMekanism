package com.newjumper.densemekanism.datagen.assets;

import com.newjumper.densemekanism.DenseMekanism;
import com.newjumper.densemekanism.content.DenseBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class DenseMekBlockStateProvider extends BlockStateProvider {
    public DenseMekBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DenseMekanism.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(DenseBlocks.DENSE_FLUORITE_ORE.get());
        simpleBlock(DenseBlocks.DENSE_DEEPSLATE_FLUORITE_ORE.get());
        simpleBlock(DenseBlocks.DENSE_LEAD_ORE.get());
        simpleBlock(DenseBlocks.DENSE_DEEPSLATE_LEAD_ORE.get());
        simpleBlock(DenseBlocks.DENSE_OSMIUM_ORE.get());
        simpleBlock(DenseBlocks.DENSE_DEEPSLATE_OSMIUM_ORE.get());
        simpleBlock(DenseBlocks.DENSE_TIN_ORE.get());
        simpleBlock(DenseBlocks.DENSE_DEEPSLATE_TIN_ORE.get());
        simpleBlock(DenseBlocks.DENSE_URANIUM_ORE.get());
        simpleBlock(DenseBlocks.DENSE_DEEPSLATE_URANIUM_ORE.get());
    }
}
