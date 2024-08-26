package com.iwaliner.urushi.integration.jei;

import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.core.recipe.OilExtractingRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import static mezz.jei.api.recipe.RecipeIngredientRole.INPUT;
import static mezz.jei.api.recipe.RecipeIngredientRole.OUTPUT;

public class OilExtractingRecipeCategory implements IRecipeCategory<OilExtractingRecipe> {
    public static final ResourceLocation location=ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"oil_extracting");
    public static final ResourceLocation tex=ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"textures/gui/fryer.png");
    private final IDrawable background;
    private final IDrawable icon;
    private  final String textName;



    public OilExtractingRecipeCategory(IGuiHelper guiHelper){
        this.background=guiHelper.createDrawable(tex,0,166,82,35);
        this.icon=guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,new ItemStack(ItemAndBlockRegister.oil_extractor.get()));
        textName="oil_extracting";
    }


    @Override
    public RecipeType<OilExtractingRecipe> getRecipeType() {
        return JEIUrushiPlugin.JEI_OIL_EXTRACTING;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("gui.jei.category.urushi."+textName);
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }


    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, OilExtractingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(INPUT, 1, 5)
                .addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(OUTPUT, 61, 5)
                .addItemStack(recipe.getResultItem());
    }


    @Override
    public void draw(OilExtractingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        Component text = Component.translatable("gui.jei.category.urushi."+textName+".text");
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        int stringWidth = fontRenderer.width(text);
        guiGraphics.drawString(fontRenderer, text, background.getWidth() - stringWidth, 28, -8355712, false);

    }
}
