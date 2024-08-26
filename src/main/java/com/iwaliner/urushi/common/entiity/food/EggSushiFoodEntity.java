package com.iwaliner.urushi.common.entiity.food;


import com.iwaliner.urushi.registries.EntityRegister;
import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EggSushiFoodEntity extends FoodEntity {

    public EggSushiFoodEntity(EntityType<?> p_i48580_1_, Level p_i48580_2_) {
        super(ItemAndBlockRegister.egg_sushi.get(), EntityRegister.EggSushiFoodEntity.get(), p_i48580_2_);
    }


}
