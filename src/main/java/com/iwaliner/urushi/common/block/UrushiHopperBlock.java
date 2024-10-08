package com.iwaliner.urushi.common.block;

import com.iwaliner.urushi.registries.BlockEntityRegister;
import com.iwaliner.urushi.common.blockentity.UrushiHopperBlockEntity;
import com.iwaliner.urushi.core.util.UrushiUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.stats.Stats;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HopperBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.Nullable;
import java.util.List;

public class UrushiHopperBlock extends HopperBlock {
    public UrushiHopperBlock(Properties p_54039_) {
        super(p_54039_);
    }
    public BlockEntity newBlockEntity(BlockPos p_153382_, BlockState p_153383_) {
        return new UrushiHopperBlockEntity(p_153382_, p_153383_);
    }
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153378_, BlockState p_153379_, BlockEntityType<T> p_153380_) {
        return p_153378_.isClientSide ? null : createTickerHelper(p_153380_, BlockEntityRegister.UrushiHopper.get(), UrushiHopperBlockEntity::pushItemsTick);
    }
    public void setPlacedBy(Level p_54049_, BlockPos p_54050_, BlockState p_54051_, LivingEntity p_54052_, ItemStack p_54053_) {
//        if (p_54053_.hasCustomHoverName()) {
//            BlockEntity blockentity = p_54049_.getBlockEntity(p_54050_);
//            if (blockentity instanceof UrushiHopperBlockEntity) {
//                ((UrushiHopperBlockEntity)blockentity).setCustomName(p_54053_.getHoverName());
//            }
//        }

    }
    public InteractionResult use(BlockState p_54071_, Level p_54072_, BlockPos p_54073_, Player p_54074_, InteractionHand p_54075_, BlockHitResult p_54076_) {
        if (p_54072_.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockentity = p_54072_.getBlockEntity(p_54073_);
            if (blockentity instanceof UrushiHopperBlockEntity) {
                p_54074_.openMenu((UrushiHopperBlockEntity)blockentity);
                p_54074_.awardStat(Stats.INSPECT_HOPPER);
            }

            return InteractionResult.CONSUME;
        }
    }
    public void onRemove(BlockState p_54085_, Level p_54086_, BlockPos p_54087_, BlockState p_54088_, boolean p_54089_) {
        if (!p_54085_.is(p_54088_.getBlock())) {
            BlockEntity blockentity = p_54086_.getBlockEntity(p_54087_);
            if (blockentity instanceof UrushiHopperBlockEntity) {
                Containers.dropContents(p_54086_, p_54087_, (UrushiHopperBlockEntity)blockentity);
                p_54086_.updateNeighbourForOutputSignal(p_54087_, this);
            }

            super.onRemove(p_54085_, p_54086_, p_54087_, p_54088_, p_54089_);
        }
    }
    public void entityInside(BlockState p_54066_, Level p_54067_, BlockPos p_54068_, Entity p_54069_) {
        BlockEntity blockentity = p_54067_.getBlockEntity(p_54068_);
        if (blockentity instanceof UrushiHopperBlockEntity) {
            UrushiHopperBlockEntity.entityInside(p_54067_, p_54068_, p_54066_, p_54069_, (UrushiHopperBlockEntity) blockentity);
        }

    }
    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> list, TooltipFlag tooltipFlag) {
       UrushiUtils.setInfo(list,"urushi_hopper");
    }
}
