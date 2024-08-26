package com.iwaliner.urushi.core.util.interfaces;

import com.iwaliner.urushi.core.util.ElementType;

import javax.annotation.Nullable;

public interface HasReiryokuItem {
    @Nullable
    int getReiryokuCapacity();


    @Nullable
    ElementType getElementType();
}
