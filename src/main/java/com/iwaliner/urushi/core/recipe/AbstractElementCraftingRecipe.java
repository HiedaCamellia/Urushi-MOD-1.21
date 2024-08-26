package com.iwaliner.urushi.core.recipe;

import com.google.gson.JsonArray;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public abstract class AbstractElementCraftingRecipe implements IElementCraftingRecipe{
    protected  NonNullList<Ingredient> ingredient;
   protected ItemStack output;
    protected ResourceLocation location;
    protected  int reiryoku;

    public AbstractElementCraftingRecipe(NonNullList<Ingredient> input, ItemStack output, ResourceLocation location,int reiryoku) {
        this.ingredient = input;
        this.output = output;
        this.location = location;
        this.reiryoku=reiryoku;
    }

    @Override
    public boolean matches(Container inventory, Level world) {

      return   (ingredient.get(0).test(inventory.getItem(0))&&ingredient.get(1).test(inventory.getItem(1))&&ingredient.get(2).test(inventory.getItem(2))&&ingredient.get(3).test(inventory.getItem(3)))
              || (ingredient.get(0).test(inventory.getItem(1))&&ingredient.get(1).test(inventory.getItem(2))&&ingredient.get(2).test(inventory.getItem(3))&&ingredient.get(3).test(inventory.getItem(0)))
              || (ingredient.get(0).test(inventory.getItem(2))&&ingredient.get(1).test(inventory.getItem(3))&&ingredient.get(2).test(inventory.getItem(0))&&ingredient.get(3).test(inventory.getItem(1)))
              || (ingredient.get(0).test(inventory.getItem(3))&&ingredient.get(1).test(inventory.getItem(0))&&ingredient.get(2).test(inventory.getItem(1))&&ingredient.get(3).test(inventory.getItem(2)))
              ;


    }


    @Override
    public ItemStack assemble(Container p_44001_, RegistryAccess p_267165_) {
        return output.copy();
    }
    @Override
    public ItemStack getResultItem(RegistryAccess p_267052_) {
        return output.copy();
    }
    public ItemStack getResultItem() {
        return output.copy();
    }

    public int getReiryoku() {
        return this.reiryoku;
    }


    @Override
    public ResourceLocation getId() {
        return location;
    }


    public NonNullList<Ingredient> getIngredients(){
        return ingredient;
    }

    public static NonNullList<Ingredient> itemsFromJson(JsonArray p_44276_) {
        NonNullList<Ingredient> nonnulllist = NonNullList.create();

        for(int i = 0; i < p_44276_.size(); ++i) {
            Ingredient ingredient = Ingredient.fromJson(p_44276_.get(i));
            if (/**net.minecraftforge.common.ForgeConfig.SERVER.skipEmptyShapelessCheck.get() || */!ingredient.isEmpty()) {
                nonnulllist.add(ingredient);
            }
        }

        return nonnulllist;
    }


}
