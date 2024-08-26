package com.iwaliner.urushi.common.item;


import com.iwaliner.urushi.core.util.ElementType;
import org.jetbrains.annotations.Nullable;

public class FireMagatamaItem extends AbstractMagatamaItem  {
    public FireMagatamaItem(Properties p_41383_) {
        super(p_41383_);
    }
    @Nullable
    @Override
    public ElementType getElementType() {
        return ElementType.FireElement;
    }
}
