package com.iwaliner.urushi.common.item;


import com.iwaliner.urushi.core.util.ElementType;
import org.jetbrains.annotations.Nullable;

public class MetalMagatamaItem extends AbstractMagatamaItem  {
    public MetalMagatamaItem(Properties p_41383_) {
        super(p_41383_);
    }
    @Nullable
    @Override
    public ElementType getElementType() {
        return ElementType.MetalElement;
    }
}
