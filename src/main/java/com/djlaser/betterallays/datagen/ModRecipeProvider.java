package com.djlaser.betterallays.datagen;

import com.djlaser.betterallays.item.ModItems;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.ItemInteractWithBlockTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(DataGenerator dataGen) {
        super(dataGen);
    }

    private void makeHeadphones (Consumer<FinishedRecipe> finishedRecipeConsumer) {

        Item[] headphones = {
                ModItems.BLACK_HEADPHONES.get(),
                ModItems.BLUE_HEADPHONES.get(),
                ModItems.BROWN_HEADPHONES.get(),
                ModItems.CYAN_HEADPHONES.get(),
                ModItems.GRAY_HEADPHONES.get(),
                ModItems.GREEN_HEADPHONES.get(),
                ModItems.LIGHT_BLUE_HEADPHONES.get(),
                ModItems.LIGHT_GRAY_HEADPHONES.get(),
                ModItems.LIME_HEADPHONES.get(),
                ModItems.MAGENTA_HEADPHONES.get(),
                ModItems.ORANGE_HEADPHONES.get(),
                ModItems.PINK_HEADPHONES.get(),
                ModItems.PURPLE_HEADPHONES.get(),
                ModItems.RED_HEADPHONES.get(),
                ModItems.WHITE_HEADPHONES.get(),
                ModItems.YELLOW_HEADPHONES.get()
        };
        
        Item[] wools = {
                Items.BLACK_WOOL,
                Items.BLUE_WOOL,
                Items.BROWN_WOOL,
                Items.CYAN_WOOL,
                Items.GRAY_WOOL,
                Items.GREEN_WOOL,
                Items.LIGHT_BLUE_WOOL,
                Items.LIGHT_GRAY_WOOL,
                Items.LIME_WOOL,
                Items.MAGENTA_WOOL,
                Items.ORANGE_WOOL,
                Items.PINK_WOOL,
                Items.PURPLE_WOOL,
                Items.RED_WOOL,
                Items.WHITE_WOOL,
                Items.YELLOW_WOOL

        };
        for(int i = 0; i < headphones.length; i++) {
            ShapedRecipeBuilder.shaped(headphones[i])
                    .define('W', wools[i])
                    .define('S', Items.STICK)
                    .define('N', Items.NOTE_BLOCK)
                    .define('R', Tags.Items.DUSTS_REDSTONE)
                    .define('I', Tags.Items.INGOTS_IRON)
                    .pattern(" I ").pattern("SRS").pattern("WNW")
                    .unlockedBy("AllayDropItem",
                            ItemInteractWithBlockTrigger.TriggerInstance.allayDropItemOnBlock(LocationPredicate.Builder
                                    .location().setBlock(
                                            BlockPredicate.Builder.block().of(Blocks.NOTE_BLOCK).build()),
                                    ItemPredicate.Builder.item()))
                    .save(finishedRecipeConsumer);
        }
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> finishedRecipeConsumer) {
        makeHeadphones(finishedRecipeConsumer);

    }
}
