package com.iwaliner.urushi.common.blockentity.screen;


import com.iwaliner.urushi.common.blockentity.menu.DoubledWoodenCabinetryMenu;
import com.iwaliner.urushi.common.blockentity.menu.UrushiHopperMenu;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class UrushiHopperScreen extends AbstractContainerScreen<UrushiHopperMenu>

{

    private final ResourceLocation CONTAINER_BACKGROUND = ResourceLocation.parse("urushi:textures/gui/urushi_hopper.png");

    public UrushiHopperScreen(UrushiHopperMenu p_i51104_1_, Inventory p_i51104_3_, Component p_i51104_4_) {
        super(p_i51104_1_, p_i51104_3_, p_i51104_4_);
        this.imageHeight = 133;
        this.inventoryLabelY = this.imageHeight - 94;
    }

    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics, mouseX, mouseY, partialTick);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    protected void renderBg(GuiGraphics p_98802_, float p_98803_, int p_98804_, int p_98805_) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, CONTAINER_BACKGROUND);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        p_98802_.blit(CONTAINER_BACKGROUND, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }


}
