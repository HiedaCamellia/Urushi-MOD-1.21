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

public class MetalElementTier2CraftingRecipe extends AbstractElementCraftingRecipe{
    public MetalElementTier2CraftingRecipe(List<Ingredient> input, ItemStack output , int reiryoku) {
        super(input,output,reiryoku);
    }
    public RecipeType<?> getType() {
        return RecipeTypeRegister.MetalElementTier2CraftingRecipe;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeTypeRegister.MetalElementTier2CraftingSerializer.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ItemAndBlockRegister.metal_element_crafting_table_tier2.get());
    }

    public static class MetalElementTier2CraftingRecipeType implements RecipeType<MetalElementTier2CraftingRecipe> {
        @Override
        public String toString() {
            return ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"metal_element_tier2_crafting").toString();
        }
    }

    public static class MetalElementTier2CraftingSerializer<T extends MetalElementTier2CraftingRecipe>implements RecipeSerializer<MetalElementTier2CraftingRecipe> {

        public static final MapCodec<MetalElementTier2CraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(MetalElementTier2CraftingRecipe::getInputItems),
                ItemStack.CODEC.fieldOf("result").forGetter(MetalElementTier2CraftingRecipe::getResult),
                Codec.INT.fieldOf("reiryoku").forGetter(MetalElementTier2CraftingRecipe::getReiryoku)
        ).apply(inst, MetalElementTier2CraftingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, MetalElementTier2CraftingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), MetalElementTier2CraftingRecipe::getInputItems,
                        ItemStack.STREAM_CODEC, MetalElementTier2CraftingRecipe::getResult,
                        ByteBufCodecs.INT, MetalElementTier2CraftingRecipe::getReiryoku,
                        MetalElementTier2CraftingRecipe::new
                );

        @Override
        public MapCodec<MetalElementTier2CraftingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, MetalElementTier2CraftingRecipe> streamCodec() {
            return STREAM_CODEC;
        }

    }
}
