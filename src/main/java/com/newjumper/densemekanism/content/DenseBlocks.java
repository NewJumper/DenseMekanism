package com.newjumper.densemekanism.content;

import com.newjumper.densemekanism.DenseMekanism;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class DenseBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DenseMekanism.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DenseMekanism.MOD_ID);

    public static final RegistryObject<Block> DENSE_FLUORITE_ORE = register("dense_fluorite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.STONE).strength(5, 9), UniformInt.of(1, 4)));
    public static final RegistryObject<Block> DENSE_DEEPSLATE_FLUORITE_ORE = register("dense_deepslate_fluorite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(DENSE_FLUORITE_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(6, 9), UniformInt.of(1, 4)));
    public static final RegistryObject<Block> DENSE_LEAD_ORE = register("dense_lead_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5, 9)));
    public static final RegistryObject<Block> DENSE_DEEPSLATE_LEAD_ORE = register("dense_deepslate_lead_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(DENSE_LEAD_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(6, 9)));
    public static final RegistryObject<Block> DENSE_OSMIUM_ORE = register("dense_osmium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(7.5f, 12)));
    public static final RegistryObject<Block> DENSE_DEEPSLATE_OSMIUM_ORE = register("dense_deepslate_osmium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(DENSE_OSMIUM_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(8.5f, 12)));
    public static final RegistryObject<Block> DENSE_TIN_ORE = register("dense_tin_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5, 6)));
    public static final RegistryObject<Block> DENSE_DEEPSLATE_TIN_ORE = register("dense_deepslate_tin_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(DENSE_TIN_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(6, 6)));
    public static final RegistryObject<Block> DENSE_URANIUM_ORE = register("dense_uranium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(5, 9)));
    public static final RegistryObject<Block> DENSE_DEEPSLATE_URANIUM_ORE = register("dense_deepslate_uranium_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(DENSE_URANIUM_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(6, 9)));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> registeredBlock = BLOCKS.register(name, block);
        ITEMS.register(name, () -> new BlockItem(registeredBlock.get(), new Item.Properties()));
        return registeredBlock;
    }
}
