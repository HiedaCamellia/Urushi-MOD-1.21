package com.iwaliner.urushi.common.fluidtype;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.FluidType.Properties;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class HotSpringWaterFluidType extends FluidType {
    /**
     * Default constructor.
     *
     * @param properties the general properties of the fluid type
     */
    public HotSpringWaterFluidType(Properties properties) {
        super(properties);
    }



    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
        consumer.accept(new IClientFluidTypeExtensions() {
            private static final ResourceLocation HotSpringStillTex = ResourceLocation.withDefaultNamespace("block/water_still");
            private static final ResourceLocation HotSpringFlowingTex = ResourceLocation.withDefaultNamespace("block/water_flow");
            private static final ResourceLocation HotSpringOverrayTex = ResourceLocation.withDefaultNamespace("block/water_overlay");

            @Override
            public ResourceLocation getStillTexture() {
                return HotSpringStillTex;
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return HotSpringFlowingTex;
            }

            @Override
            public @Nullable ResourceLocation getRenderOverlayTexture(Minecraft mc) {
                return HotSpringOverrayTex;
            }

            @Override
            public int getTintColor() {
                return 0xbf60c3c9;
            }
        });
    }
}
