package com.arthobbytwined.advanced_glass_panes.initializers;

import com.arthobbytwined.advanced_glass_panes.AdvancedGlassPanes;

import com.arthobbytwined.advanced_glass_panes.block.CornerGlassPane;
import com.arthobbytwined.advanced_glass_panes.block.DoubleGlassPane;
import com.arthobbytwined.advanced_glass_panes.block.SingleGlassPane;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.level.material.MapColor.NONE;

public class BlockInitializer {
    public static final DeferredRegister<Block> BLOCKS =
        DeferredRegister.create(ForgeRegistries.BLOCKS, AdvancedGlassPanes.MODID);

    public static final RegistryObject<SingleGlassPane> SINGLE_GLASS_PANE = BLOCKS.register(
    "single_glass_pane", () -> new SingleGlassPane(BlockBehaviour.Properties.of()
            .mapColor(NONE)
            .strength(0.6f)
            .noOcclusion()));

    public static final RegistryObject<DoubleGlassPane> DOUBLE_GLASS_PANE = BLOCKS.register(
    "double_glass_pane", () -> new DoubleGlassPane(BlockBehaviour.Properties.of()
            .mapColor(NONE)
            .strength(0.6f)
            .noOcclusion()));

    public static final RegistryObject<CornerGlassPane> CORNER_GLASS_PANE = BLOCKS.register(
            "corner_glass_pane", () -> new CornerGlassPane(BlockBehaviour.Properties.of()
                    .mapColor(NONE)
                    .strength(0.6f)
                    .noOcclusion()));
}
