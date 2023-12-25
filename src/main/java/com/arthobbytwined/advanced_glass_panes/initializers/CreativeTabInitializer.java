package com.arthobbytwined.advanced_glass_panes.initializers;

import com.arthobbytwined.advanced_glass_panes.AdvancedGlassPanes;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;
import java.util.List;
import java.util.ArrayList;

public class CreativeTabInitializer {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AdvancedGlassPanes.MODID);

    public static final List<Supplier<? extends ItemLike>> ADVANCED_GLASS_PANES_ITEMS = new ArrayList<>();
    public static final RegistryObject<CreativeModeTab> ADVANCED_GLASS_PANES_TAB = TABS.register(
            "advanced_glass_panes_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.advanced_glass_panes"))
                    .icon(ItemInitializer.DOUBLE_GLASS_PANE.get()::getDefaultInstance)
                    .displayItems((displayParams, output) ->
                        ADVANCED_GLASS_PANES_ITEMS.forEach(item -> output.accept(item.get())))
                    .build());

    public static <T extends Item> RegistryObject<T> addToTab(RegistryObject<T> registeredItems){
        ADVANCED_GLASS_PANES_ITEMS.add(registeredItems);
        return registeredItems;
    }
}
