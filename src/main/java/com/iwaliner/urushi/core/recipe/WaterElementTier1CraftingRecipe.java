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

public class WaterElementTier1CraftingRecipe extends AbstractElementCraftingRecipe{
    public WaterElementTier1CraftingRecipe(List<Ingredient> input, ItemStack output , int reiryoku) {
        super(input,output,reiryoku);
    }
    public RecipeType<?> getType() {
        return RecipeTypeRegister.WaterElementTier1CraftingRecipe;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeTypeRegister.WaterElementTier1CraftingSerializer.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ItemAndBlockRegister.water_element_crafting_table_tier1.get());
    }

    public static class WaterElementTier1CraftingRecipeType implements RecipeType<WaterElementTier1CraftingRecipe> {
        @Override
        public String toString() {
            return ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"water_element_tier1_crafting").toString();
        }
    }

    public static class WaterElementTier1CraftingSerializer <T extends WaterElementTier1CraftingRecipe> implements RecipeSerializer<WaterElementTier1CraftingRecipe> {

        public static final MapCodec<WaterElementTier1CraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(WaterElementTier1CraftingRecipe::getInputItems),
                ItemStack.CODEC.fieldOf("result").forGetter(WaterElementTier1CraftingRecipe::getResult),
                Codec.INT.fieldOf("reiryoku").forGetter(WaterElementTier1CraftingRecipe::getReiryoku)
        ).apply(inst, WaterElementTier1CraftingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, WaterElementTier1CraftingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), WaterElementTier1CraftingRecipe::getInputItems,
                        ItemStack.STREAM_CODEC, WaterElementTier1CraftingRecipe::getResult,
                        ByteBufCodecs.INT, WaterElementTier1CraftingRecipe::getReiryoku,
                        WaterElementTier1CraftingRecipe::new
                );

        @Override
        public MapCodec<WaterElementTier1CraftingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, WaterElementTier1CraftingRecipe> streamCodec() {
            return STREAM_CODEC;
        }

    }
}
