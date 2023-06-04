package com.newjumper.densemekanism.datagen.data;

import com.newjumper.densemekanism.content.DenseBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

public class DenseMekLootTables extends BlockLoot {
    @Override
    protected void addTables() {
//        this.add(DenseBlocks.DENSE_FLUORITE_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_FLUORITE_ORE.get(), MekanismItems.FLUORITE, 4, 8));
//        this.add(DenseBlocks.DENSE_DEEPSLATE_FLUORITE_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_DEEPSLATE_FLUORITE_ORE.get(), MekanismItems.FLUORITE, 4, 8));
//        this.add(DenseBlocks.DENSE_LEAD_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_LEAD_ORE.get(), MekanismItems.RAW_LEAD, 2, 4));
//        this.add(DenseBlocks.DENSE_DEEPSLATE_LEAD_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_DEEPSLATE_LEAD_ORE.get(), MekanismItems.RAW_LEAD, 2, 4));
//        this.add(DenseBlocks.DENSE_OSMIUM_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_OSMIUM_ORE.get(), MekanismItems.RAW_OSMIUM, 2, 4));
//        this.add(DenseBlocks.DENSE_DEEPSLATE_OSMIUM_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_DEEPSLATE_OSMIUM_ORE.get(), MekanismItems.RAW_OSMIUM, 2, 4));
//        this.add(DenseBlocks.DENSE_TIN_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_TIN_ORE.get(), MekanismItems.RAW_TIN, 2, 4));
//        this.add(DenseBlocks.DENSE_DEEPSLATE_TIN_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_DEEPSLATE_TIN_ORE.get(), MekanismItems.RAW_TIN, 2, 4));
//        this.add(DenseBlocks.DENSE_URANIUM_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_URANIUM_ORE.get(), MekanismItems.RAW_URANIUM, 2, 4));
//        this.add(DenseBlocks.DENSE_DEEPSLATE_URANIUM_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_DEEPSLATE_URANIUM_ORE.get(), MekanismItems.RAW_URANIUM, 2, 4));
    }

    private LootTable.Builder createDenseOreDrop(Block block, Item item, int min, int max) {
        return createSilkTouchDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
}
