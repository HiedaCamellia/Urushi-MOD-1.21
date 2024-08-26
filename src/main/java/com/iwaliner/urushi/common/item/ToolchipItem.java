package com.iwaliner.urushi.common.item;

import com.iwaliner.urushi.core.util.UrushiUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ToolchipItem extends Item {
    private final String string;
    public ToolchipItem(String s,Properties p_41383_) {
        super(p_41383_);
        string=s;
    }
    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> list, TooltipFlag tooltipFlag) {
        UrushiUtils.setInfo(list,string);
    }
}
