package com.iwaliner.urushi.common.block;


import com.iwaliner.urushi.registries.BlockEntityRegister;
import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import com.iwaliner.urushi.registries.TagUrushi;
import com.iwaliner.urushi.common.blockentity.ShichirinBlockEntity;
import com.iwaliner.urushi.common.item.AmberIgniterItem;
import com.iwaliner.urushi.core.util.ElementType;
import com.iwaliner.urushi.core.util.ElementUtils;
import com.iwaliner.urushi.core.util.UrushiUtils;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.List;
import net.minecraft.util.RandomSource;

public class ShichirinBlock extends BaseEntityBlock  {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty SHICHIRIN =IntegerProperty.create("shichirin", 0, 4);

    private static final VoxelShape UNDER = Block.box(3D, 0D, 3D, 13D, 12D, 13D);
    private static final VoxelShape UPPER = Block.box(1D, 12.0D, 1D, 15D, 15D, 15D);
     private static final VoxelShape SHAPE = Shapes.or(UNDER, UPPER);

    public ShichirinBlock(Properties p_i48440_1_) {
        super(p_i48440_1_);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(SHICHIRIN,0));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return   new ShichirinBlockEntity(pos,state);
    }

    public RenderShape getRenderShape(BlockState p_49090_) {
        return RenderShape.MODEL;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(FACING,SHICHIRIN);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if(world.getBlockEntity(pos)instanceof ShichirinBlockEntity) {
            if(!player.isSuppressingBounce()){
                ShichirinBlockEntity  tileEntity= (ShichirinBlockEntity) world.getBlockEntity(pos);
                if(tileEntity==null){
                    return ItemInteractionResult.FAIL;
                }
                ItemStack heldStack=player.getItemInHand(hand);
                ItemStack insertStack=heldStack.copy();
                if(player.getItemInHand(hand).getItem() instanceof AmberIgniterItem &&state.getValue(SHICHIRIN)==1){
                    ItemStack magatama= ElementUtils.getMagatamaInInventory(player, ElementType.FireElement);
                    if(magatama!=ItemStack.EMPTY&&ElementUtils.willBeInDomain(magatama,-10)){
                        world.playSound((Player) null, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1.0F, world.random.nextFloat() * 0.4F + 0.8F);
                        tileEntity.addFire(100);
                        world.setBlockAndUpdate(pos,state.setValue(SHICHIRIN,2));
                        ElementUtils.increaseStoredReiryokuAmount(magatama,-10);
//                        player.getItemInHand(hand).hurtAndBreak(1, player, (x) -> {
//                            x.broadcastBreakEvent(hand);
//                        });
                        return ItemInteractionResult.SUCCESS;
                    }
                }
                else if(player.getItemInHand(hand).isEmpty()&&tileEntity.getItem(0).isEmpty()&&tileEntity.getItem(1).isEmpty()){

                    return ItemInteractionResult.FAIL;
                }
                else if(heldStack.is(TagUrushi.SHICHIRIN_FUEL)){
                    ItemStack fuel=tileEntity.getItem(2);
                    if(fuel==ItemStack.EMPTY) {
                        tileEntity.setItem(2, heldStack.copy());
                        heldStack.setCount(0);
                        return ItemInteractionResult.SUCCESS;
                    }else if(fuel.getItem()==heldStack.getItem()){
                        int count=fuel.getCount()+heldStack.getCount();
                        ItemStack newStack=new ItemStack(fuel.getItem(), Math.min(count, 64));
                        tileEntity.setItem(2, newStack.copy());
                        heldStack.setCount(count>=64? count-64 : 0);
                        return ItemInteractionResult.SUCCESS;
                    }
                }
                else if(heldStack.getItem()== ItemAndBlockRegister.uchiwa.get()&&state.getValue(SHICHIRIN)!=0&&state.getValue(SHICHIRIN)!=1){
                    ItemStack magatama= ElementUtils.getMagatamaInInventory(player, ElementType.WoodElement);
                    if(magatama!=ItemStack.EMPTY&&ElementUtils.willBeInDomain(magatama,-1)) {
                        tileEntity.addFire(30);
                        ElementUtils.increaseStoredReiryokuAmount(magatama,-1);
//                        player.getItemInHand(hand).hurtAndBreak(1, player, (x) -> {
//                            x.broadcastBreakEvent(hand);
//                        });
                        world.playSound((Player) null, pos, SoundEvents.ENDER_DRAGON_FLAP, SoundSource.BLOCKS, 0.5F, 1F);
                        return ItemInteractionResult.SUCCESS;
                    }
                }
                if(tileEntity.canPlaceItem(0,insertStack)){
                    tileEntity.setItem(0,insertStack);
                    tileEntity.markUpdated();
                    heldStack.setCount(0);
                    world.playSound((Player) null,pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS,3F,1F);
                    return ItemInteractionResult.SUCCESS;
                }else {
                    ItemStack pickedStack = tileEntity.pickItem().copy();
                    if (heldStack.isEmpty()) {
                        tileEntity.markUpdated();
                        player.setItemInHand(hand, pickedStack);
                        world.playSound((Player) null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 3F, 1F);
                        return ItemInteractionResult.SUCCESS;
                    } else if (!player.getInventory().add(pickedStack)) {
                        tileEntity.markUpdated();
                        player.drop(pickedStack, false);
                        world.playSound((Player) null, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 3F, 1F);
                        return ItemInteractionResult.SUCCESS;
                    }
                }
            }

        }


        return ItemInteractionResult.FAIL;
    }



    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
        return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }


    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> list, TooltipFlag tooltipFlag) {
        UrushiUtils.setInfo(list,"shichirin1");
        UrushiUtils.setInfo(list,"shichirin2");
        UrushiUtils.setInfo(list,"shichirin3");
   }
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152160_, BlockState p_152161_, BlockEntityType<T> p_152162_) {
        return createTickerHelper(p_152162_, BlockEntityRegister.Shichirin.get(), ShichirinBlockEntity::tick);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if(level.getBlockEntity(pos)instanceof ShichirinBlockEntity){
            if(state.getValue(SHICHIRIN)!=0&&state.getValue(SHICHIRIN)!=1){
                level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE.getType(), pos.getX() + 0.1D*random.nextInt(11), pos.getY() + 1.1D, pos.getZ() + 0.1D*random.nextInt(11), 0D, 0.1D, 0D);
                    level.addParticle(ParticleTypes.SMOKE.getType(), pos.getX() + 0.1D*random.nextInt(11), pos.getY() + 1.1D, pos.getZ() + 0.1D*random.nextInt(11), 0D, 0.1D, 0D);
               if(random.nextInt(5)==0){
                   level.playSound((Player) null,pos,SoundEvents.FIRE_EXTINGUISH,SoundSource.BLOCKS,1F,1F);
               }
            }

        }
    }
    public void setPlacedBy(Level p_48694_, BlockPos p_48695_, BlockState p_48696_, LivingEntity p_48697_, ItemStack p_48698_) {
//        if (p_48698_.hasCustomHoverName()) {
//            BlockEntity blockentity = p_48694_.getBlockEntity(p_48695_);
//            if (blockentity instanceof ShichirinBlockEntity) {
//                ((ShichirinBlockEntity)blockentity).setCustomName(p_48698_.getHoverName());
//            }
//        }

    }

    public void onRemove(BlockState p_52707_, Level p_52708_, BlockPos p_52709_, BlockState p_52710_, boolean p_52711_) {
        if (!p_52707_.is(p_52710_.getBlock())) {
            BlockEntity blockentity = p_52708_.getBlockEntity(p_52709_);
            if (blockentity instanceof ShichirinBlockEntity) {
                Containers.dropContents(p_52708_, p_52709_, (ShichirinBlockEntity)blockentity);
                p_52708_.updateNeighbourForOutputSignal(p_52709_, this);
            }

            super.onRemove(p_52707_, p_52708_, p_52709_, p_52710_, p_52711_);
        }
    }
}
