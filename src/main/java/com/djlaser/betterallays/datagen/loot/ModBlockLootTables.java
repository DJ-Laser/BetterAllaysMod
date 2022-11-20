package com.djlaser.betterallays.datagen.loot;

import com.djlaser.betterallays.block.ModBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ModBlockLootTables extends BlockLoot {

    @Override
    protected void addTables(){
        this.dropSelf(ModBlocks.JADE_BLOCK.get());
        this.add(ModBlocks.BUDDING_JADE.get(), noDrop());
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
