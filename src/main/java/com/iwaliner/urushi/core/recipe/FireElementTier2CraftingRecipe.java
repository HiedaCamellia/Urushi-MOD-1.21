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

public class FireElementTier2CraftingRecipe extends AbstractElementCraftingRecipe{
    public FireElementTier2CraftingRecipe(List<Ingredient> input, ItemStack output , int reiryoku) {
        super(input,output,reiryoku);
    }
    public RecipeType<?> getType() {
        return RecipeTypeRegister.FireElementTier2CraftingRecipe;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeTypeRegister.FireElementTier2CraftingSerializer.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ItemAndBlockRegister.fire_element_crafting_table_tier2.get());
    }

    public static class FireElementTier2CraftingRecipeType implements RecipeType<FireElementTier2CraftingRecipe> {
        @Override
        public String toString() {
            return ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"fire_element_tier2_crafting").toString();
        }
    }

    public static class FireElementTier2CraftingSerializer<T extends FireElementTier2CraftingRecipe> implements RecipeSerializer<FireElementTier2CraftingRecipe> {


        public static final MapCodec<FireElementTier2CraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(FireElementTier2CraftingRecipe::getInputItems),
                ItemStack.CODEC.fieldOf("result").forGetter(FireElementTier2CraftingRecipe::getResult),
                Codec.INT.fieldOf("reiryoku").forGetter(FireElementTier2CraftingRecipe::getReiryoku)
        ).apply(inst, FireElementTier2CraftingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, FireElementTier2CraftingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), FireElementTier2CraftingRecipe::getInputItems,
                        ItemStack.STREAM_CODEC, FireElementTier2CraftingRecipe::getResult,
                        ByteBufCodecs.INT, FireElementTier2CraftingRecipe::getReiryoku,
                        FireElementTier2CraftingRecipe::new
                );

        @Override
        public MapCodec<FireElementTier2CraftingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, FireElementTier2CraftingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
