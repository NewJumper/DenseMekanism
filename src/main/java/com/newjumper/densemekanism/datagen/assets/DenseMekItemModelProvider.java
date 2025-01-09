package com.newjumper.densemekanism.datagen.assets;

import com.newjumper.densemekanism.DenseMekanism;
import com.newjumper.densemekanism.content.DenseBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class DenseMekItemModelProvider extends ItemModelProvider {
    public DenseMekItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DenseMekanism.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        blockModel(DenseBlocks.DENSE_FLUORITE_ORE);
        blockModel(DenseBlocks.DENSE_DEEPSLATE_FLUORITE_ORE);
        blockModel(DenseBlocks.DENSE_LEAD_ORE);
        blockModel(DenseBlocks.DENSE_DEEPSLATE_LEAD_ORE);
        blockModel(DenseBlocks.DENSE_OSMIUM_ORE);
        blockModel(DenseBlocks.DENSE_DEEPSLATE_OSMIUM_ORE);
        blockModel(DenseBlocks.DENSE_TIN_ORE);
        blockModel(DenseBlocks.DENSE_DEEPSLATE_TIN_ORE);
        blockModel(DenseBlocks.DENSE_URANIUM_ORE);
        blockModel(DenseBlocks.DENSE_DEEPSLATE_URANIUM_ORE);
    }

    public void blockModel(DeferredBlock<Block> block) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath()));
    }
}
