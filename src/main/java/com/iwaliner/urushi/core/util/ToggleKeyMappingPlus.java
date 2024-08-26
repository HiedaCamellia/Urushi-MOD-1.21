package com.iwaliner.urushi.core.util;


import com.iwaliner.urushi.ModCoreUrushi;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.settings.KeyConflictContext;

@OnlyIn(Dist.CLIENT)
public class ToggleKeyMappingPlus extends KeyMapping {


    public ToggleKeyMappingPlus(String description, KeyConflictContext keyConflictContext, final InputConstants.Type inputType, final int keyCode, String category) {
        super(description, keyConflictContext, inputType.getOrCreate(keyCode), category);
    }
    public ToggleKeyMappingPlus(String name, int button, String category) {
        super(name, InputConstants.Type.KEYSYM, button, category);
    }

    public void setDown(boolean p_92534_) {
        if (p_92534_ && isConflictContextAndModifierActive()) {
            super.setDown(!this.isDown());
            ModCoreUrushi.logger.info("ToggleKeyMapping");
        }

    }
}
