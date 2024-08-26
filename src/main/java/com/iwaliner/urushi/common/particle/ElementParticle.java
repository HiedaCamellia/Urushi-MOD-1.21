package com.iwaliner.urushi.common.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class ElementParticle extends TextureSheetParticle {
    ElementParticle(ClientLevel level, double x, double y, double z, double xd, double yd, double zd, SpriteSet spriteSet) {
        super(level, x, y, z, xd, yd,zd);
        this.friction = 1F;
        this.xd = xd;
        this.yd = yd;
        this.zd = zd;
        this.quadSize *= 0.8F;
        this.lifetime = 80;
        this.setSpriteFromAge(spriteSet);


    }

    @Override
    public void tick() {
        super.tick();
        BlockPos pos= BlockPos.containing(this.getPos());
      BlockState state=level.getBlockState(pos);
        VoxelShape shape= state.getCollisionShape(level,pos).optimize();
        double corner=6D;
        VoxelShape particleShape= Block.box(corner,corner,corner,16D-corner,16D-corner,16D-corner);
        if(!this.removed &&Shapes.joinIsNotEmpty(shape,particleShape, BooleanOp.AND)){
            this.remove();
        }


    }


    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprites;

        public Provider(SpriteSet spriteSet) {
            this.sprites = spriteSet;
        }

        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new ElementParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, this.sprites);
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }
}
