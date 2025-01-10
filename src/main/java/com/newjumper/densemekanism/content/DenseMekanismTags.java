package com.newjumper.densemekanism.content;

import com.newjumper.densemekanism.DenseMekanism;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class DenseMekanismTags {
    public static class Blocks {
        public static final TagKey<Block> DENSE_STONE_ORES = tag("dense_stone_ores");
        public static final TagKey<Block> DENSE_DEEPSLATE_ORES = tag("dense_deepslate_ores");

        public static final TagKey<Block> FLUORITE_ORES = sharedTag("ores/fluorite");
        public static final TagKey<Block> LEAD_ORES = sharedTag("ores/lead");
        public static final TagKey<Block> OSMIUM_ORES = sharedTag("ores/osmium");
        public static final TagKey<Block> TIN_ORES = sharedTag("ores/tin");
        public static final TagKey<Block> URANIUM_ORES = sharedTag("ores/uranium");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(DenseMekanism.MOD_ID, name));
        }

        private static TagKey<Block> sharedTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> DENSE_STONE_ORES = tag("dense_stone_ores");
        public static final TagKey<Item> DENSE_DEEPSLATE_ORES = tag("dense_deepslate_ores");

        public static final TagKey<Item> FLUORITE_ORES = sharedTag("ores/fluorite");
        public static final TagKey<Item> LEAD_ORES = sharedTag("ores/lead");
        public static final TagKey<Item> OSMIUM_ORES = sharedTag("ores/osmium");
        public static final TagKey<Item> TIN_ORES = sharedTag("ores/tin");
        public static final TagKey<Item> URANIUM_ORES = sharedTag("ores/uranium");

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(DenseMekanism.MOD_ID, name));
        }

        private static TagKey<Item> sharedTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }
}
