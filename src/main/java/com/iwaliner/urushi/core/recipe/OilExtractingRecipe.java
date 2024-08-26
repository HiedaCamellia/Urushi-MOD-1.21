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

public class OilExtractingRecipe implements Recipe<SimpleInput> {

    private final List<Ingredient> ingredient;
    private final ItemStack output;
    public static ResourceLocation locationType=ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"oil_extracting");


    public OilExtractingRecipe(List<Ingredient> input, ItemStack output ) {
        this.ingredient = input;
        this.output = output;
    }
    public RecipeType<?> getType() {
        return RecipeTypeRegister.OilExtractingRecipe;
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
        return RecipeTypeRegister.OilExtractingSerializer.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ItemAndBlockRegister.oil_extractor.get());
    }

    public NonNullList<Ingredient> getIngredients(){
        NonNullList<Ingredient> list = NonNullList.create();
        list.addAll(ingredient);
        return list;
    }
    public static class OilExtractingRecipeType implements RecipeType<OilExtractingRecipe> {
        @Override
        public String toString() {
            return OilExtractingRecipe.locationType.toString();
        }
    }

    public static class OilExtractingSerializer<T extends OilExtractingRecipe>implements RecipeSerializer<OilExtractingRecipe> {


        public static final MapCodec<OilExtractingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(OilExtractingRecipe::getIngredients),
                ItemStack.CODEC.fieldOf("result").forGetter(OilExtractingRecipe::getResult)
        ).apply(inst, OilExtractingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, OilExtractingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), OilExtractingRecipe::getIngredients,
                        ItemStack.STREAM_CODEC, OilExtractingRecipe::getResult,
                        OilExtractingRecipe::new
                );

        @Override
        public MapCodec<OilExtractingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, OilExtractingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
