package com.iwaliner.urushi.common.blockentity.menu;

import com.iwaliner.urushi.core.recipe.SimpleInput;
import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import com.iwaliner.urushi.common.blockentity.slot.FryerFuelSlot;
import com.iwaliner.urushi.core.recipe.FryingRecipe;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.List;

public abstract class AbstractFryerMenu extends RecipeBookMenu<SimpleInput,FryingRecipe> {
    public static final int INGREDIENT_SLOT = 0;
    public static final int FUEL_SLOT = 1;
    public static final int RESULT_SLOT = 2;
    public static final int SLOT_COUNT = 3;
    public static final int DATA_COUNT = 4;
    private static final int INV_SLOT_START = 3;
    private static final int INV_SLOT_END = 30;
    private static final int USE_ROW_SLOT_START = 30;
    private static final int USE_ROW_SLOT_END = 39;
    private final Container container;
    private final ContainerData data;
    protected final Level level;
    private final RecipeType<? extends FryingRecipe> recipeType;
    private final RecipeBookType recipeBookType;

    protected AbstractFryerMenu(MenuType<?> p_38960_, RecipeType<? extends FryingRecipe> p_38961_,  int p_38963_, Inventory p_38964_) {
        this(p_38960_, p_38961_, p_38963_, p_38964_, new SimpleContainer(3), new SimpleContainerData(4));
    }

    protected AbstractFryerMenu(MenuType<?> p_38966_, RecipeType<? extends FryingRecipe> p_38967_, int p_38969_, Inventory p_38970_, Container p_38971_, ContainerData p_38972_) {
        super(p_38966_, p_38969_);
        this.recipeType = p_38967_;
        this.recipeBookType = null;
        checkContainerSize(p_38971_, 3);
        checkContainerDataCount(p_38972_, 4);
        this.container = p_38971_;
        this.data = p_38972_;
        this.level = p_38970_.player.level();
        this.addSlot(new Slot(p_38971_, 0, 56, 17));
        this.addSlot(new FryerFuelSlot(this, p_38971_, 1, 56, 53));
        this.addSlot(new FurnaceResultSlot(p_38970_.player, p_38971_, 2, 116, 35));

        for(int i = 0; i < 3; ++i) {
            for(int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(p_38970_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for(int k = 0; k < 9; ++k) {
            this.addSlot(new Slot(p_38970_, k, 8 + k * 18, 142));
        }

        this.addDataSlots(p_38972_);
    }

    public void fillCraftSlotsStackedContents(StackedContents p_38976_) {
        if (this.container instanceof StackedContentsCompatible) {
            ((StackedContentsCompatible)this.container).fillStackedContents(p_38976_);
        }

    }

    public void clearCraftingContent() {
        this.getSlot(0).set(ItemStack.EMPTY);
        this.getSlot(2).set(ItemStack.EMPTY);
    }


    public boolean recipeMatches(Recipe<? super RecipeInput> p_38980_) {
        return p_38980_.matches(new SimpleInput(List.of(this.getSlot(0).getItem())), this.level);
    }

    public int getResultSlotIndex() {
        return 2;
    }

    public int getGridWidth() {
        return 1;
    }

    public int getGridHeight() {
        return 1;
    }

    public int getSize() {
        return 3;
    }

    public boolean stillValid(Player p_38974_) {
        return this.container.stillValid(p_38974_);
    }

    public ItemStack quickMoveStack(Player p_38986_, int p_38987_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_38987_);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (p_38987_ == 2) {
                if (!this.moveItemStackTo(itemstack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (p_38987_ != 1 && p_38987_ != 0) {
                if (this.canSmelt(itemstack1)) {
                    if (!this.moveItemStackTo(itemstack1, 0, 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (this.isFuel(itemstack1)) {
                    if (!this.moveItemStackTo(itemstack1, 1, 2, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (p_38987_ >= 3 && p_38987_ < 30) {
                    if (!this.moveItemStackTo(itemstack1, 30, 39, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (p_38987_ >= 30 && p_38987_ < 39 && !this.moveItemStackTo(itemstack1, 3, 30, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(p_38986_, itemstack1);
        }

        return itemstack;
    }

    protected boolean canSmelt(ItemStack input) {
        return this.level.getRecipeManager().getRecipeFor((RecipeType<FryingRecipe>)this.recipeType, new SimpleInput(List.of(input)), this.level).isPresent();
    }

    protected boolean isFuel(ItemStack itemStack) {
        return itemStack.getItem()== ItemAndBlockRegister.vegetable_oil.get();
    }

    public int getBurnProgress() {
        int i = this.data.get(2);
        int j = this.data.get(3);
        return j != 0 && i != 0 ? i * 24 / j : 0;
    }

    public int getLitProgress() {
        int i = this.data.get(1);
        if (i == 0) {
            i = 200;
        }

        return this.data.get(0) * 13 / i;
    }

    public boolean isLit() {
        return this.data.get(0) > 0;
    }

    public RecipeBookType getRecipeBookType() {
        return this.recipeBookType;
    }

    public boolean shouldMoveToInventory(int p_150463_) {
        return p_150463_ != 1;
    }
}

