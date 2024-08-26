package com.iwaliner.urushi.registries;

import com.iwaliner.urushi.ModCoreUrushi;
import com.iwaliner.urushi.common.blockentity.menu.AutoCraftingTableMenu;
import com.iwaliner.urushi.common.blockentity.menu.DoubledWoodenCabinetryMenu;
import com.iwaliner.urushi.common.blockentity.menu.FryerMenu;
import com.iwaliner.urushi.common.blockentity.menu.UrushiHopperMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class MenuRegister {
    public static final DeferredRegister<MenuType<?>> MENUS = DeferredRegister.create(BuiltInRegistries.MENU, ModCoreUrushi.ModID);



    public static final DeferredHolder<MenuType<?>,MenuType<FryerMenu>> FryerMenu = MENUS.register("fryer", () -> IMenuTypeExtension.create((windowId, inv, data) -> {return new FryerMenu(windowId, inv);}));
    public static final DeferredHolder<MenuType<?>,MenuType<DoubledWoodenCabinetryMenu>> DoubledWoodenCabinetryMenu = MENUS.register("doubled_wooden_cabinetry", () -> IMenuTypeExtension.create((windowId, inv, data) -> {return new DoubledWoodenCabinetryMenu(windowId, inv);}));
    public static final DeferredHolder<MenuType<?>,MenuType<com.iwaliner.urushi.common.blockentity.menu.UrushiHopperMenu>> UrushiHopperMenu = MENUS.register("urushi_hopper", () -> IMenuTypeExtension.create((windowId, inv, data) -> {return new UrushiHopperMenu(windowId, inv);}));
    public static final DeferredHolder<MenuType<?>,MenuType<AutoCraftingTableMenu>> AutoCraftingTableMenu = MENUS.register("auto_crafting_table", () -> IMenuTypeExtension.create((windowId, inv, data) -> {return new AutoCraftingTableMenu(windowId, inv);}));




    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
