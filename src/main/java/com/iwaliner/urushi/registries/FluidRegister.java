package com.iwaliner.urushi.registries;

import com.iwaliner.urushi.ModCoreUrushi;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class FluidRegister {

    public static final DeferredRegister<Fluid> FLUIDS=DeferredRegister.create(BuiltInRegistries.FLUID, ModCoreUrushi.ModID);


  public static final DeferredHolder<Fluid,? extends FlowingFluid> HotSpringStill = FLUIDS.register("still_hot_spring_water",
          () -> new BaseFlowingFluid.Source(FluidRegister.HOT_SPRING_FLUID_PROPERTIES));
    public static final DeferredHolder<Fluid,? extends Fluid> HotSpringFlow = FLUIDS.register("flowing_hot_spring_water",
            () -> new BaseFlowingFluid.Flowing(FluidRegister.HOT_SPRING_FLUID_PROPERTIES));

    public static final BaseFlowingFluid.Properties HOT_SPRING_FLUID_PROPERTIES = new BaseFlowingFluid.Properties(
            FluidTypeRegister.HOT_SPRING_FLUID_TYPE, HotSpringStill, HotSpringFlow)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ItemAndBlockRegister.HotSpringBlock)
            .bucket(ItemAndBlockRegister.hot_spring_bucket);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
