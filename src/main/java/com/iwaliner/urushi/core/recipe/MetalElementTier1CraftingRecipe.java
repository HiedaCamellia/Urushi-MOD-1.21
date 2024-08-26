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

public class MetalElementTier1CraftingRecipe extends AbstractElementCraftingRecipe{
    public MetalElementTier1CraftingRecipe(List<Ingredient> input, ItemStack output , int reiryoku) {
        super(input,output,reiryoku);
    }
    public RecipeType<?> getType() {
        return RecipeTypeRegister.MetalElementTier1CraftingRecipe;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeTypeRegister.MetalElementTier1CraftingSerializer.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ItemAndBlockRegister.metal_element_crafting_table_tier1.get());
    }

    public static class MetalElementTier1CraftingRecipeType implements RecipeType<MetalElementTier1CraftingRecipe> {
        @Override
        public String toString() {
            return ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"metal_element_tier1_crafting").toString();
        }
    }

    public static class MetalElementTier1CraftingSerializer<T extends MetalElementTier1CraftingRecipe>implements RecipeSerializer<MetalElementTier1CraftingRecipe> {


        public static final MapCodec<MetalElementTier1CraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(MetalElementTier1CraftingRecipe::getInputItems),
                ItemStack.CODEC.fieldOf("result").forGetter(MetalElementTier1CraftingRecipe::getResult),
                Codec.INT.fieldOf("reiryoku").forGetter(MetalElementTier1CraftingRecipe::getReiryoku)
        ).apply(inst, MetalElementTier1CraftingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, MetalElementTier1CraftingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), MetalElementTier1CraftingRecipe::getInputItems,
                        ItemStack.STREAM_CODEC, MetalElementTier1CraftingRecipe::getResult,
                        ByteBufCodecs.INT, MetalElementTier1CraftingRecipe::getReiryoku,
                        MetalElementTier1CraftingRecipe::new
                );

        @Override
        public MapCodec<MetalElementTier1CraftingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, MetalElementTier1CraftingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
