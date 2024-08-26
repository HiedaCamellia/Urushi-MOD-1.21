package com.iwaliner.urushi.core.config;


import net.neoforged.neoforge.common.ModConfigSpec;

public final class ConfigUrushi {
    public static final ModConfigSpec.Builder builder=new ModConfigSpec.Builder();
    public static final ModConfigSpec spec;
    public static final ModConfigSpec.ConfigValue<Integer> maxHightBamboo;
    public static final ModConfigSpec.ConfigValue<Boolean> TurnOnSpeedUp;
    public static final ModConfigSpec.ConfigValue<Integer> reiryokuCapacityOfMagatama;
    public static final ModConfigSpec.ConfigValue<Integer> fallingLeafParticleAmount;
    public static final ModConfigSpec.ConfigValue<Integer> fallingSakuraParticleAmount;
    public static final ModConfigSpec.ConfigValue<Boolean> WindBellSound;
    public static final ModConfigSpec.ConfigValue<Integer> shichirinIconAmount;
    public static final ModConfigSpec.ConfigValue<Integer> shichirincookingDifficlutly;
    public static final ModConfigSpec.ConfigValue<Boolean> instantlySlidingDoor;
    public static final ModConfigSpec.ConfigValue<Integer> generateKakuriyoPortalProbability;
    public static final ModConfigSpec.ConfigValue<Boolean> disableBlockElementDisplaying;


    static {
        builder.push("block settings");
        maxHightBamboo=builder.comment("max height of Japanese Timber Bamboo").define("max height(1～2147483647)",10);
        instantlySlidingDoor=builder.comment("open and close Shojis, Fusumas, and Glass Sliding Door instantly").define("instantry open and close sliding doors(true/false)",false);
        WindBellSound=builder.comment("Play the sound of Wind Bell").define("play wind bell sound(true/false)",true);
        builder.pop();
        builder.push("item settings");
        reiryokuCapacityOfMagatama=builder.comment("max Reiryoku amount of Magatama").define("magatama(1～2147483647)",5600);
        disableBlockElementDisplaying=builder.comment("disable displaying block element on item toolchip").define("disable displaying block element(true/false)",false);
        builder.pop();
        builder.push("blockentity settings");
        shichirinIconAmount=builder.comment("half number of square icons of Shichirin").define("Shichirin icon(1～2147483647)",6);
        shichirincookingDifficlutly=builder.comment("cooking difficulty by using Shichirin (small number : severe)").define("Shichirin cooking difficulty(1～2147483647)",2000);
        builder.pop();
        builder.push("entity settings");
        TurnOnSpeedUp=builder.comment("increase the player walking spped by 16% so that you can place blocks comfortably").define("walking speed(true/false)",true);
        builder.pop();
        builder.push("particle settings");
        fallingLeafParticleAmount=builder.comment("amount of falling leaf particles").define("falling leaf(1～100)",50);
        fallingSakuraParticleAmount=builder.comment("amount of falling sakura particles").define("falling sakura(1～100)",60);
        builder.pop();
        builder.push("world settings");
        generateKakuriyoPortalProbability=builder.comment("probability of kakuriyo portal generation (large number : rare)").define("kakuriyo portal(1～2147483647)",65);
        builder.pop();
        spec=builder.build();
    }
}