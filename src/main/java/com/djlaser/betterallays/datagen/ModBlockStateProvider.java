package com.djlaser.betterallays.datagen;

import com.djlaser.betterallays.BetterAllays;
import com.djlaser.betterallays.block.ModBlocks;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.io.IOException;
import java.util.ArrayList;

public class ModBlockStateProvider extends BlockStateProvider {

    private static class BlockItemModelProvider extends ItemModelProvider {
        private final ArrayList<ResourceLocation> BLOCKS = new ArrayList<>();
        private final ArrayList<ResourceLocation> BLOCKITEMS = new ArrayList<>();

        public BlockItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
            super(generator, BetterAllays.MODID, existingFileHelper);
        }

        public boolean isRegistered(ResourceLocation loc){
            return BLOCKS.contains(loc) || BLOCKITEMS.contains(loc);
        }

        public void addIfNew(ResourceLocation loc, boolean item){
            if(!this.isRegistered(loc)){
                if (item){
                    BLOCKITEMS.add(loc);
                } else {
                    BLOCKS.add(loc);
                }
            }
        }

        public void addIfNew(ResourceLocation loc){
            addIfNew(loc, false);
        }

        private ResourceLocation addFolders(ResourceLocation loc, String prefix){
            return new ResourceLocation(loc.getNamespace(),prefix + loc.getPath());
        }

        @Override
        protected void registerModels() {
            for (ResourceLocation block : BLOCKS) {
                withExistingParent(block.toString(), addFolders(block, "block/")
                        );
            }

            for (ResourceLocation item : BLOCKITEMS) {
                withExistingParent(item.toString(), "item/generated")
                        .texture("layer0", addFolders(item, "block/"));
            }
        }
    }

    private final BlockItemModelProvider itemModelProvider;

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, BetterAllays.MODID, exFileHelper);
        itemModelProvider = new BlockItemModelProvider(gen, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.JADE_BLOCK.get());
        simpleBlock(ModBlocks.BUDDING_JADE.get());
        crystalCrossBlock(ModBlocks.JADE_CLUSTER.get());
        crystalCrossBlock(ModBlocks.LARGE_JADE_BUD.get());
        crystalCrossBlock(ModBlocks.MEDIUM_JADE_BUD.get());
        crystalCrossBlock(ModBlocks.SMALL_JADE_BUD.get());
    }

    public void crystalCrossBlock(Block block){
        itemModelProvider.addIfNew(key(block), true);
        directionalBlock(block, models().cross(name(block), blockTexture(block)).renderType("cutout"));
    }

    @Override
    public VariantBlockStateBuilder getVariantBuilder(Block block) {
        itemModelProvider.addIfNew(key(block));
        return super.getVariantBuilder(block);
    }

    @Override
    public void run(CachedOutput cache) throws IOException {
        super.run(cache);
        itemModelProvider.run(cache);
    }

    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private String name(Block block) {
        return key(block).getPath();
    }
}
