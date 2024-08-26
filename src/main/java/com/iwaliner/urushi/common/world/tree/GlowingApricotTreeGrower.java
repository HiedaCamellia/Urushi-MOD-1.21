package com.iwaliner.urushi.common.world.tree;

import com.iwaliner.urushi.registries.ConfiguredFeatureRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class GlowingApricotTreeGrower   {
    public GlowingApricotTreeGrower() {
    }
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_204316_, boolean p_204317_) {
        return ConfiguredFeatureRegister.GLOWING_APRICOT_KEY;
    }
}
