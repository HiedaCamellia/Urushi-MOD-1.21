package com.iwaliner.urushi.common.blockentity.menu;

import com.iwaliner.urushi.core.recipe.FryingRecipe;
import com.iwaliner.urushi.core.recipe.SimpleInput;
import com.iwaliner.urushi.registries.MenuRegister;
import com.iwaliner.urushi.registries.RecipeTypeRegister;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.List;


public class FryerMenu extends AbstractFryerMenu{
    public FryerMenu(int p_39532_, Inventory p_39533_) {
        super(MenuRegister.FryerMenu.get(), RecipeTypeRegister.FryingRecipe,p_39532_, p_39533_);
    }

    public FryerMenu(int p_39535_, Inventory p_39536_, Container p_39537_, ContainerData p_39538_) {
        super(MenuRegister.FryerMenu.get(), RecipeTypeRegister.FryingRecipe, p_39535_, p_39536_, p_39537_, p_39538_);
    }

    @Override
    public boolean recipeMatches(RecipeHolder<FryingRecipe> recipeHolder) {
        return recipeHolder.value().matches(new SimpleInput(List.of(this.getSlot(0).getItem())), this.level);
    }
}
