package com.iwaliner.urushi.core.recipe;

import com.iwaliner.urushi.ModCoreUrushi;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.Level;

public interface IElementCraftingRecipe extends Recipe<RecipeInput> {
  //  ResourceLocation locationType=new ResourceLocation(ModCoreUrushi.ModID,"wood_element_crafting");



    @Override
    default boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_){
        return true;
    }

    @Override
    default boolean isSpecial() {
        return true;
    }

    int getReiryoku();
}
