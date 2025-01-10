package com.newjumper.densemekanism.datagen.data;

import com.google.common.collect.ImmutableList;
import com.newjumper.densemekanism.DenseMekanism;
import com.newjumper.densemekanism.content.DenseBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DenseMekRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final ImmutableList<ItemLike> DENSE_FLUORITE_ORES = ImmutableList.of(DenseBlocks.DENSE_FLUORITE_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_FLUORITE_ORE.get());
    private static final ImmutableList<ItemLike> DENSE_LEAD_ORES = ImmutableList.of(DenseBlocks.DENSE_LEAD_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_LEAD_ORE.get());
    private static final ImmutableList<ItemLike> DENSE_OSMIUM_ORES = ImmutableList.of(DenseBlocks.DENSE_OSMIUM_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_OSMIUM_ORE.get());
    private static final ImmutableList<ItemLike> DENSE_TIN_ORES = ImmutableList.of(DenseBlocks.DENSE_TIN_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_TIN_ORE.get());
    private static final ImmutableList<ItemLike> DENSE_URANIUM_ORES = ImmutableList.of(DenseBlocks.DENSE_URANIUM_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_URANIUM_ORE.get());

    public DenseMekRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput output) {
        Item fluoriteGem = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("mekanism", "fluorite_gem"));
        Item rawLead = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("mekanism", "raw_lead"));
        Item rawOsmium = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("mekanism", "raw_osmium"));
        Item rawTin = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("mekanism", "raw_tin"));
        Item rawUranium = BuiltInRegistries.ITEM.get(ResourceLocation.fromNamespaceAndPath("mekanism", "raw_uranium"));

        oreSmelting(DENSE_FLUORITE_ORES, fluoriteGem, "fluorite_gem", output);
        oreSmelting(DENSE_LEAD_ORES, rawLead, "lead_ingot", output);
        oreSmelting(DENSE_OSMIUM_ORES, rawOsmium, "osmium_ingot", output);
        oreSmelting(DENSE_TIN_ORES, rawTin, "tin_ingot", output);
        oreSmelting(DENSE_URANIUM_ORES, rawUranium, "uranium_ingot", output);

        oreBlasting(DENSE_FLUORITE_ORES, fluoriteGem, "fluorite_gem", output);
        oreBlasting(DENSE_LEAD_ORES, rawLead, "lead_ingot", output);
        oreBlasting(DENSE_OSMIUM_ORES, rawOsmium, "osmium_ingot", output);
        oreBlasting(DENSE_TIN_ORES, rawTin, "tin_ingot", output);
        oreBlasting(DENSE_URANIUM_ORES, rawUranium, "uranium_ingot", output);
    }

    private void oreSmelting(List<ItemLike> ingredients, ItemLike result, String group, RecipeOutput output) {
        for(ItemLike item : ingredients) SimpleCookingRecipeBuilder.smelting(Ingredient.of(item), RecipeCategory.MISC, result, 1.6f, 200).group(group).unlockedBy(getHasName(item), has(item)).save(output, ResourceLocation.fromNamespaceAndPath(DenseMekanism.MOD_ID, getSmeltingRecipeName(result)  + "_" + getItemName(item)));
    }

    private void oreBlasting(List<ItemLike> ingredients, ItemLike result, String group, RecipeOutput writer) {
        for(ItemLike item : ingredients) SimpleCookingRecipeBuilder.blasting(Ingredient.of(item), RecipeCategory.MISC, result, 1.6f, 100).group(group).unlockedBy(getHasName(item), has(item)).save(writer, ResourceLocation.fromNamespaceAndPath(DenseMekanism.MOD_ID, getBlastingRecipeName(result) + "_" + getItemName(item)));
    }
}
