package com.iwaliner.urushi.common.blockentity;



import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.iwaliner.urushi.core.recipe.SimpleInput;
import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import com.iwaliner.urushi.core.recipe.FryingRecipe;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public abstract class AbstractFryerBlockEntity extends BaseContainerBlockEntity implements WorldlyContainer,  StackedContentsCompatible {
    private static final int[] SLOTS_FOR_UP = new int[]{0};
    private static final int[] SLOTS_FOR_DOWN = new int[]{2, 1};
    private static final int[] SLOTS_FOR_SIDES = new int[]{1};
    protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);
    private final SidedInvWrapper handler = new SidedInvWrapper(this, null);
    public int litTime;
    public int litDuration;
    public int cookingProgress;
    public int cookingTotalTime;
    protected final ContainerData dataAccess = new ContainerData() {
        public int get(int p_58431_) {
            switch(p_58431_) {
                case 0:
                    return AbstractFryerBlockEntity.this.litTime;
                case 1:
                    return AbstractFryerBlockEntity.this.litDuration;
                case 2:
                    return AbstractFryerBlockEntity.this.cookingProgress;
                case 3:
                    return AbstractFryerBlockEntity.this.cookingTotalTime;
                default:
                    return 0;
            }
        }

        public void set(int p_58433_, int p_58434_) {
            switch(p_58433_) {
                case 0:
                    AbstractFryerBlockEntity.this.litTime = p_58434_;
                    break;
                case 1:
                    AbstractFryerBlockEntity.this.litDuration = p_58434_;
                    break;
                case 2:
                    AbstractFryerBlockEntity.this.cookingProgress = p_58434_;
                    break;
                case 3:
                    AbstractFryerBlockEntity.this.cookingTotalTime = p_58434_;
            }

        }

        public int getCount() {
            return 4;
        }
    };
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();
    protected final RecipeType<? extends FryingRecipe> recipeType;

    protected AbstractFryerBlockEntity(BlockEntityType<?> p_i49964_1_, BlockPos p_155052_, BlockState p_155053_, RecipeType<? extends FryingRecipe> p_i49964_2_) {
        super(p_i49964_1_, p_155052_, p_155053_);
        this.recipeType = p_i49964_2_;
    }
    @Deprecated
    public static Map<Item, Integer> getFuel() {
        Map<Item, Integer> map = Maps.newLinkedHashMap();
        add(map, ItemAndBlockRegister.vegetable_oil.get(), 1600);

        return map;
    }
    private static void add(Map<Item, Integer> p_58375_, ItemLike p_58376_, int p_58377_) {
        Item item = p_58376_.asItem();
            p_58375_.put(item, p_58377_);

    }
    public boolean isLit() {
        return this.litTime > 0;
    }

    @Override
    public void loadAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
        super.loadAdditional(compound, lookupProvider);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(compound, this.items, lookupProvider);
        this.litTime = compound.getInt("BurnTime");
        this.cookingProgress = compound.getInt("CookTime");
        this.cookingTotalTime = compound.getInt("CookTimeTotal");
        this.litDuration = this.getBurnDuration(this.items.get(1));
        CompoundTag compoundtag = compound.getCompound("RecipesUsed");

        for(String s : compoundtag.getAllKeys()) {
            this.recipesUsed.put(ResourceLocation.parse(s), compoundtag.getInt(s));
        }
    }

    @Override
    public void saveAdditional(CompoundTag compound, HolderLookup.Provider lookupProvider) {
        super.saveAdditional(compound, lookupProvider);
        compound.putInt("BurnTime", this.litTime);
        compound.putInt("CookTime", this.cookingProgress);
        compound.putInt("CookTimeTotal", this.cookingTotalTime);
        ContainerHelper.saveAllItems(compound, this.items, lookupProvider);
        CompoundTag compoundtag = new CompoundTag();
        this.recipesUsed.forEach((p_187449_, p_187450_) -> {
            compoundtag.putInt(p_187449_.toString(), p_187450_);
        });
        compound.put("RecipesUsed", compoundtag);
    }
    
    public static void serverTick(Level level, BlockPos pos, BlockState state, AbstractFryerBlockEntity blockEntity) {
        boolean flag = blockEntity.isLit();
        boolean flag1 = false;
        if (blockEntity.isLit()) {
            --blockEntity.litTime;
        }

        if (!level.isClientSide) {
            Recipe<?> recipe = level.getRecipeManager().getRecipeFor(
                    (RecipeType<FryingRecipe>)blockEntity.recipeType,
                    new SimpleInput(List.of()),
                    level)
                    .orElse(null).value();

            ItemStack itemstack = blockEntity.items.get(1);
            if (blockEntity.isLit() || !itemstack.isEmpty() && !blockEntity.items.get(0).isEmpty()) {
                Recipe<?> irecipe = blockEntity.level.getRecipeManager().getRecipeFor((RecipeType<FryingRecipe>)blockEntity.recipeType, new SimpleInput(List.of(itemstack)),level).orElse(null).value();
                if (!blockEntity.isLit() && blockEntity.canBurn(level.registryAccess(),recipe,blockEntity.items,blockEntity.getMaxStackSize())) {
                    blockEntity.litTime = blockEntity.getBurnDuration(itemstack);
                    blockEntity.litDuration = blockEntity.litTime;
                    if (blockEntity.isLit()) {
                        flag1 = true;
                        if (itemstack.hasCraftingRemainingItem())
                            blockEntity.items.set(1, itemstack.getCraftingRemainingItem());
                        else
                        if (!itemstack.isEmpty()) {
                            Item item = itemstack.getItem();
                            itemstack.shrink(1);
                            if (itemstack.isEmpty()) {
                                blockEntity.items.set(1, itemstack.getCraftingRemainingItem());
                            }
                        }
                    }
                }

                if (blockEntity.isLit() && blockEntity.canBurn(level.registryAccess(),recipe,blockEntity.items,blockEntity.getMaxStackSize())) {
                    ++blockEntity.cookingProgress;
                    if (blockEntity.cookingProgress == blockEntity.cookingTotalTime) {
                        blockEntity.cookingProgress = 0;
                        blockEntity.cookingTotalTime = blockEntity.getTotalCookTime();
                        blockEntity.burn(level.registryAccess(),recipe,blockEntity.items,blockEntity.getMaxStackSize());
                        flag1 = true;
                    }
                } else {
                    blockEntity.cookingProgress = 0;
                }
            } else if (!blockEntity.isLit() && blockEntity.cookingProgress > 0) {
                blockEntity.cookingProgress = Mth.clamp(blockEntity.cookingProgress - 2, 0, blockEntity.cookingTotalTime);
            }

            if (flag != blockEntity.isLit()) {
                flag1 = true;
                blockEntity.level.setBlock(blockEntity.worldPosition, blockEntity.level.getBlockState(blockEntity.worldPosition).setValue(AbstractFurnaceBlock.LIT, Boolean.valueOf(blockEntity.isLit())), 3);
            }
        }

        if (flag1) {
            blockEntity.setChanged();
        }
    }

    public boolean canBurn(RegistryAccess p_266924_,@Nullable Recipe<?> p_155006_, NonNullList<ItemStack> input, int p_155008_) {
        if (!input.get(0).isEmpty() && p_155006_ != null) {
            ItemStack itemstack = ((Recipe<SimpleInput>) p_155006_).assemble(new SimpleInput(List.of(input.get(0))),p_266924_);
            if (itemstack.isEmpty()) {
                return false;
            } else {
                ItemStack itemstack1 = input.get(2);
                if (itemstack1.isEmpty()) {
                    return true;
                } else if (!ItemStack.isSameItemSameComponents(itemstack, itemstack1)) {
                    return false;
                } else if (itemstack1.getCount() + itemstack.getCount() <= p_155008_ && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) {
                    return true;
                } else {
                    return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize();
                }
            }
        } else {
            return false;
        }
    }
    public boolean burn(RegistryAccess p_266740_, @Nullable Recipe<?> p_155027_, NonNullList<ItemStack> input, int p_155029_) {
        if (p_155027_ != null && this.canBurn(p_266740_,p_155027_, input, p_155029_)) {
            ItemStack itemstack = input.get(0);
            ItemStack itemstack1 = ((Recipe<SimpleInput>) p_155027_).assemble(new SimpleInput(List.of(input.get(0))),p_266740_);
            ItemStack itemstack2 = input.get(2);
            if (itemstack2.isEmpty()) {
                this.items.set(2, itemstack1.copy());
            } else if (itemstack2.getItem() == itemstack1.getItem()) {
                itemstack2.grow(itemstack1.getCount());
            }

            if (!this.level.isClientSide) {
                this.setRecipeUsed(p_155027_);
            }



            itemstack.shrink(1);
            return true;
        } else {
            return false;
        }
    }
    protected int getBurnDuration(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return 0;
        } else {
            Item item = itemStack.getItem();
            return item==ItemAndBlockRegister.vegetable_oil.get()?1600:0;
        }
    }
    protected int getTotalCookTime() {
        return 100;
    }
    public static boolean isFuel(ItemStack p_213991_0_) {
        return true;
    }
    public int[] getSlotsForFace(Direction p_180463_1_) {
        if (p_180463_1_ == Direction.DOWN) {
            return SLOTS_FOR_DOWN;
        } else {
            return p_180463_1_ == Direction.UP ? SLOTS_FOR_UP : SLOTS_FOR_SIDES;
        }
    }
    public boolean canPlaceItemThroughFace(int p_180462_1_, ItemStack p_180462_2_, @Nullable Direction p_180462_3_) {
        return this.canPlaceItem(p_180462_1_, p_180462_2_);
    }
    public boolean canTakeItemThroughFace(int p_180461_1_, ItemStack p_180461_2_, Direction p_180461_3_) {
        if (p_180461_3_ == Direction.DOWN && p_180461_1_ == 1) {
            Item item = p_180461_2_.getItem();
            if (item != Items.WATER_BUCKET && item != Items.BUCKET) {
                return false;
            }
        }

        return true;
    }
    public int getContainerSize() {
        return this.items.size();
    }
    public boolean isEmpty() {
        for(ItemStack itemstack : this.items) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }
    public ItemStack getItem(int p_70301_1_) {
        return this.items.get(p_70301_1_);
    }

    public ItemStack removeItem(int p_70298_1_, int p_70298_2_) {
        return ContainerHelper.removeItem(this.items, p_70298_1_, p_70298_2_);
    }
    public ItemStack removeItemNoUpdate(int p_58387_) {
        return ContainerHelper.takeItem(this.items, p_58387_);
    }
    public void setItem(int p_70299_1_, ItemStack p_70299_2_) {
        ItemStack itemstack = this.items.get(p_70299_1_);
        boolean flag = !p_70299_2_.isEmpty() && ItemStack.isSameItemSameComponents(itemstack, p_70299_2_);
        this.items.set(p_70299_1_, p_70299_2_);
        if (p_70299_2_.getCount() > this.getMaxStackSize()) {
            p_70299_2_.setCount(this.getMaxStackSize());
        }

        if (p_70299_1_ == 0 && !flag) {
            this.cookingTotalTime = this.getTotalCookTime();
            this.cookingProgress = 0;
            this.setChanged();
        }

    }
    public boolean stillValid(Player p_70300_1_) {
        if (this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        } else {
            return p_70300_1_.distanceToSqr((double)this.worldPosition.getX() + 0.5D, (double)this.worldPosition.getY() + 0.5D, (double)this.worldPosition.getZ() + 0.5D) <= 64.0D;
        }
    }
    public boolean canPlaceItem(int p_94041_1_, ItemStack p_94041_2_) {
        if (p_94041_1_ == 2) {
            return false;
        } else if (p_94041_1_ != 1) {
            return true;
        } else {
            ItemStack itemstack = this.items.get(1);
            return p_94041_2_.getItem()==ItemAndBlockRegister. vegetable_oil.get();
        }
    }
    public void clearContent() {
        this.items.clear();
    }

    public void setRecipeUsed(@Nullable Recipe<?> p_193056_1_) {
        if (p_193056_1_ != null) {
            //this.recipesUsed.addTo(resourcelocation, 1);
        }

    }
    
    public List<Recipe<?>> getRecipesToAwardAndPopExperience(ServerLevel p_235640_1_, Vec3 p_235640_2_) {
        List<Recipe<?>> list = Lists.newArrayList();

        for(Object2IntMap.Entry<ResourceLocation> entry : this.recipesUsed.object2IntEntrySet()) {
            p_235640_1_.getRecipeManager().byKey(entry.getKey()).ifPresent((p_235642_4_) -> {
                list.add(p_235642_4_.value());
                createExperience(p_235640_1_, p_235640_2_, entry.getIntValue(), 0.35f);
            });
        }

        return list;
    }

    private static void createExperience(ServerLevel p_235641_0_, Vec3 p_235641_1_, int p_235641_2_, float p_235641_3_) {
        int i = Mth.floor((float)p_235641_2_ * p_235641_3_);
        float f = Mth.frac((float)p_235641_2_ * p_235641_3_);
        if (f != 0.0F && Math.random() < (double)f) {
            ++i;
        }
        ExperienceOrb.award(p_235641_0_, p_235641_1_, i);

    }
    public void fillStackedContents(StackedContents p_194018_1_) {
        for(ItemStack itemstack : this.items) {
            p_194018_1_.accountStack(itemstack);
        }

    }


    public SidedInvWrapper getItemHandler() {
        return handler;
    }
}
