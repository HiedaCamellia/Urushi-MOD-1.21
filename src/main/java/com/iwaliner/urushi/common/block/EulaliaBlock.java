package com.iwaliner.urushi.common.block;

import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import com.iwaliner.urushi.core.util.UrushiUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.util.RandomSource;

import java.util.List;

public class EulaliaBlock extends TallGrassBlock {
    public EulaliaBlock(Properties p_57318_) {
        super(p_57318_);
    }
    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> list, TooltipFlag tooltipFlag) {
        UrushiUtils.setInfo(list,"small_flower");
    }
    public void performBonemeal(ServerLevel p_57320_, RandomSource p_57321_, BlockPos p_57322_, BlockState p_57323_) {
        DoublePlantBlock doubleplantblock = (DoublePlantBlock) ItemAndBlockRegister.double_eulalia.get();
        if (doubleplantblock.defaultBlockState().canSurvive(p_57320_, p_57322_) && p_57320_.isEmptyBlock(p_57322_.above())) {
            DoublePlantBlock.placeAt(p_57320_, doubleplantblock.defaultBlockState(), p_57322_, 2);
        }
    }
    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 60;
    }
}
