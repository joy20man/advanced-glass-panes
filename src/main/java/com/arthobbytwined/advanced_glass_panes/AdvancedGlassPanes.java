package com.arthobbytwined.advanced_glass_panes;

import com.arthobbytwined.advanced_glass_panes.initializers.BlockEntityInitializer;
import com.arthobbytwined.advanced_glass_panes.initializers.BlockInitializer;
import com.arthobbytwined.advanced_glass_panes.initializers.CreativeTabInitializer;
import com.arthobbytwined.advanced_glass_panes.initializers.ItemInitializer;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(AdvancedGlassPanes.MODID)
public class AdvancedGlassPanes {
    public static final String MODID = "advanced_glass_panes";
    
    public AdvancedGlassPanes() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        BlockInitializer.BLOCKS.register(bus);
        ItemInitializer.ITEMS.register(bus);
        CreativeTabInitializer.TABS.register(bus);
        BlockEntityInitializer.BLOCK_ENTITIES.register(bus);
    }
}