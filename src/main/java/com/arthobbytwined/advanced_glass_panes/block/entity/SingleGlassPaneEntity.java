package com.arthobbytwined.advanced_glass_panes.block.entity;

import com.arthobbytwined.advanced_glass_panes.initializers.BlockEntityInitializer;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SingleGlassPaneEntity extends BlockEntity {
    public SingleGlassPaneEntity(BlockPos position, BlockState state) {
        super(BlockEntityInitializer.SINGLE_GLASS_PANE_ENTITY.get(), position, state);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
    }
}
