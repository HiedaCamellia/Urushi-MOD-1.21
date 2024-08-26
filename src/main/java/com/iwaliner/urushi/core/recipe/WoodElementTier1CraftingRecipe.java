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

public class WoodElementTier1CraftingRecipe extends AbstractElementCraftingRecipe{
    public WoodElementTier1CraftingRecipe(List<Ingredient> input, ItemStack output , int reiryoku) {
        super(input,output,reiryoku);
    }
    public RecipeType<?> getType() {
        return RecipeTypeRegister.WoodElementTier1CraftingRecipe;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeTypeRegister.WoodElementTier1CraftingSerializer.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ItemAndBlockRegister.wood_element_crafting_table_tier1.get());
    }

    public static class WoodElementTier1CraftingRecipeType implements RecipeType<WoodElementTier1CraftingRecipe> {
        @Override
        public String toString() {
            return ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"wood_element_tier1_crafting").toString();
        }
    }

    public static class WoodElementTier1CraftingSerializer <T extends WoodElementTier1CraftingRecipe>implements RecipeSerializer<WoodElementTier1CraftingRecipe> {

        public static final MapCodec<WoodElementTier1CraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(WoodElementTier1CraftingRecipe::getInputItems),
                ItemStack.CODEC.fieldOf("result").forGetter(WoodElementTier1CraftingRecipe::getResult),
                Codec.INT.fieldOf("reiryoku").forGetter(WoodElementTier1CraftingRecipe::getReiryoku)
        ).apply(inst, WoodElementTier1CraftingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, WoodElementTier1CraftingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), WoodElementTier1CraftingRecipe::getInputItems,
                        ItemStack.STREAM_CODEC, WoodElementTier1CraftingRecipe::getResult,
                        ByteBufCodecs.INT, WoodElementTier1CraftingRecipe::getReiryoku,
                        WoodElementTier1CraftingRecipe::new
                );

        @Override
        public MapCodec<WoodElementTier1CraftingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, WoodElementTier1CraftingRecipe> streamCodec() {
            return STREAM_CODEC;
        }

    }
}
