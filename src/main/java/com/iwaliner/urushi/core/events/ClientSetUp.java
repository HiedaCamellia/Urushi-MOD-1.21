package com.iwaliner.urushi.core.events;


import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.common.entiity.food.model.*;
import com.iwaliner.urushi.common.entiity.food.renderer.*;
import com.iwaliner.urushi.common.blockentity.screen.*;
import com.iwaliner.urushi.common.blockentity.renderer.*;
import com.iwaliner.urushi.common.entiity.renderer.*;
import com.iwaliner.urushi.common.entiity.model.*;
import com.iwaliner.urushi.core.json.*;
import com.iwaliner.urushi.common.particle.*;
import com.iwaliner.urushi.core.util.ElementUtils;
import com.iwaliner.urushi.core.util.ToggleKeyMappingPlus;
import com.iwaliner.urushi.core.util.UrushiUtils;
import com.iwaliner.urushi.registries.*;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.VibrationSignalParticle;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.FallingBlockRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

import java.io.File;

@OnlyIn(Dist.CLIENT)
@EventBusSubscriber(modid = ModCoreUrushi.ModID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetUp {
    public static final ModelLayerLocation RICE = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "rice_food"), "rice_food");
    public static final ModelLayerLocation KARAAGE = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "karaage_food"), "karaage_food");
    public static final ModelLayerLocation TOFU = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "tofu_food"), "tofu_food");
    public static final ModelLayerLocation ABURAAGE = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "aburaage_food"), "aburaage_food");
    public static final ModelLayerLocation DANGO = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "dango_food"), "dango_food");
    public static final ModelLayerLocation RICE_CAKE = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "rice_cake_food"), "rice_cake_food");
    public static final ModelLayerLocation ROASTED_RICE_CAKE = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "roasted_rice_cake_food"), "roasted_rice_cake_food");
    public static final ModelLayerLocation CUSHION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "cushion"), "cushion");
    public static final ModelLayerLocation SUSHI = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "sushi_food"), "sushi_food");
    public static final ModelLayerLocation SALMON_ROE_SUSHI = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "salmon_roe_sushi_food"), "salmon_roe_sushi_food");
    public static final ModelLayerLocation INARI = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "inari_food"), "inari_food");


    public static KeyMapping connectionKey = new ToggleKeyMappingPlus("key.urushi.connectionKey", KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_C, "key.urushi.category");
    @SubscribeEvent
    public static void keyRegister(RegisterKeyMappingsEvent event) {
        event.register(ClientSetUp.connectionKey);
    }

    /**エンティティの見た目を登録*/
    @SubscribeEvent
    public static void RegisterEntityRendererEvent(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityRegister.RiceFoodEntity.get(), RiceFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.TKGFoodEntity.get(), TKGFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.SekihanFoodEntity.get(), SekihanFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.GyudonFoodEntity.get(), GyudonFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.ButadonFoodEntity.get(), ButadonFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.KitsuneUdonFoodEntity.get(), KitsuneUdonFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.KaraageFoodEntity.get(), KaraageFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.TofuFoodEntity.get(), TofuFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.AburaageFoodEntity.get(), AburaageFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.KusaDangoFoodEntity.get(), KusaDangoFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.ColorDangoFoodEntity.get(), ColorDangoFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.MitarashiDangoFoodEntity.get(), MitarashiDangoFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.RiceCakeFoodEntity.get(), RiceCakeFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.RoastedRiceCakeFoodEntity.get(), RoastedRiceCakeFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.TsunaSushiFoodEntity.get(), TsunaSushiFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.SalmonSushiFoodEntity.get(), SalmonSushiFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.SquidSushiFoodEntity.get(), SquidSushiFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.EggSushiFoodEntity.get(), EggSushiFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.SalmonRoeSushiFoodEntity.get(), SalmonRoeSushiFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.GravelSushiFoodEntity.get(), GravelSushiFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.InariFoodEntity.get(), InariFoodRenderer::new);
        event.registerEntityRenderer(EntityRegister.KitsunebiEntity.get(),  (p_174088_) -> {
            return new ThrownItemRenderer<>(p_174088_, 1.0F, true);
        });
        event.registerEntityRenderer(EntityRegister.Ghost.get(), GhostRenderer::new);
        event.registerEntityRenderer(EntityRegister.Cushion.get(), CushionRenderer::new);
       /* event.registerEntityRenderer(EntityRegister.Jufu.get(),  (p_174088_) -> {
            return new ThrownItemRenderer<>(p_174088_, 1.0F, true);
        });*/
        event.registerEntityRenderer(EntityRegister.JufuEffectDisplay.get(), FallingBlockRenderer::new);

    }

    /**エンティティのレイヤーを指定*/
    @SubscribeEvent
    public static void registerLayerEvent(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(RICE, RiceFoodModel::createBodyLayer);
        event.registerLayerDefinition(KARAAGE, KaraageFoodModel::createBodyLayer);
        event.registerLayerDefinition(TOFU, TofuFoodModel::createBodyLayer);
        event.registerLayerDefinition(ABURAAGE, AburaageFoodModel::createBodyLayer);
        event.registerLayerDefinition(DANGO, DangoFoodModel::createBodyLayer);
        event.registerLayerDefinition(RICE_CAKE, RiceCakeFoodModel::createBodyLayer);
        event.registerLayerDefinition(ROASTED_RICE_CAKE, RoastedRiceCakeFoodModel::createBodyLayer);
        event.registerLayerDefinition(CUSHION, CushionModel::createBodyLayer);
        event.registerLayerDefinition(SUSHI, SushiFoodModel::createBodyLayer);
        event.registerLayerDefinition(SALMON_ROE_SUSHI, SalmonRoeSushiFoodModel::createBodyLayer);
        event.registerLayerDefinition(INARI, InariFoodModel::createBodyLayer);



    }

    /**パーティクルの見た目を指定*/
    @SubscribeEvent
    public static void registerParticlesEvent(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ParticleRegister.FireElement.get(), ElementParticle.Provider::new);
        event.registerSpriteSet(ParticleRegister.WoodElement.get(), ElementParticle.Provider::new);
        event.registerSpriteSet(ParticleRegister.EarthElement.get(), ElementParticle.Provider::new);
        event.registerSpriteSet(ParticleRegister.MetalElement.get(), ElementParticle.Provider::new);
        event.registerSpriteSet(ParticleRegister.WaterElement.get(), ElementParticle.Provider::new);
        event.registerSpriteSet(ParticleRegister.FallingRedLeaves.get(), FallingRedLeavesParticle.Provider::new);
        event.registerSpriteSet(ParticleRegister.FallingOrangeLeaves.get(), FallingOrangeLeavesParticle.Provider::new);
        event.registerSpriteSet(ParticleRegister.FallingYellowLeaves.get(), FallingYellowLeavesParticle.Provider::new);
        event.registerSpriteSet(ParticleRegister.FallingSakuraLeaves.get(), FallingSakuraLeavesParticle.Provider::new);
        event.registerSpriteSet(ParticleRegister.WoodElementMedium.get(), MediumParticle.Provider::new);
        event.registerSpriteSet(ParticleRegister.FireElementMedium.get(), MediumParticle.Provider::new);
        event.registerSpriteSet(ParticleRegister.EarthElementMedium.get(), MediumParticle.Provider::new);
        event.registerSpriteSet(ParticleRegister.MetalElementMedium.get(), MediumParticle.Provider::new);
        event.registerSpriteSet(ParticleRegister.WaterElementMedium.get(), MediumParticle.Provider::new);

    }



    @SubscribeEvent
    public static void clientLoad(RegisterMenuScreensEvent event) {

        /**コンテナにGUIを登録*/
        event.register(MenuRegister.FryerMenu.get(), FryerScreen::new);
        event.register(MenuRegister.DoubledWoodenCabinetryMenu.get(), DoubledWoodenCabinetryScreen::new);
        event.register(MenuRegister.UrushiHopperMenu.get(), UrushiHopperScreen::new);
        event.register(MenuRegister.AutoCraftingTableMenu.get(), AutoCraftingTableScreen::new);

    }

    @SubscribeEvent
    public static void RegisterRendererEvent(FMLClientSetupEvent event) {


        /**キーボード操作を登録*/
        /**ClientRegistry.registerKeyBinding(connectionKey);*/

        /**アイテムの状態を登録*/
        event.enqueueWork(() -> {
            ItemProperties.register(ItemAndBlockRegister.iron_katana.get(), ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "ishurting"), (itemStack, clientWorld, livingEntity, i) -> (livingEntity instanceof Player &&livingEntity.swinging&&livingEntity.getMainHandItem()==itemStack)?1:0);

            ItemProperties.register(ItemAndBlockRegister.wood_element_magatama.get(), ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "stored_amount"), (itemStack, clientWorld, livingEntity,i) -> (int)Mth.floor((float) ElementUtils.getStoredReiryokuAmount(itemStack)/400) );
            ItemProperties.register(ItemAndBlockRegister.fire_element_magatama.get(), ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "stored_amount"), (itemStack, clientWorld, livingEntity,i) -> (int)Mth.floor((float) ElementUtils.getStoredReiryokuAmount(itemStack)/400) );
            ItemProperties.register(ItemAndBlockRegister.earth_element_magatama.get(), ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "stored_amount"), (itemStack, clientWorld, livingEntity,i) -> (int)Mth.floor((float) ElementUtils.getStoredReiryokuAmount(itemStack)/400) );
            ItemProperties.register(ItemAndBlockRegister.metal_element_magatama.get(), ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "stored_amount"), (itemStack, clientWorld, livingEntity,i) -> (int)Mth.floor((float) ElementUtils.getStoredReiryokuAmount(itemStack)/400) );
            ItemProperties.register(ItemAndBlockRegister.water_element_magatama.get(), ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "stored_amount"), (itemStack, clientWorld, livingEntity,i) -> (int)Mth.floor((float) ElementUtils.getStoredReiryokuAmount(itemStack)/400) );

            ItemProperties.register(Item.byBlock(ItemAndBlockRegister.japanese_timber_bamboo.get()), ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "event"), (itemStack, clientWorld, livingEntity,i) -> UrushiUtils.isShogatsu()? 1 : 0);
            ItemProperties.register(ItemAndBlockRegister.raw_rice.get(), ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "is_april_fools"), (itemStack, clientWorld, livingEntity,i) -> UrushiUtils.isAprilFoolsDay()? 1 : 0);
            ItemProperties.register(ItemAndBlockRegister.rice.get(), ResourceLocation.fromNamespaceAndPath(ModCoreUrushi.ModID, "is_april_fools"), (itemStack, clientWorld, livingEntity,i) -> UrushiUtils.isAprilFoolsDay()? 1 : 0);

        });



       /**見た目が特殊なBlockEntityの見た目を登録*/
        BlockEntityRenderers.register(BlockEntityRegister.Sanbo.get(), SanboRenderer::new);
        BlockEntityRenderers.register(BlockEntityRegister.Shichirin.get(), ShichirinRenderer::new);
        BlockEntityRenderers.register(BlockEntityRegister.Hokora.get(), HokoraRenderer::new);




       ModCoreUrushi.underDevelopmentList.add(Item.byBlock(ItemAndBlockRegister.senryoubako.get()));
        /**jsonファイルを自動生成するために開発環境のパスを登録*/
        if(ModCoreUrushi.isDebug) {
        FMLPaths.GAMEDIR.get();
        ModCoreUrushi.assetsDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/src/main/resources/assets/urushi/");
        ModCoreUrushi.assetsInBuildDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/build/resources/main/assets/urushi/");
        ModCoreUrushi.dataDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/src/main/resources/data/");
        ModCoreUrushi.dataInBuildDirectory = new File(FMLPaths.GAMEDIR.get().getParent().toString() + "/build/resources/main/data/");














            MineableTagGenerator.INSTANCE.registerPickaxeMineableTag(ModCoreUrushi.pickaxeList);
            MineableTagGenerator.INSTANCE.registerAxeMineableTag(ModCoreUrushi.axeList);
            MineableTagGenerator.INSTANCE.registerShovelMineableTag(ModCoreUrushi.shovelList);
            MineableTagGenerator.INSTANCE.registerHoeMineableTag(ModCoreUrushi.hoeList);
            RequiredToolMaterialTagGenerator.INSTANCE.registerWoodenToolTag(ModCoreUrushi.woodenToolList);
            RequiredToolMaterialTagGenerator.INSTANCE.registerStoneToolTag(ModCoreUrushi.stoneToolList);
            RequiredToolMaterialTagGenerator.INSTANCE.registerIronToolTag(ModCoreUrushi.ironToolList);
            RequiredToolMaterialTagGenerator.INSTANCE.registerGoldenToolTag(ModCoreUrushi.goldenToolList);
            RequiredToolMaterialTagGenerator.INSTANCE.registerDiamondToolTag(ModCoreUrushi.diamondToolList);
            RequiredToolMaterialTagGenerator.INSTANCE.registerNetheriteToolTag(ModCoreUrushi.netheriteToolList);



        }
    }
}