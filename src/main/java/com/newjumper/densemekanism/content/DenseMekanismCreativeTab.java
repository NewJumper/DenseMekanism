package com.newjumper.densemekanism.content;

import com.newjumper.densemekanism.DenseMekanism;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class DenseMekanismCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DenseMekanism.MOD_ID);
    public static final RegistryObject<CreativeModeTab> DENSE_MEKANISM = CREATIVE_MODE_TABS.register("deeper_darker", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup." + DenseMekanism.MOD_ID)).icon(() -> new ItemStack(DenseBlocks.DENSE_FLUORITE_ORE.get())).build());

    public static void buildCreativeTab(BuildCreativeModeTabContentsEvent event) {
        if(event.getTab() == DENSE_MEKANISM.get()) {
            event.accept(DenseBlocks.DENSE_FLUORITE_ORE);
            event.accept(DenseBlocks.DENSE_DEEPSLATE_FLUORITE_ORE);
            event.accept(DenseBlocks.DENSE_LEAD_ORE);
            event.accept(DenseBlocks.DENSE_DEEPSLATE_LEAD_ORE);
            event.accept(DenseBlocks.DENSE_OSMIUM_ORE);
            event.accept(DenseBlocks.DENSE_DEEPSLATE_OSMIUM_ORE);
            event.accept(DenseBlocks.DENSE_TIN_ORE);
            event.accept(DenseBlocks.DENSE_DEEPSLATE_TIN_ORE);
            event.accept(DenseBlocks.DENSE_URANIUM_ORE);
            event.accept(DenseBlocks.DENSE_DEEPSLATE_URANIUM_ORE);
        }
    }
}
