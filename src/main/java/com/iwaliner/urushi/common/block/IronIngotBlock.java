package com.iwaliner.urushi.common.block;



import com.iwaliner.urushi.core.util.UrushiUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;


public class IronIngotBlock extends HorizonalRotateBlock{

    protected static final VoxelShape SHAPEA = Block.box(6.0D, 0.0D, 2D, 10D, 2D, 14.0D);
    protected static final VoxelShape SHAPEB = Block.box(2D, 0.0D, 6D, 14D, 2D, 10.0D);
    private Block postBlock;
    public IronIngotBlock(Block block,Properties p_i48377_1_) {

        super(p_i48377_1_);
        postBlock=block;
    }
    public Block getPostBlock(){
     return postBlock;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        if(state.getValue(FACING)== Direction.NORTH||state.getValue(FACING)==Direction.SOUTH){
            return SHAPEB;
        }else{
            return SHAPEA;
        } }
    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> list, TooltipFlag tooltipFlag) {
        UrushiUtils.setInfo(list,"iron_ingot");
        }

}
