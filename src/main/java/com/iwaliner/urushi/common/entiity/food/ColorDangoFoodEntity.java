package com.iwaliner.urushi.common.entiity.food;


import com.iwaliner.urushi.registries.EntityRegister;
import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class ColorDangoFoodEntity extends FoodEntity {

    public ColorDangoFoodEntity(EntityType<?> p_i48580_1_, Level p_i48580_2_) {
        super(ItemAndBlockRegister.color_dango.get(), EntityRegister.ColorDangoFoodEntity.get(), p_i48580_2_);
    }


}
