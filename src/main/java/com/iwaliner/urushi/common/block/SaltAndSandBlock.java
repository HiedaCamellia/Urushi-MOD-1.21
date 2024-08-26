package com.iwaliner.urushi.common.block;



import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import com.iwaliner.urushi.core.util.UrushiUtils;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;

public class SaltAndSandBlock extends FallingBlock {
    public SaltAndSandBlock(Properties p_i48401_1_) {
        super(p_i48401_1_);
    }

    @Override
    protected MapCodec<? extends FallingBlock> codec() {
        return null;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemEntity entity = new ItemEntity(world,pos.getX()+0.5D, pos.getY()+1.5D, pos.getZ()+0.5D, new ItemStack(ItemAndBlockRegister.salt.get()));
        world.addFreshEntity(entity);
        world.setBlock(pos, Blocks.SAND.defaultBlockState(),2);
        world.playSound((Player) null,pos, SoundEvents.SAND_BREAK, SoundSource.BLOCKS, 1.0F, 1F);
        return ItemInteractionResult.SUCCESS;  }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> list, TooltipFlag tooltipFlag) {
       UrushiUtils.setInfo(list,"saltandsand");
    }

}
