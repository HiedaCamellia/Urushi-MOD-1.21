package com.iwaliner.urushi.registries;

import com.iwaliner.urushi.core.config.ConfigUrushi;
import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.common.block.*;
import com.iwaliner.urushi.common.item.*;
import com.iwaliner.urushi.core.util.ElementType;
import com.iwaliner.urushi.core.util.ElementUtils;
import com.iwaliner.urushi.common.world.tree.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Optional;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ItemAndBlockRegister {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ModCoreUrushi.ModID);
    public static final DeferredRegister.Blocks BLOCKS= DeferredRegister.createBlocks(ModCoreUrushi.ModID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ModCoreUrushi.ModID);

    public static final DeferredBlock<Block> null_block =BLOCKS.register("null_block",() -> {return new NullBlock(BlockBehaviour.Properties.of().noOcclusion().isValidSpawn(ItemAndBlockRegister::never).isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never).noLootTable());});
    public static final DeferredItem<Item> null_blockitem =ITEMS.register("null_block",() -> {return new BlockItem( Objects.requireNonNull(null_block.get()), (new Item.Properties()));});
    public static final DeferredBlock<Block> sikkui =BP("plaster","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sikkui_slab =BP("plaster_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sikkui_stairs =BP("plaster_stairs","p",0,() -> {return new StairBlock(ItemAndBlockRegister.sikkui.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_sikkui_slab =BP("vertical_plaster_slab","p",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sikkui_bars =BP("plaster_bars","p",0,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_sikkui_bars =BP("horizontal_plaster_bars","p",0,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_framed_sikkui =BP("oak_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_framed_sikkui =BP("spruce_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_framed_sikkui =BP("birch_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_framed_sikkui =BP("jungle_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_framed_sikkui =BP("acacia_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_sikkui =BP("dark_oak_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_plaster =BP("japanese_apricot_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_framed_plaster =BP("sakura_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_framed_plaster =BP("cypress_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_plaster =BP("japanese_cedar_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_framed_plaster =BP("red_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_framed_plaster =BP("black_framed_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> namako =BP("namako","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> orange_plaster =BP("orange_plaster","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> orange_plaster_slab =BP("orange_plaster_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> orange_plaster_stairs =BP("orange_plaster_stairs","p",0,() -> {return new StairBlock(ItemAndBlockRegister.orange_plaster.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_orange_plaster_slab =BP("vertical_orange_plaster_slab","p",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> orange_plaster_bars =BP("orange_plaster_bars","p",0,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_orange_plaster_bars =BP("horizontal_orange_plaster_bars","p",0,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> magenta_plaster =BP("magenta_plaster","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> magenta_plaster_slab =BP("magenta_plaster_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> magenta_plaster_stairs =BP("magenta_plaster_stairs","p",0,() -> {return new StairBlock(ItemAndBlockRegister.magenta_plaster.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_magenta_plaster_slab =BP("vertical_magenta_plaster_slab","p",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> magenta_plaster_bars =BP("magenta_plaster_bars","p",0,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_magenta_plaster_bars =BP("horizontal_magenta_plaster_bars","p",0,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> light_blue_plaster =BP("light_blue_plaster","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> light_blue_plaster_slab =BP("light_blue_plaster_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> light_blue_plaster_stairs =BP("light_blue_plaster_stairs","p",0,() -> {return new StairBlock(ItemAndBlockRegister.light_blue_plaster.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_light_blue_plaster_slab =BP("vertical_light_blue_plaster_slab","p",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> light_blue_plaster_bars =BP("light_blue_plaster_bars","p",0,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_light_blue_plaster_bars =BP("horizontal_light_blue_plaster_bars","p",0,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> yellow_plaster =BP("yellow_plaster","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> yellow_plaster_slab =BP("yellow_plaster_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> yellow_plaster_stairs =BP("yellow_plaster_stairs","p",0,() -> {return new StairBlock(ItemAndBlockRegister.yellow_plaster.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_yellow_plaster_slab =BP("vertical_yellow_plaster_slab","p",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> yellow_plaster_bars =BP("yellow_plaster_bars","p",0,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_yellow_plaster_bars =BP("horizontal_yellow_plaster_bars","p",0,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> lime_plaster =BP("lime_plaster","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> lime_plaster_slab =BP("lime_plaster_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> lime_plaster_stairs =BP("lime_plaster_stairs","p",0,() -> {return new StairBlock(ItemAndBlockRegister.lime_plaster.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_lime_plaster_slab =BP("vertical_lime_plaster_slab","p",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> lime_plaster_bars =BP("lime_plaster_bars","p",0,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_lime_plaster_bars =BP("horizontal_lime_plaster_bars","p",0,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> pink_plaster =BP("pink_plaster","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> pink_plaster_slab =BP("pink_plaster_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> pink_plaster_stairs =BP("pink_plaster_stairs","p",0,() -> {return new StairBlock(ItemAndBlockRegister.pink_plaster.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_pink_plaster_slab =BP("vertical_pink_plaster_slab","p",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> pink_plaster_bars =BP("pink_plaster_bars","p",0,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_pink_plaster_bars =BP("horizontal_pink_plaster_bars","p",0,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> gray_plaster =BP("gray_plaster","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> gray_plaster_slab =BP("gray_plaster_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> gray_plaster_stairs =BP("gray_plaster_stairs","p",0,() -> {return new StairBlock(ItemAndBlockRegister.gray_plaster.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_gray_plaster_slab =BP("vertical_gray_plaster_slab","p",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> gray_plaster_bars =BP("gray_plaster_bars","p",0,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_gray_plaster_bars =BP("horizontal_gray_plaster_bars","p",0,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> light_gray_plaster =BP("light_gray_plaster","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> light_gray_plaster_slab =BP("light_gray_plaster_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> light_gray_plaster_stairs =BP("light_gray_plaster_stairs","p",0,() -> {return new StairBlock(ItemAndBlockRegister.light_gray_plaster.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_light_gray_plaster_slab =BP("vertical_light_gray_plaster_slab","p",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> light_gray_plaster_bars =BP("light_gray_plaster_bars","p",0,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_light_gray_plaster_bars =BP("horizontal_light_gray_plaster_bars","p",0,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cyan_plaster =BP("cyan_plaster","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cyan_plaster_slab =BP("cyan_plaster_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cyan_plaster_stairs =BP("cyan_plaster_stairs","p",0,() -> {return new StairBlock(ItemAndBlockRegister.cyan_plaster.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_cyan_plaster_slab =BP("vertical_cyan_plaster_slab","p",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cyan_plaster_bars =BP("cyan_plaster_bars","p",0,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_cyan_plaster_bars =BP("horizontal_cyan_plaster_bars","p",0,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> purple_plaster =BP("purple_plaster","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> purple_plaster_slab =BP("purple_plaster_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> purple_plaster_stairs =BP("purple_plaster_stairs","p",0,() -> {return new StairBlock(ItemAndBlockRegister.purple_plaster.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_purple_plaster_slab =BP("vertical_purple_plaster_slab","p",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> purple_plaster_bars =BP("purple_plaster_bars","p",0,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_purple_plaster_bars =BP("horizontal_purple_plaster_bars","p",0,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> blue_plaster =BP("blue_plaster","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> blue_plaster_slab =BP("blue_plaster_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> blue_plaster_stairs =BP("blue_plaster_stairs","p",0,() -> {return new StairBlock(ItemAndBlockRegister.blue_plaster.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_blue_plaster_slab =BP("vertical_blue_plaster_slab","p",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> blue_plaster_bars =BP("blue_plaster_bars","p",0,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_blue_plaster_bars =BP("horizontal_blue_plaster_bars","p",0,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> brown_plaster =BP("brown_plaster","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> brown_plaster_slab =BP("brown_plaster_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> brown_plaster_stairs =BP("brown_plaster_stairs","p",0,() -> {return new StairBlock(ItemAndBlockRegister.brown_plaster.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_brown_plaster_slab =BP("vertical_brown_plaster_slab","p",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> brown_plaster_bars =BP("brown_plaster_bars","p",0,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_brown_plaster_bars =BP("horizontal_brown_plaster_bars","p",0,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> green_plaster =BP("green_plaster","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> green_plaster_slab =BP("green_plaster_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> green_plaster_stairs =BP("green_plaster_stairs","p",0,() -> {return new StairBlock(ItemAndBlockRegister.green_plaster.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_green_plaster_slab =BP("vertical_green_plaster_slab","p",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> green_plaster_bars =BP("green_plaster_bars","p",0,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_green_plaster_bars =BP("horizontal_green_plaster_bars","p",0,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_plaster =BP("red_plaster","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_plaster_slab =BP("red_plaster_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_plaster_stairs =BP("red_plaster_stairs","p",0,() -> {return new StairBlock(ItemAndBlockRegister.red_plaster.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_red_plaster_slab =BP("vertical_red_plaster_slab","p",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_plaster_bars =BP("red_plaster_bars","p",0,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_red_plaster_bars =BP("horizontal_red_plaster_bars","p",0,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_plaster =BP("black_plaster","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_plaster_slab =BP("black_plaster_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_plaster_stairs =BP("black_plaster_stairs","p",0,() -> {return new StairBlock(ItemAndBlockRegister.black_plaster.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_black_plaster_slab =BP("vertical_black_plaster_slab","p",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_plaster_bars =BP("black_plaster_bars","p",0,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_black_plaster_bars =BP("horizontal_black_plaster_bars","p",0,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_framed_orange_plaster = BP("oak_framed_orange_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_framed_magenta_plaster = BP("oak_framed_magenta_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_framed_light_blue_plaster = BP("oak_framed_light_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_framed_yellow_plaster = BP("oak_framed_yellow_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_framed_lime_plaster = BP("oak_framed_lime_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_framed_pink_plaster = BP("oak_framed_pink_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_framed_gray_plaster = BP("oak_framed_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_framed_light_gray_plaster = BP("oak_framed_light_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_framed_cyan_plaster = BP("oak_framed_cyan_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_framed_purple_plaster = BP("oak_framed_purple_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_framed_blue_plaster = BP("oak_framed_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_framed_brown_plaster = BP("oak_framed_brown_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_framed_green_plaster = BP("oak_framed_green_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_framed_red_plaster = BP("oak_framed_red_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_framed_black_plaster = BP("oak_framed_black_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_framed_orange_plaster = BP("spruce_framed_orange_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_framed_magenta_plaster = BP("spruce_framed_magenta_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_framed_light_blue_plaster = BP("spruce_framed_light_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_framed_yellow_plaster = BP("spruce_framed_yellow_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_framed_lime_plaster = BP("spruce_framed_lime_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_framed_pink_plaster = BP("spruce_framed_pink_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_framed_gray_plaster = BP("spruce_framed_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_framed_light_gray_plaster = BP("spruce_framed_light_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_framed_cyan_plaster = BP("spruce_framed_cyan_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_framed_purple_plaster = BP("spruce_framed_purple_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_framed_blue_plaster = BP("spruce_framed_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_framed_brown_plaster = BP("spruce_framed_brown_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_framed_green_plaster = BP("spruce_framed_green_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_framed_red_plaster = BP("spruce_framed_red_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_framed_black_plaster = BP("spruce_framed_black_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_framed_orange_plaster = BP("birch_framed_orange_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_framed_magenta_plaster = BP("birch_framed_magenta_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_framed_light_blue_plaster = BP("birch_framed_light_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_framed_yellow_plaster = BP("birch_framed_yellow_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_framed_lime_plaster = BP("birch_framed_lime_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_framed_pink_plaster = BP("birch_framed_pink_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_framed_gray_plaster = BP("birch_framed_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_framed_light_gray_plaster = BP("birch_framed_light_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_framed_cyan_plaster = BP("birch_framed_cyan_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_framed_purple_plaster = BP("birch_framed_purple_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_framed_blue_plaster = BP("birch_framed_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_framed_brown_plaster = BP("birch_framed_brown_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_framed_green_plaster = BP("birch_framed_green_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_framed_red_plaster = BP("birch_framed_red_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_framed_black_plaster = BP("birch_framed_black_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_framed_orange_plaster = BP("jungle_framed_orange_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_framed_magenta_plaster = BP("jungle_framed_magenta_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_framed_light_blue_plaster = BP("jungle_framed_light_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_framed_yellow_plaster = BP("jungle_framed_yellow_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_framed_lime_plaster = BP("jungle_framed_lime_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_framed_pink_plaster = BP("jungle_framed_pink_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_framed_gray_plaster = BP("jungle_framed_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_framed_light_gray_plaster = BP("jungle_framed_light_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_framed_cyan_plaster = BP("jungle_framed_cyan_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_framed_purple_plaster = BP("jungle_framed_purple_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_framed_blue_plaster = BP("jungle_framed_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_framed_brown_plaster = BP("jungle_framed_brown_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_framed_green_plaster = BP("jungle_framed_green_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_framed_red_plaster = BP("jungle_framed_red_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_framed_black_plaster = BP("jungle_framed_black_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_framed_orange_plaster = BP("acacia_framed_orange_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_framed_magenta_plaster = BP("acacia_framed_magenta_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_framed_light_blue_plaster = BP("acacia_framed_light_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_framed_yellow_plaster = BP("acacia_framed_yellow_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_framed_lime_plaster = BP("acacia_framed_lime_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_framed_pink_plaster = BP("acacia_framed_pink_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_framed_gray_plaster = BP("acacia_framed_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_framed_light_gray_plaster = BP("acacia_framed_light_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_framed_cyan_plaster = BP("acacia_framed_cyan_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_framed_purple_plaster = BP("acacia_framed_purple_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_framed_blue_plaster = BP("acacia_framed_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_framed_brown_plaster = BP("acacia_framed_brown_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_framed_green_plaster = BP("acacia_framed_green_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_framed_red_plaster = BP("acacia_framed_red_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_framed_black_plaster = BP("acacia_framed_black_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_orange_plaster = BP("dark_oak_framed_orange_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_magenta_plaster = BP("dark_oak_framed_magenta_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_light_blue_plaster = BP("dark_oak_framed_light_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_yellow_plaster = BP("dark_oak_framed_yellow_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_lime_plaster = BP("dark_oak_framed_lime_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_pink_plaster = BP("dark_oak_framed_pink_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_gray_plaster = BP("dark_oak_framed_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_light_gray_plaster = BP("dark_oak_framed_light_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_cyan_plaster = BP("dark_oak_framed_cyan_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_purple_plaster = BP("dark_oak_framed_purple_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_blue_plaster = BP("dark_oak_framed_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_brown_plaster = BP("dark_oak_framed_brown_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_green_plaster = BP("dark_oak_framed_green_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_red_plaster = BP("dark_oak_framed_red_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_black_plaster = BP("dark_oak_framed_black_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_orange_plaster = BP("japanese_apricot_framed_orange_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_magenta_plaster = BP("japanese_apricot_framed_magenta_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_light_blue_plaster = BP("japanese_apricot_framed_light_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_yellow_plaster = BP("japanese_apricot_framed_yellow_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_lime_plaster = BP("japanese_apricot_framed_lime_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_pink_plaster = BP("japanese_apricot_framed_pink_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_gray_plaster = BP("japanese_apricot_framed_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_light_gray_plaster = BP("japanese_apricot_framed_light_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_cyan_plaster = BP("japanese_apricot_framed_cyan_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_purple_plaster = BP("japanese_apricot_framed_purple_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_blue_plaster = BP("japanese_apricot_framed_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_brown_plaster = BP("japanese_apricot_framed_brown_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_green_plaster = BP("japanese_apricot_framed_green_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_red_plaster = BP("japanese_apricot_framed_red_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_black_plaster = BP("japanese_apricot_framed_black_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_framed_orange_plaster = BP("sakura_framed_orange_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_framed_magenta_plaster = BP("sakura_framed_magenta_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_framed_light_blue_plaster = BP("sakura_framed_light_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_framed_yellow_plaster = BP("sakura_framed_yellow_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_framed_lime_plaster = BP("sakura_framed_lime_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_framed_pink_plaster = BP("sakura_framed_pink_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_framed_gray_plaster = BP("sakura_framed_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_framed_light_gray_plaster = BP("sakura_framed_light_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_framed_cyan_plaster = BP("sakura_framed_cyan_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_framed_purple_plaster = BP("sakura_framed_purple_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_framed_blue_plaster = BP("sakura_framed_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_framed_brown_plaster = BP("sakura_framed_brown_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_framed_green_plaster = BP("sakura_framed_green_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_framed_red_plaster = BP("sakura_framed_red_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_framed_black_plaster = BP("sakura_framed_black_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_framed_orange_plaster = BP("cypress_framed_orange_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_framed_magenta_plaster = BP("cypress_framed_magenta_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_framed_light_blue_plaster = BP("cypress_framed_light_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_framed_yellow_plaster = BP("cypress_framed_yellow_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_framed_lime_plaster = BP("cypress_framed_lime_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_framed_pink_plaster = BP("cypress_framed_pink_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_framed_gray_plaster = BP("cypress_framed_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_framed_light_gray_plaster = BP("cypress_framed_light_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_framed_cyan_plaster = BP("cypress_framed_cyan_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_framed_purple_plaster = BP("cypress_framed_purple_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_framed_blue_plaster = BP("cypress_framed_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_framed_brown_plaster = BP("cypress_framed_brown_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_framed_green_plaster = BP("cypress_framed_green_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_framed_red_plaster = BP("cypress_framed_red_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_framed_black_plaster = BP("cypress_framed_black_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_orange_plaster = BP("japanese_cedar_framed_orange_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_magenta_plaster = BP("japanese_cedar_framed_magenta_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_light_blue_plaster = BP("japanese_cedar_framed_light_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_yellow_plaster = BP("japanese_cedar_framed_yellow_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_lime_plaster = BP("japanese_cedar_framed_lime_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_pink_plaster = BP("japanese_cedar_framed_pink_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_gray_plaster = BP("japanese_cedar_framed_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_light_gray_plaster = BP("japanese_cedar_framed_light_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_cyan_plaster = BP("japanese_cedar_framed_cyan_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_purple_plaster = BP("japanese_cedar_framed_purple_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_blue_plaster = BP("japanese_cedar_framed_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_brown_plaster = BP("japanese_cedar_framed_brown_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_green_plaster = BP("japanese_cedar_framed_green_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_red_plaster = BP("japanese_cedar_framed_red_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_black_plaster = BP("japanese_cedar_framed_black_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_framed_orange_plaster = BP("red_framed_orange_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_framed_magenta_plaster = BP("red_framed_magenta_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_framed_light_blue_plaster = BP("red_framed_light_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_framed_yellow_plaster = BP("red_framed_yellow_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_framed_lime_plaster = BP("red_framed_lime_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_framed_pink_plaster = BP("red_framed_pink_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_framed_gray_plaster = BP("red_framed_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_framed_light_gray_plaster = BP("red_framed_light_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_framed_cyan_plaster = BP("red_framed_cyan_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_framed_purple_plaster = BP("red_framed_purple_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_framed_blue_plaster = BP("red_framed_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_framed_brown_plaster = BP("red_framed_brown_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_framed_green_plaster = BP("red_framed_green_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_framed_red_plaster = BP("red_framed_red_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_framed_black_plaster = BP("red_framed_black_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_framed_orange_plaster = BP("black_framed_orange_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_framed_magenta_plaster = BP("black_framed_magenta_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_framed_light_blue_plaster = BP("black_framed_light_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_framed_yellow_plaster = BP("black_framed_yellow_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_framed_lime_plaster = BP("black_framed_lime_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_framed_pink_plaster = BP("black_framed_pink_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_framed_gray_plaster = BP("black_framed_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_framed_light_gray_plaster = BP("black_framed_light_gray_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_framed_cyan_plaster = BP("black_framed_cyan_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_framed_purple_plaster = BP("black_framed_purple_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_framed_blue_plaster = BP("black_framed_blue_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_framed_brown_plaster = BP("black_framed_brown_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_framed_green_plaster = BP("black_framed_green_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_framed_red_plaster = BP("black_framed_red_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_framed_black_plaster = BP("black_framed_black_plaster","p",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredItem<Item> raw_ibushi_kawara =I("raw_ibushi_kawara");
    public static final DeferredItem<Item> ibushi_kawara =I("ibushi_kawara");
    public static final DeferredBlock<Block> ibushi_kawara_block =B("ibushi_kawara_block","p",0,() -> {return new HorizonalRotateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> ibushi_kawara_slab =B("ibushi_kawara_slab","p",0,() -> {return new HorizonalRotateSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> ibushi_kawara_stairs =B("ibushi_kawara_stairs","p",0,() -> {return new StairBlock(ibushi_kawara_block.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> ibushi_kawara_wall =B("ibushi_kawara_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> ibushi_kawara_roof_45 =B("ibushi_kawara_roof_45","p",0,() -> {return new Roof45Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F).noCollission());});
    public static final DeferredBlock<Block> ibushi_kawara_roof_225 =B("ibushi_kawara_roof_225","p",0,() -> {return new Roof225Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F).noCollission());});
    public static final DeferredItem<Item> copper_kawara =I("copper_kawara");
    public static final DeferredBlock<Block> copper_kawara_block =B("copper_kawara_block","p",0,() -> {return new HorizonalRotateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> copper_kawara_slab =B("copper_kawara_slab","p",0,() -> {return new HorizonalRotateSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> copper_kawara_stairs =B("copper_kawara_stairs","p",0,() -> {return new StairBlock(copper_kawara_block.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> copper_kawara_wall =B("copper_kawara_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> copper_kawara_roof_45 =B("copper_kawara_roof_45","p",0,() -> {return new Roof45Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F).noCollission());});
    public static final DeferredBlock<Block> copper_kawara_roof_225 =B("copper_kawara_roof_225","p",0,() -> {return new Roof225Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F).noCollission());});
    public static final DeferredItem<Item> cupric_oxide_kawara =I("cupric_oxide_kawara");
    public static final DeferredBlock<Block> cupric_oxide_kawara_block =B("cupric_oxide_kawara_block","p",0,() -> {return new HorizonalRotateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cupric_oxide_kawara_slab =B("cupric_oxide_kawara_slab","p",0,() -> {return new HorizonalRotateSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cupric_oxide_kawara_stairs =B("cupric_oxide_kawara_stairs","p",0,() -> {return new StairBlock(cupric_oxide_kawara_block.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cupric_oxide_kawara_wall =B("cupric_oxide_kawara_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cupric_oxide_kawara_roof_45 =B("cupric_oxide_kawara_roof_45","p",0,() -> {return new Roof45Block(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F).noCollission());});
    public static final DeferredBlock<Block> cupric_oxide_kawara_roof_225 =B("cupric_oxide_kawara_roof_225","p",0,() -> {return new Roof225Block(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.COPPER).requiresCorrectToolForDrops().strength(1.0F, 10.0F).noCollission());});
    public static final DeferredBlock<Block> wattle_and_daub =B("wattle_and_daub","s",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.5F, 2.0F).sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> wattle_and_daub_slab =B("wattle_and_daub_slab","s",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.5F, 2.0F).sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> wattle_and_daub_stairs =B("wattle_and_daub_stairs","s",-1,() -> {return new StairBlock(wattle_and_daub.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.5F, 2.0F).sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> oak_framed_wattle_and_daub =B("oak_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> spruce_framed_wattle_and_daub =B("spruce_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> birch_framed_wattle_and_daub =B("birch_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> jungle_framed_wattle_and_daub =B("jungle_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> acacia_framed_wattle_and_daub =B("acacia_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_wattle_and_daub =B("dark_oak_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_wattle_and_daub =B("japanese_apricot_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> sakura_framed_wattle_and_daub =B("sakura_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> cypress_framed_wattle_and_daub =B("cypress_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_wattle_and_daub =B("japanese_cedar_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> red_urushi_framed_wattle_and_daub =B("red_urushi_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> black_urushi_framed_wattle_and_daub =B("black_urushi_framed_wattle_and_daub","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.GRASS).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> sand_coast =B("sand_coast","s",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(0.5F, 3.0F).sound(SoundType.SAND));});
    public static final DeferredBlock<Block> oak_framed_sand_coast =B("oak_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> spruce_framed_sand_coast =B("spruce_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> birch_framed_sand_coast =B("birch_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> jungle_framed_sand_coast =B("jungle_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> acacia_framed_sand_coast =B("acacia_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> dark_oak_framed_sand_coast =B("dark_oak_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> japanese_apricot_framed_sand_coast =B("japanese_apricot_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> sakura_framed_sand_coast =B("sakura_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> cypress_framed_sand_coast =B("cypress_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> japanese_cedar_framed_sand_coast =B("japanese_cedar_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> red_urushi_framed_sand_coast =B("red_urushi_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> black_urushi_framed_sand_coast =B("black_urushi_framed_sand_coast","s",-1,() -> {return new FramedBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(0.5F, 2.0F));});
    public static final DeferredBlock<Block> thatched_block =B("thatched_block","h",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> thatched_slab =B("thatched_slab","h",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> thatched_stairs =B("thatched_stairs","h",-1,() -> {return new FlammableStairBlock(thatched_block.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> thatched_roof_45 =B("thatched_roof_45","h",-1,() -> {return new FlammableRoof45Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> thatched_roof_225 =B("thatched_roof_225","h",-1,() -> {return new FlammableRoof225Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> hiwadabuki_block =B("hiwadabuki_block","h",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> hiwadabuki_slab =B("hiwadabuki_slab","h",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> hiwadabuki_stairs =B("hiwadabuki_stairs","h",-1,() -> {return new FlammableStairBlock(thatched_block.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> hiwadabuki_roof_45 =B("hiwadabuki_roof_45","h",-1,() -> {return new FlammableRoof45Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> hiwadabuki_roof_225 =B("hiwadabuki_roof_225","h",-1,() -> {return new FlammableRoof225Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).strength(0.2F, 3.0F).sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> green_tatami =B("green_tatami","h",-1,() -> {return new FlammableRotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).strength(0.2F, 10.0F).sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> green_tatami_carpet =B("green_tatami_carpet","h",-1,() -> {return new FlammableTwoDirectionShapedBlock(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D,BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).strength(0.2F, 10.0F).sound(SoundType.GRASS).noCollission());});
    public static final DeferredBlock<Block> brown_tatami =B("brown_tatami","h",-1,() -> {return new FlammableRotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).strength(0.2F, 10.0F).sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> brown_tatami_carpet =B("brown_tatami_carpet","h",-1,() -> {return new FlammableTwoDirectionShapedBlock(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D,BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).strength(0.2F, 10.0F).sound(SoundType.GRASS).noOcclusion());});
    public static final DeferredBlock<Block> goldfish_bowl =B("goldfish_bowl","p",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(0.2F, 10.0F).sound(SoundType.GLASS).noOcclusion());});
    public static final DeferredBlock<Block> stone_trapdoor =B("stone_trapdoor","p",-1,() -> {return new TrapDoorBlock( BlockSetType.STONE,BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> rough_stone =B("rough_stone","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> rough_stone_slab =B("rough_stone_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> rough_stone_stairs =B("rough_stone_stairs","p",0,() -> {return new StairBlock(rough_stone.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> rough_stone_wall =B("rough_stone_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> ishigaki_block =B("ishigaki_block","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> ishigaki_slab =B("ishigaki_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> ishigaki_stairs =B("ishigaki_stairs","p",0,() -> {return new StairBlock(ishigaki_block.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> ishigaki_wall =B("ishigaki_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> concrete =B("concrete","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> concrete_slab =B("concrete_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> concrete_stairs =B("concrete_stairs","p",0,() -> {return new StairBlock(concrete.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> concrete_block_wall =B("concrete_block_wall","p",0,() -> {return new SimpleWallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dirty_concrete =B("dirty_concrete","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dirty_concrete_slab =B("dirty_concrete_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dirty_concrete_stairs =B("dirty_concrete_stairs","p",0,() -> {return new StairBlock(dirty_concrete.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> lidless_groove =B("lidless_groove","p",0,() -> {return new GrooveBlock(false,BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> groove =B("groove","p",0,() -> {return new GrooveBlock(true,BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> mesh_groove =B("mesh_groove","p",0,() -> {return new GrooveBlock(true,BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F).noOcclusion());});
    public static final DeferredBlock<Block> connectable_glass =B("connectable_glass","p",-1,() -> {return new ConnectableGlassBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(0.2F, 3.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never).isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> connectable_glass_pane =B("connectable_glass_pane","p",-1,() -> {return new ConnectableGlassPaneBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> metal_framed_glass =B("metal_framed_glass","p",-1,() -> {return new ConnectableGlassBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(0.2F, 3.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never).isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> metal_framed_glass_pane =B("metal_framed_glass_pane","p",-1,() -> {return new ConnectableGlassPaneBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> smooth_oak_planks =BW("smooth_oak_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_oak_slab =BW("smooth_oak_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_oak_stairs =BW("smooth_oak_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_oak_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_smooth_oak_slab =BW("vertical_smooth_oak_slab","a",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_shitamiita =BW("oak_shitamiita","a",-1,() -> {return new FlammableHorizonalRotateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_shitamiita_slab =BW("oak_shitamiita_slab","a",-1,() -> {return new FlammableHorizonalRotateSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_wall_for_framed_blocks =BW("oak_wall_for_framed_blocks","a",-1,() -> {return new FrameBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> oak_parapet =BW("oak_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_bars =BW("oak_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_oak_bars =BW("horizontal_oak_bars","a",-1,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_fushiranma =BW("oak_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> oak_board_window =BW("oak_board_window","a",-1,() -> {return new BoardWindowBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_spruce_planks =BW("smooth_spruce_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_spruce_slab =BW("smooth_spruce_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_spruce_stairs =BW("smooth_spruce_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_spruce_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_smooth_spruce_slab =BW("vertical_smooth_spruce_slab","a",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_shitamiita =BW("spruce_shitamiita","a",-1,() -> {return new FlammableHorizonalRotateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_shitamiita_slab =BW("spruce_shitamiita_slab","a",-1,() -> {return new FlammableHorizonalRotateSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_wall_for_framed_blocks =BW("spruce_wall_for_framed_blocks","a",-1,() -> {return new FrameBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> spruce_parapet =BW("spruce_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_bars =BW("spruce_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_spruce_bars =BW("horizontal_spruce_bars","a",-1,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_fushiranma =BW("spruce_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> spruce_board_window =BW("spruce_board_window","a",-1,() -> {return new BoardWindowBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_birch_planks =BW("smooth_birch_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_birch_slab =BW("smooth_birch_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_birch_stairs =BW("smooth_birch_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_birch_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_smooth_birch_slab =BW("vertical_smooth_birch_slab","a",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_shitamiita =BW("birch_shitamiita","a",-1,() -> {return new FlammableHorizonalRotateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_shitamiita_slab =BW("birch_shitamiita_slab","a",-1,() -> {return new FlammableHorizonalRotateSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_wall_for_framed_blocks =BW("birch_wall_for_framed_blocks","a",-1,() -> {return new FrameBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> birch_parapet =BW("birch_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_bars =BW("birch_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_birch_bars =BW("horizontal_birch_bars","a",-1,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_fushiranma =BW("birch_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> birch_board_window =BW("birch_board_window","a",-1,() -> {return new BoardWindowBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_jungle_planks =BW("smooth_jungle_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_jungle_slab =BW("smooth_jungle_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_jungle_stairs =BW("smooth_jungle_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_jungle_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_smooth_jungle_slab =BW("vertical_smooth_jungle_slab","a",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_shitamiita =BW("jungle_shitamiita","a",-1,() -> {return new FlammableHorizonalRotateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_shitamiita_slab =BW("jungle_shitamiita_slab","a",-1,() -> {return new FlammableHorizonalRotateSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_wall_for_framed_blocks =BW("jungle_wall_for_framed_blocks","a",-1,() -> {return new FrameBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> jungle_parapet =BW("jungle_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_bars =BW("jungle_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_jungle_bars =BW("horizontal_jungle_bars","a",-1,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_fushiranma =BW("jungle_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jungle_board_window =BW("jungle_board_window","a",-1,() -> {return new BoardWindowBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_acacia_planks =BW("smooth_acacia_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_acacia_slab =BW("smooth_acacia_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_acacia_stairs =BW("smooth_acacia_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_acacia_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_smooth_acacia_slab =BW("vertical_smooth_acacia_slab","a",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_shitamiita =BW("acacia_shitamiita","a",-1,() -> {return new FlammableHorizonalRotateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_shitamiita_slab =BW("acacia_shitamiita_slab","a",-1,() -> {return new FlammableHorizonalRotateSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_wall_for_framed_blocks =BW("acacia_wall_for_framed_blocks","a",-1,() -> {return new FrameBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> acacia_parapet =BW("acacia_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_bars =BW("acacia_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_acacia_bars =BW("horizontal_acacia_bars","a",-1,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_fushiranma =BW("acacia_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> acacia_board_window =BW("acacia_board_window","a",-1,() -> {return new BoardWindowBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_dark_oak_planks =BW("smooth_dark_oak_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_dark_oak_slab =BW("smooth_dark_oak_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_dark_oak_stairs =BW("smooth_dark_oak_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_dark_oak_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_smooth_dark_oak_slab =BW("vertical_smooth_dark_oak_slab","a",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_shitamiita =BW("dark_oak_shitamiita","a",-1,() -> {return new FlammableHorizonalRotateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_shitamiita_slab =BW("dark_oak_shitamiita_slab","a",-1,() -> {return new FlammableHorizonalRotateSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_wall_for_framed_blocks =BW("dark_oak_wall_for_framed_blocks","a",-1,() -> {return new FrameBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> dark_oak_parapet =BW("dark_oak_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_bars =BW("dark_oak_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_dark_oak_bars =BW("horizontal_dark_oak_bars","a",-1,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_fushiranma =BW("dark_oak_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> dark_oak_board_window =BW("dark_oak_board_window","a",-1,() -> {return new BoardWindowBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> green_bars =BW("green_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_green_bars =BW("horizontal_green_bars","a",-1,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_sapling =BW("red_sapling","a",-1,() -> {return new FlammableSaplingBlock(new TreeGrower("red_sapling",Optional.of(ConfiguredFeatureRegister.RED_KEY),Optional.empty(),Optional.empty()),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY).noCollission().instabreak().randomTicks());});
    public static final DeferredBlock<Block> red_leaves =BW("red_leaves","h",-1,() -> {return cutouteaves(MapColor.COLOR_RED,SoundType.AZALEA_LEAVES);});
    public static final DeferredBlock<Block> fallen_red_leaves =BW("fallen_red_leaves","h",-1,() -> {return new FallenLeavesBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).mapColor(MapColor.COLOR_RED).replaceable().strength(0.2F, 10.0F).sound(SoundType.AZALEA_LEAVES).noCollission());});
    public static final DeferredBlock<Block> grass_block_with_fallen_red_leaves =BW("grass_block_with_fallen_red_leaves","s",-1,() -> {return new GrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> kakuriyo_grass_block_with_fallen_red_leaves =BW("kakuriyo_grass_block_with_fallen_red_leaves","s",-1,() -> {return new KakuriyoGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> orange_sapling =BW("orange_sapling","a",-1,() -> {return new FlammableSaplingBlock(new TreeGrower("orange_sapling",Optional.of(ConfiguredFeatureRegister.ORANGE_KEY),Optional.empty(),Optional.empty()),BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).mapColor(MapColor.COLOR_ORANGE).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final DeferredBlock<Block> orange_leaves =BW("orange_leaves","h",-1,() -> {return cutouteaves(MapColor.COLOR_ORANGE,SoundType.AZALEA_LEAVES);});
    public static final DeferredBlock<Block> fallen_orange_leaves =BW("fallen_orange_leaves","h",-1,() -> {return new FallenLeavesBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).mapColor(MapColor.COLOR_ORANGE).replaceable().strength(0.2F, 10.0F).sound(SoundType.AZALEA_LEAVES).noCollission());});
    public static final DeferredBlock<Block> grass_block_with_fallen_orange_leaves =BW("grass_block_with_fallen_orange_leaves","s",-1,() -> {return new GrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> kakuriyo_grass_block_with_fallen_orange_leaves =BW("kakuriyo_grass_block_with_fallen_orange_leaves","s",-1,() -> {return new KakuriyoGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> yellow_sapling =BW("yellow_sapling","a",-1,() -> {return new FlammableSaplingBlock(new TreeGrower("yellow_sapling",Optional.of(ConfiguredFeatureRegister.YELLOW_KEY),Optional.empty(),Optional.empty()),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final DeferredBlock<Block> yellow_leaves =BW("yellow_leaves","h",-1,() -> {return cutouteaves(MapColor.COLOR_YELLOW,SoundType.AZALEA_LEAVES);});
    public static final DeferredBlock<Block> fallen_yellow_leaves =BW("fallen_yellow_leaves","h",-1,() -> {return new FallenLeavesBlock(BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).mapColor(MapColor.COLOR_YELLOW).replaceable().strength(0.2F, 10.0F).sound(SoundType.AZALEA_LEAVES).noCollission());});
    public static final DeferredBlock<Block> grass_block_with_fallen_yellow_leaves =BW("grass_block_with_fallen_yellow_leaves","s",-1,() -> {return new GrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> kakuriyo_grass_block_with_fallen_yellow_leaves =BW("kakuriyo_grass_block_with_fallen_yellow_leaves","s",-1,() -> {return new KakuriyoGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final DeferredItem<Item> japanese_apricot_bark =IW("japanese_apricot_bark");
    public static final DeferredBlock<Block> japanese_apricot_sapling =BW("japanese_apricot_sapling","a",-1,() -> {return new FlammableSaplingBlock(new TreeGrower("japanese_apricot_sapling",Optional.of(ConfiguredFeatureRegister.APRICOT_KEY),Optional.empty(),Optional.empty()),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).pushReaction(PushReaction.DESTROY).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final DeferredBlock<Block> japanese_apricot_leaves =BW("japanese_apricot_leaves","h",-1,() -> {return cutouteaves(MapColor.COLOR_PINK,SoundType.AZALEA_LEAVES);});
    public static final DeferredBlock<Block> fallen_japanese_apricot_leaves =BW("fallen_japanese_apricot_leaves","h",-1,() -> {return new FallenLeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).replaceable().pushReaction(PushReaction.DESTROY).strength(0.2F, 10.0F).sound(SoundType.AZALEA_LEAVES).noCollission());});
    public static final DeferredBlock<Block> grass_block_with_fallen_japanese_apricot_leaves =BW("grass_block_with_fallen_japanese_apricot_leaves","s",-1,() -> {return new GrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> kakuriyo_grass_block_with_fallen_japanese_apricot_leaves =BW("kakuriyo_grass_block_with_fallen_japanese_apricot_leaves","s",-1,() -> {return new KakuriyoGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> glowing_japanese_apricot_sapling =BW("glowing_japanese_apricot_sapling","a",-1,() -> {return new GlowingSaplingBlock(new TreeGrower("glowing_japanese_apricot_sapling",Optional.of(ConfiguredFeatureRegister.GLOWING_APRICOT_KEY),Optional.empty(),Optional.empty()),BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).mapColor(MapColor.COLOR_PINK).sound(SoundType.GRASS).noCollission().instabreak().randomTicks().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final DeferredBlock<Block> glowing_japanese_apricot_leaves =BW("glowing_japanese_apricot_leaves","h",-1,() -> {return glowingleaves(MapColor.COLOR_PINK,SoundType.AZALEA_LEAVES);});
    public static final DeferredItem<Item> matured_japanese_apricot_fruit =IF("matured_japanese_apricot_fruit");
    public static final DeferredItem<Item> pickled_japanese_apricot =ITEMS.register("pickled_japanese_apricot", () -> {return new Item((new Item.Properties()).food(FoodUrushi.PickledJapaneseApricot));});
    public static final DeferredBlock<Block> stripped_japanese_apricot_log =BW("stripped_japanese_apricot_log","a",-1,() -> {return log(MapColor.WOOD, MapColor.TERRACOTTA_PINK);});
    public static final DeferredBlock<Block> japanese_apricot_log =BW("japanese_apricot_log","a",-1,() -> {return strippablelog(stripped_japanese_apricot_log.get(),0,MapColor.WOOD, MapColor.TERRACOTTA_PINK);});
    public static final DeferredBlock<Block> stripped_japanese_apricot_wood =BW("stripped_japanese_apricot_wood","a",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_wood =BW("japanese_apricot_wood","a",-1,() -> {return new StrippableLogBlock(stripped_japanese_apricot_wood.get(),0,BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_planks =BW("japanese_apricot_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_slab =BW("japanese_apricot_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_stairs =BW("japanese_apricot_stairs","a",-1,() -> {return new FlammableStairBlock(japanese_apricot_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_fence =BW("japanese_apricot_fence","a",-1,() -> {return new FlammableFenceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_fence_gate =BW("japanese_apricot_fence_gate","a",-1,() -> {return new FlammableFenceGateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_door =BW("japanese_apricot_door","a",-1,() -> {return new DoorBlock(BlockSetType.OAK,BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion());});
    public static final DeferredBlock<Block> japanese_apricot_trapdoor =BW("japanese_apricot_trapdoor","a",-1,() -> {return new ConnectableTrapdoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> japanese_apricot_pressure_plate =BW("japanese_apricot_pressure_plate","a",-1,() -> {return new PressurePlateBlock(BlockSetType.OAK,BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final DeferredBlock<Block> japanese_apricot_button =BW("japanese_apricot_button","a",-1,() -> {return new ButtonBlock(BlockSetType.OAK,30,BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission().pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> smooth_japanese_apricot_planks =BW("smooth_japanese_apricot_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_japanese_apricot_slab =BW("smooth_japanese_apricot_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_japanese_apricot_stairs =BW("smooth_japanese_apricot_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_japanese_apricot_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_smooth_japanese_apricot_slab =BW("vertical_smooth_japanese_apricot_slab","a",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_shitamiita =BW("japanese_apricot_shitamiita","a",-1,() -> {return new FlammableHorizonalRotateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_shitamiita_slab =BW("japanese_apricot_shitamiita_slab","a",-1,() -> {return new FlammableHorizonalRotateSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_wall_for_framed_blocks =BW("japanese_apricot_wall_for_framed_blocks","a",-1,() -> {return new FrameBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> japanese_apricot_parapet =BW("japanese_apricot_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_bars =BW("japanese_apricot_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_japanese_apricot_bars =BW("horizontal_japanese_apricot_bars","a",-1,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_fushiranma =BW("japanese_apricot_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_apricot_board_window =BW("japanese_apricot_board_window","a",-1,() -> {return new BoardWindowBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredItem<Item> sakura_bark =IW("sakura_bark");
    public static final DeferredBlock<Block> sakura_sapling =BW("sakura_sapling","a",-1,() -> {return new FlammableSaplingBlock(new TreeGrower("sakura_sapling", Optional.of(ConfiguredFeatureRegister.SAKURA_KEY),Optional.empty(),Optional.empty()),BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).mapColor(MapColor.TERRACOTTA_WHITE).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final DeferredBlock<Block> big_sakura_sapling =BW("big_sakura_sapling","a",-1,() -> {return new FlammableSaplingBlock(new TreeGrower("big_sakura_sapling", Optional.of(ConfiguredFeatureRegister.FANCY_SAKURA_KEY),Optional.empty(),Optional.empty()),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final DeferredBlock<Block> sakura_leaves =BW("sakura_leaves","h",-1,() -> {return cutouteaves(MapColor.TERRACOTTA_WHITE,SoundType.AZALEA_LEAVES);});
    public static final DeferredBlock<Block> fallen_sakura_leaves =BW("fallen_sakura_leaves","h",-1,() -> {return new FallenLeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).pushReaction(PushReaction.DESTROY).replaceable().strength(0.2F, 10.0F).sound(SoundType.AZALEA_LEAVES).noCollission());});
    public static final DeferredBlock<Block> grass_block_with_fallen_sakura_leaves =BW("grass_block_with_fallen_sakura_leaves","s",-1,() -> {return new GrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> kakuriyo_grass_block_with_fallen_sakura_leaves =BW("kakuriyo_grass_block_with_fallen_sakura_leaves","s",-1,() -> {return new KakuriyoGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).strength(0.6F, 10.0F).randomTicks().sound(SoundType.GRASS));});
    public static final DeferredBlock<Block> glowing_sakura_sapling =BW("glowing_sakura_sapling","a",-1,() -> {return new GlowingSaplingBlock(new TreeGrower("glowing_sakura_sapling", Optional.of(ConfiguredFeatureRegister.GLOWING_SAKURA_KEY),Optional.empty(),Optional.empty()),BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).mapColor(MapColor.TERRACOTTA_WHITE).sound(SoundType.GRASS).noCollission().instabreak().randomTicks().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final DeferredBlock<Block> glowing_big_sakura_sapling =BW("glowing_big_sakura_sapling","a",-1,() -> {return new GlowingSaplingBlock(new TreeGrower("glowing_big_sakura_sapling", Optional.of(ConfiguredFeatureRegister.GLOWING_FANCY_SAKURA_KEY),Optional.empty(),Optional.empty()),BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).mapColor(MapColor.TERRACOTTA_WHITE).sound(SoundType.GRASS).noCollission().instabreak().randomTicks().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final DeferredBlock<Block> glowing_sakura_leaves =BW("glowing_sakura_leaves","h",-1,() -> {return glowingleaves(MapColor.TERRACOTTA_WHITE,SoundType.AZALEA_LEAVES);});
    public static final DeferredBlock<Block> stripped_sakura_log =BW("stripped_sakura_log","a",-1,() -> {return log(MapColor.WOOD, MapColor.COLOR_ORANGE);});
    public static final DeferredBlock<Block> sakura_log =BW("sakura_log","a",-1,() -> {return strippablelog(stripped_sakura_log.get(),1,MapColor.WOOD, MapColor.COLOR_ORANGE);});
    public static final DeferredBlock<Block> stripped_sakura_wood =BW("stripped_sakura_wood","a",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_wood =BW("sakura_wood","a",-1,() -> {return new StrippableLogBlock(stripped_sakura_wood.get(),1,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_planks =BW("sakura_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_slab =BW("sakura_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_stairs =BW("sakura_stairs","a",-1,() -> {return new FlammableStairBlock(sakura_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_fence =BW("sakura_fence","a",-1,() -> {return new FlammableFenceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_fence_gate =BW("sakura_fence_gate","a",-1,() -> {return new FlammableFenceGateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_door =BW("sakura_door","a",-1,() -> {return new DoorBlock(BlockSetType.OAK,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion());});
    public static final DeferredBlock<Block> sakura_trapdoor =BW("sakura_trapdoor","a",-1,() -> {return new ConnectableTrapdoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> sakura_pressure_plate =BW("sakura_pressure_plate","a",-1,() -> {return new PressurePlateBlock(BlockSetType.OAK,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final DeferredBlock<Block> sakura_button =BW("sakura_button","a",-1,() -> {return new ButtonBlock(BlockSetType.OAK,30,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission().pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> smooth_sakura_planks =BW("smooth_sakura_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_sakura_slab =BW("smooth_sakura_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_sakura_stairs =BW("smooth_sakura_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_sakura_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_smooth_sakura_slab =BW("vertical_smooth_sakura_slab","a",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_shitamiita =BW("sakura_shitamiita","a",-1,() -> {return new FlammableHorizonalRotateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_shitamiita_slab =BW("sakura_shitamiita_slab","a",-1,() -> {return new FlammableHorizonalRotateSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_wall_for_framed_blocks =BW("sakura_wall_for_framed_blocks","a",-1,() -> {return new FrameBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> sakura_parapet =BW("sakura_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_bars =BW("sakura_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_sakura_bars =BW("horizontal_sakura_bars","a",-1,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_fushiranma =BW("sakura_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> sakura_board_window =BW("sakura_board_window","a",-1,() -> {return new BoardWindowBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredItem<Item> cypress_bark =IW("cypress_bark");
    public static final DeferredBlock<Block> cypress_sapling =BW("cypress_sapling","a",-1,() -> {return new FlammableSaplingBlock(new TreeGrower("cypress_sapling",Optional.of(ConfiguredFeatureRegister.CYPRESS_KEY),Optional.of(ConfiguredFeatureRegister.MEGA_CYPRESS_KEY),Optional.empty()),BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).mapColor(MapColor.GRASS).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final DeferredBlock<Block> cypress_leaves =BW("cypress_leaves","h",-1,() -> {return leaves(MapColor.GRASS,SoundType.AZALEA_LEAVES);});
    public static final DeferredBlock<Block> stripped_cypress_log =BW("stripped_cypress_log","a",-1,() -> {return log(MapColor.WOOD, MapColor.SAND);});
    public static final DeferredBlock<Block> cypress_log =BW("cypress_log","a",-1,() -> {return strippablelog(stripped_cypress_log.get(),2,MapColor.WOOD, MapColor.SAND);});
    public static final DeferredBlock<Block> stripped_cypress_wood =BW("stripped_cypress_wood","a",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_wood =BW("cypress_wood","a",-1,() -> {return new StrippableLogBlock(stripped_cypress_wood.get(),2,BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_planks =BW("cypress_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_slab =BW("cypress_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_stairs =BW("cypress_stairs","a",-1,() -> {return new FlammableStairBlock(cypress_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_fence =BW("cypress_fence","a",-1,() -> {return new FlammableFenceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_fence_gate =BW("cypress_fence_gate","a",-1,() -> {return new FlammableFenceGateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_door =BW("cypress_door","a",-1,() -> {return new DoorBlock(BlockSetType.OAK,BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion());});
    public static final DeferredBlock<Block> cypress_trapdoor =BW("cypress_trapdoor","a",-1,() -> {return new ConnectableTrapdoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> cypress_pressure_plate =BW("cypress_pressure_plate","a",-1,() -> {return new PressurePlateBlock(BlockSetType.OAK,BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final DeferredBlock<Block> cypress_button =BW("cypress_button","a",-1,() -> {return new ButtonBlock(BlockSetType.OAK,30,BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission().pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> smooth_cypress_planks =BW("smooth_cypress_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_cypress_slab =BW("smooth_cypress_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_cypress_stairs =BW("smooth_cypress_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_cypress_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_smooth_cypress_slab =BW("vertical_smooth_cypress_slab","a",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_shitamiita =BW("cypress_shitamiita","a",-1,() -> {return new FlammableHorizonalRotateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_shitamiita_slab =BW("cypress_shitamiita_slab","a",-1,() -> {return new FlammableHorizonalRotateSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_wall_for_framed_blocks =BW("cypress_wall_for_framed_blocks","a",-1,() -> {return new FrameBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> cypress_parapet =BW("cypress_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_bars =BW("cypress_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_cypress_bars =BW("horizontal_cypress_bars","a",-1,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_fushiranma =BW("cypress_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> cypress_board_window =BW("cypress_board_window","a",-1,() -> {return new BoardWindowBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredItem<Item> japanese_cedar_bark =IW("japanese_cedar_bark");
    public static final DeferredBlock<Block> japanese_cedar_sapling =BW("japanese_cedar_sapling","a",-1,() -> {return new FlammableSaplingBlock(new TreeGrower("japanese_cedar_sapling", Optional.of(ConfiguredFeatureRegister.CEDAR_KEY),Optional.of(ConfiguredFeatureRegister.MEGA_CEDAR_KEY),Optional.empty()),BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).mapColor(MapColor.COLOR_BROWN).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final DeferredBlock<Block> japanese_cedar_leaves =BW("japanese_cedar_leaves","h",-1,() -> {return leaves(MapColor.GRASS,SoundType.AZALEA_LEAVES);});
    public static final DeferredBlock<Block> stripped_japanese_cedar_log =BW("stripped_japanese_cedar_log","a",-1,() -> {return log(MapColor.WOOD, MapColor.COLOR_BROWN);});
    public static final DeferredBlock<Block> japanese_cedar_log =BW("japanese_cedar_log","a",-1,() -> {return strippablelog(stripped_japanese_cedar_log.get(),3,MapColor.WOOD, MapColor.COLOR_BROWN);});
    public static final DeferredBlock<Block> stripped_japanese_cedar_wood =BW("stripped_japanese_cedar_wood","a",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_wood =BW("japanese_cedar_wood","a",-1,() -> {return new StrippableLogBlock(stripped_japanese_cedar_wood.get(),3,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_planks =BW("japanese_cedar_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_slab =BW("japanese_cedar_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_stairs =BW("japanese_cedar_stairs","a",-1,() -> {return new FlammableStairBlock(cypress_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_fence =BW("japanese_cedar_fence","a",-1,() -> {return new FlammableFenceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_fence_gate =BW("japanese_cedar_fence_gate","a",-1,() -> {return new FlammableFenceGateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_door =BW("japanese_cedar_door","a",-1,() -> {return new DoorBlock(BlockSetType.OAK,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion());});
    public static final DeferredBlock<Block> japanese_cedar_trapdoor =BW("japanese_cedar_trapdoor","a",-1,() -> {return new ConnectableTrapdoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> japanese_cedar_pressure_plate =BW("japanese_cedar_pressure_plate","a",-1,() -> {return new PressurePlateBlock(BlockSetType.OAK,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final DeferredBlock<Block> japanese_cedar_button =BW("japanese_cedar_button","a",-1,() -> {return new ButtonBlock(BlockSetType.OAK,30,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission().pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> smooth_japanese_cedar_planks =BW("smooth_japanese_cedar_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_japanese_cedar_slab =BW("smooth_japanese_cedar_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_japanese_cedar_stairs =BW("smooth_japanese_cedar_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_cypress_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_smooth_japanese_cedar_slab =BW("vertical_smooth_japanese_cedar_slab","a",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_shitamiita =BW("japanese_cedar_shitamiita","a",-1,() -> {return new FlammableHorizonalRotateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_shitamiita_slab =BW("japanese_cedar_shitamiita_slab","a",-1,() -> {return new FlammableHorizonalRotateSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_wall_for_framed_blocks =BW("japanese_cedar_wall_for_framed_blocks","a",-1,() -> {return new FrameBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> japanese_cedar_parapet =BW("japanese_cedar_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_bars =BW("japanese_cedar_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_japanese_cedar_bars =BW("horizontal_japanese_cedar_bars","a",-1,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_fushiranma =BW("japanese_cedar_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> japanese_cedar_board_window =BW("japanese_cedar_board_window","a",-1,() -> {return new BoardWindowBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> lacquer_sapling =BW("lacquer_sapling","a",-1,() -> {return new FlammableSaplingBlock(new TreeGrower("lacquer_sapling", Optional.of(ConfiguredFeatureRegister.LACQUER_KEY),Optional.empty(),Optional.empty()),BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).mapColor(MapColor.GRASS).sound(SoundType.GRASS).noCollission().instabreak().randomTicks());});
    public static final DeferredBlock<Block> lacquer_leaves =BW("lacquer_leaves","h",-1,() -> {return leaves(MapColor.GRASS,SoundType.AZALEA_LEAVES);});
    public static final DeferredBlock<Block> lacquer_log =BW("lacquer_log","a",-1,() -> {return chiselablelog(MapColor.WOOD, MapColor.WOOD);});
    public static final DeferredBlock<Block> chiseled_lacquer_log =BW("chiseled_lacquer_log","a",-1,() -> {return new ChiseledLacquerLogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F).randomTicks());});
    public static final DeferredItem<Item> tiny_red_dye =I("tiny_red_dye");
    public static final DeferredItem<Item> tiny_black_dye =I("tiny_black_dye");
    public static final DeferredItem<Item> raw_urushi_ball =ITEMS.register("raw_urushi_ball", () -> {return new ToolchipItem("rawurushi",(new Item.Properties()));});
    public static final DeferredItem<Item> red_urushi_ball =ITEMS.register("red_urushi_ball", () -> {return new Item((new Item.Properties()).craftRemainder(Items.BOWL));});
    public static final DeferredItem<Item> black_urushi_ball =ITEMS.register("black_urushi_ball", () -> {return new Item((new Item.Properties()).craftRemainder(Items.BOWL));});
    public static final DeferredBlock<Block> red_urushi_planks =BW("red_urushi_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_urushi_slab =BW("red_urushi_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_urushi_stairs =BW("red_urushi_stairs","a",-1,() -> {return new FlammableStairBlock(red_urushi_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_urushi_fence =BW("red_urushi_fence","a",-1,() -> {return new FlammableFenceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_urushi_fence_gate =BW("red_urushi_fence_gate","a",-1,() -> {return new FlammableFenceGateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_urushi_door =BW("red_urushi_door","a",-1,() -> {return new DoorBlock(BlockSetType.OAK,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion());});
    public static final DeferredBlock<Block> red_urushi_trapdoor =BW("red_urushi_trapdoor","a",-1,() -> {return new TrapDoorBlock(BlockSetType.OAK,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> red_urushi_pressure_plate =BW("red_urushi_pressure_plate","a",-1,() -> {return new PressurePlateBlock(BlockSetType.OAK,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final DeferredBlock<Block> red_urushi_button =BW("red_urushi_button","a",-1,() -> {return new ButtonBlock(BlockSetType.OAK,30,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission().pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> smooth_red_urushi_planks =BW("smooth_red_urushi_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_red_urushi_slab =BW("smooth_red_urushi_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_red_urushi_stairs =BW("smooth_red_urushi_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_red_urushi_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_smooth_red_urushi_slab =BW("vertical_smooth_red_urushi_slab","a",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_urushi_shitamiita =BW("red_urushi_shitamiita","a",-1,() -> {return new FlammableHorizonalRotateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_urushi_shitamiita_slab =BW("red_urushi_shitamiita_slab","a",-1,() -> {return new FlammableHorizonalRotateSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_urushi_wall_for_framed_blocks =BW("red_urushi_wall_for_framed_blocks","a",-1,() -> {return new FrameBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> red_urushi_parapet =BW("red_urushi_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_urushi_bars =BW("red_urushi_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_red_urushi_bars =BW("horizontal_red_urushi_bars","a",-1,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_urushi_fushiranma =BW("red_urushi_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> red_urushi_board_window =BW("red_urushi_board_window","a",-1,() -> {return new BoardWindowBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_urushi_planks =BW("black_urushi_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_urushi_slab =BW("black_urushi_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_urushi_stairs =BW("black_urushi_stairs","a",-1,() -> {return new FlammableStairBlock(black_urushi_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_urushi_fence =BW("black_urushi_fence","a",-1,() -> {return new FlammableFenceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_urushi_fence_gate =BW("black_urushi_fence_gate","a",-1,() -> {return new FlammableFenceGateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_urushi_door =BW("black_urushi_door","a",-1,() -> {return new DoorBlock(BlockSetType.OAK,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion());});
    public static final DeferredBlock<Block> black_urushi_trapdoor =BW("black_urushi_trapdoor","a",-1,() -> {return new TrapDoorBlock(BlockSetType.OAK,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> black_urushi_pressure_plate =BW("black_urushi_pressure_plate","a",-1,() -> {return new PressurePlateBlock(BlockSetType.OAK,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission());});
    public static final DeferredBlock<Block> black_urushi_button =BW("black_urushi_button","a",-1,() -> {return new ButtonBlock(BlockSetType.OAK,30,BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(0.5F, 10.0F).noCollission().pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> smooth_black_urushi_planks =BW("smooth_black_urushi_planks","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_black_urushi_slab =BW("smooth_black_urushi_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_black_urushi_stairs =BW("smooth_black_urushi_stairs","a",-1,() -> {return new FlammableStairBlock(smooth_black_urushi_planks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> vertical_smooth_black_urushi_slab =BW("vertical_smooth_black_urushi_slab","a",0,() -> {return new VerticalSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_urushi_shitamiita =BW("black_urushi_shitamiita","a",-1,() -> {return new FlammableHorizonalRotateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_urushi_shitamiita_slab =BW("black_urushi_shitamiita_slab","a",-1,() -> {return new FlammableHorizonalRotateSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_urushi_wall_for_framed_blocks =BW("black_urushi_wall_for_framed_blocks","a",-1,() -> {return new FrameBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).noOcclusion().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> black_urushi_parapet =BW("black_urushi_parapet","a",-1,() -> {return new ParapetBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_urushi_bars =BW("black_urushi_bars","a",-1,() -> {return new BarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> horizontal_black_urushi_bars =BW("horizontal_black_urushi_bars","a",-1,() -> {return new HorizontalBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_urushi_fushiranma =BW("black_urushi_fushiranma","a",-1,() -> {return new FushiranmaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> black_urushi_board_window =BW("black_urushi_board_window","a",-1,() -> {return new BoardWindowBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> wooden_cabinetry_slab =B("wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> wooden_cabinetry =B("wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_wooden_cabinetry =B("doubled_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> red_urushi_wooden_cabinetry_slab =B("red_urushi_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> red_urushi_wooden_cabinetry =B("red_urushi_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_red_urushi_wooden_cabinetry =B("doubled_red_urushi_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> white_stained_wooden_cabinetry_slab =B("white_stained_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> orange_stained_wooden_cabinetry_slab =B("orange_stained_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> magenta_stained_wooden_cabinetry_slab =B("magenta_stained_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> light_blue_stained_wooden_cabinetry_slab =B("light_blue_stained_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> yellow_stained_wooden_cabinetry_slab =B("yellow_stained_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> lime_stained_wooden_cabinetry_slab =B("lime_stained_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> pink_stained_wooden_cabinetry_slab =B("pink_stained_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> gray_stained_wooden_cabinetry_slab =B("gray_stained_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> light_gray_stained_wooden_cabinetry_slab =B("light_gray_stained_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> cyan_stained_wooden_cabinetry_slab =B("cyan_stained_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> purple_stained_wooden_cabinetry_slab =B("purple_stained_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> blue_stained_wooden_cabinetry_slab =B("blue_stained_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> brown_stained_wooden_cabinetry_slab =B("brown_stained_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> green_stained_wooden_cabinetry_slab =B("green_stained_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> red_stained_wooden_cabinetry_slab =B("red_stained_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> black_stained_wooden_cabinetry_slab =B("black_stained_wooden_cabinetry_slab","a",-1,() -> {return new WoodenCabinetrySlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> white_stained_wooden_cabinetry =B("white_stained_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> orange_stained_wooden_cabinetry =B("orange_stained_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> magenta_stained_wooden_cabinetry =B("magenta_stained_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> light_blue_stained_wooden_cabinetry =B("light_blue_stained_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> yellow_stained_wooden_cabinetry =B("yellow_stained_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> lime_stained_wooden_cabinetry =B("lime_stained_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> pink_stained_wooden_cabinetry =B("pink_stained_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> gray_stained_wooden_cabinetry =B("gray_stained_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> light_gray_stained_wooden_cabinetry =B("light_gray_stained_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> cyan_stained_wooden_cabinetry =B("cyan_stained_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> purple_stained_wooden_cabinetry =B("purple_stained_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> blue_stained_wooden_cabinetry =B("blue_stained_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> brown_stained_wooden_cabinetry =B("brown_stained_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> green_stained_wooden_cabinetry =B("green_stained_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> red_stained_wooden_cabinetry =B("red_stained_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> black_stained_wooden_cabinetry =B("black_stained_wooden_cabinetry","a",-1,() -> {return new WoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_white_stained_wooden_cabinetry =B("doubled_white_stained_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_orange_stained_wooden_cabinetry =B("doubled_orange_stained_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_magenta_stained_wooden_cabinetry =B("doubled_magenta_stained_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_light_blue_stained_wooden_cabinetry =B("doubled_light_blue_stained_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_yellow_stained_wooden_cabinetry =B("doubled_yellow_stained_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_lime_stained_wooden_cabinetry =B("doubled_lime_stained_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_pink_stained_wooden_cabinetry =B("doubled_pink_stained_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_gray_stained_wooden_cabinetry =B("doubled_gray_stained_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_light_gray_stained_wooden_cabinetry =B("doubled_light_gray_stained_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_cyan_stained_wooden_cabinetry =B("doubled_cyan_stained_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_purple_stained_wooden_cabinetry =B("doubled_purple_stained_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_blue_stained_wooden_cabinetry =B("doubled_blue_stained_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_brown_stained_wooden_cabinetry =B("doubled_brown_stained_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_green_stained_wooden_cabinetry =B("doubled_green_stained_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GREEN).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_red_stained_wooden_cabinetry =B("doubled_red_stained_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> doubled_black_stained_wooden_cabinetry =B("doubled_black_stained_wooden_cabinetry","a",-1,() -> {return new DoubledWoodenCabinetryBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> senryoubako =B("senryoubako","a",-1,() -> {return new SenryoubakoBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> auto_crafting_table =B("auto_crafting_table","p",-1,() -> {return new AutoCraftingTableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.STONE).strength(0.8F, 10.0F));});
    public static final DeferredBlock<Block> advanced_auto_crafting_table =B("advanced_auto_crafting_table","p",-1,() -> {return new AutoCraftingTableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).sound(SoundType.STONE).strength(0.8F, 10.0F));});
    public static final DeferredBlock<Block> urushi_hopper =B("urushi_hopper","a",-1,() -> {return new UrushiHopperBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> kitsunebiBlock =BLOCKS.register("kitsunebi",() -> {return new BarrierBlock(BlockBehaviour.Properties.of().sound(SoundType.SOUL_SAND).instabreak().noCollission().noOcclusion().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final DeferredItem<Item> kitsunebiItem =ITEMS.register("kitsunebi", () -> {return new KitsunebiItem((new Item.Properties()));});
    public static final DeferredBlock<Block> fox_hopper =B("fox_hopper","a",-1,() -> {return new FoxHopperBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOL).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> andon =B("andon","a",-1,() -> {return new AndonBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(0.2F, 10.0F).noOcclusion().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final DeferredBlock<Block> ariake_andon =B("ariake_andon","a",-1,() -> {return new AriakeAndonBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(0.2F, 10.0F).noOcclusion().lightLevel((p_235470_0_) -> {return 13;}));});
    public static final DeferredBlock<Block> kasuga_lantern =B("kasuga_lantern","a",-1,() -> {return new KasugaLanternBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(0.2F, 10.0F).noOcclusion().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final DeferredBlock<Block> long_chochin =B("long_chochin","n",-1,() -> {return new LongChochinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(0.2F, 10.0F).noOcclusion().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final DeferredBlock<Block> eigyouchu_long_chochin =B("eigyouchu_long_chochin","n",-1,() -> {return new LongChochinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(0.2F, 10.0F).noOcclusion().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final DeferredBlock<Block> izakaya_long_chochin =B("izakaya_long_chochin","n",-1,() -> {return new LongChochinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(0.2F, 10.0F).noOcclusion().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final DeferredBlock<Block> oden_long_chochin =B("oden_long_chochin","n",-1,() -> {return new LongChochinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(0.2F, 10.0F).noOcclusion().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final DeferredBlock<Block> ramen_long_chochin =B("ramen_long_chochin","n",-1,() -> {return new LongChochinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(0.2F, 10.0F).noOcclusion().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final DeferredBlock<Block> shokujidokoro_long_chochin =B("shokujidokoro_long_chochin","n",-1,() -> {return new LongChochinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(0.2F, 10.0F).noOcclusion().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final DeferredBlock<Block> pendant_light =B("pendant_light","a",-1,() -> {return new PendantLightBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(0.2F, 10.0F).noOcclusion().lightLevel(litBlockEmission(15)));});
    public static final DeferredBlock<Block> copper_giboshi =B("copper_giboshi","p",2,() -> {return new SimpleShapedBlock(Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D),BlockBehaviour.Properties.of().mapColor( MapColor.TERRACOTTA_CYAN).sound(SoundType.METAL).strength(0.5F, 30.0F).noOcclusion().requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> iron_giboshi =B("iron_giboshi","p",2,() -> {return new SimpleShapedBlock(Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.METAL).strength(0.5F, 30.0F).noOcclusion().requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> gold_giboshi =B("gold_giboshi","p",2,() -> {return new SimpleShapedBlock(Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D),BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).sound(SoundType.METAL).strength(0.5F, 30.0F).noOcclusion().requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> blank_fusuma =B("blank_fusuma","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> blue_seigaiha_fusuma =B("blue_seigaiha_fusuma","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> blue_sayagata_fusuma =B("blue_sayagata_fusuma","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> blank_antique_fusuma =B("blank_antique_fusuma","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SNOW).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> sliding_glass_door =B("sliding_glass_door","p",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().sound(SoundType.GLASS).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> oak_shoji_pane =BW("oak_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> spruce_shoji_pane =BW("spruce_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> birch_shoji_pane =BW("birch_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> jungle_shoji_pane =BW("jungle_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> acacia_shoji_pane =BW("acacia_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> dark_oak_shoji_pane =BW("dark_oak_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> japanese_apricot_shoji_pane =BW("japanese_apricot_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> sakura_shoji_pane =BW("sakura_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> cypress_shoji_pane =BW("cypress_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> japanese_cedar_shoji_pane =BW("japanese_cedar_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> red_urushi_shoji_pane =BW("red_urushi_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> black_urushi_shoji_pane =BW("black_urushi_shoji_pane","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> oak_shoji =BW("oak_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> spruce_shoji =BW("spruce_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> birch_shoji =BW("birch_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> jungle_shoji =BW("jungle_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> acacia_shoji =BW("acacia_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> dark_oak_shoji =BW("dark_oak_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> japanese_apricot_shoji =BW("japanese_apricot_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> sakura_shoji =BW("sakura_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> cypress_shoji =BW("cypress_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> japanese_cedar_shoji =BW("japanese_cedar_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> red_urushi_shoji =BW("red_urushi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> black_urushi_shoji =BW("black_urushi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> oak_yukimi_shoji =BW("oak_yukimi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> spruce_yukimi_shoji =BW("spruce_yukimi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PODZOL).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> birch_yukimi_shoji =BW("birch_yukimi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> jungle_yukimi_shoji =BW("jungle_yukimi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> acacia_yukimi_shoji =BW("acacia_yukimi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> dark_oak_yukimi_shoji =BW("dark_oak_yukimi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> japanese_apricot_yukimi_shoji =BW("japanese_apricot_yukimi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> sakura_yukimi_shoji =BW("sakura_yukimi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> cypress_yukimi_shoji =BW("cypress_yukimi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> japanese_cedar_yukimi_shoji =BW("japanese_cedar_yukimi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> red_urushi_yukimi_shoji =BW("red_urushi_yukimi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> black_urushi_yukimi_shoji =BW("black_urushi_yukimi_shoji","a",-1,() -> {return new SlideDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> deep_blue_noren =B("deep_blue_noren","a",-1,() -> {return new NorenBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> red_noren =B("red_noren","a",-1,() -> {return new NorenBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> cyan_noren =B("cyan_noren","a",-1,() -> {return new NorenBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_CYAN).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> magenta_noren =B("magenta_noren","a",-1,() -> {return new NorenBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_MAGENTA).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> men_onsen_noren =B("men_onsen_noren","a",-1,() -> {return new WideNorenBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> women_onsen_noren =B("women_onsen_noren","a",-1,() -> {return new WideNorenBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> sushi_noren =B("sushi_noren","a",-1,() -> {return new WideNorenBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).sound(SoundType.WOOD).strength(0.2F, 3.0F).noOcclusion());});
    public static final DeferredBlock<Block> kakejiku_14 =B("kakejiku_14","a",-1,() -> {return new KakejikuBlock(null,BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final DeferredBlock<Block> kakejiku_13 =B("kakejiku_13","a",-1,() -> {return new KakejikuBlock(kakejiku_14.get(),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final DeferredBlock<Block> kakejiku_12 =B("kakejiku_12","a",-1,() -> {return new KakejikuBlock(kakejiku_13.get(),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final DeferredBlock<Block> kakejiku_11 =B("kakejiku_11","a",-1,() -> {return new KakejikuBlock(kakejiku_12.get(),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final DeferredBlock<Block> kakejiku_10 =B("kakejiku_10","a",-1,() -> {return new KakejikuBlock(kakejiku_11.get(),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final DeferredBlock<Block> kakejiku_9 =B("kakejiku_9","a",-1,() -> {return new KakejikuBlock(kakejiku_10.get(),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final DeferredBlock<Block> kakejiku_8 =B("kakejiku_8","a",-1,() -> {return new KakejikuBlock(kakejiku_9.get(),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final DeferredBlock<Block> kakejiku_7 =B("kakejiku_7","a",-1,() -> {return new KakejikuBlock(kakejiku_8.get(),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final DeferredBlock<Block> kakejiku_6 =B("kakejiku_6","a",-1,() -> {return new KakejikuBlock(kakejiku_7.get(),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final DeferredBlock<Block> kakejiku_5 =B("kakejiku_5","a",-1,() -> {return new KakejikuBlock(kakejiku_6.get(),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final DeferredBlock<Block> kakejiku_4 =B("kakejiku_4","a",-1,() -> {return new KakejikuBlock(kakejiku_5.get(),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final DeferredBlock<Block> kakejiku_3 =B("kakejiku_3","a",-1,() -> {return new KakejikuBlock(kakejiku_4.get(),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final DeferredBlock<Block> kakejiku_2 =B("kakejiku_2","a",-1,() -> {return new KakejikuBlock(kakejiku_3.get(),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final DeferredBlock<Block> kakejiku_1 =B("kakejiku_1","a",-1,() -> {return new KakejikuBlock(kakejiku_2.get(),BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).sound(SoundType.WOOD).instabreak().noCollission());});
    public static final DeferredItem<Item> white_cushion =ITEMS.register("white_cushion", () -> {return new CushionItem(DyeColor.WHITE,(new Item.Properties()));});
    public static final DeferredItem<Item> orange_cushion =ITEMS.register("orange_cushion", () -> {return new CushionItem(DyeColor.ORANGE,(new Item.Properties()));});
    public static final DeferredItem<Item> magenta_cushion =ITEMS.register("magenta_cushion", () -> {return new CushionItem(DyeColor.MAGENTA,(new Item.Properties()));});
    public static final DeferredItem<Item> light_blue_cushion =ITEMS.register("light_blue_cushion", () -> {return new CushionItem(DyeColor.LIGHT_BLUE,(new Item.Properties()));});
    public static final DeferredItem<Item> yellow_cushion =ITEMS.register("yellow_cushion", () -> {return new CushionItem(DyeColor.YELLOW,(new Item.Properties()));});
    public static final DeferredItem<Item> lime_cushion =ITEMS.register("lime_cushion", () -> {return new CushionItem(DyeColor.LIME,(new Item.Properties()));});
    public static final DeferredItem<Item> pink_cushion =ITEMS.register("pink_cushion", () -> {return new CushionItem(DyeColor.PINK,(new Item.Properties()));});
    public static final DeferredItem<Item> gray_cushion =ITEMS.register("gray_cushion", () -> {return new CushionItem(DyeColor.GRAY,(new Item.Properties()));});
    public static final DeferredItem<Item> light_gray_cushion =ITEMS.register("light_gray_cushion", () -> {return new CushionItem(DyeColor.LIGHT_GRAY,(new Item.Properties()));});
    public static final DeferredItem<Item> cyan_cushion =ITEMS.register("cyan_cushion", () -> {return new CushionItem(DyeColor.CYAN,(new Item.Properties()));});
    public static final DeferredItem<Item> purple_cushion =ITEMS.register("purple_cushion", () -> {return new CushionItem(DyeColor.PURPLE,(new Item.Properties()));});
    public static final DeferredItem<Item> blue_cushion =ITEMS.register("blue_cushion", () -> {return new CushionItem(DyeColor.BLUE,(new Item.Properties()));});
    public static final DeferredItem<Item> brown_cushion =ITEMS.register("brown_cushion", () -> {return new CushionItem(DyeColor.BROWN,(new Item.Properties()));});
    public static final DeferredItem<Item> green_cushion =ITEMS.register("green_cushion", () -> {return new CushionItem(DyeColor.GREEN,(new Item.Properties()));});
    public static final DeferredItem<Item> red_cushion =ITEMS.register("red_cushion", () -> {return new CushionItem(DyeColor.RED,(new Item.Properties()));});
    public static final DeferredItem<Item> black_cushion =ITEMS.register("black_cushion", () -> {return new CushionItem(DyeColor.BLACK,(new Item.Properties()));});
    public static final DeferredBlock<Block> white_futon =B("white_futon","n",-1,() -> {return new FutonBlock(DyeColor.WHITE,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final DeferredBlock<Block> orange_futon =B("orange_futon","n",-1,() -> {return new FutonBlock(DyeColor.ORANGE,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final DeferredBlock<Block> magenta_futon =B("magenta_futon","n",-1,() -> {return new FutonBlock(DyeColor.MAGENTA,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final DeferredBlock<Block> light_blue_futon =B("light_blue_futon","n",-1,() -> {return new FutonBlock(DyeColor.LIGHT_BLUE,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final DeferredBlock<Block> yellow_futon =B("yellow_futon","n",-1,() -> {return new FutonBlock(DyeColor.YELLOW,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final DeferredBlock<Block> lime_futon =B("lime_futon","n",-1,() -> {return new FutonBlock(DyeColor.LIME,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final DeferredBlock<Block> pink_futon =B("pink_futon","n",-1,() -> {return new FutonBlock(DyeColor.PINK,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final DeferredBlock<Block> gray_futon =B("gray_futon","n",-1,() -> {return new FutonBlock(DyeColor.GRAY,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final DeferredBlock<Block> light_gray_futon =B("light_gray_futon","n",-1,() -> {return new FutonBlock(DyeColor.LIGHT_GRAY,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final DeferredBlock<Block> cyan_futon =B("cyan_futon","n",-1,() -> {return new FutonBlock(DyeColor.CYAN,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final DeferredBlock<Block> purple_futon =B("purple_futon","n",-1,() -> {return new FutonBlock(DyeColor.PURPLE,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final DeferredBlock<Block> blue_futon =B("blue_futon","n",-1,() -> {return new FutonBlock(DyeColor.BLUE,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final DeferredBlock<Block> brown_futon =B("brown_futon","n",-1,() -> {return new FutonBlock(DyeColor.BROWN,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final DeferredBlock<Block> green_futon =B("green_futon","n",-1,() -> {return new FutonBlock(DyeColor.GREEN,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final DeferredBlock<Block> red_futon =B("red_futon","n",-1,() -> {return new FutonBlock(DyeColor.RED,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final DeferredBlock<Block> black_futon =B("black_futon","n",-1,() -> {return new FutonBlock(DyeColor.BLACK,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.WOOL).strength(0.3F, 10.0F));});
    public static final DeferredBlock<Block> wind_bell =B("wind_bell","n",-1,() -> {return new WIndBellBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NONE).sound(SoundType.GLASS).strength(0.2F, 10.0F).noOcclusion().noCollission());});
    public static final DeferredBlock<Block> magma_slab =B("magma_slab","p",-1,() -> {return new MagmaSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(0.5F, 10.0F).lightLevel((p_235470_0_) -> {return 3;}).randomTicks().isValidSpawn((p_187421_, p_187422_, p_187423_, p_187424_) -> {return p_187424_.fireImmune();}).hasPostProcess(ItemAndBlockRegister::always).emissiveRendering(ItemAndBlockRegister::always));});
    public static final DeferredBlock<Block> magma_stairs =B("magma_stairs","p",-1,() -> {return new MagmaStairBlock(Blocks.MAGMA_BLOCK.defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(0.5F, 10.0F).lightLevel((p_235470_0_) -> {return 3;}).randomTicks().isValidSpawn((p_187421_, p_187422_, p_187423_, p_187424_) -> {return p_187424_.fireImmune();}).hasPostProcess(ItemAndBlockRegister::always).emissiveRendering(ItemAndBlockRegister::always));});
    public static final DeferredBlock<Block> japanese_timber_bamboo =B("japanese_timber_bamboo","a",-1,() -> {return new JapaneseTimberBambooBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).sound(SoundType.BAMBOO).strength(0.5F, 10.0F).randomTicks().noCollission().pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> bamboo_block =B("bamboo_block","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.BAMBOO).strength(0.5F, 10.0F));});
    public static final DeferredBlock<Block> bamboo_slab =B("bamboo_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.BAMBOO).strength(0.5F, 10.0F));});
    public static final DeferredBlock<Block> bamboo_stairs =B("bamboo_stairs","a",-1,() -> {return new FlammableStairBlock(bamboo_block.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.BAMBOO).strength(0.5F, 10.0F));});
    public static final DeferredBlock<Block> bamboo_wall =B("bamboo_wall","a",-1,() -> {return new IronBarsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.BAMBOO).strength(0.5F, 10.0F).noOcclusion());});
    public static final DeferredItem<Item> bamboo_charcoal =I("bamboo_charcoal");
    public static final DeferredBlock<Block> bamboo_charcoal_block =B("bamboo_charcoal_block","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.BAMBOO).strength(0.5F, 10.0F));});
    public static final DeferredBlock<Block> tawara =BF("tawara","h",-1,() -> {return new FlammableHorizonalRotateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.2F, 3.0F).sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> paddy_field =BF("paddy_field","s",-1,() -> {return new FarmBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(0.6F, 3.0F).sound(SoundType.GRAVEL).isViewBlocking(ItemAndBlockRegister::always).isSuffocating(ItemAndBlockRegister::always));});
    public static final DeferredBlock<Block> senbakoki =BF("senbakoki","a",-1,() -> {return new SenbakokiBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(0.6F, 10.0F).sound(SoundType.WOOD));});
    public static final DeferredBlock<Block> dirt_furnace =BF("dirt_furnace","s",-1,() -> {return new DirtFurnaceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(1F, 10.0F).sound(SoundType.GRAVEL).noOcclusion());});
    public static final DeferredBlock<Block> rice_cauldron =BF("rice_cauldron","p",-1,() -> {return new RiceCauldronBlock(BlockBehaviour.Properties.of().mapColor( MapColor.COLOR_BLACK).strength(1F, 10.0F).sound(SoundType.METAL).requiresCorrectToolForDrops());});
    public static final DeferredItem<Item> vegetable_oil =IF("vegetable_oil");
    public static final DeferredBlock<Block> oil_extractor =BF("oil_extractor","a",-1,() -> {return new OilExtractorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.LADDER).strength(1F, 3.0F));});
    public static final DeferredBlock<Block> fryer =BF("fryer","p",0,() -> {return new FryerBlock(BlockBehaviour.Properties.of().mapColor( MapColor.WOOL).sound(SoundType.METAL).strength(1F, 10.0F).requiresCorrectToolForDrops().dynamicShape());});
    public static final DeferredBlock<Block> fermentation_barrel =BF("fermentation_barrel","a",-1,() -> {return new FermentationBarrelBlock(()->Blocks.AIR,()->ItemStack.EMPTY,BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(0.5F, 10.0F));});
    public static final DeferredBlock<Block> fermentation_barrel_with_rice =BF("fermentation_barrel_with_rice","a",-1,() -> {return new FermentationBarrelBlock(()->ItemAndBlockRegister.fermentation_barrel_with_rice_malt.get(),()->new ItemStack(ItemAndBlockRegister.rice.get(),8),BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(0.5F, 10.0F).randomTicks());});
    public static final DeferredBlock<Block> fermentation_barrel_with_rice_malt =BF("fermentation_barrel_with_rice_malt","a",-1,() -> {return new FermentationBarrelBlock(()->Blocks.AIR,()->new ItemStack(ItemAndBlockRegister.rice_malt.get(),8),BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(0.5F, 10.0F));});
    public static final DeferredBlock<Block> fermentation_barrel_with_shikomi_miso =BF("fermentation_barrel_with_shikomi_miso","a",-1,() -> {return new FermentationBarrelBlock(()->ItemAndBlockRegister.fermentation_barrel_with_miso.get(),()->new ItemStack(ItemAndBlockRegister.shikomi_miso.get(),8),BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(0.5F, 10.0F).randomTicks());});
    public static final DeferredBlock<Block> fermentation_barrel_with_miso =BF("fermentation_barrel_with_miso","a",-1,() -> {return new FermentationBarrelBlock(()->Blocks.AIR,()->new ItemStack(ItemAndBlockRegister.miso.get(),8),BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(0.5F, 10.0F));});
    public static final DeferredBlock<Block> unfired_shichirin =B("unfired_shichirin","s",-1,() -> {return new UnfinishedShichirinBlock(BlockBehaviour.Properties.of().mapColor( MapColor.TERRACOTTA_RED).sound(SoundType.ROOTED_DIRT).strength(0.4F, 10.0F));});
    public static final DeferredBlock<Block> unfinished_shichirin =B("unfinished_shichirin","p",-1,() -> {return new UnfinishedShichirinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.STONE).strength(1F, 10.0F).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> shichirin =BM("shichirin","p",-1,() -> {return new ShichirinBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.STONE).strength(1F, 10.0F).requiresCorrectToolForDrops().dynamicShape());});
    public static final DeferredItem<Item> uchiwa =ITEMS.register("uchiwa", () -> {return new UchiwaItem((new Item.Properties()).durability(5120));});
    public static final DeferredBlock<Block> rice_crop =BF("rice_crop","h",-1,() -> {return new RiceCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).sound(SoundType.GRASS).randomTicks().noCollission().instabreak().pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> azuki_crop =BF("azuki_crop","h",-1,() -> {return new UrushiCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).sound(SoundType.GRASS).randomTicks().noCollission().instabreak().pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> soy_crop =BF("soy_crop","h",-1,() -> {return new UrushiCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).sound(SoundType.GRASS).randomTicks().noCollission().instabreak().pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> green_onion_crop =BF("green_onion_crop","h",-1,() -> {return new UrushiCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).sound(SoundType.GRASS).randomTicks().noCollission().instabreak().pushReaction(PushReaction.DESTROY));});
    public static final DeferredItem<Item> rice_malt =ITEMS.register("rice_malt", () -> {return new ToolchipItem("rice_malt",(new Item.Properties()));});
    public static final DeferredItem<Item> raw_rice =ITEMS.register("raw_rice", () -> {return new ToolchipItem("rawrice",(new Item.Properties()));});
    public static final DeferredItem<Item> rice =ITEMS.register("rice", () -> {return new PlaceableFoodItem(()-> EntityRegister.RiceFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Rice));});
    public static final DeferredItem<Item> tkg =ITEMS.register("tkg", () -> {return new PlaceableFoodItem(()->EntityRegister.TKGFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.TKG));});
    public static final DeferredItem<Item> sekihan =ITEMS.register("sekihan", () -> {return new PlaceableFoodItem(()->EntityRegister.SekihanFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Sekihan));});
    public static final DeferredItem<Item> butadon =ITEMS.register("butadon", () -> {return new PlaceableFoodItem(()->EntityRegister.ButadonFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Butadon));});
    public static final DeferredItem<Item> gyudon =ITEMS.register("gyudon", () -> {return new PlaceableFoodItem(()->EntityRegister.GyudonFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Gyudon));});
    public static final DeferredItem<Item> cheese_gyudon =ITEMS.register("cheese_gyudon", () -> {return new Item((new Item.Properties()).food(FoodUrushi.OtherGyudon));});
    public static final DeferredItem<Item> cheese_gyudon_with_onsen_egg =ITEMS.register("cheese_gyudon_with_onsen_egg", () -> {return new Item((new Item.Properties()).food(FoodUrushi.OtherGyudon));});
    public static final DeferredItem<Item> green_onion_and_raw_egg_gyudon =ITEMS.register("green_onion_and_raw_egg_gyudon", () -> {return new Item((new Item.Properties()).food(FoodUrushi.OtherGyudon));});
    public static final DeferredItem<Item> mustard_leaf_and_cod_caviar_gyudon =ITEMS.register("mustard_leaf_and_cod_caviar_gyudon", () -> {return new Item((new Item.Properties()).food(FoodUrushi.OtherGyudon));});
    public static final DeferredItem<Item> rice_ball =ITEMS.register("rice_ball", () -> {return new Item((new Item.Properties()).food(FoodUrushi.RiceBall));});
    public static final DeferredItem<Item> rice_cake =ITEMS.register("rice_cake", () -> {return new PlaceableFoodItem(()->EntityRegister.RiceCakeFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.RiceCake));});
    public static final DeferredItem<Item> roasted_rice_cake =ITEMS.register("roasted_rice_cake", () -> {return new PlaceableFoodItem(()->EntityRegister.RoastedRiceCakeFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.RoastedRiceCake));});
    public static final DeferredItem<Item> kusa_dango =ITEMS.register("kusa_dango", () -> {return new PlaceableFoodItem(()->EntityRegister.KusaDangoFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Dango));});
    public static final DeferredItem<Item> color_dango =ITEMS.register("color_dango", () -> {return new PlaceableFoodItem(()->EntityRegister.ColorDangoFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Dango));});
    public static final DeferredItem<Item> mitarashi_dango =ITEMS.register("mitarashi_dango", () -> {return new PlaceableFoodItem(()->EntityRegister.MitarashiDangoFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Dango));});
    public static final DeferredItem<Item> sakura_mochi =ITEMS.register("sakura_mochi", () -> {return new Item((new Item.Properties()).food(FoodUrushi.SakuraMochi));});
    public static final DeferredItem<Item> kusa_mochi =ITEMS.register("kusa_mochi", () -> {return new Item((new Item.Properties()).food(FoodUrushi.KusaMochi));});
    public static final DeferredItem<Item> ohagi =ITEMS.register("ohagi", () -> {return new Item((new Item.Properties()).food(FoodUrushi.Ohagi));});
    public static final DeferredItem<Item> yokan =ITEMS.register("yokan", () -> {return new Item((new Item.Properties()).food(FoodUrushi.Yokan));});
    public static final DeferredItem<Item> sakura_yokan =ITEMS.register("sakura_yokan", () -> {return new Item((new Item.Properties()).food(FoodUrushi.SakuraYokan));});
    public static final DeferredItem<Item> baked_mochocho =ITEMS.register("baked_mochocho", () -> {return new BakedMochochoItem((new Item.Properties()).food(FoodUrushi.Yokan));});
    public static final DeferredItem<Item> karaage =ITEMS.register("karaage", () -> {return new PlaceableFoodItem(()->EntityRegister.KaraageFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Karaage));});
    public static final DeferredItem<Item> yakitori =ITEMS.register("yakitori", () -> {return new Item((new Item.Properties()).food(FoodUrushi.Karaage));});
    public static final DeferredItem<Item> tofu =ITEMS.register("tofu", () -> {return new PlaceableFoodItem(()->EntityRegister.TofuFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Tofu));});
    public static final DeferredItem<Item> shikomi_miso =IF("shikomi_miso");
    public static final DeferredItem<Item> miso =ITEMS.register("miso", () -> {return new ToolchipItem("miso",(new Item.Properties()));});
    public static final DeferredItem<Item> miso_soup =ITEMS.register("miso_soup", () -> {return new Item((new Item.Properties()).food(FoodUrushi.Hiyayakko));});
    public static final DeferredItem<Item> hiyayakko =ITEMS.register("hiyayakko", () -> {return new Item((new Item.Properties()).food(FoodUrushi.MisoSoup));});
    public static final DeferredItem<Item> aburaage =ITEMS.register("abura_age", () -> {return new PlaceableFoodItem(()->EntityRegister.AburaageFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Aburaage));});
    //public static final DeferredItem<Item> tonkatsu =ITEMS.register("tonkatsu", () -> {return new Item((new Item.Properties()).food(FoodUrushi.Tonkatsu).tab(ModCoreUrushi.UrushiFoodTab));});
    public static final DeferredItem<Item> roasted_shiitake =ITEMS.register("roasted_shiitake", () -> {return new Item((new Item.Properties()).food(FoodUrushi.Shiitake));});
    public static final DeferredItem<Item> so =ITEMS.register("so", () -> {return new Item((new Item.Properties()).food(FoodUrushi.So));});
    public static final DeferredItem<Item> onsen_egg =ITEMS.register("onsen_egg", () -> {return new ToolchipItem("onsen_egg",(new Item.Properties()));});
    public static final DeferredItem<Item> noodle_knife =ITEMS.register("noodle_knife", () -> {return new NoodleKnifeItem((new Item.Properties()).durability(1024));});
    public static final DeferredBlock<Block> dough =BF("dough","n",-1,() -> {return new TwoDirectionShapedBlock(3.0D, 0.0D, 0D, 13.0D, 2.0D, 16.0D,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).instabreak().sound(SoundType.WOOD));});
    public static final DeferredBlock<Block> udon =BF("udon","n",-1,() -> {return new TwoDirectionShapedBlock(2.0D, 0.0D, 0D, 14.0D, 2.0D, 16.0D,BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).instabreak().sound(SoundType.WOOD));});
    public static final DeferredItem<Item> kitsune_udon =ITEMS.register("kitsune_udon", () -> {return new PlaceableFoodItem(()->EntityRegister.KitsuneUdonFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.KitsuneUdon));});
    public static final DeferredBlock<Block> salt_and_sand =BF("salt_and_sand","s",-1,() -> {return new SaltAndSandBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(1F, 10F).sound(SoundType.SAND));});
    public static final DeferredItem<Item> salt =ITEMS.register("salt", () -> {return new ToolchipItem("salt",(new Item.Properties()));});
    public static final DeferredItem<Item> kanten_powder =IF("kanten_powder");
    public static final DeferredItem<Item> kansui_powder =IF("kansui_powder");
    public static final DeferredBlock<Block> alkaline_dough =BF("alkaline_dough","n",-1,() -> {return new TwoDirectionShapedBlock(3.0D, 0.0D, 0D, 13.0D, 2.0D, 16.0D,BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).instabreak().sound(SoundType.WOOD));});
    public static final DeferredBlock<Block> alkaline_noodles =BF("alkaline_noodles","n",-1,() -> {return new TwoDirectionShapedBlock(2.0D, 0.0D, 0D, 14.0D, 2.0D, 16.0D,BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).instabreak().sound(SoundType.WOOD));});
    public static final DeferredItem<Item> soy_source_ramen =ITEMS.register("soy_source_ramen", () -> {return new Item((new Item.Properties()).food(FoodUrushi.Ramen));});
    public static final DeferredItem<Item> miso_ramen =ITEMS.register("miso_ramen", () -> {return new Item((new Item.Properties()).food(FoodUrushi.Ramen));});
    public static final DeferredItem<Item> tonkotsu_ramen =ITEMS.register("tonkotsu_ramen", () -> {return new Item((new Item.Properties()).food(FoodUrushi.Ramen));});
    public static final DeferredItem<Item> salt_ramen =ITEMS.register("salt_ramen", () -> {return new Item((new Item.Properties()).food(FoodUrushi.Ramen));});
    public static final DeferredItem<Item> syari =ITEMS.register("syari", () -> {return new Item((new Item.Properties()).food(FoodUrushi.RawFish));});
    public static final DeferredItem<Item> tsuna =ITEMS.register("tsuna", () -> {return new Item((new Item.Properties()).food(FoodUrushi.RawFish));});
    public static final DeferredItem<Item> sweetfish =ITEMS.register("sweetfish", () -> {return new Item((new Item.Properties()).food(FoodUrushi.RawFish));});
    public static final DeferredItem<Item> sweetfish_with_salt =ITEMS.register("sweetfish_with_salt", () -> {return new Item((new Item.Properties()).food(FoodUrushi.RawFishWithSalt));});
    public static final DeferredItem<Item> cooked_sweetfish =ITEMS.register("cooked_sweetfish", () -> {return new Item((new Item.Properties()).food(FoodUrushi.CookedFish));});
    public static final DeferredItem<Item> cooked_sweetfish_with_salt =ITEMS.register("cooked_sweetfish_with_salt", () -> {return new Item((new Item.Properties()).food(FoodUrushi.CookedFishWithSalt));});
    public static final DeferredItem<Item> tsuna_sashimi =ITEMS.register("tsuna_sashimi", () -> {return new Item((new Item.Properties()).food(FoodUrushi.RawFish));});
    public static final DeferredItem<Item> tsuna_sushi =ITEMS.register("tsuna_sushi", () -> {return new PlaceableFoodItem(()->EntityRegister.TsunaSushiFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Sushi));});
    public static final DeferredItem<Item> salmon_sashimi =ITEMS.register("salmon_sashimi", () -> {return new Item((new Item.Properties()).food(FoodUrushi.RawFish));});
    public static final DeferredItem<Item> salmon_sushi =ITEMS.register("salmon_sushi", () -> {return new PlaceableFoodItem(()->EntityRegister.SalmonSushiFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Sushi));});
    public static final DeferredItem<Item> squid_sashimi =ITEMS.register("squid_sashimi", () -> {return new Item((new Item.Properties()).food(FoodUrushi.RawFish));});
    public static final DeferredItem<Item> squid_sushi =ITEMS.register("squid_sushi", () -> {return new PlaceableFoodItem(()->EntityRegister.SquidSushiFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Sushi));});
    public static final DeferredItem<Item> egg_sushi =ITEMS.register("egg_sushi", () -> {return new PlaceableFoodItem(()->EntityRegister.EggSushiFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Sushi));});
    public static final DeferredItem<Item> salmon_roe =ITEMS.register("salmon_roe", () -> {return new Item((new Item.Properties()));});
    public static final DeferredItem<Item> salmon_roe_sushi =ITEMS.register("salmon_roe_sushi", () -> {return new PlaceableFoodItem(()->EntityRegister.SalmonRoeSushiFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Sushi));});
    public static final DeferredItem<Item> gravel_sushi =ITEMS.register("gravel_sushi", () -> {return new PlaceableFoodItem(()->EntityRegister.GravelSushiFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Sushi));});
    public static final DeferredItem<Item> inari =ITEMS.register("inari", () -> {return new PlaceableFoodItem(()->EntityRegister.InariFoodEntity.get(),(new Item.Properties()).food(FoodUrushi.Sushi));});
    public static final DeferredBlock<Block> sushi_conveyor =BF("sushi_conveyor","a",-1,() -> {return new SushiConveyorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.BAMBOO).strength(1.0F, 10.0F));});
    public static final DeferredItem<Item> minced_tuna_bowl =ITEMS.register("minced_tuna_bowl", () -> {return new Item((new Item.Properties()).food(FoodUrushi.TKG));});
    public static final DeferredItem<Item> wood_chip =I("wood_chip");
    public static final DeferredItem<Item> gold_leaf =I("gold_leaf");
    public static final DeferredBlock<Block> gold_leaf_block =B("gold_leaf_block","a",-1,() -> {return new FlammableBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).sound(SoundType.WOOD).strength(1F, 10.0F));});
    public static final DeferredBlock<Block> gold_leaf_slab =B("gold_leaf_slab","a",-1,() -> {return new FlammableSlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).sound(SoundType.WOOD).strength(1F, 10.0F));});
    public static final DeferredBlock<Block> gold_leaf_stairs =B("gold_leaf_stairs","a",-1,() -> {return new FlammableStairBlock(gold_leaf_block.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).sound(SoundType.WOOD).strength(1F, 10.0F));});
    public static final DeferredBlock<Block> ironsand_ore =B("ironsand_ore","s",1,() -> {return new UFallingBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).strength(1F, 10.0F).sound(SoundType.SAND));});
    public static final DeferredItem<Item> ironsand =I("ironsand");
    public static final DeferredItem<Item> hammer =ITEMS.register("hammer", () -> {return new HammerItem((new Item.Properties()).durability(1024));});
    public static final DeferredBlock<Block> hot_ironsand =BWater("hot_ironsand","p",1,()->Items.RAW_IRON,() -> {return new HotIronsandBlock(BlockBehaviour.Properties.of().mapColor( MapColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final DeferredBlock<Block> hot_iron_plate =BWater("hot_iron_plate","p",1,()->ItemAndBlockRegister.quenched_iron_plate.get(), ()-> {return new IronPlateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final DeferredBlock<Block> quenched_iron_plate =B("quenched_iron_plate","p",1,() -> {return new IronPlateBlock(BlockBehaviour.Properties.of().mapColor( MapColor.METAL).instabreak().sound(SoundType.ANVIL));});
    public static final DeferredBlock<Block> crushed_iron =B("crushed_iron","p",1,() -> {return new CrushedIronBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instabreak().sound(SoundType.ANVIL));});
    public static final DeferredBlock<Block> stacked_iron =B("stacked_iron","p",1,() -> {return new StackedIronBlock(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).instabreak().sound(SoundType.ANVIL));});
    public static final DeferredBlock<Block> hot_iron_ingot_1 =B("hot_iron_ingot_1","p",1,() -> {return new HotIronIngotBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final DeferredBlock<Block> hot_iron_ingot_2 =B("hot_iron_ingot_2","p",1,() -> {return new HotIronIngotBlock(BlockBehaviour.Properties.of().mapColor( MapColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final DeferredBlock<Block> hot_iron_ingot_3 =B("hot_iron_ingot_3","p",1,() -> {return new HotIronIngotBlock(BlockBehaviour.Properties.of().mapColor( MapColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final DeferredBlock<Block> hot_iron_ingot_4 =B("hot_iron_ingot_4","p",1,() -> {return new HotIronIngotBlock(BlockBehaviour.Properties.of().mapColor( MapColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final DeferredBlock<Block> hot_iron_ingot_5 =B("hot_iron_ingot_5","p",1,() -> {return new HotIronIngotBlock(BlockBehaviour.Properties.of().mapColor( MapColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final DeferredBlock<Block> hot_iron_blade_1 =B("hot_iron_blade_1","p",1,() -> {return new BladeBlock(BlockBehaviour.Properties.of().mapColor( MapColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final DeferredBlock<Block> hot_iron_blade_2 =BWater("hot_iron_blade_2","p",1,()->ItemAndBlockRegister.quenched_iron_blade.get(),() -> {return new BladeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).instabreak().sound(SoundType.ANVIL));});
    public static final DeferredBlock<Block> quenched_iron_blade =B("quenched_iron_blade","p",1,() -> {return new BladeBlock(BlockBehaviour.Properties.of().mapColor( MapColor.METAL).instabreak().sound(SoundType.ANVIL));});
    public static final DeferredItem<Item> iron_katana =ITEMS.register("iron_katana", () -> {return new NormalKatanaItem(Tiers.IRON,4,-2.9F,(new Item.Properties()));});
    public static final DeferredBlock<Block> rope =B("rope","a",-1,() -> {return new RopeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.LADDER).strength(0.1F, 10.0F));});
    public static final DeferredItem<Item> climbing_rope =ITEMS.register("climbing_rope", () -> {return new ClimbingRopesItem((new Item.Properties()));});
    public static final DeferredItem<Item> open_wagasa =ITEMS.register("open_wagasa", () -> {return new WagasaItem(true,(new Item.Properties()).stacksTo(1));});
    public static final DeferredItem<Item> close_wagasa =ITEMS.register("close_wagasa", () -> {return new WagasaItem(false,(new Item.Properties()).stacksTo(1));});
    public static final DeferredBlock<LiquidBlock> HotSpringBlock =BLOCKS.register("hot_spring_water",() -> {return new HotSpringWaterBlock(()-> FluidRegister.HotSpringStill.get(),BlockBehaviour.Properties.of().mapColor(MapColor.WATER).liquid().pushReaction(PushReaction.DESTROY).replaceable().noLootTable().strength(1000F).noCollission());});
    public static final DeferredItem<Item> hot_spring_bucket =ITEMS.register("hot_spring_water_bucket", () -> {return new BucketItem(FluidRegister.HotSpringStill.get(),(new Item.Properties()).stacksTo(1));});
    public static final DeferredBlock<Block> sandpaper_block =B("sandpaper_block","h",-1,() -> {return new SandpaperBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.SOUL_SAND).strength(0.3F, 10.0F));});
    public static final DeferredBlock<Block> invisible_button =BLOCKS.register("invisible_button",() -> {return new InvisibleButtonBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.SOUL_SAND).strength(0.3F, 10.0F).noCollission().pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> hidden_invisible_button =BLOCKS.register("hidden_invisible_button",() -> {return new HiddenInvisibleButtonBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.SOUL_SAND).strength(0.3F, 10.0F).pushReaction(PushReaction.DESTROY));});
    public static final DeferredItem<Item> invisible_button_item =ITEMS.register("invisible_button", () -> {return new InvisibleButtonItem(invisible_button.get(),(new Item.Properties()));});
    public static final DeferredBlock<Block> invisible_lever =BLOCKS.register("invisible_lever",() -> {return new InvisibleLeverBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.SOUL_SAND).instabreak().noCollission().pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> hidden_invisible_lever =BLOCKS.register("hidden_invisible_lever",() -> {return new HiddenInvisibleLeverBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.SOUL_SAND).strength(0.3F, 10.0F).pushReaction(PushReaction.DESTROY));});
    public static final DeferredItem<Item> invisible_lever_item =ITEMS.register("invisible_lever", () -> {return new InvisibleLeverItem(invisible_lever.get(),(new Item.Properties()));});
    public static final DeferredBlock<Block> invisible_pressure_plate =BLOCKS.register("invisible_pressure_plate",() -> {return new InvisiblePressurePlateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.SOUL_SAND).pushReaction(PushReaction.DESTROY).strength(0.3F, 10.0F).noCollission());});
    public static final DeferredBlock<Block> hidden_invisible_pressure_plate =BLOCKS.register("hidden_invisible_pressure_plate",() -> {return new HiddenInvisiblePressurePlateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.SOUL_SAND).pushReaction(PushReaction.DESTROY).strength(0.3F, 10.0F));});
    public static final DeferredItem<Item> invisible_pressure_plate_item =ITEMS.register("invisible_pressure_plate", () -> {return new InvisiblePressurePlateItem(invisible_pressure_plate.get(),(new Item.Properties()));});
    public static final DeferredItem<Item> shide =ITEMS.register("shide", () -> {return new Item((new Item.Properties()));});
    public static final DeferredItem<Item> wood_element_paper =ITEMS.register("wood_element_paper", () -> {return new ToolchipItem("wood_element_paper",(new Item.Properties()));});
    public static final DeferredItem<Item> fire_element_paper =ITEMS.register("fire_element_paper", () -> {return new ToolchipItem("fire_element_paper",(new Item.Properties()));});
    public static final DeferredItem<Item> earth_element_paper =ITEMS.register("earth_element_paper", () -> {return new ToolchipItem("earth_element_paper",(new Item.Properties()));});
    public static final DeferredItem<Item> metal_element_paper =ITEMS.register("metal_element_paper", () -> {return new ToolchipItem("metal_element_paper",(new Item.Properties()));});
    public static final DeferredItem<Item> water_element_paper =ITEMS.register("water_element_paper", () -> {return new ToolchipItem("water_element_paper",(new Item.Properties()));});
    public static final DeferredBlock<Block> rock =BM("rock","p",0,() -> {return new RockBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1F, 10.0F).sound(SoundType.STONE).randomTicks().requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> sazare_ishi =BM("sazare_ishi","p",0,() -> {return new RockBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1F, 10.0F).sound(SoundType.STONE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> kakuriyo_dirt =B("kakuriyo_dirt","s",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor( MapColor.TERRACOTTA_RED).strength(0.4F, 10.0F).sound(SoundType.ROOTED_DIRT));});
    public static final DeferredBlock<Block> kakuriyo_grass_block =B("kakuriyo_grass_block","s",-1,() -> {return new KakuriyoGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).strength(0.6F, 10.0F).sound(SoundType.GRASS).randomTicks());});
    public static final DeferredBlock<Block> yomi_stone =B("yomi_stone","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(1F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> cobbled_yomi_stone =B("cobbled_yomi_stone","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(1F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> polished_yomi_stone =B("polished_yomi_stone","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(1F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> large_yomi_stone_bricks =B("large_yomi_stone_bricks","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(1F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> small_yomi_stone_bricks =B("small_yomi_stone_bricks","p",0,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(1F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> yomi_stone_slab =B("yomi_stone_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final DeferredBlock<Block> cobbled_yomi_stone_slab =B("cobbled_yomi_stone_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final DeferredBlock<Block> polished_yomi_stone_slab =B("polished_yomi_stone_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final DeferredBlock<Block> large_yomi_stone_brick_slab =B("large_yomi_stone_brick_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final DeferredBlock<Block> small_yomi_stone_brick_slab =B("small_yomi_stone_brick_slab","p",0,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final DeferredBlock<Block> yomi_stone_stairs =B("yomi_stone_stairs","p",0,() -> {return new StairBlock(yomi_stone.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final DeferredBlock<Block> cobbled_yomi_stone_stairs =B("cobbled_yomi_stone_stairs","p",0,() -> {return new StairBlock(cobbled_yomi_stone.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final DeferredBlock<Block> polished_yomi_stone_stairs =B("polished_yomi_stone_stairs","p",0,() -> {return new StairBlock(polished_yomi_stone.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final DeferredBlock<Block> large_yomi_stone_brick_stairs =B("large_yomi_stone_brick_stairs","p",0,() -> {return new StairBlock(large_yomi_stone_bricks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final DeferredBlock<Block> small_yomi_stone_brick_stairs =B("small_yomi_stone_brick_stairs","p",0,() -> {return new StairBlock(small_yomi_stone_bricks.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final DeferredBlock<Block> cobbled_yomi_stone_wall =B("cobbled_yomi_stone_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final DeferredBlock<Block> polished_yomi_stone_wall =B("polished_yomi_stone_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final DeferredBlock<Block> large_yomi_stone_brick_wall =B("large_yomi_stone_brick_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final DeferredBlock<Block> small_yomi_stone_brick_wall =B("small_yomi_stone_brick_wall","p",0,() -> {return new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops().strength(1.0F, 30.0F));});
    public static final DeferredBlock<Block> yomi_stone_trapdoor =B("yomi_stone_trapdoor","p",-1,() -> {return new TrapDoorBlock(BlockSetType.STONE,BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1.0F, 10.0F).noOcclusion().requiresCorrectToolForDrops().isValidSpawn(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> jadeite_ore =B("jadeite_ore","p",2,() -> {return new DropExperienceBlock(ConstantInt.of(1),BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(3F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> chalcopyrite_ore =B("chalcopyrite_ore","p",1,() -> {return new DropExperienceBlock(ConstantInt.of(1),BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(3F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> limonite_ore =B("limonite_ore","p",1,() -> {return new DropExperienceBlock(ConstantInt.of(1),BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(3F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> yomi_gold_ore =B("yomi_gold_ore","p",2,() -> {return new DropExperienceBlock(ConstantInt.of(1),BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(3F, 30.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> quartz_cluster =B("quartz_cluster","p",-1,() -> {return new QuartzClusterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).strength(0.5F, 5.0F).sound(SoundType.AMETHYST_CLUSTER).noCollission().lightLevel((p_235470_0_) -> {return 5;}));});
    public static final DeferredItem<Item> jadeite =I("jadeite");
    public static final DeferredBlock<Block> shiitake =BN("shiitake","a",-1,() -> {return new ShiitakeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).randomTicks().instabreak().noCollission().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> wall_shiitake =BN("wall_shiitake","a",-1,() -> {return new WallShiitakeBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).randomTicks().instabreak().noCollission().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY));});
    public static final DeferredItem<StandingAndWallBlockItem> shiitake_item =ITEMS.register("shiitake",() -> {return new StandingAndWallBlockItem(shiitake.get(), wall_shiitake.get(), (new Item.Properties()),Direction.DOWN);});
    public static final DeferredItem<Item> shiitake_goggles =ITEMS.register("shiitake_goggles", () -> {return new WearableItem("shiitake_goggles",(new Item.Properties()).stacksTo(1));});
    public static final DeferredBlock<Block> eulalia =B("eulalia","h",-1,() -> {return new EulaliaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).replaceable().instabreak().noCollission().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> double_eulalia =BN("double_eulalia","h",-1,() -> {return new DoubleEulaliaBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).replaceable().instabreak().noCollission().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> lycoris =B("lycoris","h",-1,() -> {return new SmallFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instabreak().noCollission().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> ajisai =B("ajisai","h",-1,() -> {return new TallFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.GRASS).instabreak().noCollission().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> yomi_vines =BN("yomi_vines","n",-1,() -> {return new YomiVinesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().sound(SoundType.CAVE_VINES).noCollission().lightLevel(YomiVinesBlock.LIGHT_EMISSION).pushReaction(PushReaction.DESTROY));});
    public static final DeferredBlock<Block> yomi_vines_plant =BN("yomi_vines_plant","n",-1,() -> {return new YomiVinesPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().sound(SoundType.CAVE_VINES).noCollission().lightLevel(YomiVinesPlantBlock.LIGHT_EMISSION).pushReaction(PushReaction.DESTROY));});
    public static final DeferredItem<Item> yomotsuhegui_fruit =ITEMS.register("yomotsuhegui_fruit", () -> {return new ItemNameBlockItem(yomi_vines.get(),(new Item.Properties()).food(FoodUrushi.YomitsuheguiFruit));});
    public static final DeferredBlock<Block> lantern_plant =BN("lantern_plant","a",-1,() -> {return new LanternPlantBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).instabreak().sound(SoundType.CAVE_VINES).randomTicks().noCollission().lightLevel(LanternPlantBlock.LIGHT_EMISSION).pushReaction(PushReaction.DESTROY));});
    public static final DeferredItem<Item> lantern_plant_fruit =ITEMS.register("lantern_plant_fruit", () -> {return new ItemNameBlockItem(lantern_plant.get(),(new Item.Properties()).food(FoodUrushi.LanternPlant));});
    public static final DeferredBlock<Block> lantern_plant_torch =BN("lantern_plant_torch","a",-1,() -> {return new LanternPlantTorchBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).instabreak().noCollission().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel((p_235470_0_) -> {return 15;}));});
    public static final DeferredBlock<Block> wall_lantern_plant_torch =BN("wall_lantern_plant_torch","a",-1,() -> {return new WallLanternPlantTorchBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).sound(SoundType.WOOD).instabreak().noCollission().noOcclusion().pushReaction(PushReaction.DESTROY).lightLevel((p_235470_0_) -> {return 15;}));});
    public static final DeferredItem<StandingAndWallBlockItem> lantern_plant_torch_item =ITEMS.register("lantern_plant_torch",() -> {return new StandingAndWallBlockItem(lantern_plant_torch.get(), wall_lantern_plant_torch.get(), (new Item.Properties()),Direction.DOWN);});
    public static final DeferredBlock<Block> lantern_plant_block =B("lantern_plant_block","h",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).pushReaction(PushReaction.DESTROY).strength(0.2F, 1.0F).sound(SoundType.GRASS).lightLevel((p_235470_0_) -> {return 15;}).noOcclusion());});
    public static final DeferredBlock<Block> kakuriyo_portal =BN("kakuriyo_portal","n",-1,() -> {return new KakuriyoPortalBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(-1F, 30.0F).sound(SoundType.GLASS).noCollission().lightLevel((p_235470_0_) -> {return 15;}));});
    public static final DeferredBlock<Block> kakuriyo_portal_core =B("kakuriyo_portal_core","a",-1,() -> {return new KakuriyoPortalCoreBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(2.0F, 10.0F).noLootTable());});
    public static final DeferredBlock<Block> ghost_kakuriyo_portal_core =B("ghost_kakuriyo_portal_core","a",-1,() -> {return new GhostKakuriyoPortalCoreBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(2.0F, 10.0F).noLootTable().noOcclusion().isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> red_kakuriyo_portal_frame =B("red_kakuriyo_portal_frame","a",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(2.0F, 10.0F).noLootTable());});
    public static final DeferredBlock<Block> ghost_red_kakuriyo_portal_frame =B("ghost_red_kakuriyo_portal_frame","a",-1,() -> {return new GhostRotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).sound(SoundType.WOOD).strength(2.0F, 10.0F).noLootTable().noOcclusion().isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> black_kakuriyo_portal_frame =B("black_kakuriyo_portal_frame","a",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(2.0F, 10.0F).noLootTable());});
    public static final DeferredBlock<Block> ghost_black_kakuriyo_portal_frame =B("ghost_black_kakuriyo_portal_frame","a",-1,() -> {return new GhostBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).sound(SoundType.WOOD).strength(2.0F, 10.0F).noLootTable().noOcclusion().isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never));});
    public static final DeferredItem<Item> ghost_core =I("ghost_core");
    public static final DeferredBlock<Block> ghost_dirt =B("ghost_dirt","s",-1,() -> {return new GhostBlock(BlockBehaviour.Properties.of().mapColor( MapColor.DIRT).sound(SoundType.GRAVEL).strength(0.5F).noOcclusion().isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never));});
    public static final DeferredBlock<Block> ghost_stone =B("ghost_stone","p",-1,() -> {return new GhostBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1F).noOcclusion().isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> ghost_plaster =B("ghost_plaster","p",-1,() -> {return new GhostBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOL).sound(SoundType.STONE).strength(1F).noOcclusion().isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> ghost_sand_coast =B("ghost_sand_coast","s",-1,() -> {return new GhostBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.SAND).strength(1F).noOcclusion().isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> ghost_wattle_and_daub =B("ghost_wattle_and_daub","s",-1,() -> {return new GhostBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).sound(SoundType.GRAVEL).strength(1F).noOcclusion().isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> ghost_concrete =B("ghost_concrete","p",-1,() -> {return new GhostBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1F).noOcclusion().isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never).requiresCorrectToolForDrops());});
    public static final DeferredItem<Item> wood_element_magatama =ITEMS.register("wood_element_magatama", () -> {return new WoodMagatamaItem((new Item.Properties()).stacksTo(1));});
    public static final DeferredItem<Item> fire_element_magatama =ITEMS.register("fire_element_magatama", () -> {return new FireMagatamaItem((new Item.Properties()).stacksTo(1));});
    public static final DeferredItem<Item> earth_element_magatama =ITEMS.register("earth_element_magatama", () -> {return new EarthMagatamaItem((new Item.Properties()).stacksTo(1));});
    public static final DeferredItem<Item> metal_element_magatama =ITEMS.register("metal_element_magatama", () -> {return new MetalMagatamaItem((new Item.Properties()).stacksTo(1));});
    public static final DeferredItem<Item> water_element_magatama =ITEMS.register("water_element_magatama", () -> {return new WaterMagatamaItem((new Item.Properties()).stacksTo(1));});
    public static final DeferredBlock<Block> jadeite_block =B("jadeite_block","p",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).strength(1F, 10.0F).sound(SoundType.STONE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> jadeite_slab =B("jadeite_slab","p",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jadeite_stairs =B("jadeite_stairs","p",-1,() -> {return new StairBlock(jadeite_block.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jadeite_brick =B("jadeite_brick","p",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).strength(1F, 10.0F).sound(SoundType.STONE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> jadeite_brick_slab =B("jadeite_brick_slab","p",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jadeite_brick_stairs =B("jadeite_brick_stairs","p",-1,() -> {return new StairBlock(jadeite_brick.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_jadeite_block =B("smooth_jadeite_block","p",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).strength(1F, 10.0F).sound(SoundType.STONE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> smooth_jadeite_slab =B("smooth_jadeite_slab","p",-1,() -> {return new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> smooth_jadeite_stairs =B("smooth_jadeite_stairs","p",-1,() -> {return new StairBlock(smooth_jadeite_block.get().defaultBlockState(),BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).requiresCorrectToolForDrops().strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> jadeite_pillar =B("jadeite_pillar","p",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    //public static final DeferredItem<Item> magonote =ITEMS.register("magonote", () -> {return new MagonoteItem((new Item.Properties()).tab(ModCoreUrushi.UrushiTab).stacksTo(1).durability(4096));});
    public static final DeferredItem<Item> wood_amber =ITEMS.register("wood_amber", () -> {return new ToolchipItem("wood_amber",(new Item.Properties()));});
    public static final DeferredItem<Item> fire_amber =ITEMS.register("fire_amber", () -> {return new ToolchipItem("fire_amber",(new Item.Properties()));});
    public static final DeferredItem<Item> earth_amber =ITEMS.register("earth_amber", () -> {return new ToolchipItem("earth_amber",(new Item.Properties()));});
    public static final DeferredItem<Item> metal_amber =ITEMS.register("metal_amber", () -> {return new ToolchipItem("metal_amber",(new Item.Properties()));});
    public static final DeferredItem<Item> water_amber =ITEMS.register("water_amber", () -> {return new ToolchipItem("water_amber",(new Item.Properties()));});
    public static final DeferredBlock<Block> petrified_log =BW("petrified_log","p",-1,() -> {return new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> petrified_log_with_wood_amber =BM("petrified_log_with_wood_amber","p",-1,() -> {return new PetrifiedLogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> petrified_log_with_fire_amber =BM("petrified_log_with_fire_amber","p",-1,() -> {return new PetrifiedLogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> petrified_log_with_earth_amber =BM("petrified_log_with_earth_amber","p",-1,() -> {return new PetrifiedLogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> petrified_log_with_metal_amber =BM("petrified_log_with_metal_amber","p",-1,() -> {return new PetrifiedLogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> petrified_log_with_water_amber =BM("petrified_log_with_water_amber","p",-1,() -> {return new PetrifiedLogBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> petrified_planks =BW("petrified_planks","p",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> sanbo_tier1 =BM("sanbo_tier1","a",-1,() -> {return new SanboBlock(BlockBehaviour.Properties.of().mapColor(MapColor.SAND).sound(SoundType.WOOD).strength(1.0F, 10.0F).dynamicShape());});
    public static final DeferredBlock<Block> wood_element_sacred_rock =BM("wood_element_sacred_rock","p",-1,() -> {return new SacredRockBlock(ElementType.WoodElement,BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> fire_element_sacred_rock =BM("fire_element_sacred_rock","p",-1,() -> {return new SacredRockBlock(ElementType.FireElement,BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> earth_element_sacred_rock =BM("earth_element_sacred_rock","p",-1,() -> {return new SacredRockBlock(ElementType.EarthElement,BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> metal_element_sacred_rock =BM("metal_element_sacred_rock","p",-1,() -> {return new SacredRockBlock(ElementType.MetalElement,BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> water_element_sacred_rock =BM("water_element_sacred_rock","p",-1,() -> {return new SacredRockBlock(ElementType.WaterElement,BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> wood_element_emitter_tier1 =BM("wood_element_emitter_tier1","p",-1,() -> {return new EmitterBlock(1,ElementType.WoodElement,BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> fire_element_emitter_tier1 =BM("fire_element_emitter_tier1","p",-1,() -> {return new EmitterBlock(1,ElementType.FireElement,BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> earth_element_emitter_tier1 =BM("earth_element_emitter_tier1","p",-1,() -> {return new EmitterBlock(1,ElementType.EarthElement,BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> metal_element_emitter_tier1 =BM("metal_element_emitter_tier1","p",-1,() -> {return new EmitterBlock(1,ElementType.MetalElement,BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> water_element_emitter_tier1 =BM("water_element_emitter_tier1","p",-1,() -> {return new EmitterBlock(1,ElementType.WaterElement,BlockBehaviour.Properties.of().mapColor(MapColor.STONE).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> wood_element_emitter_tier2 =BM("wood_element_emitter_tier2","p",-1,() -> {return new EmitterBlock(2,ElementType.WoodElement,BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> fire_element_emitter_tier2 =BM("fire_element_emitter_tier2","p",-1,() -> {return new EmitterBlock(2,ElementType.FireElement,BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> earth_element_emitter_tier2 =BM("earth_element_emitter_tier2","p",-1,() -> {return new EmitterBlock(2,ElementType.EarthElement,BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> metal_element_emitter_tier2 =BM("metal_element_emitter_tier2","p",-1,() -> {return new EmitterBlock(2,ElementType.MetalElement,BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> water_element_emitter_tier2 =BM("water_element_emitter_tier2","p",-1,() -> {return new EmitterBlock(2,ElementType.WaterElement,BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> wood_element_tank_tier1 =BM("wood_element_tank_tier1","a",-1,() -> {return new TankBlock(1,ElementType.WoodElement,BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> fire_element_tank_tier1 =BM("fire_element_tank_tier1","a",-1,() -> {return new TankBlock(1,ElementType.FireElement,BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> earth_element_tank_tier1 =BM("earth_element_tank_tier1","a",-1,() -> {return new TankBlock(1,ElementType.EarthElement,BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> metal_element_tank_tier1 =BM("metal_element_tank_tier1","a",-1,() -> {return new TankBlock(1,ElementType.MetalElement,BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> water_element_tank_tier1 =BM("water_element_tank_tier1","a",-1,() -> {return new TankBlock(1,ElementType.WaterElement,BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> mirror_tier1 =BM("mirror_tier1","a",-1,() -> {return new MirrorBlock(1,BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.GLASS).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> mirror_tier2 =BM("mirror_tier2","a",-1,() -> {return new MirrorBlock(2,BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.GLASS).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> wood_element_crafting_table_tier1 =BM("wood_element_crafting_table_tier1","a",-1,() -> {return new ElementCraftingTableBlock(1,ElementType.WoodElement,()-> RecipeTypeRegister.WoodElementTier1CraftingRecipe,BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> fire_element_crafting_table_tier1 =BM("fire_element_crafting_table_tier1","a",-1,() -> {return new ElementCraftingTableBlock(1,ElementType.FireElement,()-> RecipeTypeRegister.FireElementTier1CraftingRecipe,BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> earth_element_crafting_table_tier1 =BM("earth_element_crafting_table_tier1","a",-1,() -> {return new ElementCraftingTableBlock(1,ElementType.EarthElement,()-> RecipeTypeRegister.EarthElementTier1CraftingRecipe,BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> metal_element_crafting_table_tier1 =BM("metal_element_crafting_table_tier1","a",-1,() -> {return new ElementCraftingTableBlock(1,ElementType.MetalElement,()-> RecipeTypeRegister.MetalElementTier1CraftingRecipe,BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> water_element_crafting_table_tier1 =BM("water_element_crafting_table_tier1","a",-1,() -> {return new ElementCraftingTableBlock(1,ElementType.WaterElement,()->  RecipeTypeRegister.WaterElementTier1CraftingRecipe,BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).sound(SoundType.WOOD).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> wood_element_crafting_table_tier2 =BM("wood_element_crafting_table_tier2","p",-1,() -> {return new ElementCraftingTableBlock(2,ElementType.WoodElement,()-> RecipeTypeRegister.WoodElementTier2CraftingRecipe,BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> fire_element_crafting_table_tier2 =BM("fire_element_crafting_table_tier2","p",-1,() -> {return new ElementCraftingTableBlock(2,ElementType.FireElement,()-> RecipeTypeRegister.FireElementTier2CraftingRecipe,BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> earth_element_crafting_table_tier2 =BM("earth_element_crafting_table_tier2","p",-1,() -> {return new ElementCraftingTableBlock(2,ElementType.EarthElement,()-> RecipeTypeRegister.EarthElementTier2CraftingRecipe,BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> metal_element_crafting_table_tier2 =BM("metal_element_crafting_table_tier2","p",-1,() -> {return new ElementCraftingTableBlock(2,ElementType.MetalElement,()-> RecipeTypeRegister.MetalElementTier2CraftingRecipe,BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> water_element_crafting_table_tier2 =BM("water_element_crafting_table_tier2","p",-1,() -> {return new ElementCraftingTableBlock(2,ElementType.WaterElement,()->  RecipeTypeRegister.WaterElementTier2CraftingRecipe,BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).strength(1.0F, 10.0F).requiresCorrectToolForDrops());});
    public static final DeferredItem<Item> wood_enhanced_jadeite =IM("wood_enhanced_jadeite");
    public static final DeferredItem<Item> fire_enhanced_jadeite =IM("fire_enhanced_jadeite");
    public static final DeferredItem<Item> earth_enhanced_jadeite =IM("earth_enhanced_jadeite");
    public static final DeferredItem<Item> metal_enhanced_jadeite =IM("metal_enhanced_jadeite");
    public static final DeferredItem<Item> water_enhanced_jadeite =IM("water_enhanced_jadeite");
    public static final DeferredBlock<Block> wood_enhanced_jadeite_brick =BM("wood_enhanced_jadeite_brick","p",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).strength(1F, 10.0F).sound(SoundType.STONE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> fire_enhanced_jadeite_brick =BM("fire_enhanced_jadeite_brick","p",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).strength(1F, 10.0F).sound(SoundType.STONE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> earth_enhanced_jadeite_brick =BM("earth_enhanced_jadeite_brick","p",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).strength(1F, 10.0F).sound(SoundType.STONE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> metal_enhanced_jadeite_brick =BM("metal_enhanced_jadeite_brick","p",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).strength(1F, 10.0F).sound(SoundType.STONE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> water_enhanced_jadeite_brick =BM("water_enhanced_jadeite_brick","p",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).strength(1F, 10.0F).sound(SoundType.STONE).requiresCorrectToolForDrops());});
    public static final DeferredBlock<Block> wood_element_hokora =BM("wood_element_hokora","p",-1,() -> {return new HokoraBlock(ElementType.WoodElement,"wood_hokora",BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> fire_element_hokora =BM("fire_element_hokora","p",-1,() -> {return new HokoraBlock(ElementType.FireElement,"fire_hokora",BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> earth_element_hokora =BM("earth_element_hokora","p",-1,() -> {return new HokoraBlock(ElementType.EarthElement,"earth_hokora",BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> metal_element_hokora =BM("metal_element_hokora","p",-1,() -> {return new HokoraBlock(ElementType.MetalElement,"metal_hokora",BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).strength(1.0F, 10.0F));});
    public static final DeferredBlock<Block> water_element_hokora =BM("water_element_hokora","p",-1,() -> {return new HokoraBlock(ElementType.WaterElement,"water_hokora",BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).sound(SoundType.STONE).strength(1.0F, 10.0F));});

    public static final DeferredItem<Item> amber_igniter =ITEMS.register("amber_igniter", () -> {return new AmberIgniterItem((new Item.Properties()).durability(512));});
//    public static final DeferredItem<Item> freezing_jufu =ITEMS.register("freezing_jufu", () -> {return new JufuItem(ElementType.WaterElement,50,"freezing_jufu",(new Item.Properties()).tab(ModCoreUrushi.UrushiMagicTab));});
//    public static final DeferredItem<Item> knockback_jufu =ITEMS.register("knockback_jufu", () -> {return new JufuItem(ElementType.WoodElement,50,"knockback_jufu",(new Item.Properties()).tab(ModCoreUrushi.UrushiMagicTab));});
//    public static final DeferredItem<Item> jump_jufu =ITEMS.register("jump_jufu", () -> {return new JufuItem(ElementType.WoodElement,50,"jump_jufu",(new Item.Properties()).tab(ModCoreUrushi.UrushiMagicTab));});
//    public static final DeferredItem<Item> liana_jufu =ITEMS.register("liana_jufu", () -> {return new JufuItem(ElementType.WoodElement,50,"liana_jufu",(new Item.Properties()).tab(ModCoreUrushi.UrushiMagicTab));});
//    public static final DeferredItem<Item> growing_jufu =ITEMS.register("growing_jufu", () -> {return new JufuItem(ElementType.EarthElement,50,"growing_jufu",(new Item.Properties()).tab(ModCoreUrushi.UrushiMagicTab));});
//    public static final DeferredItem<Item> mountain_creation_jufu =ITEMS.register("mountain_creation_jufu", () -> {return new JufuItem(ElementType.EarthElement,50,"mountain_creation_jufu",(new Item.Properties()).tab(ModCoreUrushi.UrushiMagicTab));});
//    public static final DeferredItem<Item> fluid_erasion_jufu =ITEMS.register("fluid_erasion_jufu", () -> {return new JufuItem(ElementType.EarthElement,50,"fluid_erasion_jufu",(new Item.Properties()).tab(ModCoreUrushi.UrushiMagicTab));});
//    public static final DeferredBlock<Block> freezing_display =BLOCKS.register("freezing_display",() -> {return new Block(BlockBehaviour.Properties.of(Material.ICE).noOcclusion().isValidSpawn(ItemAndBlockRegister::never).isRedstoneConductor(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never).noLootTable());});
//    public static final DeferredBlock<Block> wood_element_puzzle_block =BN("wood_element_puzzle_block","p",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(1F, 10.0F).sound(SoundType.AMETHYST).noLootTable());});
//    public static final DeferredBlock<Block> fire_element_puzzle_block =BN("fire_element_puzzle_block","p",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(1F, 10.0F).sound(SoundType.AMETHYST).noLootTable());});
//    public static final DeferredBlock<Block> earth_element_puzzle_block =BN("earth_element_puzzle_block","p",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(1F, 10.0F).sound(SoundType.AMETHYST).noLootTable());});
//    public static final DeferredBlock<Block> metal_element_puzzle_block =BN("metal_element_puzzle_block","p",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(1F, 10.0F).sound(SoundType.AMETHYST).noLootTable());});
//    public static final DeferredBlock<Block> random_element_puzzle_block =BN("random_element_puzzle_block","p",-1,() -> {return new RandomElementPuzzleBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(1F, 10.0F).sound(SoundType.AMETHYST).noLootTable());});
//    public static final DeferredBlock<Block> water_element_puzzle_block =BN("water_element_puzzle_block","p",-1,() -> {return new Block(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(1F, 10.0F).sound(SoundType.AMETHYST).noLootTable());});
//    public static final DeferredBlock<Block> element_puzzle_controller_A =BN("element_puzzle_controller_a","p",-1,() -> {return new ElementPuzzleControllerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(1F, 10.0F).sound(SoundType.AMETHYST).noLootTable());});
//    public static final DeferredBlock<Block> element_puzzle_controller_B =BN("element_puzzle_controller_b","p",-1,() -> {return new ElementPuzzleControllerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(1F, 10.0F).sound(SoundType.AMETHYST).noLootTable());});
//    public static final DeferredBlock<Block> element_puzzle_controller_C =BN("element_puzzle_controller_c","p",-1,() -> {return new ElementPuzzleControllerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(1F, 10.0F).sound(SoundType.AMETHYST).noLootTable());});
   public static final DeferredItem<Item> empty_bamboo_cup =ITEMS.register("bamboo_cup", () -> {return new EmptyBambooCup((new Item.Properties()));});
    public static final DeferredItem<Item> water_bamboo_cup =ITEMS.register("water_bamboo_cup", () -> {return new FilledBambooCup((new Item.Properties()).craftRemainder(empty_bamboo_cup.get()));});
    public static final DeferredItem<Item> milk_bamboo_cup =ITEMS.register("milk_bamboo_cup", () -> {return new FilledBambooCup((new Item.Properties()).craftRemainder(empty_bamboo_cup.get()));});
    public static final DeferredItem<Item> soy_source_cup =ITEMS.register("soy_source_bamboo_cup", () -> {return new FilledBambooCup((new Item.Properties()).craftRemainder(empty_bamboo_cup.get()));});



    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> URUSHI_TAB = CREATIVE_TABS.register("urushi", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(Item.byBlock(ItemAndBlockRegister.kasuga_lantern.get())))
            .title(Component.translatable("itemGroup.urushi"))
            .displayItems((parameters, output) -> {
                for(int i=0;i<ModCoreUrushi.urushiTabContents.size();i++) {
                    output.accept(ModCoreUrushi.urushiTabContents.get(i).get());
                }
                output.accept(white_cushion.get());
                output.accept(orange_cushion.get());
                output.accept(magenta_cushion.get());
                output.accept(light_blue_cushion.get());
                output.accept(yellow_cushion.get());
                output.accept(lime_cushion.get());
                output.accept(pink_cushion.get());
                output.accept(gray_cushion.get());
                output.accept(light_gray_cushion.get());
                output.accept(cyan_cushion.get());
                output.accept(purple_cushion.get());
                output.accept(blue_cushion.get());
                output.accept(brown_cushion.get());
                output.accept(green_cushion.get());
                output.accept(red_cushion.get());
                output.accept(black_cushion.get());
                output.accept(hammer.get());
                output.accept(iron_katana.get());
                output.accept(climbing_rope.get());
                output.accept(hot_spring_bucket.get());
                output.accept(invisible_button_item.get());
                output.accept(invisible_lever_item.get());
                output.accept(invisible_pressure_plate_item.get());
                output.accept(shiitake_goggles.get());
                output.accept(lantern_plant_torch_item.get());
                output.accept(empty_bamboo_cup.get());
                output.accept(water_bamboo_cup.get());
            })
            .build());
    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> URUSHI_PLASTER_TAB = CREATIVE_TABS.register("urushi_plaster", () -> CreativeModeTab.builder()
            .withTabsBefore(URUSHI_TAB.getKey())
            .title(Component.translatable("itemGroup.urushi_plaster"))
            .icon(() -> new ItemStack(Item.byBlock(ItemAndBlockRegister.red_framed_plaster.get())))
            .displayItems((parameters, output) -> {
                for(int i=0;i<ModCoreUrushi.urushiPlasterTabContents.size();i++) {
                    output.accept(ModCoreUrushi.urushiPlasterTabContents.get(i).get());
                }
            })
            .build());
    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> URUSHI_WOOD_TAB = CREATIVE_TABS.register("urushi_wood", () -> CreativeModeTab.builder()
            .withTabsBefore(URUSHI_PLASTER_TAB.getKey())
            .title(Component.translatable("itemGroup.urushi_wood"))
            .icon(() -> new ItemStack(Item.byBlock(ItemAndBlockRegister.big_sakura_sapling.get())))
            .displayItems((parameters, output) -> {
                output.accept(raw_urushi_ball.get());
                output.accept(red_urushi_ball.get());
                output.accept(black_urushi_ball.get());
                for(int i=0;i<ModCoreUrushi.urushiWoodTabContents.size();i++) {
                    output.accept(ModCoreUrushi.urushiWoodTabContents.get(i).get());
                }
            })
            .build());
    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> URUSHI_FOOD_TAB = CREATIVE_TABS.register("urushi_dood", () -> CreativeModeTab.builder()
            .withTabsBefore(URUSHI_WOOD_TAB.getKey())
            .title(Component.translatable("itemGroup.urushi_food"))
            .icon(() -> new ItemStack(ItemAndBlockRegister.color_dango.get()))
            .displayItems((parameters, output) -> {
                for(int i=0;i<ModCoreUrushi.urushiFoodTabContents.size();i++) {
                    output.accept(ModCoreUrushi.urushiFoodTabContents.get(i).get());
                }
                output.accept(pickled_japanese_apricot.get());
                output.accept(shiitake.get());
                output.accept(roasted_shiitake.get());
                output.accept(rice_malt.get());
                output.accept(raw_rice.get());
                output.accept(rice.get());
                output.accept(tkg.get());
                output.accept(sekihan.get());
                output.accept(butadon.get());
                output.accept(gyudon.get());
                output.accept(cheese_gyudon.get());
                output.accept(cheese_gyudon_with_onsen_egg.get());
                output.accept(green_onion_and_raw_egg_gyudon.get());
                output.accept(mustard_leaf_and_cod_caviar_gyudon.get());
                output.accept(rice_ball.get());
                output.accept(rice_cake.get());
                output.accept(roasted_rice_cake.get());
                output.accept(kusa_dango.get());
                output.accept(color_dango.get());
                output.accept(mitarashi_dango.get());
                output.accept(sakura_mochi.get());
                output.accept(kusa_mochi.get());
                output.accept(ohagi.get());
                output.accept(yokan.get());
                output.accept(sakura_yokan.get());
                output.accept(baked_mochocho.get());
                output.accept(karaage.get());
                output.accept(yakitori.get());
                output.accept(tofu.get());
                output.accept(miso.get());
                output.accept(miso_soup.get());
                output.accept(hiyayakko.get());
                output.accept(aburaage.get());
                output.accept(so.get());
                output.accept(onsen_egg.get());
                output.accept(kitsune_udon.get());
                output.accept(salt.get());
                output.accept(soy_source_ramen.get());
                output.accept(miso_ramen.get());
                output.accept(tonkotsu_ramen.get());
                output.accept(salt_ramen.get());
                output.accept(syari.get());
                output.accept(tsuna.get());
                output.accept(sweetfish.get());
                output.accept(sweetfish_with_salt.get());
                output.accept(cooked_sweetfish.get());
                output.accept(cooked_sweetfish_with_salt.get());
                output.accept(tsuna_sashimi.get());
                output.accept(tsuna_sushi.get());
                output.accept(salmon_sashimi.get());
                output.accept(salmon_sushi.get());
                output.accept(squid_sashimi.get());
                output.accept(squid_sushi.get());
                output.accept(egg_sushi.get());
                output.accept(salmon_roe.get());
                output.accept(salmon_roe_sushi.get());
                output.accept(gravel_sushi.get());
                output.accept(inari.get());
                output.accept(minced_tuna_bowl.get());
                output.accept(yomotsuhegui_fruit.get());
                output.accept(lantern_plant_fruit.get());
                output.accept(milk_bamboo_cup.get());
                output.accept(soy_source_cup.get());
            })
            .build());
    public static final DeferredHolder<CreativeModeTab,CreativeModeTab> URUSHI_MAGIC_TAB = CREATIVE_TABS.register("urushi_magic", () -> CreativeModeTab.builder()
            .withTabsBefore(URUSHI_FOOD_TAB.getKey())
            .title(Component.translatable("itemGroup.urushi_magic"))
            .icon(() -> new ItemStack(ItemAndBlockRegister.earth_element_magatama.get()))
            .displayItems((parameters, output) -> {
                for(int i=0;i<ModCoreUrushi.urushiMagicTabContents.size();i++) {
                    output.accept(ModCoreUrushi.urushiMagicTabContents.get(i).get());
                }
                output.accept(kitsunebiItem.get());
                output.accept(uchiwa.get());
                output.accept(open_wagasa.get());
                output.accept(shide.get());
                output.accept(wood_element_paper.get());
                output.accept(fire_element_paper.get());
                output.accept(earth_element_paper.get());
                output.accept(metal_element_paper.get());
                output.accept(water_element_paper.get());
                output.accept(wood_element_magatama.get());
                ItemStack itemStack1=new ItemStack(ItemAndBlockRegister.wood_element_magatama.get());
                CompoundTag tag=new CompoundTag();
                tag.putInt(ElementUtils.REIRYOKU_AMOUNT, ConfigUrushi.reiryokuCapacityOfMagatama.get());
                itemStack1.set(DataComponents.CUSTOM_DATA,CustomData.of(tag));
                output.accept(itemStack1);
                output.accept(fire_element_magatama.get());
                ItemStack itemStack2=new ItemStack(ItemAndBlockRegister.fire_element_magatama.get());
                itemStack2.set(DataComponents.CUSTOM_DATA,CustomData.of(tag));
                output.accept(itemStack2);
                output.accept(earth_element_magatama.get());
                ItemStack itemStack3=new ItemStack(ItemAndBlockRegister.earth_element_magatama.get());
                itemStack3.set(DataComponents.CUSTOM_DATA,CustomData.of(tag));
                output.accept(itemStack3);
                output.accept(metal_element_magatama.get());
                ItemStack itemStack4=new ItemStack(ItemAndBlockRegister.metal_element_magatama.get());
                itemStack4.set(DataComponents.CUSTOM_DATA,CustomData.of(tag));
                output.accept(itemStack4);
                output.accept(water_element_magatama.get());
                ItemStack itemStack5=new ItemStack(ItemAndBlockRegister.water_element_magatama.get());
                itemStack5.set(DataComponents.CUSTOM_DATA,CustomData.of(tag));
                output.accept(itemStack5);

                output.accept(wood_amber.get());
                output.accept(fire_amber.get());
                output.accept(earth_amber.get());
                output.accept(metal_amber.get());
                output.accept(water_amber.get());
                output.accept(amber_igniter.get());
            })
            .build());

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos blockPos) {
        return false;
    }

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos blockPos, EntityType<?> entityType) {
   return false;
    }
    private static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
        return true;
    }

    private static ToIntFunction<BlockState> litBlockEmission(int p_50760_) {
        return (p_50763_) -> {
            return p_50763_.getValue(BlockStateProperties.LIT) ? p_50760_ : 0;
        };
    }
    private static FlammableRotatedPillarBlock log(MapColor p_50789_, MapColor p_50790_) {
        return new FlammableRotatedPillarBlock(BlockBehaviour.Properties.of().mapColor((p_152624_) -> {
            return p_152624_.getValue(FlammableRotatedPillarBlock.AXIS) == Direction.Axis.Y ? p_50789_ : p_50790_;
        }).strength(2.0F).sound(SoundType.WOOD));
    }
    private static RotatedPillarBlock chiselablelog(MapColor p_50789_, MapColor p_50790_) {
        return new LacquerLogBlock(BlockBehaviour.Properties.of().mapColor((p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? p_50789_ : p_50790_;
        }).strength(2.0F).sound(SoundType.WOOD));
    }
    private static RotatedPillarBlock strippablelog(Block block,int i,MapColor p_50789_, MapColor p_50790_) {
        return new StrippableLogBlock(block,i,BlockBehaviour.Properties.of().mapColor((p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? p_50789_ : p_50790_;
        }).strength(2.0F).sound(SoundType.WOOD));
    }
    private static LeavesBlock leaves(MapColor color,SoundType p_152615_) {
        return new FlammableLeavesBlock(BlockBehaviour.Properties.of().mapColor(color).strength(0.2F).randomTicks().sound(p_152615_).noOcclusion().isValidSpawn(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(ItemAndBlockRegister::never));
    }
    private static CutoutLeavesBlock cutouteaves(MapColor color,SoundType p_152615_) {
        return new CutoutLeavesBlock(BlockBehaviour.Properties.of().mapColor(color).strength(0.2F).randomTicks().sound(p_152615_).noOcclusion().isValidSpawn(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(ItemAndBlockRegister::never));
    }
    private static CutoutLeavesBlock glowingleaves(MapColor color,SoundType p_152615_) {
        return new CutoutLeavesBlock(BlockBehaviour.Properties.of().mapColor(color).strength(0.2F).randomTicks().sound(p_152615_).noOcclusion().isValidSpawn(ItemAndBlockRegister::never).isSuffocating(ItemAndBlockRegister::never).isViewBlocking(ItemAndBlockRegister::never).lightLevel((p_235470_0_) -> {return 15;}).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(ItemAndBlockRegister::never));
    }
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
        BLOCKS.register(eventBus);
        CREATIVE_TABS.register(eventBus);
    }
    private static <T extends Item> DeferredItem<T> I(String name) {
        DeferredItem<Item> object = ITEMS.register(name, ()-> {
            return new Item((new Item.Properties()));
        });
        ModCoreUrushi.urushiTabContents.add(Objects.requireNonNull(object));
        return (DeferredItem<T>) object;
    }
    private static <T extends Item> DeferredItem<T> IW(String name) {
        DeferredItem<Item> object = ITEMS.register(name, ()-> {
            return new Item((new Item.Properties()));
        });
        ModCoreUrushi.urushiWoodTabContents.add(Objects.requireNonNull(object));
        return (DeferredItem<T>) object;
    }
    private static <T extends Item> DeferredItem<T> IF(String name) {
        DeferredItem<Item> object = ITEMS.register(name, ()-> {
            return new Item((new Item.Properties()));
        });
        ModCoreUrushi.urushiFoodTabContents.add(Objects.requireNonNull(object));
        return (DeferredItem<T>) object;
    }
    private static <T extends Item> DeferredItem<T> IM(String name) {
        DeferredItem<Item> object = ITEMS.register(name, ()-> {
            return new Item((new Item.Properties()));
        });
        ModCoreUrushi.urushiMagicTabContents.add(Objects.requireNonNull(object));
        return (DeferredItem<T>) object;
    }
    private static <T extends Block> DeferredBlock<T> B(String name,String tool,int l, Supplier<T > sup) {
        DeferredBlock<T> object = BLOCKS.register(name, sup);
        DeferredItem<Item> object2 = ITEMS.register(name, () -> {
            return new BlockItem(Objects.requireNonNull(object.get()), (new Item.Properties()));
        });
        ModCoreUrushi.urushiTabContents.add(Objects.requireNonNull(object2));
        if (ModCoreUrushi.isDebug) {
            ModCoreUrushi.blockSelfDropList.add((DeferredBlock<Block>) Objects.requireNonNull(object));
            if (tool == "p") {
                ModCoreUrushi.pickaxeList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "a") {
                ModCoreUrushi.axeList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "s") {
                ModCoreUrushi.shovelList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "h") {
                ModCoreUrushi.hoeList.add(ModCoreUrushi.ModID + ":" + name);
            }

            if (l == 0) {
                ModCoreUrushi.woodenToolList.add("urushi:" + name);
            } else if (l == 1) {
                ModCoreUrushi.stoneToolList.add("urushi:" + name);
            } else if (l == 2) {
                ModCoreUrushi.ironToolList.add("urushi:" + name);
            } else if (l == 3) {
                ModCoreUrushi.goldenToolList.add("urushi:" + name);
            } else if (l == 4) {
                ModCoreUrushi.diamondToolList.add("urushi:" + name);
            } else if (l == 5) {
                ModCoreUrushi.netheriteToolList.add("urushi:" + name);
            }
        }
        return object;
    }
    private static <T extends Block> DeferredBlock<T> BWater(String name, String tool, int l, java.util.function.Supplier<? extends ItemLike> result, Supplier<T > sup) {
        DeferredBlock<T> object = BLOCKS.register(name, sup);
        DeferredItem<Item> object2 =ITEMS.register(name,() -> {return new WaterCraftingItem(result, Objects.requireNonNull(object.get()), (new Item.Properties()));});
        ModCoreUrushi.urushiTabContents.add(Objects.requireNonNull(object2));
        if(ModCoreUrushi.isDebug) {
            ModCoreUrushi.blockSelfDropList.add((DeferredBlock<Block>) Objects.requireNonNull(object));
            if (tool == "p") {
                ModCoreUrushi.pickaxeList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "a") {
                ModCoreUrushi.axeList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "s") {
                ModCoreUrushi.shovelList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "h") {
                ModCoreUrushi.hoeList.add(ModCoreUrushi.ModID + ":" + name);
            }

            if (l == 0) {
                ModCoreUrushi.woodenToolList.add("urushi:" + name);
            } else if (l == 1) {
                ModCoreUrushi.stoneToolList.add("urushi:" + name);
            } else if (l == 2) {
                ModCoreUrushi.ironToolList.add("urushi:" + name);
            } else if (l == 3) {
                ModCoreUrushi.goldenToolList.add("urushi:" + name);
            } else if (l == 4) {
                ModCoreUrushi.diamondToolList.add("urushi:" + name);
            } else if (l == 5) {
                ModCoreUrushi.netheriteToolList.add("urushi:" + name);
            }
        }
        return object;
    }
    private static <T extends Block> DeferredBlock<T> BW(String name,String tool,int l, Supplier<T > sup) {
        DeferredBlock<T> object = BLOCKS.register(name, sup);
        DeferredItem<Item> object2 =ITEMS.register(name,() -> {return new BlockItem( Objects.requireNonNull(object.get()), (new Item.Properties()));});
        ModCoreUrushi.urushiWoodTabContents.add(Objects.requireNonNull(object2));
        if(ModCoreUrushi.isDebug) {
            ModCoreUrushi.blockSelfDropList.add((DeferredBlock<Block>) Objects.requireNonNull(object));
            if (tool == "p") {
                ModCoreUrushi.pickaxeList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "a") {
                ModCoreUrushi.axeList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "s") {
                ModCoreUrushi.shovelList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "h") {
                ModCoreUrushi.hoeList.add(ModCoreUrushi.ModID + ":" + name);
            }

            if (l == 0) {
                ModCoreUrushi.woodenToolList.add("urushi:" + name);
            } else if (l == 1) {
                ModCoreUrushi.stoneToolList.add("urushi:" + name);
            } else if (l == 2) {
                ModCoreUrushi.ironToolList.add("urushi:" + name);
            } else if (l == 3) {
                ModCoreUrushi.goldenToolList.add("urushi:" + name);
            } else if (l == 4) {
                ModCoreUrushi.diamondToolList.add("urushi:" + name);
            } else if (l == 5) {
                ModCoreUrushi.netheriteToolList.add("urushi:" + name);
            }
        }
        return object;
    }
    private static <T extends Block> DeferredBlock<T> BP(String name,String tool,int l, Supplier<T > sup) {
        DeferredBlock<T> object = BLOCKS.register(name, sup);
        DeferredItem<Item> object2 =ITEMS.register(name,() -> {return new BlockItem( Objects.requireNonNull(object.get()), (new Item.Properties()));});
        ModCoreUrushi.urushiPlasterTabContents.add(Objects.requireNonNull(object2));
        if(ModCoreUrushi.isDebug) {
            ModCoreUrushi.blockSelfDropList.add((DeferredBlock<Block>) Objects.requireNonNull(object));
            if (tool == "p") {
                ModCoreUrushi.pickaxeList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "a") {
                ModCoreUrushi.axeList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "s") {
                ModCoreUrushi.shovelList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "h") {
                ModCoreUrushi.hoeList.add(ModCoreUrushi.ModID + ":" + name);
            }

            if (l == 0) {
                ModCoreUrushi.woodenToolList.add("urushi:" + name);
            } else if (l == 1) {
                ModCoreUrushi.stoneToolList.add("urushi:" + name);
            } else if (l == 2) {
                ModCoreUrushi.ironToolList.add("urushi:" + name);
            } else if (l == 3) {
                ModCoreUrushi.goldenToolList.add("urushi:" + name);
            } else if (l == 4) {
                ModCoreUrushi.diamondToolList.add("urushi:" + name);
            } else if (l == 5) {
                ModCoreUrushi.netheriteToolList.add("urushi:" + name);
            }
        }
        return object;
    }
    private static <T extends Block> DeferredBlock<T> BF(String name,String tool,int l, Supplier<T > sup) {
        DeferredBlock<T> object = BLOCKS.register(name, sup);
        DeferredItem<Item> object2 =ITEMS.register(name,() -> {return new BlockItem( Objects.requireNonNull(object.get()), (new Item.Properties()));});
        ModCoreUrushi.urushiFoodTabContents.add(Objects.requireNonNull(object2));
        if(ModCoreUrushi.isDebug) {
            ModCoreUrushi.blockSelfDropList.add((DeferredBlock<Block>) Objects.requireNonNull(object));
            if (tool == "p") {
                ModCoreUrushi.pickaxeList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "a") {
                ModCoreUrushi.axeList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "s") {
                ModCoreUrushi.shovelList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "h") {
                ModCoreUrushi.hoeList.add(ModCoreUrushi.ModID + ":" + name);
            }

            if (l == 0) {
                ModCoreUrushi.woodenToolList.add("urushi:" + name);
            } else if (l == 1) {
                ModCoreUrushi.stoneToolList.add("urushi:" + name);
            } else if (l == 2) {
                ModCoreUrushi.ironToolList.add("urushi:" + name);
            } else if (l == 3) {
                ModCoreUrushi.goldenToolList.add("urushi:" + name);
            } else if (l == 4) {
                ModCoreUrushi.diamondToolList.add("urushi:" + name);
            } else if (l == 5) {
                ModCoreUrushi.netheriteToolList.add("urushi:" + name);
            }
        }
        return object;
    }
    private static <T extends Block> DeferredBlock<T> BM(String name,String tool,int l, Supplier<T > sup) {
        DeferredBlock<T> object = BLOCKS.register(name, sup);
        DeferredItem<Item> object2 =ITEMS.register(name,() -> {return new BlockItem( Objects.requireNonNull(object.get()), (new Item.Properties()));});
        ModCoreUrushi.urushiMagicTabContents.add(Objects.requireNonNull(object2));
        if(ModCoreUrushi.isDebug) {
            ModCoreUrushi.blockSelfDropList.add((DeferredBlock<Block>) Objects.requireNonNull(object));
            if (tool == "p") {
                ModCoreUrushi.pickaxeList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "a") {
                ModCoreUrushi.axeList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "s") {
                ModCoreUrushi.shovelList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "h") {
                ModCoreUrushi.hoeList.add(ModCoreUrushi.ModID + ":" + name);
            }

            if (l == 0) {
                ModCoreUrushi.woodenToolList.add("urushi:" + name);
            } else if (l == 1) {
                ModCoreUrushi.stoneToolList.add("urushi:" + name);
            } else if (l == 2) {
                ModCoreUrushi.ironToolList.add("urushi:" + name);
            } else if (l == 3) {
                ModCoreUrushi.goldenToolList.add("urushi:" + name);
            } else if (l == 4) {
                ModCoreUrushi.diamondToolList.add("urushi:" + name);
            } else if (l == 5) {
                ModCoreUrushi.netheriteToolList.add("urushi:" + name);
            }
        }
        return object;
    }
    private static <T extends Block> DeferredBlock<T> BIron(String name, Supplier<T > sup) {
        DeferredBlock<T> object = BLOCKS.register(name, sup);
        DeferredItem<Item> object2 =ITEMS.register(name,() -> {return new IronIngotItem( Objects.requireNonNull(object.get()), (new Item.Properties()));});
        ModCoreUrushi.urushiTabContents.add(Objects.requireNonNull(object2));
        if(ModCoreUrushi.isDebug) {
            ModCoreUrushi.blockSelfDropList.add((DeferredBlock<Block>) Objects.requireNonNull(object));
            ModCoreUrushi.pickaxeList.add(ModCoreUrushi.ModID + ":" + name);
        }
        return object;
    }
    private static <T extends Block> DeferredBlock<T> BN(String name,String tool,int l, Supplier<T > sup) {
        DeferredBlock<T> object = BLOCKS.register(name, sup);
        if(ModCoreUrushi.isDebug) {
            ModCoreUrushi.blockSelfDropList.add((DeferredBlock<Block>) Objects.requireNonNull(object));
            if (tool == "p") {
                ModCoreUrushi.pickaxeList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "a") {
                ModCoreUrushi.axeList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "s") {
                ModCoreUrushi.shovelList.add(ModCoreUrushi.ModID + ":" + name);
            } else if (tool == "h") {
                ModCoreUrushi.hoeList.add(ModCoreUrushi.ModID + ":" + name);
            }

            if (l == 0) {
                ModCoreUrushi.woodenToolList.add("urushi:" + name);
            } else if (l == 1) {
                ModCoreUrushi.stoneToolList.add("urushi:" + name);
            } else if (l == 2) {
                ModCoreUrushi.ironToolList.add("urushi:" + name);
            } else if (l == 3) {
                ModCoreUrushi.goldenToolList.add("urushi:" + name);
            } else if (l == 4) {
                ModCoreUrushi.diamondToolList.add("urushi:" + name);
            } else if (l == 5) {
                ModCoreUrushi.netheriteToolList.add("urushi:" + name);
            }
        }
        return object;
    }



}
