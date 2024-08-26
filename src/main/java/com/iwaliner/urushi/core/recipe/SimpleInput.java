package com.iwaliner.urushi.core.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

import java.util.List;

public record SimpleInput(List<ItemStack> stack) implements RecipeInput {
    @Override
    public ItemStack getItem(int slot) {
        return this.stack().get(slot);
    }

    @Override
    public int size() {
        return 1;
    }
}
