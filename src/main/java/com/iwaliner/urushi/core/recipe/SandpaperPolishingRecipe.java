package com.iwaliner.urushi.core.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.registries.RecipeTypeRegister;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;


import javax.annotation.Nullable;
import java.util.List;

public class SandpaperPolishingRecipe implements Recipe<SimpleInput> {

    private final List<Ingredient> ingredient;
    private final ItemStack output;
    public static ResourceLocation locationType=ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"polishing");


    public SandpaperPolishingRecipe(List<Ingredient> input, ItemStack output ) {
        this.ingredient = input;
        this.output = output;
    }
    public RecipeType<?> getType() {
        return RecipeTypeRegister.SandpaperPolishingRecipe;
    }
    public ItemStack getResult() {
        return output.copy();
    }

    @Override
    public boolean matches(SimpleInput simpleInput, Level level) {
        return ingredient.get(0).test(simpleInput.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleInput simpleInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int p_43999_, int p_44000_) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output.copy();
    }


    public NonNullList<Ingredient> getIngredient() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.addAll(ingredient);
        return list;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeTypeRegister.SandpaperPolishingSerializer.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ItemAndBlockRegister.sandpaper_block.get());
    }

    public NonNullList<Ingredient> getIngredients(){
        NonNullList<Ingredient> list = NonNullList.create();
        list.addAll(ingredient);
        return list;
    }
    public static class SandpaperPolishingRecipeType implements RecipeType<SandpaperPolishingRecipe> {
        @Override
        public String toString() {
            return SandpaperPolishingRecipe.locationType.toString();
        }
    }

    public static class SandpaperPolishingSerializer <T extends SandpaperPolishingRecipe> implements RecipeSerializer<SandpaperPolishingRecipe> {


        public static final MapCodec<SandpaperPolishingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(SandpaperPolishingRecipe::getIngredients),
                ItemStack.CODEC.fieldOf("result").forGetter(SandpaperPolishingRecipe::getResult)
        ).apply(inst, SandpaperPolishingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, SandpaperPolishingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), SandpaperPolishingRecipe::getIngredients,
                        ItemStack.STREAM_CODEC, SandpaperPolishingRecipe::getResult,
                        SandpaperPolishingRecipe::new
                );

        @Override
        public MapCodec<SandpaperPolishingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, SandpaperPolishingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
