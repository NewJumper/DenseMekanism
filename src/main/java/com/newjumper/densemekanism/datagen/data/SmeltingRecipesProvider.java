package com.newjumper.densemekanism.datagen.data;

import com.google.common.collect.ImmutableList;
import com.newjumper.densemekanism.DenseMekanism;
import com.newjumper.densemekanism.content.DenseBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public class SmeltingRecipesProvider extends RecipeProvider implements IConditionBuilder {
    private static final ImmutableList<ItemLike> DENSE_FLUORITE_ORES = ImmutableList.of(DenseBlocks.DENSE_FLUORITE_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_FLUORITE_ORE.get());
    private static final ImmutableList<ItemLike> DENSE_LEAD_ORES = ImmutableList.of(DenseBlocks.DENSE_LEAD_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_LEAD_ORE.get());
    private static final ImmutableList<ItemLike> DENSE_OSMIUM_ORES = ImmutableList.of(DenseBlocks.DENSE_OSMIUM_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_OSMIUM_ORE.get());
    private static final ImmutableList<ItemLike> DENSE_TIN_ORES = ImmutableList.of(DenseBlocks.DENSE_TIN_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_TIN_ORE.get());
    private static final ImmutableList<ItemLike> DENSE_URANIUM_ORES = ImmutableList.of(DenseBlocks.DENSE_URANIUM_ORE.get(), DenseBlocks.DENSE_DEEPSLATE_URANIUM_ORE.get());

    public SmeltingRecipesProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        Item fluoriteGem = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "fluorite_gem"));
        Item rawLead = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "raw_lead"));
        Item rawOsmium = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "raw_osmium"));
        Item rawTin = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "raw_tin"));
        Item rawUranium = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "raw_uranium"));

        oreSmelting(DENSE_FLUORITE_ORES, fluoriteGem, "fluorite_gem", consumer);
        oreSmelting(DENSE_LEAD_ORES, rawLead, "lead_ingot", consumer);
        oreSmelting(DENSE_OSMIUM_ORES, rawOsmium, "osmium_ingot", consumer);
        oreSmelting(DENSE_TIN_ORES, rawTin, "tin_ingot", consumer);
        oreSmelting(DENSE_URANIUM_ORES, rawUranium, "uranium_ingot", consumer);

        oreBlasting(DENSE_FLUORITE_ORES, fluoriteGem, "fluorite_gem", consumer);
        oreBlasting(DENSE_LEAD_ORES, rawLead, "lead_ingot", consumer);
        oreBlasting(DENSE_OSMIUM_ORES, rawOsmium, "osmium_ingot", consumer);
        oreBlasting(DENSE_TIN_ORES, rawTin, "tin_ingot", consumer);
        oreBlasting(DENSE_URANIUM_ORES, rawUranium, "uranium_ingot", consumer);
    }

    private void oreSmelting(List<ItemLike> ingredients, ItemLike result, String group, Consumer<FinishedRecipe> consumer) {
        for(ItemLike item : ingredients) SimpleCookingRecipeBuilder.smelting(Ingredient.of(item), result, 1.6f, 200).group(group).unlockedBy(getHasName(item), has(item)).save(consumer, new ResourceLocation(DenseMekanism.MOD_ID, getItemName(result) + "_from_smelting_" + getItemName(item)));
    }

    private void oreBlasting(List<ItemLike> ingredients, ItemLike result, String group, Consumer<FinishedRecipe> consumer) {
        for(ItemLike item : ingredients) SimpleCookingRecipeBuilder.blasting(Ingredient.of(item), result, 1.6f, 100).group(group).unlockedBy(getHasName(item), has(item)).save(consumer, new ResourceLocation(DenseMekanism.MOD_ID, getItemName(result) + "_from_blasting_" + getItemName(item)));
    }
}
