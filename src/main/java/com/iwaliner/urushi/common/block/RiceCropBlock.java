package com.iwaliner.urushi.common.block;


import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;


public class RiceCropBlock extends UrushiCropBlock {

    public RiceCropBlock(Properties p_i48421_1_) {
        super(p_i48421_1_);
    }

    @Override
    public void onPlace(BlockState state, Level world, BlockPos pos, BlockState state2, boolean boo) {
        if(world.getBlockState(pos.below()).getBlock() instanceof FarmBlock){
            world.setBlockAndUpdate(pos.below(), ItemAndBlockRegister.paddy_field.get().defaultBlockState());
        }
    }




}
