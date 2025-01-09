package com.newjumper.densemekanism.content;

import com.newjumper.densemekanism.DenseMekanism;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class DenseBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(DenseMekanism.MOD_ID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DenseMekanism.MOD_ID);

    public static final DeferredBlock<Block> DENSE_FLUORITE_ORE = register("dense_fluorite_ore", () -> new DropExperienceBlock(UniformInt.of(1, 4), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.STONE).strength(5, 9)));
    public static final DeferredBlock<Block> DENSE_DEEPSLATE_FLUORITE_ORE = register("dense_deepslate_fluorite_ore", () -> new DropExperienceBlock(UniformInt.of(1, 4), BlockBehaviour.Properties.ofFullCopy(DENSE_FLUORITE_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(6, 9)));
    public static final DeferredBlock<Block> DENSE_LEAD_ORE = register("dense_lead_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(5, 9)));
    public static final DeferredBlock<Block> DENSE_DEEPSLATE_LEAD_ORE = register("dense_deepslate_lead_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(DENSE_LEAD_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(6, 9)));
    public static final DeferredBlock<Block> DENSE_OSMIUM_ORE = register("dense_osmium_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(7.5f, 12)));
    public static final DeferredBlock<Block> DENSE_DEEPSLATE_OSMIUM_ORE = register("dense_deepslate_osmium_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(DENSE_OSMIUM_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(8.5f, 12)));
    public static final DeferredBlock<Block> DENSE_TIN_ORE = register("dense_tin_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(5, 6)));
    public static final DeferredBlock<Block> DENSE_DEEPSLATE_TIN_ORE = register("dense_deepslate_tin_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(DENSE_TIN_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(6, 6)));
    public static final DeferredBlock<Block> DENSE_URANIUM_ORE = register("dense_uranium_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(5, 9)));
    public static final DeferredBlock<Block> DENSE_DEEPSLATE_URANIUM_ORE = register("dense_deepslate_uranium_ore", () -> new Block(BlockBehaviour.Properties.ofFullCopy(DENSE_URANIUM_ORE.get()).mapColor(MapColor.DEEPSLATE).strength(6, 9)));

    private static <T extends Block> DeferredBlock<T> register(String name, Supplier<T> properties) {
        DeferredBlock<T> block = BLOCKS.register(name, properties);
        ITEMS.registerSimpleBlockItem(name, block);
        return block;
    }
}
