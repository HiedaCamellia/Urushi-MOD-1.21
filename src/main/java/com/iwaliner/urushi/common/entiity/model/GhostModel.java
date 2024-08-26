package com.iwaliner.urushi.common.entiity.model;

import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Monster;

import java.util.function.Function;

public class GhostModel <T extends Monster> extends HumanoidModel<T> {

    public GhostModel(ModelPart root) {
        this(root,RenderType::entityTranslucent);
    }
    public GhostModel(ModelPart root, Function<ResourceLocation, RenderType>  renderType) {
        super(root, renderType);
    }
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        AnimationUtils.animateZombieArms(this.leftArm, this.rightArm, false, this.attackTime, ageInTicks);

        float rx=this.rightLeg.x;
        float ry=this.rightLeg.y;
        float rz=this.rightLeg.z;
        float lx=this.leftLeg.x;
        float ly=this.leftLeg.y;
        float lz=this.leftLeg.z;

        this.rightLeg.copyFrom(this.body);
        this.leftLeg.copyFrom(this.body);
        this.rightLeg.x=rx;
        this.rightLeg.y=ry;
        this.rightLeg.z=rz;
        this.leftLeg.x=lx;
        this.leftLeg.y=ly;
        this.leftLeg.z=lz;

    }

}

