package com.iwaliner.urushi.core.recipe;

import com.google.gson.JsonObject;
import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.registries.RecipeTypeRegister;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;


import javax.annotation.Nullable;
import java.util.List;

public class FireElementTier1CraftingRecipe extends AbstractElementCraftingRecipe{
    public FireElementTier1CraftingRecipe(List<Ingredient> input, ItemStack output , int reiryoku) {
        super(input,output,reiryoku);
    }
    public RecipeType<?> getType() {
        return RecipeTypeRegister.FireElementTier1CraftingRecipe;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeTypeRegister.FireElementTier1CraftingSerializer.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ItemAndBlockRegister.fire_element_crafting_table_tier1.get());
    }

    public static class FireElementTier1CraftingRecipeType implements RecipeType<FireElementTier1CraftingRecipe> {
        @Override
        public String toString() {
            return ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"fire_element_tier1_crafting").toString();
        }
    }

    public static class FireElementTier1CraftingSerializer<T extends FireElementTier1CraftingRecipe> implements RecipeSerializer<FireElementTier1CraftingRecipe> {


        public static final MapCodec<FireElementTier1CraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(FireElementTier1CraftingRecipe::getInputItems),
                ItemStack.CODEC.fieldOf("result").forGetter(FireElementTier1CraftingRecipe::getResult),
                Codec.INT.fieldOf("reiryoku").forGetter(FireElementTier1CraftingRecipe::getReiryoku)
        ).apply(inst, FireElementTier1CraftingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, FireElementTier1CraftingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), FireElementTier1CraftingRecipe::getInputItems,
                        ItemStack.STREAM_CODEC, FireElementTier1CraftingRecipe::getResult,
                        ByteBufCodecs.INT, FireElementTier1CraftingRecipe::getReiryoku,
                        FireElementTier1CraftingRecipe::new
                );

        @Override
        public MapCodec<FireElementTier1CraftingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, FireElementTier1CraftingRecipe> streamCodec() {
            return STREAM_CODEC;
        }

    }
}
