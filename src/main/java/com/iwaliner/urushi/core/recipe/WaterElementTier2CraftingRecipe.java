package com.iwaliner.urushi.core.recipe;

import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.registries.RecipeTypeRegister;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.List;

public class WaterElementTier2CraftingRecipe extends AbstractElementCraftingRecipe{
    public WaterElementTier2CraftingRecipe(List<Ingredient> input, ItemStack output , int reiryoku) {
        super(input,output,reiryoku);
    }
    public RecipeType<?> getType() {
        return RecipeTypeRegister.WaterElementTier2CraftingRecipe;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeTypeRegister.WaterElementTier2CraftingSerializer.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ItemAndBlockRegister.water_element_crafting_table_tier2.get());
    }


    public static class WaterElementTier2CraftingRecipeType implements RecipeType<WaterElementTier2CraftingRecipe> {
        @Override
        public String toString() {
            return ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID,"water_element_tier2_crafting").toString();
        }
    }

    public static class WaterElementTier2CraftingSerializer <T extends WaterElementTier2CraftingRecipe> implements RecipeSerializer<WaterElementTier2CraftingRecipe> {

        public static final MapCodec<WaterElementTier2CraftingRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Codec.list(Ingredient.CODEC).fieldOf("ingredients").forGetter(WaterElementTier2CraftingRecipe::getInputItems),
                ItemStack.CODEC.fieldOf("result").forGetter(WaterElementTier2CraftingRecipe::getResult),
                Codec.INT.fieldOf("reiryoku").forGetter(WaterElementTier2CraftingRecipe::getReiryoku)
        ).apply(inst, WaterElementTier2CraftingRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, WaterElementTier2CraftingRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ByteBufCodecs.fromCodec(Codec.list(Ingredient.CODEC)), WaterElementTier2CraftingRecipe::getInputItems,
                        ItemStack.STREAM_CODEC, WaterElementTier2CraftingRecipe::getResult,
                        ByteBufCodecs.INT, WaterElementTier2CraftingRecipe::getReiryoku,
                        WaterElementTier2CraftingRecipe::new
                );

        @Override
        public MapCodec<WaterElementTier2CraftingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, WaterElementTier2CraftingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
