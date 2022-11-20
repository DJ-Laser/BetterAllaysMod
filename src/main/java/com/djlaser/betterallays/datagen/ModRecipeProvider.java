package com.djlaser.betterallays.datagen;

import com.djlaser.betterallays.util.ColorsUtil;
import com.djlaser.betterallays.util.ModTags;
import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.ItemInteractWithBlockTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;


public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(DataGenerator dataGen) {
        super(dataGen);
    }

    private void makeHeadphones(Consumer<FinishedRecipe> finishedRecipeConsumer) {

        Item[] headphones = ColorsUtil.HEADPHONES;
        Item[] wools = ColorsUtil.WOOLS;
        Item[] dyes = ColorsUtil.DYES;

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

            ShapelessRecipeBuilder.shapeless(headphones[i])
                    .requires(ModTags.Items.HEADPHONES)
                    .requires(dyes[i])
                    .unlockedBy("AllayDropItem",
                            ItemInteractWithBlockTrigger.TriggerInstance.allayDropItemOnBlock(LocationPredicate.Builder
                                            .location().setBlock(
                                                    BlockPredicate.Builder.block().of(Blocks.NOTE_BLOCK).build()),
                                    ItemPredicate.Builder.item()))
                    .save(finishedRecipeConsumer, new ResourceLocation(
                                    ForgeRegistries.ITEMS.getKey(headphones[i]).toString() + "_dyed"));
        }
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> finishedRecipeConsumer) {
        makeHeadphones(finishedRecipeConsumer);

    }
}
