package com.djlaser.betterallays.item;

import com.djlaser.betterallays.BetterAllays;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BetterAllays.MODID);

    public static final RegistryObject<Item> HEADPHONES = ITEMS.register("white_headphones",
            () -> new Item(new Item.Properties()
                    .tab(CreativeModeTab.TAB_MISC)
                    .stacksTo(1)
            ));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
