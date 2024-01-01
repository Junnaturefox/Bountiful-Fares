package net.hecco.bountifulcuisine.block.entity;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.hecco.bountifulcuisine.networking.ModMessages;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class CeramicDishBlockEntity extends BlockEntity implements ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);
    private static final int[] SLOTS = new int[]{0};
    public CeramicDishBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CERAMIC_DISH_BLOCK_ENTITY, pos, state);

    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        super.readNbt(nbt);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    public boolean canInsertItem() {
        return this.getStack(0).isEmpty();
    }

    public void insertItem(ItemStack item) {
        assert world != null;
        if (!world.isClient()) {
            this.setStack(0, item.copyWithCount(1));
            markDirty();
        }
    }

    public void removeItem() {
        assert world != null;
        if (!world.isClient()) {
            this.setStack(0, Items.AIR.getDefaultStack());
            markDirty();
        }
    }

    @Override
    public int[] getAvailableSlots(Direction side) {
        if (side == Direction.DOWN) {
            return SLOTS;
        }
        if (side == Direction.UP) {
            return SLOTS;
        }
        return SLOTS;
    }

    public void setInventory(DefaultedList<ItemStack> list) {
        this.inventory.set(0, list.get(0));
    }

    public ItemStack getRenderStack() {
        return this.getStack(0);
    }

    @Override
    public void markDirty() {
        if (!world.isClient()) {
            PacketByteBuf data = PacketByteBufs.create();
            data.writeInt(inventory.size());
            for (int i = 0; i < inventory.size(); i++) {
                data.writeItemStack(inventory.get(i));
            }
            data.writeBlockPos(getPos());
            for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())) {
                ServerPlayNetworking.send(player, ModMessages.CERAMIC_DISH_ITEM_SYNC, data);
            }
        }
        super.markDirty();
    }
}