package com.djlaser.betterallays.datagen;

import com.djlaser.betterallays.BetterAllays;
import com.djlaser.betterallays.util.ColorsUtil;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BetterAllays.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        Item[] headphones = ColorsUtil.HEADPHONES;

        for (Item headphone : headphones) {
            simpleItem(headphone);
        }
    }

    private void simpleItem(Item item) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
        withExistingParent(location.toString(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BetterAllays.MODID, "item/" + location.getPath()));
    }

    private void handheldItem(Item item) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
        withExistingParent(location.toString(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(BetterAllays.MODID,"item/" + location.getPath()));
    }
}
