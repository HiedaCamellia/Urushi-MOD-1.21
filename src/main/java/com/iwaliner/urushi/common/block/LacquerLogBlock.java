package com.iwaliner.urushi.common.block;


import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class LacquerLogBlock extends RotatedPillarBlock {


    public LacquerLogBlock(Properties p_55926_) {
        super(p_55926_);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(result.getDirection()!= Direction.UP&&result.getDirection()!=Direction.DOWN){
            if (player.getItemInHand(hand).getItem() instanceof TieredItem || player.getItemInHand(hand).getItem() == Items.FLINT) {
                level.setBlock(pos, ItemAndBlockRegister.chiseled_lacquer_log.get().defaultBlockState().setValue(ChiseledLacquerLogBlock.FACING, result.getDirection()), 4);
                level.playSound(player, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0F, 1.0F);
                return ItemInteractionResult.SUCCESS;
            }}
        return ItemInteractionResult.FAIL;
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
