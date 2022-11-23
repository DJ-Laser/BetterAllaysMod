package com.djlaser.betterallays.block;

import com.djlaser.betterallays.BetterAllays;
import com.djlaser.betterallays.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BetterAllays.MODID);

    public static final RegistryObject<Block> JADE_BLOCK = registerBlock("jade_block",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.AMETHYST)
                    .strength(1.5F)
                    .sound(SoundType.AMETHYST)
                    .requiresCorrectToolForDrops()
            ), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> BUDDING_JADE = registerBlock("budding_jade",
            () -> new Block(BlockBehaviour.Properties
                    .of(Material.AMETHYST)
                    .randomTicks()
                    .strength(1.5F)
                    .sound(SoundType.AMETHYST)
                    .requiresCorrectToolForDrops()
            ), CreativeModeTab.TAB_BUILDING_BLOCKS);

    public static final RegistryObject<Block> JADE_CLUSTER = registerBlock("jade_cluster",
            () -> new AmethystClusterBlock(7, 3,
                            BlockBehaviour.Properties
                                    .of(Material.AMETHYST)
                                    .noOcclusion()
                                    .randomTicks()
                                    .sound(SoundType.AMETHYST_CLUSTER)
                                    .strength(1.5F)
                                    .lightLevel((l) -> 5)

            ), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> LARGE_JADE_BUD = registerBlock("large_jade_bud",
            () -> new AmethystClusterBlock(5, 3,
                    BlockBehaviour.Properties
                            .copy(JADE_CLUSTER.get()).sound(SoundType.LARGE_AMETHYST_BUD).lightLevel((l) -> 4)
            ), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> MEDIUM_JADE_BUD = registerBlock("medium_jade_bud",
            () -> new AmethystClusterBlock(4, 3,
                    BlockBehaviour.Properties
                            .copy(JADE_CLUSTER.get()).sound(SoundType.MEDIUM_AMETHYST_BUD).lightLevel((l) -> 2)
            ), CreativeModeTab.TAB_DECORATIONS);

    public static final RegistryObject<Block> SMALL_JADE_BUD = registerBlock("small_jade_bud",
            () -> new AmethystClusterBlock(3, 4,
                    BlockBehaviour.Properties
                            .copy(JADE_CLUSTER.get()).sound(SoundType.SMALL_AMETHYST_BUD).lightLevel((l) -> 1)
            ), CreativeModeTab.TAB_DECORATIONS);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
