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

    private void makeHeadphones() {
        Item[] headphones = ColorsUtil.HEADPHONES;
        String[] colors = ColorsUtil.COLOR_NAMES;

        for(int i = 0; i < headphones.length; i++){
            headphoneItem(headphones[i], colors[i]);
        }
    }

    @Override
    protected void registerModels() {
        makeHeadphones();
        
    }

    private ItemModelBuilder headphoneItem(Item item, String color) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);;
        return withExistingParent(location.toString(),
                new ResourceLocation("item/generated"))
                .texture("layer0",
                new ResourceLocation(BetterAllays.MODID,"item/headphones/" + color))
                .texture("layer1",
                        new ResourceLocation(BetterAllays.MODID,"item/headphones/base"));
    }
    private ItemModelBuilder simpleItem(Item item) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);
        return withExistingParent(location.toString(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BetterAllays.MODID,"item/" + location.getPath()));
    }

    private ItemModelBuilder handheldItem(Item item) {
        ResourceLocation location = ForgeRegistries.ITEMS.getKey(item);;
        return withExistingParent(location.toString(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(BetterAllays.MODID,"item/" + location.getPath()));
    }
}
