package net.hecco.bountifulfares.block.custom;

import net.hecco.bountifulfares.block.entity.DyeableCeramicBlockEntity;
import net.hecco.bountifulfares.block.interfaces.DyeableCeramicBlockInterface;
import net.hecco.bountifulfares.item.BFItems;
import net.hecco.bountifulfares.item.custom.ArtisanBrushItem;
import net.hecco.bountifulfares.item.custom.DyeableCeramicBlockItem;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class CeramicDoorBlock extends DoorBlock implements DyeableCeramicBlockInterface {
    private final BlockSetType blockSetType;

    public CeramicDoorBlock(Settings settings, BlockSetType blockSetType) {
        super(settings, blockSetType);
        this.blockSetType = blockSetType;
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        if (DyeableCeramicBlockEntity.getColor(world, pos) != DyeableCeramicBlockEntity.DEFAULT_COLOR) {
            ItemStack stack = super.getPickStack(world, pos, state);
            return pickBlock(world,pos,stack);
        } else {
            return new ItemStack(this);
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(BFItems.ARTISAN_BRUSH) && !player.isSneaking() && itemStack.getSubNbt(ArtisanBrushItem.DISPLAY_KEY) != null) {
            int brushColor = itemStack.getSubNbt(ArtisanBrushItem.DISPLAY_KEY).getInt(ArtisanBrushItem.COLOR_KEY);
            if (state.get(HALF) == DoubleBlockHalf.LOWER && world.getBlockState(pos.up()).isOf(this)) {
//                world.removeBlock(pos.up(), false);
                world.setBlockState(pos.up(), this.getDefaultState().with(FACING, state.get(FACING)).with(HALF, DoubleBlockHalf.UPPER).with(OPEN, state.get(OPEN)).with(HINGE, state.get(HINGE)), 0);
                if (world.getBlockEntity(pos.up()) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity && dyeableCeramicBlockEntity.color != brushColor) {
                    dyeableCeramicBlockEntity.color = brushColor;
                    dyeableCeramicBlockEntity.markDirty();
                }
            }
            if (state.get(HALF) == DoubleBlockHalf.UPPER && world.getBlockState(pos.down()).isOf(this)) {
//                world.removeBlock(pos.down(), false);
                world.setBlockState(pos.down(), this.getDefaultState().with(FACING, state.get(FACING)).with(HALF, DoubleBlockHalf.LOWER).with(OPEN, state.get(OPEN)).with(HINGE, state.get(HINGE)), 0);
                if (world.getBlockEntity(pos.down()) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity && dyeableCeramicBlockEntity.color != brushColor) {
                    dyeableCeramicBlockEntity.color = brushColor;
                    dyeableCeramicBlockEntity.markDirty();
                }
            }
            world.removeBlock(pos, false);
            world.setBlockState(pos, this.getStateWithProperties(state), 0);
            world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_DYE_USE, SoundCategory.BLOCKS, 1.0F, 0.8F + (world.random.nextFloat() / 3));
            if (world.getBlockEntity(pos) instanceof DyeableCeramicBlockEntity dyeableCeramicBlockEntity && dyeableCeramicBlockEntity.color != brushColor) {
                dyeableCeramicBlockEntity.color = brushColor;
                dyeableCeramicBlockEntity.markDirty();
                return ActionResult.SUCCESS;
            }
        }
        if (!state.get(POWERED)) {
            if (!this.blockSetType.canOpenByHand()) {
                return ActionResult.PASS;
            } else {
                state = state.cycle(OPEN);
                world.setBlockState(pos, state, 10);
                this.playOpenCloseSound(player, world, pos, state.get(OPEN));
                world.emitGameEvent(player, this.isOpen(state) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
                return ActionResult.success(world.isClient);
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        DoubleBlockHalf doubleBlockHalf = state.get(HALF);
        DyeableCeramicBlockEntity entity = (DyeableCeramicBlockEntity) world.getBlockEntity(pos);
        DyeableCeramicBlockEntity topentity = (DyeableCeramicBlockEntity) world.getBlockEntity(pos.up());
        DyeableCeramicBlockEntity bottomentity = (DyeableCeramicBlockEntity) world.getBlockEntity(pos.down());
        if (doubleBlockHalf == DoubleBlockHalf.LOWER && world.getBlockState(pos.up()).isOf(this) && entity.color == topentity.color) {
            if (direction.getAxis() == Direction.Axis.Y && doubleBlockHalf == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
                return neighborState.isOf(this) && neighborState.get(HALF) != doubleBlockHalf ? state.with(FACING, neighborState.get(FACING)).with(OPEN, neighborState.get(OPEN)).with(HINGE, neighborState.get(HINGE)).with(POWERED, neighborState.get(POWERED)) : Blocks.AIR.getDefaultState();
            } else {
                if (direction == Direction.DOWN && !state.canPlaceAt(world, pos)) {
                    world.scheduleBlockTick(pos.up(), this, 1);
                    return Blocks.AIR.getDefaultState();
                } else {
                    return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
                }
            }
        }
        if (doubleBlockHalf == DoubleBlockHalf.UPPER && world.getBlockState(pos.down()).isOf(this) && entity.color == bottomentity.color) {
            return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }
        return state;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        boolean bl = world.isReceivingRedstonePower(pos) || world.isReceivingRedstonePower(pos.offset(state.get(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));
        if (!this.getDefaultState().isOf(sourceBlock) && bl != state.get(POWERED)) {
            if (bl != state.get(POWERED)) {
                if (!state.get(POWERED)) {
                    state = state.cycle(OPEN);
                    this.playOpenCloseSound(null, world, pos, bl);
                }
                world.setBlockState(pos, state.with(POWERED, bl), 2);
            }
//            if (!state.get(POWERED)) {
//                if (bl != state.get(OPEN)) {
//                    this.playOpenCloseSound(null, world, pos, bl);
//                    world.emitGameEvent(null, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
//                }
//
//                world.setBlockState(pos, (state.with(POWERED, bl)).cycle(OPEN), 2);
//            }
        }

    }

    private void playOpenCloseSound(@Nullable Entity entity, World world, BlockPos pos, boolean open) {
        world.playSound(entity, pos, open ? this.blockSetType.doorOpen() : this.blockSetType.doorClose(), SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        world.setBlockState(pos.up(), state.with(HALF, DoubleBlockHalf.UPPER), 3);
        if (world.getBlockEntity(pos.up()) instanceof DyeableCeramicBlockEntity entity) {
            DyeableCeramicBlockItem thisEntity = (DyeableCeramicBlockItem) itemStack.getItem();
            entity.color = thisEntity.getColor(itemStack);
            entity.markDirty();
        }
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (state.get(HALF) == DoubleBlockHalf.LOWER && world.getBlockState(pos.up()).isOf(this)) {
            world.scheduleBlockTick(pos.up(), this, 1);
        }
        if (state.get(HALF) == DoubleBlockHalf.UPPER && world.getBlockState(pos.down()).isOf(this)) {
            world.scheduleBlockTick(pos.down(), this, 1);
        }
        super.onBreak(world, pos, state, player);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.breakBlock(pos, true);
        super.scheduledTick(state, world, pos, random);
    }
}

