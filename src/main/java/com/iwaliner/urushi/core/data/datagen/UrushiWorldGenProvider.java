package com.iwaliner.urushi.core.data.datagen;

import com.iwaliner.urushi.registries.ConfiguredFeatureRegister;
import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.registries.PlacedFeatureRegister;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class UrushiWorldGenProvider  extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ConfiguredFeatureRegister::bootstrap)
            .add(Registries.PLACED_FEATURE, PlacedFeatureRegister::bootstrap);

    public UrushiWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(ModCoreUrushi.ModID));
    }
}
