package com.arthobbytwined.advanced_glass_panes.utils;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Objects;

public class BlockRotationHelper {
    public enum BlockFaceQuadrant {
        UP,DOWN,LEFT,RIGHT
    }

    public Direction GetRotatedFace(Direction facing, RotationInfo info) {
        switch(facing){
            case NORTH -> {
                if(info.rotationAxis == Direction.Axis.Y && info.rotationDirection == Rotation.CLOCKWISE_90)
                    return Direction.EAST;
                if(info.rotationAxis == Direction.Axis.Y && info.rotationDirection == Rotation.COUNTERCLOCKWISE_90)
                    return Direction.WEST;
                if(info.rotationAxis == Direction.Axis.X && info.rotationDirection == Rotation.CLOCKWISE_90)
                    return Direction.UP;
                if(info.rotationAxis == Direction.Axis.X && info.rotationDirection == Rotation.COUNTERCLOCKWISE_90)
                    return Direction.DOWN;
            }
            case SOUTH -> {
                if(info.rotationAxis == Direction.Axis.Y && info.rotationDirection == Rotation.CLOCKWISE_90)
                    return Direction.WEST;
                if(info.rotationAxis == Direction.Axis.Y && info.rotationDirection == Rotation.COUNTERCLOCKWISE_90)
                    return Direction.EAST;
                if(info.rotationAxis == Direction.Axis.X && info.rotationDirection == Rotation.CLOCKWISE_90)
                    return Direction.UP;
                if(info.rotationAxis == Direction.Axis.X && info.rotationDirection == Rotation.COUNTERCLOCKWISE_90)
                    return Direction.DOWN;
            }
            case EAST -> {
                if(info.rotationAxis == Direction.Axis.Y && info.rotationDirection == Rotation.CLOCKWISE_90)
                    return Direction.SOUTH;
                if(info.rotationAxis == Direction.Axis.Y && info.rotationDirection == Rotation.COUNTERCLOCKWISE_90)
                    return Direction.NORTH;
                if(info.rotationAxis == Direction.Axis.Z && info.rotationDirection == Rotation.CLOCKWISE_90)
                    return Direction.UP;
                if(info.rotationAxis == Direction.Axis.Z && info.rotationDirection == Rotation.COUNTERCLOCKWISE_90)
                    return Direction.DOWN;
            }
            case WEST -> {
                if(info.rotationAxis == Direction.Axis.Y && info.rotationDirection == Rotation.CLOCKWISE_90)
                    return Direction.NORTH;
                if(info.rotationAxis == Direction.Axis.Y && info.rotationDirection == Rotation.COUNTERCLOCKWISE_90)
                    return Direction.SOUTH;
                if(info.rotationAxis == Direction.Axis.Z && info.rotationDirection == Rotation.CLOCKWISE_90)
                    return Direction.UP;
                if(info.rotationAxis == Direction.Axis.Z && info.rotationDirection == Rotation.COUNTERCLOCKWISE_90)
                    return Direction.DOWN;
            }
            case UP -> {
                if(info.rotationAxis == Direction.Axis.X && info.rotationDirection == Rotation.CLOCKWISE_90)
                    return Direction.SOUTH;
                if(info.rotationAxis == Direction.Axis.X && info.rotationDirection == Rotation.COUNTERCLOCKWISE_90)
                    return Direction.NORTH;
                if(info.rotationAxis == Direction.Axis.Z && info.rotationDirection == Rotation.CLOCKWISE_90)
                    return Direction.WEST;
                if(info.rotationAxis == Direction.Axis.Z && info.rotationDirection == Rotation.COUNTERCLOCKWISE_90)
                    return Direction.EAST;
            }
            case DOWN -> {
                if(info.rotationAxis == Direction.Axis.X && info.rotationDirection == Rotation.CLOCKWISE_90)
                    return Direction.SOUTH;
                if(info.rotationAxis == Direction.Axis.X && info.rotationDirection == Rotation.COUNTERCLOCKWISE_90)
                    return Direction.NORTH;
                if(info.rotationAxis == Direction.Axis.Z && info.rotationDirection == Rotation.CLOCKWISE_90)
                    return Direction.EAST;
                if(info.rotationAxis == Direction.Axis.Z && info.rotationDirection == Rotation.COUNTERCLOCKWISE_90)
                    return Direction.WEST;
            }
        }
        return facing;
    }

    public RotationInfo GetInfo(BlockHitResult result){
        RotationInfo info = new RotationInfo(result);
        switch (result.getDirection()){
            case NORTH, SOUTH -> {
                info.clickedQuadrant = GetClickedQuadrant(result.getDirection(), info.xDiff, info.yDiff);
                switch (Objects.requireNonNull(info.clickedQuadrant)) {
                    case LEFT -> {
                        info.rotationAxis = Direction.Axis.Y;
                        info.rotationDirection = Rotation.CLOCKWISE_90;
                    }
                    case RIGHT -> {
                        info.rotationAxis = Direction.Axis.Y;
                        info.rotationDirection = Rotation.COUNTERCLOCKWISE_90;
                    }
                    case UP -> {
                        info.rotationAxis = Direction.Axis.X;
                        info.rotationDirection = Rotation.CLOCKWISE_90;
                    }
                    case DOWN -> {
                        info.rotationAxis = Direction.Axis.X;
                        info.rotationDirection = Rotation.COUNTERCLOCKWISE_90;
                    }
                }
            }
            case EAST, WEST -> {
                info.clickedQuadrant = GetClickedQuadrant(result.getDirection(), info.zDiff, info.yDiff);
                switch (Objects.requireNonNull(info.clickedQuadrant)) {
                    case LEFT -> {
                        info.rotationAxis = Direction.Axis.Y;
                        info.rotationDirection = Rotation.CLOCKWISE_90;
                    }
                    case RIGHT -> {
                        info.rotationAxis = Direction.Axis.Y;
                        info.rotationDirection = Rotation.COUNTERCLOCKWISE_90;
                    }
                    case UP -> {
                        info.rotationAxis = Direction.Axis.Z;
                        info.rotationDirection = Rotation.CLOCKWISE_90;
                    }
                    case DOWN -> {
                        info.rotationAxis = Direction.Axis.Z;
                        info.rotationDirection = Rotation.COUNTERCLOCKWISE_90;
                    }
                }
            }
            case UP, DOWN -> {
                info.clickedQuadrant = GetClickedQuadrant(result.getDirection(), info.zDiff, info.xDiff);
                switch (Objects.requireNonNull(info.clickedQuadrant)) {
                    case LEFT -> {
                        info.rotationAxis = Direction.Axis.X;
                        info.rotationDirection = Rotation.CLOCKWISE_90;
                    }
                    case RIGHT -> {
                        info.rotationAxis = Direction.Axis.X;
                        info.rotationDirection = Rotation.COUNTERCLOCKWISE_90;
                    }
                    case UP -> {
                        info.rotationAxis = Direction.Axis.Z;
                        info.rotationDirection = Rotation.CLOCKWISE_90;
                    }
                    case DOWN -> {
                        info.rotationAxis = Direction.Axis.Z;
                        info.rotationDirection = Rotation.COUNTERCLOCKWISE_90;
                    }
                }
            }
        }

        return info;
    }

    private BlockFaceQuadrant GetClickedQuadrant(Direction clickedFace, double horizontal, double vertical){
        double rotatedX = RotateA(horizontal, vertical);
        double rotatedY = RotateB(horizontal, vertical);
        if(rotatedX > 0 && rotatedY > 0) {
            return switch(clickedFace) {
                case NORTH, EAST, DOWN, UP -> BlockFaceQuadrant.LEFT;
                case SOUTH, WEST -> BlockFaceQuadrant.RIGHT;
            };
        }
        if(rotatedX <= 0 && rotatedY > 0) {
            return switch (clickedFace) {
                case NORTH, EAST, SOUTH, WEST, DOWN -> BlockFaceQuadrant.UP;
                case UP -> BlockFaceQuadrant.DOWN;
            };
        }
        if(rotatedX <= 0 && rotatedY <= 0) {
            return switch (clickedFace) {
                case NORTH, EAST, DOWN, UP -> BlockFaceQuadrant.RIGHT;
                case SOUTH, WEST -> BlockFaceQuadrant.LEFT;
            };
        }
        if(rotatedX > 0 && rotatedY <= 0) {
            return switch (clickedFace) {
                case NORTH, EAST, SOUTH, WEST, DOWN -> BlockFaceQuadrant.DOWN;
                case UP -> BlockFaceQuadrant.UP;
            };
        }
        return null;
    }

    private double RotateA(double a, double b){
        return a * Math.cos(Math.toRadians(45)) - b * Math.sin(Math.toRadians(45));
    }

    private double RotateB(double a, double b){
        return a * Math.sin(Math.toRadians(45)) + b * Math.cos(Math.toRadians(45));
    }

    public static class RotationInfo {
        public RotationInfo(BlockHitResult result) {
            xDiff = result.getLocation().x() - result.getBlockPos().getX() - 0.5;
            yDiff = result.getLocation().y() - result.getBlockPos().getY() - 0.5;
            zDiff = result.getLocation().z() - result.getBlockPos().getZ() - 0.5;
        }
        public BlockFaceQuadrant clickedQuadrant;
        public Direction.Axis rotationAxis;
        public Rotation rotationDirection;
        public double xDiff;
        public double yDiff;
        public double zDiff;
    }
}
