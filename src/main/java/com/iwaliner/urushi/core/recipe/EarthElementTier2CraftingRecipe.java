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

public class EarthElementTier2CraftingRecipe extends AbstractElementCraftingRecipe{
    public EarthElementTier2CraftingRecipe(List<Ingredient> input, ItemStack output, int reiryoku) {
        super(input,output,reiryoku);
    }
    public RecipeType<?> getType() {
        return RecipeTypeRegister.EarthElementTier2CraftingRecipe;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeTypeRegister.EarthElementTier2CraftingSerializer.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ItemAndBlockRegister.earth_element_crafting_table_tier2.get());
    }

    public static class EarthElementTier2CraftingRecipeType implements RecipeType<EarthElementTier2CraftingRecipe> {
        @Override
        public String toString() {
            return ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"earth_element_tier2_crafting").toString();
        }
    }

    public static class EarthElementTier2CraftingSerializer<T extends EarthElementTier2CraftingRecipe>implements RecipeSerializer<EarthElementTier2CraftingRecipe> {


        public static final MapCodec<EarthElementTier2CraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(EarthElementTier2CraftingRecipe::getInputItems),
                ItemStack.CODEC.fieldOf("result").forGetter(EarthElementTier2CraftingRecipe::getResult),
                Codec.INT.fieldOf("reiryoku").forGetter(EarthElementTier2CraftingRecipe::getReiryoku)
        ).apply(inst, EarthElementTier2CraftingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, EarthElementTier2CraftingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), EarthElementTier2CraftingRecipe::getInputItems,
                        ItemStack.STREAM_CODEC, EarthElementTier2CraftingRecipe::getResult,
                        ByteBufCodecs.INT, EarthElementTier2CraftingRecipe::getReiryoku,
                        EarthElementTier2CraftingRecipe::new
                );

        @Override
        public MapCodec<EarthElementTier2CraftingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, EarthElementTier2CraftingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
