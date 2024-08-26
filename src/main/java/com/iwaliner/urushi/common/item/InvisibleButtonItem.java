package com.iwaliner.urushi.common.item;

import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import com.iwaliner.urushi.common.block.HiddenInvisibleButtonBlock;
import com.iwaliner.urushi.common.block.InvisibleButtonBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class InvisibleButtonItem extends BlockItem {
    public InvisibleButtonItem(Block p_40565_, Properties p_40566_) {
        super(p_40565_, p_40566_);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level world, Entity entity, int a, boolean b) {
        if(entity instanceof LivingEntity){
            int range=8;
            LivingEntity player= (LivingEntity) entity;
            BlockPos pos=new BlockPos(Mth.floor(entity.getX()),Mth.floor(entity.getY()),Mth.floor(entity.getZ()));
            if (player.getOffhandItem() == stack || player.getMainHandItem() == stack) {
                for(int i=-range; i<range+1;i++) {
                    for(int j=-range; j<range+1;j++) {
                        for(int k=-range; k<range+1;k++) {
                            if( world.getBlockState(pos.offset(i,j,k)).getBlock()== ItemAndBlockRegister.hidden_invisible_button.get()){
                                BlockState hiddenState=world.getBlockState(pos.offset(i,j,k));
                                world.setBlockAndUpdate(pos.offset(i,j,k),ItemAndBlockRegister.invisible_button.get().defaultBlockState().setValue(InvisibleButtonBlock.POWERED,hiddenState.getValue(HiddenInvisibleButtonBlock.POWERED)).setValue(InvisibleButtonBlock.FACE,hiddenState.getValue(HiddenInvisibleButtonBlock.FACE)).setValue(InvisibleButtonBlock.FACING,hiddenState.getValue(HiddenInvisibleButtonBlock.FACING)));
                            }
                        }
                    }
                }


            }
        }
    }
}
