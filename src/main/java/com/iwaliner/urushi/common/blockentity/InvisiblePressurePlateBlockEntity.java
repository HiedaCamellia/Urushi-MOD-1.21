package com.iwaliner.urushi.common.blockentity;

import com.iwaliner.urushi.registries.BlockEntityRegister;
import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class InvisiblePressurePlateBlockEntity extends BlockEntity {
    public int time;

    public InvisiblePressurePlateBlockEntity(BlockPos p_155550_, BlockState p_155551_) {
        super(BlockEntityRegister.InvisiblePressurePlate.get(), p_155550_, p_155551_);
    }
    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider lookupProvider) {
        super.loadAdditional(tag, lookupProvider);
        this.time = tag.getInt("time");
    }

    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider lookupProvider) {
        super.saveAdditional(tag, lookupProvider);
        tag.putInt("time", this.time);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, InvisiblePressurePlateBlockEntity blockEntity) {
        --blockEntity.time;
        if(!level.isClientSide()&&blockEntity.time<=0) {
            level.setBlock(pos, ItemAndBlockRegister.hidden_invisible_pressure_plate.get().defaultBlockState(), 2);
        }
    }


    }
