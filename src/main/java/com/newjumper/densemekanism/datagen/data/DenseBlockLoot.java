package com.newjumper.densemekanism.datagen.data;

import com.newjumper.densemekanism.content.DenseBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class DenseBlockLoot extends BlockLootSubProvider {
    protected DenseBlockLoot(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        Item fluoriteGem = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("mekanism", "fluorite_gem"));
        Item rawLead = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("mekanism", "raw_lead"));
        Item rawOsmium = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("mekanism", "raw_osmium"));
        Item rawTin = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("mekanism", "raw_tin"));
        Item rawUranium = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("mekanism", "raw_uranium"));

        this.add(DenseBlocks.DENSE_FLUORITE_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_FLUORITE_ORE.get(), fluoriteGem, 4, 8));
        this.add(DenseBlocks.DENSE_DEEPSLATE_FLUORITE_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_DEEPSLATE_FLUORITE_ORE.get(), fluoriteGem, 4, 8));
        this.add(DenseBlocks.DENSE_LEAD_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_LEAD_ORE.get(), rawLead, 2, 4));
        this.add(DenseBlocks.DENSE_DEEPSLATE_LEAD_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_DEEPSLATE_LEAD_ORE.get(), rawLead, 2, 4));
        this.add(DenseBlocks.DENSE_OSMIUM_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_OSMIUM_ORE.get(), rawOsmium, 2, 4));
        this.add(DenseBlocks.DENSE_DEEPSLATE_OSMIUM_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_DEEPSLATE_OSMIUM_ORE.get(), rawOsmium, 2, 4));
        this.add(DenseBlocks.DENSE_TIN_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_TIN_ORE.get(), rawTin, 2, 4));
        this.add(DenseBlocks.DENSE_DEEPSLATE_TIN_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_DEEPSLATE_TIN_ORE.get(), rawTin, 2, 4));
        this.add(DenseBlocks.DENSE_URANIUM_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_URANIUM_ORE.get(), rawUranium, 2, 4));
        this.add(DenseBlocks.DENSE_DEEPSLATE_URANIUM_ORE.get(), createDenseOreDrop(DenseBlocks.DENSE_DEEPSLATE_URANIUM_ORE.get(), rawUranium, 2, 4));
    }

    private LootTable.Builder createDenseOreDrop(Block block, Item item, int min, int max) {
        return createSilkTouchDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max))).apply(ApplyBonusCount.addUniformBonusCount(registries.holderOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return DenseBlocks.BLOCKS.getEntries().stream().map(block -> block.getDelegate().value())::iterator;
    }
}
