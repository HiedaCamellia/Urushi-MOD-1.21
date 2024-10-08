package com.iwaliner.urushi.common.item;



import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import com.iwaliner.urushi.common.block.AbstractFramedBlock;
import com.iwaliner.urushi.common.block.FramedPaneBlock;
import com.iwaliner.urushi.common.block.HotIronIngotBlock;
import com.iwaliner.urushi.common.block.IronIngotBlock;
import com.iwaliner.urushi.core.util.UrushiUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
 
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Random;

public class HammerItem extends Item {
    public HammerItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player playerentity = context.getPlayer();
        ItemStack itemstack = context.getItemInHand();
        Level level=context.getLevel();
        BlockPos pos=context.getClickedPos();
        BlockState clickedState=level.getBlockState(pos);
        assert playerentity != null;
        ItemStack heldStack=playerentity.getItemInHand(context.getHand());

        playerentity.getCooldowns().addCooldown(this, 15);
        playerentity.startUsingItem(context.getHand());
        if(context.getLevel().getBlockState(context.getClickedPos()).getBlock() instanceof IronIngotBlock){
            IronIngotBlock ironIngotBlock= (IronIngotBlock) context.getLevel().getBlockState(context.getClickedPos()).getBlock();
            if(ironIngotBlock.getPostBlock()!=null){
                Random random=new Random();
                int i=random.nextInt(16);
                double d0 = (double) context.getClickedPos().getX() +random.nextInt(8)*0.1D+0.2D;
                double d1 = (double) context.getClickedPos().getY() +random.nextInt(5)*0.1D+0.2D;
                double d2 = (double) context.getClickedPos().getZ() +random.nextInt(8)*0.1D+0.2D;
                if (i == 0) {
                    context.getLevel().setBlockAndUpdate(context.getClickedPos(), ironIngotBlock.getPostBlock().defaultBlockState().setValue(IronIngotBlock.FACING, context.getLevel().getBlockState(context.getClickedPos()).getValue(IronIngotBlock.FACING)));
                    context.getLevel().addParticle(ParticleTypes.FLAME,  d0,d1, d2, 0.0D, 0D, 0.0D);
                    context.getLevel().playSound((Player) null, context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 0.3F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
//                    itemstack.hurtAndBreak(1, playerentity, (x) -> {
//                        x.broadcastBreakEvent(context.getHand());
//                    });
                    return InteractionResult.SUCCESS;
                }else{
                    context.getLevel().addParticle(ParticleTypes.FLAME,  d0,d1, d2, 0.0D, 0D, 0.0D);
                    context.getLevel().playSound((Player) null, context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 0.3F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
//                    itemstack.hurtAndBreak(1, playerentity, (x) -> {
//                        x.broadcastBreakEvent(context.getHand());
//                    });
                    return InteractionResult.SUCCESS;
                }
            }

        }else if(clickedState.getBlock() ==ItemAndBlockRegister.hot_ironsand.get()){

            return temper(level,pos,ItemAndBlockRegister.hot_iron_plate.get().defaultBlockState(),heldStack,playerentity,context.getHand(),level.getRandom(),10);

        }else if(clickedState.getBlock() ==ItemAndBlockRegister.hot_iron_ingot_1.get()){

            Direction direction=clickedState.getValue(HotIronIngotBlock.FACING);
            return temper(level,pos,ItemAndBlockRegister.hot_iron_ingot_2.get().defaultBlockState().setValue(HotIronIngotBlock.FACING,direction),heldStack,playerentity,context.getHand(),level.getRandom(),10);

        }else if(clickedState.getBlock() ==ItemAndBlockRegister.hot_iron_ingot_2.get()){

            Direction direction=clickedState.getValue(HotIronIngotBlock.FACING);
            return temper(level,pos,ItemAndBlockRegister.hot_iron_ingot_3.get().defaultBlockState().setValue(HotIronIngotBlock.FACING,direction),heldStack,playerentity,context.getHand(),level.getRandom(),10);

        }else if(clickedState.getBlock() ==ItemAndBlockRegister.hot_iron_ingot_3.get()){

            Direction direction=clickedState.getValue(HotIronIngotBlock.FACING);
            return temper(level,pos,ItemAndBlockRegister.hot_iron_ingot_4.get().defaultBlockState().setValue(HotIronIngotBlock.FACING,direction),heldStack,playerentity,context.getHand(),level.getRandom(),10);

        }else if(clickedState.getBlock() ==ItemAndBlockRegister.hot_iron_ingot_4.get()){

            Direction direction=clickedState.getValue(HotIronIngotBlock.FACING);
            return temper(level,pos,ItemAndBlockRegister.hot_iron_ingot_5.get().defaultBlockState().setValue(HotIronIngotBlock.FACING,direction),heldStack,playerentity,context.getHand(),level.getRandom(),10);

        }else if(clickedState.getBlock() ==ItemAndBlockRegister.hot_iron_blade_1.get()){

            return temper(level,pos,ItemAndBlockRegister.hot_iron_blade_2.get().defaultBlockState(),heldStack,playerentity,context.getHand(),level.getRandom(),10);

        }else if(context.getLevel().getBlockState(context.getClickedPos()).getBlock() instanceof FramedPaneBlock ||context.getLevel().getBlockState(context.getClickedPos()).getBlock() instanceof AbstractFramedBlock){
            BlockState state=context.getLevel().getBlockState(context.getClickedPos());
            context.getLevel().setBlockAndUpdate(context.getClickedPos(), state.setValue(AbstractFramedBlock.VARIANT, !state.getValue(AbstractFramedBlock.VARIANT)));
//            itemstack.hurtAndBreak(1, playerentity, (x) -> {
//                x.broadcastBreakEvent(context.getHand());
//            });
            context.getLevel().playSound((Player) null, context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), SoundEvents.STONE_PLACE, SoundSource.BLOCKS, 1F, 1F);
            playerentity.getCooldowns().removeCooldown(this);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.FAIL;
    }
    private InteractionResult temper(Level level, BlockPos pos, BlockState resultState, ItemStack hammer, Player player, InteractionHand hand, RandomSource random, int probability){
        if(!level.isClientSide()) {
            int i = random.nextInt(probability);
            if (i == 0) {
                level.setBlockAndUpdate(pos, resultState);
                //  context.getLevel().addParticle(ParticleTypes.FLAME,  d0,d1, d2, 0.0D, 0D, 0.0D);
                level.playSound((Player) null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ANVIL_USE, SoundSource.BLOCKS, 0.3F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
//                hammer.hurtAndBreak(1, player, (x) -> {
//                    x.broadcastBreakEvent(hand);
//                });
                return InteractionResult.SUCCESS;
            } else {
                //   context.getLevel().addParticle(ParticleTypes.FLAME,  d0,d1, d2, 0.0D, 0D, 0.0D);
                level.playSound((Player) null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 0.3F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
//                hammer.hurtAndBreak(1, player, (x) -> {
//                    x.broadcastBreakEvent(hand);
//                });
                return InteractionResult.SUCCESS;
            }
        }else{
            return InteractionResult.SUCCESS;
        }
    }
    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> list, TooltipFlag tooltipFlag) {
        UrushiUtils.setInfo(list,"hammer");
    }

}
