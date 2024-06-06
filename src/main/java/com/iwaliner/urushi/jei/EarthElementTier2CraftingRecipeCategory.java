package com.iwaliner.urushi.jei;

import com.iwaliner.urushi.ItemAndBlockRegister;
import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.recipe.EarthElementTier1CraftingRecipe;
import com.iwaliner.urushi.recipe.EarthElementTier2CraftingRecipe;
import com.mojang.blaze3d.vertex.PoseStack;
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

public class EarthElementTier2CraftingRecipeCategory implements IRecipeCategory<EarthElementTier2CraftingRecipe> {
    public static final ResourceLocation location=new ResourceLocation(ModCoreUrushi.ModID,"earth_element_tier2_crafting");
    public static final ResourceLocation tex=new ResourceLocation(ModCoreUrushi.ModID,"textures/gui/tier2_crafting.png");
    private final IDrawable background;
    private final IDrawable icon;
    private  final String textName;



    public EarthElementTier2CraftingRecipeCategory(IGuiHelper guiHelper){
        this.background=guiHelper.createDrawable(tex,0,122,116,61);
        this.icon=guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK,new ItemStack(ItemAndBlockRegister.earth_element_crafting_table_tier2.get()));
        textName="earth_element_tier2_crafting";
    }


    @Override
    public RecipeType<EarthElementTier2CraftingRecipe> getRecipeType() {
        return JEIUrushiPlugin.JEI_EARTH_ELEMENT_TIER2_CRAFTING;
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
    public void setRecipe(IRecipeLayoutBuilder builder, EarthElementTier2CraftingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(INPUT, 19, 1)
                .addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(INPUT, 37, 19)
                .addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(INPUT,19, 37)
                .addIngredients(recipe.getIngredients().get(2));
        builder.addSlot(INPUT, 1, 19)
                .addIngredients(recipe.getIngredients().get(3));

        builder.addSlot(OUTPUT, 95, 23)
                .addItemStack(recipe.getResultItem());
    }

    @Override
    public void draw(EarthElementTier2CraftingRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        int reiryoku = recipe.getReiryoku();
        Component string = Component.literal(String.valueOf(reiryoku));
        Minecraft minecraft = Minecraft.getInstance();
        Font fontRenderer = minecraft.font;
        guiGraphics.drawString(fontRenderer, string, 72, 9, -8355712, false);

    }
}
