package com.iwaliner.urushi.registries;

import com.iwaliner.urushi.ModCoreUrushi;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ParticleRegister {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(BuiltInRegistries.PARTICLE_TYPE, ModCoreUrushi.ModID);
    public static final DeferredHolder<ParticleType<?>,? extends ParticleType<?>> WoodElement = PARTICLES.register("wood_element", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>,? extends ParticleType<?>> FireElement = PARTICLES.register("fire_element", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>,? extends ParticleType<?>> EarthElement = PARTICLES.register("earth_element", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>,? extends ParticleType<?>> MetalElement = PARTICLES.register("metal_element", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>,? extends ParticleType<?>> WaterElement = PARTICLES.register("water_element", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>,? extends ParticleType<?>> FallingRedLeaves = PARTICLES.register("falling_red_leaves", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>,? extends ParticleType<?>> FallingOrangeLeaves = PARTICLES.register("falling_orange_leaves", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>,? extends ParticleType<?>> FallingYellowLeaves = PARTICLES.register("falling_yellow_leaves", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>,? extends ParticleType<?>> FallingSakuraLeaves = PARTICLES.register("falling_sakura_leaves", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>,? extends ParticleType<?>> WoodElementMedium = PARTICLES.register("wood_element_medium", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>,? extends ParticleType<?>> FireElementMedium = PARTICLES.register("fire_element_medium", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>,? extends ParticleType<?>> EarthElementMedium = PARTICLES.register("earth_element_medium", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>,? extends ParticleType<?>> MetalElementMedium = PARTICLES.register("metal_element_medium", () -> new SimpleParticleType(true));
    public static final DeferredHolder<ParticleType<?>,? extends ParticleType<?>> WaterElementMedium = PARTICLES.register("water_element_medium", () -> new SimpleParticleType(true));


    public static void register(IEventBus eventBus) {
        PARTICLES.register(eventBus);
    }
}
