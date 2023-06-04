package com.newjumper.densemekanism.content;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class DenseMekanismCreativeTab {
    public static final CreativeModeTab DENSE_MEKANISM = new CreativeModeTab("densemekanism") {
        @NotNull
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(DenseBlocks.DENSE_FLUORITE_ORE.get());
        }
    };
}
