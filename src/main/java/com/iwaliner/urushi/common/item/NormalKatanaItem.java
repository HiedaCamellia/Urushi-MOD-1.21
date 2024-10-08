package com.iwaliner.urushi.common.item;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;


import java.util.List;

public class NormalKatanaItem extends SwordItem {
    private final float attackDamage;

    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    public NormalKatanaItem(Tier tier,int i,float f, Properties properties) {
        super(tier, properties);
        this.attackDamage = (float)i + tier.getAttackDamageBonus();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE.value(), new AttributeModifier(BASE_ATTACK_DAMAGE_ID, this.attackDamage, AttributeModifier.Operation.ADD_VALUE));
        builder.put(Attributes.ATTACK_SPEED.value(), new AttributeModifier(BASE_ATTACK_SPEED_ID, f, AttributeModifier.Operation.ADD_VALUE));
        this.defaultModifiers = builder.build();
    }

    public float getDamage() {
        return this.attackDamage;
    }


    @Override
    public boolean canAttackBlock(BlockState p_41441_, Level p_41442_, BlockPos p_41443_, Player player) {
        return !player.isCreative();
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(Blocks.COBWEB)) {
            return 15.0F;
        }
        return 1.0F;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity living, LivingEntity entity) {
//        stack.hurtAndBreak(1, entity, (slot) -> {
//            slot.broadcastBreakEvent(EquipmentSlot.MAINHAND);
//        });
        return true;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity living) {
        if (state.getDestroySpeed(level, pos) != 0.0F) {
//            stack.hurtAndBreak(2, living, (slot) -> {
//                slot.broadcastBreakEvent(EquipmentSlot.MAINHAND);
//            });
        }

        return true; }


    public boolean isCorrectToolForDrops(BlockState p_150897_1_) {
        return p_150897_1_.is(Blocks.COBWEB);
    }

//    @Override
//    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot slot) {
//        return slot == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(slot);
//    }

   @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        boolean flag= player.onGround();
        float a=flag?2F:1F;
        double f = -Math.sin(player.getYRot() * ((float)Math.PI / 180F)) * Math.cos(player.getXRot() * ((float)Math.PI / 180F));
        double f1 = -Math.sin((player.getXRot() + 0f) * ((float)Math.PI / 180F));
        double f2 = Math.cos(player.getYRot() * ((float)Math.PI / 180F)) * Math.cos(player.getXRot() * ((float)Math.PI / 180F));
        Vec3 vector3d = (new Vec3((double)f*a, (double)f1*a*0.4D, (double)f2*a));
        player.getCooldowns().addCooldown(this, 10);
        player.startUsingItem(hand);
        player.setDeltaMovement(vector3d);
//        player.getItemInHand(hand).hurtAndBreak(1, player, (x) -> {
//            x.broadcastBreakEvent(hand);
//        });
        AABB axisalignedbb =player.getBoundingBox() .inflate(4.0D, 4.0D, 4.0D);
        List<LivingEntity> list = player.level().getEntitiesOfClass(LivingEntity.class, axisalignedbb);
        if(!list.isEmpty()) {
            for (LivingEntity entity : list) {
                if(entity instanceof Player) {
                }else{
                    //entity.hurt(entity.damageSources().playerAttack(player), (getDamage()+EnchantmentHelper.modifyDamage(player.getItemInHand(hand),entity.getMobType()))*0.5F);
                    entity.hurt(entity.damageSources().playerAttack(player), getDamage());
                    player.level().playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.PLAYER_ATTACK_KNOCKBACK, SoundSource.PLAYERS, 1.5F, 1F);
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }



    @Override
    public InteractionResult interactLivingEntity(ItemStack itemStack, Player player, LivingEntity living, InteractionHand hand) {
        //living.hurt(living.damageSources().playerAttack((Player) player),(getDamage()+EnchantmentHelper.getDamageBonus(player.getItemInHand(hand),living.getMobType()))*0.5F);
        living.hurt(living.damageSources().playerAttack(player),getDamage());
            this.use(player.level(),player,hand);
            player.level().playSound((Player) null, living.getX(), living.getY(), living.getZ(), SoundEvents.PLAYER_ATTACK_KNOCKBACK, SoundSource.PLAYERS, 1.5F, 1F);
            return InteractionResult.sidedSuccess(player.level().isClientSide);
        }



}
