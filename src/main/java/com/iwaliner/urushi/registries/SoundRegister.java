package com.iwaliner.urushi.registries;


import com.iwaliner.urushi.ModCoreUrushi;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class SoundRegister {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, ModCoreUrushi.ModID);
    public static final DeferredHolder<SoundEvent,SoundEvent> WindBell=SOUNDS.register("wind_bell",()->SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"wind_bell")));

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }

}
