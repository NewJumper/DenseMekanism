package com.newjumper.densemekanism.datagen.data;

import com.google.common.collect.ImmutableList;
import com.newjumper.densemekanism.DenseMekanism;
import com.newjumper.densemekanism.content.DenseBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
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

    public SmeltingRecipesProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> pWriter) {
        Item fluoriteGem = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "fluorite_gem"));
        Item rawLead = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "raw_lead"));
        Item rawOsmium = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "raw_osmium"));
        Item rawTin = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "raw_tin"));
        Item rawUranium = ForgeRegistries.ITEMS.getValue(new ResourceLocation("mekanism", "raw_uranium"));

        oreSmelting(DENSE_FLUORITE_ORES, fluoriteGem, "fluorite_gem", pWriter);
        oreSmelting(DENSE_LEAD_ORES, rawLead, "lead_ingot", pWriter);
        oreSmelting(DENSE_OSMIUM_ORES, rawOsmium, "osmium_ingot", pWriter);
        oreSmelting(DENSE_TIN_ORES, rawTin, "tin_ingot", pWriter);
        oreSmelting(DENSE_URANIUM_ORES, rawUranium, "uranium_ingot", pWriter);

        oreBlasting(DENSE_FLUORITE_ORES, fluoriteGem, "fluorite_gem", pWriter);
        oreBlasting(DENSE_LEAD_ORES, rawLead, "lead_ingot", pWriter);
        oreBlasting(DENSE_OSMIUM_ORES, rawOsmium, "osmium_ingot", pWriter);
        oreBlasting(DENSE_TIN_ORES, rawTin, "tin_ingot", pWriter);
        oreBlasting(DENSE_URANIUM_ORES, rawUranium, "uranium_ingot", pWriter);
    }

    private void oreSmelting(List<ItemLike> ingredients, ItemLike result, String group, Consumer<FinishedRecipe> writer) {
        for(ItemLike item : ingredients) SimpleCookingRecipeBuilder.smelting(Ingredient.of(item), RecipeCategory.MISC, result, 1.6f, 200).group(group).unlockedBy(getHasName(item), has(item)).save(writer, new ResourceLocation(DenseMekanism.MOD_ID, getSmeltingRecipeName(result)  + "_" + getItemName(item)));
    }

    private void oreBlasting(List<ItemLike> ingredients, ItemLike result, String group, Consumer<FinishedRecipe> writer) {
        for(ItemLike item : ingredients) SimpleCookingRecipeBuilder.blasting(Ingredient.of(item), RecipeCategory.MISC, result, 1.6f, 100).group(group).unlockedBy(getHasName(item), has(item)).save(writer, new ResourceLocation(DenseMekanism.MOD_ID, getBlastingRecipeName(result) + "_" + getItemName(item)));
    }
}
