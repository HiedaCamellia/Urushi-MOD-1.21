package com.iwaliner.urushi.core.mixin;

import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.WritableLevelData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Level.class)

public interface LevelMixin {
    @Accessor("levelData") @Final
    public void setLevelData(WritableLevelData data);

    @Accessor("levelData") @Final
    public WritableLevelData getLevelData();
}
