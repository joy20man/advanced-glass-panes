package com.arthobbytwined.advanced_glass_panes.initializers;

import com.arthobbytwined.advanced_glass_panes.AdvancedGlassPanes;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInitializer {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, AdvancedGlassPanes.MODID);
    
    public static final RegistryObject<BlockItem> SINGLE_GLASS_PANE = CreativeTabInitializer.addToTab(ITEMS.register(
        "single_glass_pane", () -> 
            new BlockItem(BlockInitializer.SINGLE_GLASS_PANE.get(), 
            new Item.Properties().stacksTo(64))));
    public static final RegistryObject<BlockItem> DOUBLE_GLASS_PANE = CreativeTabInitializer.addToTab(ITEMS.register(
        "double_glass_pane", () ->
            new BlockItem(BlockInitializer.DOUBLE_GLASS_PANE.get(),
            new Item.Properties().stacksTo(64))));
}