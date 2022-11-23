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

    private static RegistryObject<Item> makeHeadphone(String color){
        return ITEMS.register(color + "_headphones",
                () -> new Item(new Item.Properties()
                        .tab(CreativeModeTab.TAB_MISC)
                        .stacksTo(1)
                ));
    }

    public static final RegistryObject<Item> JADE_SHARD = ITEMS.register("jade_shard", () ->
            new Item(new Item.Properties()
                    .tab(CreativeModeTab.TAB_MATERIALS)
            ));
    public static final RegistryObject<Item> BLACK_HEADPHONES = makeHeadphone("black");
    public static final RegistryObject<Item> BLUE_HEADPHONES = makeHeadphone("blue");
    public static final RegistryObject<Item> BROWN_HEADPHONES = makeHeadphone("brown");
    public static final RegistryObject<Item> CYAN_HEADPHONES = makeHeadphone("cyan");
    public static final RegistryObject<Item> GRAY_HEADPHONES = makeHeadphone("gray");
    public static final RegistryObject<Item> GREEN_HEADPHONES = makeHeadphone("green");
    public static final RegistryObject<Item> LIGHT_BLUE_HEADPHONES = makeHeadphone("light_blue");
    public static final RegistryObject<Item> LIGHT_GRAY_HEADPHONES = makeHeadphone("light_gray");
    public static final RegistryObject<Item> LIME_HEADPHONES = makeHeadphone("lime");
    public static final RegistryObject<Item> MAGENTA_HEADPHONES = makeHeadphone("magenta");
    public static final RegistryObject<Item> ORANGE_HEADPHONES = makeHeadphone("orange");
    public static final RegistryObject<Item> PINK_HEADPHONES = makeHeadphone("pink");
    public static final RegistryObject<Item> PURPLE_HEADPHONES = makeHeadphone("purple");
    public static final RegistryObject<Item> RED_HEADPHONES = makeHeadphone("red");
    public static final RegistryObject<Item> WHITE_HEADPHONES = makeHeadphone("white");
    public static final RegistryObject<Item> YELLOW_HEADPHONES = makeHeadphone("yellow");


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
