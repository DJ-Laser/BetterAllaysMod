package com.djlaser.betterallays.datagen.loot;

import com.djlaser.betterallays.block.ModBlocks;
import com.djlaser.betterallays.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ModBlockLootTables extends BlockLoot {

    @Override
    protected void addTables(){
        this.dropSelf(ModBlocks.JADE_BLOCK.get());
        this.add(ModBlocks.BUDDING_JADE.get(), noDrop());
        this.add(ModBlocks.JADE_CLUSTER.get(),
                (p_236253_) ->
                        createSilkTouchDispatchTable(p_236253_,
                                LootItem.lootTableItem(ModItems.JADE_SHARD.get())
                                        .apply(SetItemCountFunction
                                                .setCount(ConstantValue.exactly(4.0F)))
                                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                                        .when(MatchTool.toolMatches(ItemPredicate.Builder.item()
                                                .of(ItemTags.CLUSTER_MAX_HARVESTABLES)))
                                        .otherwise(applyExplosionDecay(p_236253_, LootItem.lootTableItem(Items.AMETHYST_SHARD)
                                                .apply(SetItemCountFunction
                                                        .setCount(ConstantValue
                                                                .exactly(2.0F)))))));
        this.dropWhenSilkTouch(ModBlocks.LARGE_JADE_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.MEDIUM_JADE_BUD.get());
        this.dropWhenSilkTouch(ModBlocks.SMALL_JADE_BUD.get());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
