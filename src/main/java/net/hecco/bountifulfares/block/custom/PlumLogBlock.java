package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.BFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class PlumLogBlock extends FruitLogBlock {
    public PlumLogBlock(Block leaves, Block floweringleaves, Settings settings) {
        super(leaves, floweringleaves, settings);
    }

    @Override
    protected boolean shouldBeLeafy(WorldView world, BlockPos pos, BlockState blockState) {
        Direction.Axis axis = blockState.get(PlumLogBlock.AXIS);
        Direction[] directions;
        if (axis == Direction.Axis.X) {
            directions = new Direction[]{Direction.UP, Direction.DOWN, Direction.NORTH, Direction.SOUTH};
        } else if (axis == Direction.Axis.Z) {
            directions = new Direction[]{Direction.UP, Direction.DOWN, Direction.WEST, Direction.EAST};
        } else {
            // No rotation needed for Y axis
            directions = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};
        }

        for (Direction direction : directions) {
            BlockState neighborState = world.getBlockState(pos.offset(direction));
            if (neighborState.getBlock() != BFBlocks.PLUM_LEAVES && neighborState.getBlock() != BFBlocks.FLOWERING_PLUM_LEAVES) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if (!world.isClient) {
            boolean shouldBeLeafy = shouldBeLeafy(world, pos, state);
            if (shouldBeLeafy && !state.get(LEAFY)) {
                world.setBlockState(pos, state.with(LEAFY, true), 2);
                world.updateListeners(pos, state, state, 3); // Trigger immediate block update
            } else if (!shouldBeLeafy && state.get(LEAFY)) {
                world.setBlockState(pos, state.with(LEAFY, false), 2);
                world.updateListeners(pos, state, state, 3); // Trigger immediate block update
            }
        }
    }

}