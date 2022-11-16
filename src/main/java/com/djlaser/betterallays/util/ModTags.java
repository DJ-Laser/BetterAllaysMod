package com.djlaser.betterallays.util;

import com.djlaser.betterallays.BetterAllays;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class ModTags {

    public static class Blocks {

        private static TagKey<Block> create(String location, String modid) {
            return BlockTags.create(new ResourceLocation(modid, location));
        }

        private static TagKey<Block> create(String location) {
            return create(BetterAllays.MODID, location);
        }
    }

    public static class Items {

        private static TagKey<Item> create(String location, String modid) {
            return ItemTags.create(new ResourceLocation(modid, location));
        }
        private static TagKey<Item> create(String location) {
            return create(location, BetterAllays.MODID);
        }

        public static final TagKey<Item> HEADPHONES = create("headphones");
    }

    public static class Fluids {

        private static TagKey<Fluid> create(String location, String modid) {
            return FluidTags.create(new ResourceLocation(modid, location));
        }

        private static TagKey<Fluid> create(String location) {
            return create(BetterAllays.MODID, location);
        }
    }

}
