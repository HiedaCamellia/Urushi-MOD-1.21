package com.iwaliner.urushi.core.events;

import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.core.network.FramedBlockTextureConnectionPacket;
import com.iwaliner.urushi.core.network.NetworkAccess;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.InputEvent;

@EventBusSubscriber(modid = ModCoreUrushi.ModID, value = Dist.CLIENT)
public class ClientNonBusSetUp {
    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        if(ClientSetUp.connectionKey.consumeClick()) {
            NetworkAccess.sendToServer(new FramedBlockTextureConnectionPacket(ClientSetUp.connectionKey.isDown()));
        }
    }
}
