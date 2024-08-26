package com.iwaliner.urushi.registries;

import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.common.fluidtype.HotSpringWaterFluidType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.SoundAction;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.FluidType.Properties;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class FluidTypeRegister {

    public static final DeferredRegister<FluidType> FLUID_TYPES=DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, ModCoreUrushi.ModID);

    public static final DeferredHolder<FluidType,? extends FluidType> HOT_SPRING_FLUID_TYPE = register("hot_spring_fluid",
            FluidType.Properties.create().lightLevel(2).density(1000).viscosity(1000).sound(SoundAction.get("drink"),
                    SoundEvents.BUCKET_FILL).canExtinguish(true).canConvertToSource(true));



    private static DeferredHolder<FluidType,? extends FluidType> register(String name, Properties properties) {
        return FLUID_TYPES.register(name, () -> new HotSpringWaterFluidType( properties));
    }
    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
