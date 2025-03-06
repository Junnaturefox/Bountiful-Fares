package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.registry.content.BFSounds;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class CeramicLeverBlock extends LeverBlock implements BlockEntityProvider {

    public CeramicLeverBlock(Settings settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return DyeableCeramicBlock.createBlockEntity(pos, state);
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return DyeableCeramicBlock.getPickStack(world, pos, state.getBlock());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (DyeableCeramicBlock.onUse(state, world, pos, player, state.getBlock()) == ActionResult.PASS) {
            BlockState blockState;
            if (world.isClient) {
                blockState = state.cycle(POWERED);
                if (blockState.get(POWERED)) {
                    this.spawnParticles(blockState, world, pos, 1.0F);
                }

                return ActionResult.SUCCESS;
            } else {
                this.togglePower(state, world, pos, player);
                SoundEvent f = state.get(POWERED) ? BFSounds.CERAMIC_LEVER_OFF : BFSounds.CERAMIC_LEVER_ON;
                world.playSound(null, pos, f, SoundCategory.BLOCKS, 0.8F, 1);
                world.emitGameEvent(player, state.get(POWERED) ? GameEvent.BLOCK_ACTIVATE : GameEvent.BLOCK_DEACTIVATE, pos);
                return ActionResult.CONSUME;
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACE)) {
            case FLOOR:
                return Block.createCuboidShape(4, 0, 4, 12, 2, 12);
            case WALL:
                switch (state.get(FACING)) {
                    case EAST:
                        return Block.createCuboidShape(0, 4, 4, 2, 12, 12);
                    case WEST:
                        return Block.createCuboidShape(14, 4, 4, 16, 12, 12);
                    case SOUTH:
                        return Block.createCuboidShape(4, 4, 0, 12, 12, 2);
                    case NORTH:
                    default:
                        return Block.createCuboidShape(4, 4, 14, 12, 12, 16);
                }
            case CEILING:
            default:
                return Block.createCuboidShape(4, 14, 4, 12, 16, 12);
        }
    }
}
