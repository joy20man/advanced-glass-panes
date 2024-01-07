package com.arthobbytwined.advanced_glass_panes.block;

import com.arthobbytwined.advanced_glass_panes.initializers.BlockEntityInitializer;
import com.arthobbytwined.advanced_glass_panes.utils.BlockRotationHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class CornerGlassPane extends HorizontalDirectionalBlock implements EntityBlock {
    protected static final VoxelShape NORTH_AABB =
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 2.0D);
    protected static final VoxelShape SOUTH_AABB =
            Block.box(0.0D, 0.0D, 14.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape EAST_AABB =
            Block.box(14.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape WEST_AABB =
            Block.box(0.0D, 0.0D, 0.0D, 2.0D, 16.0D, 16.0D);

    public CornerGlassPane(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(FACING, Direction.NORTH));
    }

    @Override
    @SuppressWarnings("deprecation")
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos position, CollisionContext context) {
        return switch(state.getValue(FACING)) {
            case NORTH -> Shapes.join(NORTH_AABB, WEST_AABB, BooleanOp.OR);
            case SOUTH -> Shapes.join(SOUTH_AABB, EAST_AABB, BooleanOp.OR);
            case EAST -> Shapes.join(EAST_AABB, NORTH_AABB, BooleanOp.OR);
            case WEST -> Shapes.join(WEST_AABB, SOUTH_AABB, BooleanOp.OR);
            default -> throw new IllegalStateException("Unexpected value: " + state.getValue(FACING));
        };
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos position, BlockState state) {
        return BlockEntityInitializer.CORNER_GLASS_PANE_ENTITY.get().create(position, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Direction direction = context.getHorizontalDirection().getOpposite();
        return defaultBlockState().setValue(FACING, direction);
    }

    @Override
    @SuppressWarnings("deprecation")
    public InteractionResult use(BlockState state, Level level, BlockPos position, Player player, InteractionHand hand, BlockHitResult result) {
        if(!level.isClientSide() && player.getMainHandItem().getCount() == 0 && hand.equals(InteractionHand.MAIN_HAND)){
            BlockRotationHelper rotationHelper = new BlockRotationHelper();
            var info = new BlockRotationHelper.RotationInfo(result);
            info.rotationAxis = Direction.Axis.Y;
            info.rotationDirection = Rotation.COUNTERCLOCKWISE_90;
            Direction newDirection = rotationHelper.GetRotatedFace(state.getValue(FACING), info);
            level.setBlockAndUpdate(position, state.setValue(FACING, newDirection));
        }
        return super.use(state, level, position, player, hand, result);
    }
}