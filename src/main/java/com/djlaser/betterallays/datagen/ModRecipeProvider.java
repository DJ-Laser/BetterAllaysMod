package com.djlaser.betterallays.datagen;

import com.djlaser.betterallays.item.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(DataGenerator dataGen) {
        super(dataGen);
    }

    private void makeHeadphones (Consumer<FinishedRecipe> finishedRecipeConsumer) {

        Item[] headphones = {
                ModItems.WHITE_HEADPHONES.get()
        };
        
        Item[] wools = {
                Items.WHITE_WOOL
        };
        for(int i = 0; i < headphones.length; i++) {
            ShapedRecipeBuilder.shaped(headphones[i])
                    .define('W', wools[i])
                    .define('S', Items.STICK)
                    .define('N', Items.NOTE_BLOCK)
                    .define('R', Tags.Items.DUSTS_REDSTONE)
                    .define('I', Tags.Items.INGOTS_IRON)
                    .pattern(" I ").pattern("SRS").pattern("WNW")
                    .save(finishedRecipeConsumer);
        }
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {

        makeHeadphones(finishedRecipeConsumer);

    }
}
