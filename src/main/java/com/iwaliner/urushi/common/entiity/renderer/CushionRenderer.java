package com.iwaliner.urushi.common.entiity.renderer;

import com.iwaliner.urushi.core.events.ClientSetUp;
import com.iwaliner.urushi.common.entiity.CushionEntity;
import com.iwaliner.urushi.common.entiity.model.CushionModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class CushionRenderer<T extends CushionEntity> extends EntityRenderer<T> {
    private static final ResourceLocation[] TEXTURE_LOCATIONS = new ResourceLocation[]{ResourceLocation.parse("urushi:textures/entity/cushion/cushion_white.png"), ResourceLocation.parse("urushi:textures/entity/cushion/cushion_orange.png"), ResourceLocation.parse("urushi:textures/entity/cushion/cushion_magenta.png"), ResourceLocation.parse("urushi:textures/entity/cushion/cushion_light_blue.png"), ResourceLocation.parse("urushi:textures/entity/cushion/cushion_yellow.png"), ResourceLocation.parse("urushi:textures/entity/cushion/cushion_lime.png"), ResourceLocation.parse("urushi:textures/entity/cushion/cushion_pink.png"), ResourceLocation.parse("urushi:textures/entity/cushion/cushion_gray.png"), ResourceLocation.parse("urushi:textures/entity/cushion/cushion_silver.png"), ResourceLocation.parse("urushi:textures/entity/cushion/cushion_cyan.png"), ResourceLocation.parse("urushi:textures/entity/cushion/cushion_purple.png"), ResourceLocation.parse("urushi:textures/entity/cushion/cushion_blue.png"), ResourceLocation.parse("urushi:textures/entity/cushion/cushion_brown.png"), ResourceLocation.parse("urushi:textures/entity/cushion/cushion_green.png"), ResourceLocation.parse("urushi:textures/entity/cushion/cushion_red.png"), ResourceLocation.parse("urushi:textures/entity/cushion/cushion_black.png")};

      public final EntityModel<CushionEntity> model;

    public CushionRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new CushionModel<>(context.bakeLayer(ClientSetUp.CUSHION));
    }

    public void render(CushionEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int light) {
        poseStack.pushPose();
        poseStack.mulPose(Axis.XN.rotationDegrees(180.0F));
        poseStack.translate(0.0D, (double) -1.5F, 0.0D);
        poseStack.scale(1F, 1F, 1F);

        poseStack.mulPose(Axis.YN.rotationDegrees(180.0F - entityYaw)); //この行がないとモデルの回転ができない

        VertexConsumer ivertexbuilder = bufferSource.getBuffer(this.model.renderType(TEXTURE_LOCATIONS[entity.getCushionType().ordinal()]));
        this.model.renderToBuffer(poseStack, ivertexbuilder, light, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();
        super.render((T) entity, entityYaw, partialTick, poseStack, bufferSource, light);
    }


    public ResourceLocation getTextureLocation(CushionEntity p_110775_1_) {
        return TEXTURE_LOCATIONS[p_110775_1_.getCushionType().ordinal()];
    }
}
