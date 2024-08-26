package com.iwaliner.urushi.common.block;

import com.iwaliner.urushi.core.config.ConfigUrushi;
import com.iwaliner.urushi.registries.SoundRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import net.minecraft.util.RandomSource;

public class WIndBellBlock extends Block {

    public WIndBellBlock(Properties p_49795_) {
        super(p_49795_);
    }



    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (ConfigUrushi.WindBellSound.get()) {
            level.playSound((Player) null, pos, SoundRegister.WindBell.get(), SoundSource.BLOCKS, 1F, 1F);
            level.scheduleTick(new BlockPos(pos), this, 120);
        }
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState state2, boolean b) {
        super.onPlace(state, level, pos, state2, b);
        level.scheduleTick(new BlockPos(pos), this, 120);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        level.playSound(player,pos, SoundRegister.WindBell.get(), SoundSource.BLOCKS,0.01F,1F+level.random.nextFloat()*0.4F);
        return ItemInteractionResult.SUCCESS;
    }
}
