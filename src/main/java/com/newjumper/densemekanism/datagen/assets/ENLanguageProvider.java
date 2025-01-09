package com.newjumper.densemekanism.datagen.assets;

import com.newjumper.densemekanism.DenseMekanism;
import com.newjumper.densemekanism.content.DenseBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ENLanguageProvider extends LanguageProvider {
    public ENLanguageProvider(PackOutput output) {
        super(output, DenseMekanism.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        DenseBlocks.BLOCKS.getEntries().forEach(this::addBlock);
        add("itemGroup." + DenseMekanism.MOD_ID, "Dense Mekanism");
    }

    private void addBlock(DeferredHolder<?, ?> block) {
        String key = block.getId().getPath();
        add("block." + DenseMekanism.MOD_ID + "." + key, convertToName(key));
    }

    private String convertToName(String key) {
        StringBuilder builder = new StringBuilder(key.substring(0, 1).toUpperCase() + key.substring(1));
        for(int i = 1; i < builder.length(); i++) {
            if(builder.charAt(i) == '_') {
                builder.deleteCharAt(i);
                builder.replace(i, i + 1, " " + Character.toUpperCase(builder.charAt(i)));
            }
        }

        return builder.toString();
    }
}
