package com.iwaliner.urushi.core.util.interfaces;

import com.iwaliner.urushi.core.util.ComplexDirection;
import net.minecraft.core.Direction;

public interface Mirror {

    /**入射角を参照*/
    ComplexDirection getIncidentDirection();

    /**入射角を設定*/
    void setIncidentDirection(ComplexDirection direction);

    /**入射角を設定*/
    void setIncidentDirection(Direction direction);

    boolean getCanReach();
}
