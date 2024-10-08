package com.iwaliner.urushi.common.world.feature;

import com.iwaliner.urushi.core.config.ConfigUrushi;
import com.iwaliner.urushi.registries.ItemAndBlockRegister;
import com.iwaliner.urushi.common.block.JapaneseTimberBambooBlock;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class JapaneseTimberBambooFeature extends Feature<JapaneseTimberBambooFeature.Configuration> {
    private static final BlockState BAMBOO_TRUNK = ItemAndBlockRegister.japanese_timber_bamboo.get().defaultBlockState();
    private static final BlockState BAMBOO_UPPER = ItemAndBlockRegister.japanese_timber_bamboo.get().defaultBlockState().setValue(JapaneseTimberBambooBlock.AGE,Integer.valueOf(1));
    private static final BlockState BAMBOO_TOP = ItemAndBlockRegister.japanese_timber_bamboo.get().defaultBlockState().setValue(JapaneseTimberBambooBlock.AGE,Integer.valueOf(2));

    public JapaneseTimberBambooFeature(Codec<JapaneseTimberBambooFeature.Configuration> p_65137_) {
        super(p_65137_);
    }

    public boolean place(FeaturePlaceContext<JapaneseTimberBambooFeature.Configuration> p_159438_) {
        int n = 0;
        BlockPos blockpos = p_159438_.origin();
        WorldGenLevel worldgenlevel = p_159438_.level();
        RandomSource random = p_159438_.random();
        JapaneseTimberBambooFeature.Configuration probabilityfeatureconfiguration = p_159438_.config();

        BlockPos.MutableBlockPos blockpos$mutableblockpos = blockpos.mutable();
        BlockPos.MutableBlockPos blockpos$mutableblockpos1 = blockpos.mutable();
        if (worldgenlevel.isEmptyBlock(blockpos$mutableblockpos)) {
            if (ItemAndBlockRegister.japanese_timber_bamboo.get().defaultBlockState().canSurvive(worldgenlevel, blockpos$mutableblockpos)) {
                int m = random.nextInt(3) + 4;
                if (random.nextInt(2) ==0) {
                    int k = random.nextInt(4) + 1;

                    for(int l = blockpos.getX() - k; l <= blockpos.getX() + k; ++l) {
                        for(int i1 = blockpos.getZ() - k; i1 <= blockpos.getZ() + k; ++i1) {
                            int j1 = l - blockpos.getX();
                            int k1 = i1 - blockpos.getZ();
                            if (j1 * j1 + k1 * k1 <= k * k) {
                                blockpos$mutableblockpos1.set(l, worldgenlevel.getHeight(Heightmap.Types.WORLD_SURFACE, l, i1) - 1, i1);

                            }
                        }
                    }
                }

               /* for(int l1 = 0; l1 < j && worldgenlevel.isEmptyBlock(blockpos$mutableblockpos); ++l1) {
                    worldgenlevel.setBlock(blockpos$mutableblockpos, BAMBOO_TRUNK, 2);
                    blockpos$mutableblockpos.move(Direction.UP, 1);
                }

                if (blockpos$mutableblockpos.getY() - blockpos.getY() >= 3) {
                    worldgenlevel.setBlock(blockpos$mutableblockpos, BAMBOO_UPPER, 2);
                   }*/


                for(int i1 = 0; i1 < ConfigUrushi.maxHightBamboo.get(); ++i1) {

                    if(i1 < ConfigUrushi.maxHightBamboo.get()-7) {
                        worldgenlevel.setBlock(blockpos.above(i1), BAMBOO_TRUNK, 2);
                    }else{
                        if(worldgenlevel.getBlockState(blockpos.above(i1-1))!=BAMBOO_TRUNK&&worldgenlevel.getBlockState(blockpos.above(i1-1))!=BAMBOO_UPPER){
                            if(worldgenlevel.getBlockState(blockpos.above(i1-1))==BAMBOO_UPPER||worldgenlevel.getBlockState(blockpos.above(i1-1))==BAMBOO_TRUNK){
                                worldgenlevel.setBlock(blockpos.above(i1-1),BAMBOO_TOP,2);
                            }
                            break;
                        }
                        if(random.nextInt(3)!=0){
                            worldgenlevel.setBlock(blockpos.above(i1),BAMBOO_UPPER,2);
                        }else{
                            if(worldgenlevel.getBlockState(blockpos.above(i1-1)).getValue(JapaneseTimberBambooBlock.AGE)==Integer.valueOf(0)){
                                worldgenlevel.setBlock(blockpos.above(i1),BAMBOO_TRUNK,2);
                            }else{
                                worldgenlevel.setBlock(blockpos.above(i1),BAMBOO_TOP,2);
                            }
                        }
                    }
                }
            }

            ++n;
        }

        return n > 0;
    }

    public static record Configuration(BlockStateProvider bamboo) implements FeatureConfiguration {
        public static final Codec<JapaneseTimberBambooFeature.Configuration> CODEC = RecordCodecBuilder.create((p_190962_) -> {
            return p_190962_.group(BlockStateProvider.CODEC.fieldOf("bamboo").forGetter(JapaneseTimberBambooFeature.Configuration::bamboo)).apply(p_190962_, JapaneseTimberBambooFeature.Configuration::new);
        });
    }






}
