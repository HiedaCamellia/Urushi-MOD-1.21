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

public class WoodElementTier2CraftingRecipe extends AbstractElementCraftingRecipe{
    public WoodElementTier2CraftingRecipe(List<Ingredient> input, ItemStack output , int reiryoku) {
        super(input,output,reiryoku);
    }
    public RecipeType<?> getType() {
        return RecipeTypeRegister.WoodElementTier2CraftingRecipe;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeTypeRegister.WoodElementTier2CraftingSerializer.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ItemAndBlockRegister.wood_element_crafting_table_tier2.get());
    }

    public static class WoodElementTier2CraftingRecipeType implements RecipeType<WoodElementTier2CraftingRecipe> {
        @Override
        public String toString() {
            return ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"wood_element_tier2_crafting").toString();
        }
    }

    public static class WoodElementTier2CraftingSerializer <T extends WoodElementTier2CraftingRecipe>implements RecipeSerializer<WoodElementTier2CraftingRecipe> {


        public static final MapCodec<WoodElementTier2CraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(WoodElementTier2CraftingRecipe::getInputItems),
                ItemStack.CODEC.fieldOf("result").forGetter(WoodElementTier2CraftingRecipe::getResult),
                Codec.INT.fieldOf("reiryoku").forGetter(WoodElementTier2CraftingRecipe::getReiryoku)
        ).apply(inst, WoodElementTier2CraftingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, WoodElementTier2CraftingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), WoodElementTier2CraftingRecipe::getInputItems,
                        ItemStack.STREAM_CODEC, WoodElementTier2CraftingRecipe::getResult,
                        ByteBufCodecs.INT, WoodElementTier2CraftingRecipe::getReiryoku,
                        WoodElementTier2CraftingRecipe::new
                );

        @Override
        public MapCodec<WoodElementTier2CraftingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, WoodElementTier2CraftingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
