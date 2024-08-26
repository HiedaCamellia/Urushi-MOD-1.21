package com.iwaliner.urushi.core.events;

import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.common.entiity.GhostEntity;
import com.iwaliner.urushi.registries.EntityRegister;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = ModCoreUrushi.ModID, bus = EventBusSubscriber.Bus.MOD)
public class MobAttributeSetUp {
    /**モブの挙動・性質を設定*/
    @SubscribeEvent
    public static void MobAttributesEvent(EntityAttributeCreationEvent entityRegisterEvent) {


        entityRegisterEvent.put(EntityRegister.Ghost.get(),
                GhostEntity.createAttributes()
                        .add(Attributes.MAX_HEALTH, 20.0D)
                        .add(Attributes.ATTACK_DAMAGE, 6.0D)
                        .add(Attributes.ATTACK_SPEED, 0.5D)
                        .add(Attributes.FLYING_SPEED, 1.0D)
                        .add(Attributes.MOVEMENT_SPEED, 0.2D)
                        .build());


    }
}
