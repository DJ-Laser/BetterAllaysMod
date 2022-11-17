package com.djlaser.betterallays.block;

import com.djlaser.betterallays.BetterAllays;
import com.djlaser.betterallays.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
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

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab){
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
