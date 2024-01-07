package com.arthobbytwined.advanced_glass_panes.initializers;

import com.arthobbytwined.advanced_glass_panes.AdvancedGlassPanes;

import com.arthobbytwined.advanced_glass_panes.block.entity.CornerGlassPaneEntity;
import com.arthobbytwined.advanced_glass_panes.block.entity.SingleGlassPaneEntity;
import com.arthobbytwined.advanced_glass_panes.block.entity.DoubleGlassPaneEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityInitializer {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
        DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, AdvancedGlassPanes.MODID);

    public static final RegistryObject<BlockEntityType<SingleGlassPaneEntity>> SINGLE_GLASS_PANE_ENTITY =
        BLOCK_ENTITIES.register("single_glass_pane", () ->
            BlockEntityType.Builder.of(
                SingleGlassPaneEntity::new, BlockInitializer.SINGLE_GLASS_PANE.get()).build(null));

    public static final RegistryObject<BlockEntityType<DoubleGlassPaneEntity>> DOUBLE_GLASS_PANE_ENTITY =
        BLOCK_ENTITIES.register("double_glass_pane", () ->
            BlockEntityType.Builder.of(
                DoubleGlassPaneEntity::new, BlockInitializer.DOUBLE_GLASS_PANE.get()).build(null));

    public static final RegistryObject<BlockEntityType<CornerGlassPaneEntity>> CORNER_GLASS_PANE_ENTITY =
        BLOCK_ENTITIES.register("corner_glass_pane", () ->
            BlockEntityType.Builder.of(
                CornerGlassPaneEntity::new, BlockInitializer.CORNER_GLASS_PANE.get()).build(null));
}
