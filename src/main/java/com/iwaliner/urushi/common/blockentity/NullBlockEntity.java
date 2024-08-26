package com.iwaliner.urushi.common.blockentity;



import com.iwaliner.urushi.registries.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public  class NullBlockEntity extends BlockEntity {

    public NullBlockEntity(BlockPos p_155052_, BlockState p_155053_) {
        super(BlockEntityRegister.Null.get(), p_155052_, p_155053_);
    }


    public static void tick(Level level, BlockPos pos, BlockState bs, NullBlockEntity blockEntity) {
        level.setBlock(pos, Blocks.AIR.defaultBlockState(),3);
    }




}
