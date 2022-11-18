package com.djlaser.betterallays.datagen.loot;

import com.djlaser.betterallays.block.ModBlocks;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockLoot {

    @Override
    protected void addTables(){
        this.dropSelf(ModBlocks.JADE_BLOCK);
    }

    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
