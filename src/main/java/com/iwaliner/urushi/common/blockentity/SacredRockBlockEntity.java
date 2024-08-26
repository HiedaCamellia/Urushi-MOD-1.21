package com.iwaliner.urushi.common.blockentity;

import com.iwaliner.urushi.registries.BlockEntityRegister;
import com.iwaliner.urushi.common.block.SacredRockBlock;
import com.iwaliner.urushi.core.util.ElementType;
import com.iwaliner.urushi.core.util.ElementUtils;
import com.iwaliner.urushi.core.util.interfaces.ReiryokuExportable;
import com.iwaliner.urushi.core.util.interfaces.Tiered;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class SacredRockBlockEntity extends AbstractReiryokuStorableBlockEntity implements ReiryokuExportable {
    public int coolTime;
    public SacredRockBlockEntity(BlockPos p_155550_, BlockState p_155551_) {
        super(BlockEntityRegister.SacredRock.get(),100, p_155550_, p_155551_);
    }

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider lookupProvider) {
        super.loadAdditional(tag, lookupProvider);
        this.coolTime = tag.getInt("coolTime");
    }

    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider lookupProvider) {
        super.saveAdditional(tag, lookupProvider);
        tag.putInt("coolTime", this.coolTime);

    }
    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider lookupProvider) {
        CompoundTag compoundtag = new CompoundTag();
        compoundtag.putInt("coolTime", this.coolTime);
       this.putBaseTag(compoundtag);
        return compoundtag;
    }
   @Override
    public  ElementType getExportElementType() {
      return this.getStoredElementType();
    }

    private int getAddAmount(int tier){
        return 1;
    }


    public static void tick(Level level, BlockPos pos, BlockState state, SacredRockBlockEntity blockEntity) {
       BlockPos dedicatedPos=pos.relative(state.getValue(SacredRockBlock.FACING));
        BlockState dedicatedState=level.getBlockState(dedicatedPos);
        Tiered elementBlock= (Tiered) state.getBlock();
      if(ElementUtils.isSpecificElement(blockEntity.getStoredElementType(),dedicatedState)){
          if(blockEntity.coolTime<20*5) {
              blockEntity.coolTime++;
          }else if( blockEntity.canAddReiryoku(blockEntity.getAddAmount(elementBlock.getTier()))){
              blockEntity.addStoredReiryoku(blockEntity.getAddAmount(elementBlock.getTier()));
              level.setBlock(dedicatedPos, Blocks.AIR.defaultBlockState(),2);
              blockEntity.coolTime=0;
          }
       }else{
          if(blockEntity.coolTime!=0){
              blockEntity.coolTime=0;
          }
      }
    }
    }
