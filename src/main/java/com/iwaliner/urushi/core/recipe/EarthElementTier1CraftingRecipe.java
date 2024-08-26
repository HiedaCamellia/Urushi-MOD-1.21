package com.iwaliner.urushi.core.recipe;

import com.google.gson.JsonObject;
import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.registries.RecipeTypeRegister;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;


import javax.annotation.Nullable;
import java.util.List;

public class EarthElementTier1CraftingRecipe extends AbstractElementCraftingRecipe{

    public EarthElementTier1CraftingRecipe(List<Ingredient> input, ItemStack output, int reiryoku) {
        super(input,output,reiryoku);
    }

    public RecipeType<?> getType() {
        return RecipeTypeRegister.EarthElementTier1CraftingRecipe;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeTypeRegister.EarthElementTier1CraftingSerializer.get();
    }



    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ItemAndBlockRegister.earth_element_crafting_table_tier1.get());
    }

    public static class EarthElementTier1CraftingRecipeType implements RecipeType<EarthElementTier1CraftingRecipe> {
        @Override
        public String toString() {
            return ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"earth_element_tier1_crafting").toString();
        }
    }

    public static class EarthElementTier1CraftingSerializer<T extends EarthElementTier1CraftingRecipe>implements RecipeSerializer<EarthElementTier1CraftingRecipe> {


        public static final MapCodec<EarthElementTier1CraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(EarthElementTier1CraftingRecipe::getInputItems),
                ItemStack.CODEC.fieldOf("result").forGetter(EarthElementTier1CraftingRecipe::getResult),
                Codec.INT.fieldOf("reiryoku").forGetter(EarthElementTier1CraftingRecipe::getReiryoku)
        ).apply(inst, EarthElementTier1CraftingRecipe::new));
        
        public static final StreamCodec<RegistryFriendlyByteBuf, EarthElementTier1CraftingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), EarthElementTier1CraftingRecipe::getInputItems,
                        ItemStack.STREAM_CODEC, EarthElementTier1CraftingRecipe::getResult,
                        ByteBufCodecs.INT, EarthElementTier1CraftingRecipe::getReiryoku,
                        EarthElementTier1CraftingRecipe::new
                );

        @Override
        public MapCodec<EarthElementTier1CraftingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, EarthElementTier1CraftingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
