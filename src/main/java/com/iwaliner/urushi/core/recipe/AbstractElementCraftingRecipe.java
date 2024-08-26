package com.iwaliner.urushi.core.recipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.List;

public abstract class AbstractElementCraftingRecipe implements Recipe<ElementInput> {
    protected List<Ingredient> ingredient;
    protected ItemStack output;
    protected int reiryoku;

    public AbstractElementCraftingRecipe(List<Ingredient> input, ItemStack output, int reiryoku) {
        this.ingredient = input;
        this.output = output;
        this.reiryoku=reiryoku;
    }

    @Override
    public boolean matches(ElementInput inventory, Level world) {

      return   (ingredient.get(0).test(inventory.getItem(0))&&ingredient.get(1).test(inventory.getItem(1))&&ingredient.get(2).test(inventory.getItem(2))&&ingredient.get(3).test(inventory.getItem(3)))
              || (ingredient.get(0).test(inventory.getItem(1))&&ingredient.get(1).test(inventory.getItem(2))&&ingredient.get(2).test(inventory.getItem(3))&&ingredient.get(3).test(inventory.getItem(0)))
              || (ingredient.get(0).test(inventory.getItem(2))&&ingredient.get(1).test(inventory.getItem(3))&&ingredient.get(2).test(inventory.getItem(0))&&ingredient.get(3).test(inventory.getItem(1)))
              || (ingredient.get(0).test(inventory.getItem(3))&&ingredient.get(1).test(inventory.getItem(0))&&ingredient.get(2).test(inventory.getItem(1))&&ingredient.get(3).test(inventory.getItem(2)))
              ;


    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack assemble(ElementInput input, HolderLookup.Provider registries) {
        return output.copy();
    }
    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return this.output;
    }

    public ItemStack getResultItem() {
        return this.output;
    }

    public int getReiryoku() {
        return this.reiryoku;
    }

    public NonNullList<Ingredient> getIngredients(){
        NonNullList<Ingredient> list = NonNullList.create();
        list.addAll(ingredient);
        return list;
    }

    public List<Ingredient> getInputItems() {
        return ingredient;
    }

    public ItemStack getResult() {
        return output;
    }
}
