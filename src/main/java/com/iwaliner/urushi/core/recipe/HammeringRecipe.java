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

public class HammeringRecipe implements Recipe<SimpleInput> {

    private final List<Ingredient> ingredient;
    private final ItemStack output;
    public static ResourceLocation locationType=ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"hammering");


    public HammeringRecipe(List<Ingredient> input, ItemStack output ) {
        this.ingredient = input;
        this.output = output;
    }
    public RecipeType<?> getType() {
        return RecipeTypeRegister.HammeringRecipe;
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

    public ItemStack getResultItem() {
        return output.copy();
    }

    public NonNullList<Ingredient> getIngredient() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.addAll(ingredient);
        return list;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeTypeRegister.HammeringSerializer.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ItemAndBlockRegister.hammer.get());
    }

    public NonNullList<Ingredient> getIngredients(){
        NonNullList<Ingredient> list = NonNullList.create();
        list.addAll(ingredient);
        return list;
    }
    public static class HammeringRecipeType implements RecipeType<HammeringRecipe> {
        @Override
        public String toString() {
            return HammeringRecipe.locationType.toString();
        }
    }

    public static class HammeringSerializer<T extends HammeringRecipe>implements RecipeSerializer<HammeringRecipe> {


        public static final MapCodec<HammeringRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(HammeringRecipe::getIngredients),
                ItemStack.CODEC.fieldOf("result").forGetter(HammeringRecipe::getResult)
        ).apply(inst, HammeringRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, HammeringRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), HammeringRecipe::getIngredients,
                        ItemStack.STREAM_CODEC, HammeringRecipe::getResult,
                        HammeringRecipe::new
                );

        @Override
        public MapCodec<HammeringRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, HammeringRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
