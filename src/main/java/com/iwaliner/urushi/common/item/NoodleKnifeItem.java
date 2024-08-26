package com.iwaliner.urushi.common.item;


import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import com.iwaliner.urushi.core.util.UrushiUtils;
import com.iwaliner.urushi.common.block.HorizonalRotateBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;

public class NoodleKnifeItem extends Item {
    public NoodleKnifeItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }



    public InteractionResult useOn(UseOnContext context) {
        Player playerentity = context.getPlayer();
        ItemStack itemstack = context.getItemInHand();
        playerentity.startUsingItem(context.getHand());
        if(context.getLevel().getBlockState(context.getClickedPos()).getBlock() ==ItemAndBlockRegister.dough.get()){
            context.getLevel().setBlock(context.getClickedPos(), ItemAndBlockRegister.udon.get().defaultBlockState().setValue(HorizonalRotateBlock.FACING,context.getLevel().getBlockState(context.getClickedPos()).getValue(HorizonalRotateBlock.FACING)),2);
//               itemstack.hurtAndBreak(1, playerentity, (x) -> {
//                        x.broadcastBreakEvent(context.getHand());
//                    });
            context.getLevel().playSound((Player) null, context.getClickedPos(), SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 1F);

            return InteractionResult.SUCCESS;
                }else if(context.getLevel().getBlockState(context.getClickedPos()).getBlock() ==ItemAndBlockRegister.alkaline_dough.get()){
            context.getLevel().setBlock(context.getClickedPos(), ItemAndBlockRegister.alkaline_noodles.get().defaultBlockState().setValue(HorizonalRotateBlock.FACING,context.getLevel().getBlockState(context.getClickedPos()).getValue(HorizonalRotateBlock.FACING)),2);
//            itemstack.hurtAndBreak(1, playerentity, (x) -> {
//                x.broadcastBreakEvent(context.getHand());
//            });
            context.getLevel().playSound((Player) null, context.getClickedPos(), SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 1F);

            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> list, TooltipFlag tooltipFlag) {
      UrushiUtils.setInfo(list,"noodleknife");
    }

}
