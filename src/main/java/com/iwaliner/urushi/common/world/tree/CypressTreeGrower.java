package com.iwaliner.urushi.common.world.tree;

import com.iwaliner.urushi.registries.ConfiguredFeatureRegister;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class CypressTreeGrower {
    public CypressTreeGrower() {
    }
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_204316_, boolean p_204317_) {
       return ConfiguredFeatureRegister.CYPRESS_KEY;
    }
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource p_204332_) {
       return ConfiguredFeatureRegister.MEGA_CYPRESS_KEY;
    }
}
