package com.iwaliner.urushi.common.blockentity;

import com.iwaliner.urushi.registries.BlockEntityRegister;
import com.iwaliner.urushi.common.block.SenryoubakoBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
 
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;


import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;

import javax.annotation.Nullable;
import java.util.stream.IntStream;

public class SenryoubakoBlockEntity extends RandomizableContainerBlockEntity implements WorldlyContainer {
    public static final int COLUMNS = 9;
    public static final int ROWS = 3;
    public static final int CONTAINER_SIZE = 27;
    public static final int EVENT_SET_OPEN_COUNT = 1;
    public static final int OPENING_TICK_LENGTH = 10;
    public static final float MAX_LID_HEIGHT = 0.5F;
    public static final float MAX_LID_ROTATION = 270.0F;
    public static final String ITEMS_TAG = "Items";
    private static final int[] SLOTS = IntStream.range(0, 54).toArray();
    private NonNullList<ItemStack> itemStacks = NonNullList.withSize(54, ItemStack.EMPTY);
    private int openCount;
    private ShulkerBoxBlockEntity.AnimationStatus animationStatus = ShulkerBoxBlockEntity.AnimationStatus.CLOSED;
    private float progress;
    private float progressOld;

    private final SidedInvWrapper handler = new SidedInvWrapper(this, null);

    public SidedInvWrapper getItemHandler() {
        return handler;
    }


    public SenryoubakoBlockEntity(@Nullable DyeColor p_155666_, BlockPos p_155667_, BlockState p_155668_) {
        super(BlockEntityRegister.SenryoubakoBlockEntity.get(), p_155667_, p_155668_);
    }



    public SenryoubakoBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegister.SenryoubakoBlockEntity.get(), pos, state);
    }


    public static void tick(Level p_155673_, BlockPos p_155674_, BlockState p_155675_, SenryoubakoBlockEntity p_155676_) {
        p_155676_.updateAnimation(p_155673_, p_155674_, p_155675_);
    }

    private void updateAnimation(Level p_155680_, BlockPos p_155681_, BlockState p_155682_) {
        this.progressOld = this.progress;
        switch(this.animationStatus) {
            case CLOSED:
                this.progress = 0.0F;
                break;
            case OPENING:
                this.progress += 0.1F;
                if (this.progress >= 1.0F) {
                    this.animationStatus = ShulkerBoxBlockEntity.AnimationStatus.OPENED;
                    this.progress = 1.0F;
                    doNeighborUpdates(p_155680_, p_155681_, p_155682_);
                }

               // this.moveCollidedEntities(p_155680_, p_155681_, p_155682_);
                break;
            case CLOSING:
                this.progress -= 0.1F;
                if (this.progress <= 0.0F) {
                    this.animationStatus = ShulkerBoxBlockEntity.AnimationStatus.CLOSED;
                    this.progress = 0.0F;
                    doNeighborUpdates(p_155680_, p_155681_, p_155682_);
                }
                break;
            case OPENED:
                this.progress = 1.0F;
        }

    }

    public ShulkerBoxBlockEntity.AnimationStatus getAnimationStatus() {
        return this.animationStatus;
    }





    public int getContainerSize() {
        return this.itemStacks.size();
    }

    public boolean triggerEvent(int p_59678_, int p_59679_) {
        if (p_59678_ == 1) {
            this.openCount = p_59679_;
            if (p_59679_ == 0) {
                this.animationStatus = ShulkerBoxBlockEntity.AnimationStatus.CLOSING;
                doNeighborUpdates(this.getLevel(), this.worldPosition, this.getBlockState());
            }

            if (p_59679_ == 1) {
                this.animationStatus = ShulkerBoxBlockEntity.AnimationStatus.OPENING;
                doNeighborUpdates(this.getLevel(), this.worldPosition, this.getBlockState());
            }

            return true;
        } else {
            return super.triggerEvent(p_59678_, p_59679_);
        }
    }

    private static void doNeighborUpdates(Level p_155688_, BlockPos p_155689_, BlockState p_155690_) {
        p_155690_.updateNeighbourShapes(p_155688_, p_155689_, 3);
    }

    public void startOpen(Player p_59692_) {
        if (!p_59692_.isSpectator()) {
            if (this.openCount < 0) {
                this.openCount = 0;
            }

            ++this.openCount;
            this.level.blockEvent(this.worldPosition, this.getBlockState().getBlock(), 1, this.openCount);
            if (this.openCount == 1) {
                this.level.gameEvent(p_59692_, GameEvent.CONTAINER_OPEN, this.worldPosition);
                this.level.playSound((Player)null, this.worldPosition, SoundEvents.SHULKER_BOX_OPEN, SoundSource.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
            }
        }

    }

    public void stopOpen(Player p_59688_) {
        if (!p_59688_.isSpectator()) {
            --this.openCount;
            this.level.blockEvent(this.worldPosition, this.getBlockState().getBlock(), 1, this.openCount);
            if (this.openCount <= 0) {
                this.level.gameEvent(p_59688_, GameEvent.CONTAINER_CLOSE, this.worldPosition);
                this.level.playSound((Player)null, this.worldPosition, SoundEvents.SHULKER_BOX_CLOSE, SoundSource.BLOCKS, 0.5F, this.level.random.nextFloat() * 0.1F + 0.9F);
            }
        }

    }

    protected Component getDefaultName() {
        return Component.translatable("container.senryoubako");
    }

    @Override
    public void loadAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
        super.loadAdditional(compound, lookupProvider);
        this.itemStacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if (!this.tryLoadLootTable(compound) && compound.contains("Items", 9)) {
            ContainerHelper.loadAllItems(compound, this.itemStacks, lookupProvider);
        }
    }

    protected void saveAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
        super.saveAdditional(compound, lookupProvider);
        if (!this.trySaveLootTable(compound)) {
            ContainerHelper.saveAllItems(compound, this.itemStacks, lookupProvider);
        }

    }

    protected NonNullList<ItemStack> getItems() {
        return this.itemStacks;
    }

    protected void setItems(NonNullList<ItemStack> p_59674_) {
        this.itemStacks = p_59674_;
    }

    public int[] getSlotsForFace(Direction p_59672_) {
        return SLOTS;
    }

    public boolean canPlaceItemThroughFace(int p_59663_, ItemStack p_59664_, @Nullable Direction p_59665_) {
        return !(Block.byItem(p_59664_.getItem()) instanceof SenryoubakoBlock);
    }

    public boolean canTakeItemThroughFace(int p_59682_, ItemStack p_59683_, Direction p_59684_) {
        return true;
    }

    public float getProgress(float p_59658_) {
        return Mth.lerp(p_59658_, this.progressOld, this.progress);
    }



    protected AbstractContainerMenu createMenu(int p_59660_, Inventory p_59661_) {
        return ChestMenu.sixRows(p_59660_, p_59661_, this);
    }

    public boolean isClosed() {
        return this.animationStatus == ShulkerBoxBlockEntity.AnimationStatus.CLOSED;
    }

//    @Override
//    protected net.minecraftforge.item.IItemHandler createUnSidedHandler() {
//        return new net.minecraftforge.item.wrapper.SidedInvWrapper(this, Direction.UP);
//    }

    public static enum AnimationStatus {
        CLOSED,
        OPENING,
        OPENED,
        CLOSING;
    }
}
