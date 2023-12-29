package com.newjumper.densemekanism.datagen.data;

import com.newjumper.densemekanism.content.DenseBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DenseBlockLoot extends BlockLootSubProvider {
    private static final Set<Item> EXPLOSION_RESISTANT = Stream.of(Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.CONDUIT, Blocks.SKELETON_SKULL, Blocks.WITHER_SKELETON_SKULL, Blocks.PLAYER_HEAD, Blocks.ZOMBIE_HEAD, Blocks.CREEPER_HEAD, Blocks.DRAGON_HEAD, Blocks.PIGLIN_HEAD, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX, Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX, Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX).map(ItemLike::asItem).collect(Collectors.toSet());

    public DenseBlockLoot() {
        super(EXPLOSION_RESISTANT, FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        Item fluoriteGem = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "fluorite_gem"));
        Item rawLead = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "raw_lead"));
        Item rawOsmium = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "raw_osmium"));
        Item rawTin = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "raw_tin"));
        Item rawUranium = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "raw_uranium"));

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
        return createSilkTouchDispatchTable(block, applyExplosionDecay(block, LootItem.lootTableItem(item).apply(SetItemCountFunction.setCount(UniformGenerator.between(min, max))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return DenseBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
