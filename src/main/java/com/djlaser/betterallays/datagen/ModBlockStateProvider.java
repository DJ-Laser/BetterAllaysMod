package com.djlaser.betterallays.datagen;

import com.djlaser.betterallays.BetterAllays;
import com.djlaser.betterallays.block.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, BetterAllays.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.JADE_BLOCK.get());
        simpleBlock(ModBlocks.BUDDING_JADE.get());
    }
}
