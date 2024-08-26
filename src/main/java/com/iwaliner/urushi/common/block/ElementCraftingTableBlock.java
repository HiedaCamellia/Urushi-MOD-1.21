package com.iwaliner.urushi.common.block;

import com.iwaliner.urushi.registries.BlockEntityRegister;
import com.iwaliner.urushi.common.blockentity.ElementCraftingTableBlockEntity;
import com.iwaliner.urushi.core.recipe.AbstractElementCraftingRecipe;
import com.iwaliner.urushi.core.util.ElementType;
import com.iwaliner.urushi.core.util.ElementUtils;
import com.iwaliner.urushi.core.util.UrushiUtils;
import com.iwaliner.urushi.core.util.interfaces.ElementBlock;
import com.iwaliner.urushi.core.util.interfaces.Tiered;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ElementCraftingTableBlock extends BaseEntityBlock implements Tiered, ElementBlock {
    private final   ElementType elementType;
    private final int tier;
    private final java.util.function.Supplier<? extends RecipeType<? extends AbstractElementCraftingRecipe>> recipe;
    public static final BooleanProperty LIT=BlockStateProperties.LIT;
    public ElementCraftingTableBlock(int tier, ElementType elementType,java.util.function.Supplier<? extends RecipeType<? extends AbstractElementCraftingRecipe>> recipe, Properties p_49795_) {
        super(p_49795_);
        this.tier=tier;
        this.elementType=elementType;
        this.recipe=recipe;
        this.registerDefaultState(this.stateDefinition.any().setValue(LIT, Boolean.valueOf(false)));
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_49915_) {
        p_49915_.add(LIT);
    }
    @Nullable
    @Override
    public int getTier() {
        return tier;
    }
    @org.jetbrains.annotations.Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ElementCraftingTableBlockEntity(pos, state);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    public RenderShape getRenderShape(BlockState p_49090_) {
        return RenderShape.MODEL;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> list, TooltipFlag tooltipFlag) {
        UrushiUtils.setInfo(list, "element_crafting_table1");
        UrushiUtils.setInfo(list, "element_crafting_table2");
    }

    @Override
    public ElementType getElementType() {
        return elementType;
    }

    @javax.annotation.Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_152160_, BlockState p_152161_, BlockEntityType<T> p_152162_) {
        return createTickerHelper(p_152162_, BlockEntityRegister.ElementCraftingTable.get(), ElementCraftingTableBlockEntity::tick);
    }
    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (level.getBlockEntity(pos) instanceof ElementCraftingTableBlockEntity &&!player.isSuppressingBounce()) {
            ElementCraftingTableBlockEntity blockEntity = (ElementCraftingTableBlockEntity) level.getBlockEntity(pos);
            if(player.getItemInHand(hand).getItem()== Items.BARRIER){
                blockEntity.addStoredReiryoku(100);
            }
            if(!level.isClientSide()) {
                player.displayClientMessage(ElementUtils.getStoredReiryokuDisplayMessage(blockEntity.getStoredReiryoku(), blockEntity.getReiryokuCapacity(), blockEntity.getStoredElementType()), true);
            }
            return ItemInteractionResult.SUCCESS;

        }
        return ItemInteractionResult.FAIL;
    }
    public RecipeType<? extends AbstractElementCraftingRecipe> getRecipeType(){
        return recipe.get();
    }
}
