package com.iwaliner.urushi.common.blockentity;

import com.iwaliner.urushi.registries.BlockEntityRegister;
import com.iwaliner.urushi.core.util.ElementType;
import com.iwaliner.urushi.core.util.interfaces.ReiryokuExportable;
import com.iwaliner.urushi.core.util.interfaces.ReiryokuImportable;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class TankBlockEntity extends AbstractReiryokuStorableBlockEntity implements ReiryokuImportable,ReiryokuExportable {
    public TankBlockEntity(BlockPos p_155550_, BlockState p_155551_) {
        super(BlockEntityRegister.Tank.get(),1000, p_155550_, p_155551_);
    }


    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag compoundtag = new CompoundTag();
        this.putBaseTag(compoundtag);
        return compoundtag;
    }



    public static void tick(Level level, BlockPos pos, BlockState state, TankBlockEntity blockEntity) {
       blockEntity.recieveReiryoku(level,pos);
    }



    @Override
    public ElementType getExportElementType() {
        return this.getStoredElementType();
    }

    @Override
    public ElementType getImportElementType() {
        return this.getStoredElementType();
    }

}
