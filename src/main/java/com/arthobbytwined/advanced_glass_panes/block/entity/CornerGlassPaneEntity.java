package com.arthobbytwined.advanced_glass_panes.block.entity;

import com.arthobbytwined.advanced_glass_panes.initializers.BlockEntityInitializer;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CornerGlassPaneEntity extends BlockEntity {
    public CornerGlassPaneEntity(BlockPos position, BlockState state) {
        super(BlockEntityInitializer.CORNER_GLASS_PANE_ENTITY.get(), position, state);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
    }
}
