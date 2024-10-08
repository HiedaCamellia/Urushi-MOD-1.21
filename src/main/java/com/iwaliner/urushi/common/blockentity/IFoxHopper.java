package com.iwaliner.urushi.common.blockentity;

import net.minecraft.world.Container;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.Hopper;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public interface IFoxHopper extends Hopper {
    VoxelShape INSIDE = Block.box(2.0D, 11.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    VoxelShape ABOVE = Block.box(0.0D, 16.0D, 0.0D, 16.0D, 64.1D, 16.0D);
    VoxelShape SUCK = Shapes.or(INSIDE, ABOVE);

    default VoxelShape getSuckShape() {
        return SUCK;
    }


}
