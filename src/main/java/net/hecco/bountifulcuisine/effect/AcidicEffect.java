package net.hecco.bountifulcuisine.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.ArrayList;
import java.util.List;

public class AcidicEffect extends StatusEffect {
    protected AcidicEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity instanceof net.minecraft.server.network.ServerPlayerEntity) {
            net.minecraft.server.network.ServerPlayerEntity player = (net.minecraft.server.network.ServerPlayerEntity) entity;

            // Create a list to store modified effects
            List<StatusEffectInstance> modifiedEffects = new ArrayList<>();

            // Loop through all active status effects except Acidic
            for (StatusEffectInstance effect : player.getStatusEffects()) {
                if (effect.getEffectType() != this) {
                    int newAmplifier = effect.getAmplifier() + amplifier + 1;
                    if (newAmplifier > 255) {
                        newAmplifier = 255;
                    }
                    StatusEffectInstance newEffect = new StatusEffectInstance(effect.getEffectType(), effect.getDuration(), newAmplifier, effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon());
                    modifiedEffects.add(newEffect);
                }
            }

            // Remove and re-add modified effects
            for (StatusEffectInstance effect : modifiedEffects) {
                player.removeStatusEffect(effect.getEffectType());
                player.addStatusEffect(effect);
            }
        }
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (entity instanceof net.minecraft.server.network.ServerPlayerEntity) {
            net.minecraft.server.network.ServerPlayerEntity player = (net.minecraft.server.network.ServerPlayerEntity) entity;

            // Create a list to store modified effects
            List<StatusEffectInstance> modifiedEffects = new ArrayList<>();

            // Loop through all active status effects except Acidic
            for (StatusEffectInstance effect : player.getStatusEffects()) {
                if (effect.getEffectType() != this) {
                    int newAmplifier = effect.getAmplifier() - amplifier - 1;
                    if (newAmplifier < 0) {
                        newAmplifier = 0;
                    }
                    StatusEffectInstance newEffect = new StatusEffectInstance(effect.getEffectType(), effect.getDuration(), newAmplifier, effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon());
                    modifiedEffects.add(newEffect);
                }
            }

            // Remove and re-add modified effects
            for (StatusEffectInstance effect : modifiedEffects) {
                player.removeStatusEffect(effect.getEffectType());
                player.addStatusEffect(effect);
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}