package com.djlaser.betterallays.integration.jei;

import com.djlaser.betterallays.BetterAllays;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public class JEIBetterAllaysPlugin implements IModPlugin {

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(BetterAllays.MODID, "jei_plugin");
    }
}
