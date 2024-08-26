package com.iwaliner.urushi.common.item;

import com.iwaliner.urushi.core.config.ConfigUrushi;
import com.iwaliner.urushi.core.util.ElementUtils;
import com.iwaliner.urushi.core.util.interfaces.HasReiryokuItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public abstract class AbstractMagatamaItem extends Item implements HasReiryokuItem {

    public AbstractMagatamaItem(Properties p_41383_) {
        super(p_41383_);
    }
    @Override
    public int getReiryokuCapacity(){
        return ConfigUrushi.reiryokuCapacityOfMagatama.get();
    }

    @Override


    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
        list.add((Component.translatable("info.urushi.magatama1")).withStyle(ChatFormatting.GRAY));
        list.add((Component.translatable("info.urushi.magatama2")).withStyle(ChatFormatting.GRAY));

        if (stack.hasTag()) {
            list.add((Component.translatable("info.urushi.stored_reiryoku_amount").append(" "+ElementUtils.getStoredReiryokuAmount(stack))).withStyle(ChatFormatting.WHITE));
        }
    }

   /* @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level=context.getLevel();
        BlockPos pos=context.getClickedPos();
        BlockEntity blockEntity=level.getBlockEntity(pos);
        ItemStack stack=context.getItemInHand();
        if(blockEntity instanceof TankBlockEntity){
            TankBlockEntity tankBlockEntity= (TankBlockEntity) blockEntity;
            int blockEntityStoredReiryoku=tankBlockEntity.getStoredReiryoku();
            int magatamaStoredReiryoku=ElementUtils.getStoredReiryokuAmount(stack);
            int magatamaCapacity=ElementUtils.getReiryokuCapacity(stack);
            int i1=magatamaCapacity-magatamaStoredReiryoku;
            if(blockEntityStoredReiryoku>=i1){
                ElementUtils.increaseStoredReiryokuAmount(stack,i1);
                ((TankBlockEntity) blockEntity).decreaseStoredReiryoku(i1);
                return InteractionResult.SUCCESS;
            }else{
                ElementUtils.increaseStoredReiryokuAmount(stack,blockEntityStoredReiryoku);
                ((TankBlockEntity) blockEntity).decreaseStoredReiryoku(blockEntityStoredReiryoku);
                return InteractionResult.SUCCESS;
            }
        }
        else if(context.getLevel().getBlockState(context.getClickedPos()).getBlock()== Blocks.BARRIER){
            ElementUtils.increaseStoredReiryokuAmount(context.getPlayer().getItemInHand(context.getHand()),100);
            return InteractionResult.SUCCESS;
        }else if(context.getLevel().getBlockState(context.getClickedPos()).getBlock()== Blocks.STRUCTURE_VOID){
            ElementUtils.increaseStoredReiryokuAmount(context.getPlayer().getItemInHand(context.getHand()),-100);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }*/
}
