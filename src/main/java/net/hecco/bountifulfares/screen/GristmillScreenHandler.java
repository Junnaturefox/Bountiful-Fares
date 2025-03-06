package net.hecco.bountifulfares.screen;

import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.block.custom.GristmillBlock;
import net.hecco.bountifulfares.block.entity.network.GristmillPayload;
import net.hecco.bountifulfares.block.entity.slot.GristmillOutputSlot;
import net.hecco.bountifulfares.registry.misc.BFScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class GristmillScreenHandler extends ScreenHandler {

    private final Inventory inventory;
    public final PropertyDelegate propertyDelegate;
    public final Boolean milling;

    public boolean isCrafting() {
        return true;
    }

    public int getScaledProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int progressArrowSize = 35;

        int scaledProgress = (int) (((float) progress / (float) maxProgress) * progressArrowSize);
        BountifulFares.LOGGER.info("Progress: " + progress + " / " + maxProgress + " -> Scaled: " + scaledProgress);

        return scaledProgress;
    }

    public GristmillScreenHandler(int syncId, PlayerInventory playerInventory, GristmillPayload payload) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(payload.pos()), new ArrayPropertyDelegate(2));
    }

    public GristmillScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate propertyDelegate) {
        super(BFScreenHandlers.GRISTMILL_SCREEN_HANDLER, syncId);
        checkSize(((Inventory) blockEntity), 2);
        this.inventory = (Inventory)blockEntity;
        this.milling = playerInventory.player.getWorld().getBlockState(blockEntity.getPos()).get(GristmillBlock.MILLING);
        this.propertyDelegate = propertyDelegate;
        this.addSlot(new Slot(inventory, 0, 44, 36));
        this.addSlot(new GristmillOutputSlot(inventory, 1, 116, 36));

        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }
    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);

    }
    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}