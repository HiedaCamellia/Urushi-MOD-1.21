package com.iwaliner.urushi.registries;

import com.iwaliner.urushi.ModCoreUrushi;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class BiomeRegister {

    public static final DeferredRegister<MapCodec<? extends BiomeSource>> BIOMES;
    public static final ResourceKey<Biome> SakuraForest;
    public static final ResourceKey<Biome> EulaliaPlains;
    public static final ResourceKey<Biome> AutumnForest;
    public static final ResourceKey<Biome> CedarForest;



    public static final List<ResourceKey<Biome>> KakuriyoList = new ArrayList<>();

    public BiomeRegister() {
    }

    public static void register(IEventBus eventBus) {
        BIOMES.register(eventBus);
        KakuriyoList.add(SakuraForest);
        KakuriyoList.add(EulaliaPlains);
        KakuriyoList.add(AutumnForest);
        KakuriyoList.add(CedarForest);


    }



    static {
        BIOMES = DeferredRegister.create(BuiltInRegistries.BIOME_SOURCE, ModCoreUrushi.ModID);
        SakuraForest = ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"sakura_forest"));
        EulaliaPlains =ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"eulalia_plains"));
        AutumnForest =ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"autumn_forest"));
        CedarForest =ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"cedar_forest"));



    }



}