package com.iwaliner.urushi.core.network;

import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

public class FramedBlockTextureConnectionProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
    @Nullable
    @Override
    public Object getCapability(Object o, Object o2) {
        return null;
    }

    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.Provider provider) {
        return null;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag compoundTag) {

    }
//    public class FramedBlockTextureConnectionProvider implements ICapabilityProvider, INBTSerializable<CompoundTag> {
//    public static Capability<FramedBlockTextureConnectionData> FRAMED_BLOCK_TEXTURE_CONNECTION = CapabilityManager.get(new CapabilityToken<FramedBlockTextureConnectionData>() { });
//
//    private FramedBlockTextureConnectionData data = null;
//    private final LazyOptional<FramedBlockTextureConnectionData> optional = LazyOptional.of(this::createData);
//
//    private FramedBlockTextureConnectionData createData() {
//        if(this.data == null) {
//            this.data = new FramedBlockTextureConnectionData();
//        }
//
//        return this.data;
//    }
//
//    @Override
//    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
//        if(cap == FRAMED_BLOCK_TEXTURE_CONNECTION) {
//            return optional.cast();
//        }
//
//        return LazyOptional.empty();
//    }
//
//    @Override
//    public CompoundTag serializeNBT() {
//        CompoundTag nbt = new CompoundTag();
//        createData().saveNBTData(nbt);
//        return nbt;
//    }
//
//    @Override
//    public void deserializeNBT(CompoundTag nbt) {
//        createData().loadNBTData(nbt);
//    }
}
