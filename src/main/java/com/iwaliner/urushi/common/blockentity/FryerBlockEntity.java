package com.iwaliner.urushi.common.blockentity;



import com.iwaliner.urushi.registries.BlockEntityRegister;
import com.iwaliner.urushi.registries.RecipeTypeRegister;
import com.iwaliner.urushi.common.blockentity.menu.FryerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

public  class FryerBlockEntity extends AbstractFryerBlockEntity  {
    public FryerBlockEntity(BlockPos p_155052_, BlockState p_155053_) {
        super(BlockEntityRegister.FryerBlockEntity.get(), p_155052_,p_155053_, RecipeTypeRegister.FryingRecipe);
    }
    protected Component getDefaultName() {
        return Component.translatable("container.fryer");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return null;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> nonNullList) {

    }


    protected AbstractContainerMenu createMenu(int p_59293_, Inventory p_59294_) {
        return new FryerMenu(p_59293_, p_59294_, this, this.dataAccess);
    }

}
