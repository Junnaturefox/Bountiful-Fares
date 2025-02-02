package net.hecco.bountifulfares.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AcidicEffect extends StatusEffect {
    //TODO: Fix acidic effect
    private final List<StatusEffectInstance> affectedEffects;
    public static final List<StatusEffect> EFFECTS_BLACKLIST = List.of(
            StatusEffects.INSTANT_HEALTH.value(),
            StatusEffects.INSTANT_DAMAGE.value(),
            StatusEffects.INVISIBILITY.value(),
            StatusEffects.NIGHT_VISION.value(),
            StatusEffects.BLINDNESS.value(),
            StatusEffects.CONDUIT_POWER.value(),
            StatusEffects.DARKNESS.value(),
            StatusEffects.FIRE_RESISTANCE.value(),
            StatusEffects.WATER_BREATHING.value(),
            StatusEffects.GLOWING.value(),
            StatusEffects.SLOW_FALLING.value(),
            StatusEffects.HERO_OF_THE_VILLAGE.value(),
            StatusEffects.BAD_OMEN.value(),
            StatusEffects.RAID_OMEN.value(),
            StatusEffects.TRIAL_OMEN.value(),
            StatusEffects.OOZING.value(),
            StatusEffects.WIND_CHARGED.value(),
            StatusEffects.INFESTED.value(),
            StatusEffects.WEAVING.value());
    protected AcidicEffect(StatusEffectCategory category, int color) {
        super(category, color);
        this.affectedEffects = new ArrayList<>();
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
//        if (!entity.getStatusEffects().isEmpty()) {
//            affectedEffects.clear();
//            List<StatusEffectInstance> effectsToModify = new ArrayList<>();
//            for (StatusEffectInstance effect : entity.getStatusEffects()) {
//                if (effect.getEffectType() != BFEffects.ACIDIC) {
//                    if (!EFFECTS_BLACKLIST.contains(effect.getEffectType().value())) {
//                        int newAmplifier = effect.getAmplifier() + amplifier + 1;
//                        if (newAmplifier > 255) {
//                            newAmplifier = 255;
//                        }
//                        StatusEffectInstance newEffect = new StatusEffectInstance(effect.getEffectType(), effect.getDuration(), newAmplifier, effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon());
//                        effectsToModify.add(newEffect);
//                        affectedEffects.add(newEffect);
//                    }
//                }
//            }
//            if (!effectsToModify.isEmpty()) {
//                for (StatusEffectInstance effect : effectsToModify) {
//                    entity.removeStatusEffect(effect.getEffectType());
//                    entity.addStatusEffect(effect);
//                }
//            }
//        }
        super.onApplied(entity, amplifier);
    }

//    @Override
//    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
//        if (!entity.getStatusEffects().isEmpty()) {
//            List<StatusEffectInstance> effectsToModify = new ArrayList<>();
//
//            for (StatusEffectInstance effect : entity.getStatusEffects()) {
//                //iterates through every effect on the entity and checks if it wasnt already amplified
//                boolean alreadyAffected = affectedEffects.stream().anyMatch(prev -> prev.getEffectType() == effect.getEffectType());
//
//                if (!alreadyAffected && effect.getEffectType() != BFEffects.ACIDIC) {
//                    if (!EFFECTS_BLACKLIST.contains(effect.getEffectType().value())) {
//                        int newAmplifier = effect.getAmplifier() + amplifier + 1;
//                        if (newAmplifier > 255) {
//                            newAmplifier = 255;
//                        }
//                        StatusEffectInstance newEffect = new StatusEffectInstance(effect.getEffectType(), effect.getDuration(), newAmplifier, effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon());
//                        effectsToModify.add(newEffect);
//                        affectedEffects.add(newEffect);
//                    }
//                }
//            }
//            if (!effectsToModify.isEmpty()) {
//                effectsToModify.forEach(instance -> entity.removeStatusEffect(instance.getEffectType()));
//                effectsToModify.forEach(entity::addStatusEffect);
//            }
//        }
//        super.applyUpdateEffect(entity, amplifier);
//        for (StatusEffectInstance thisEffect : entity.getStatusEffects()) {
//            if (thisEffect.getEffectType() == this){
//                if (thisEffect.isDurationBelow(5)) {
//                    List<StatusEffectInstance> effectsToModify = new ArrayList<>();
//
//                    Iterator<StatusEffectInstance> iterator = affectedEffects.iterator();
//                    while (iterator.hasNext()) {
//                        StatusEffectInstance effect = iterator.next();
//
//                        if (effect.getEffectType() != this && entity.hasStatusEffect(effect.getEffectType())) {
//                            if (!EFFECTS_BLACKLIST.contains(effect.getEffectType().value())) {
//                                int newAmplifier = effect.getAmplifier() - amplifier - 1;
//                                if (newAmplifier < 0) {
//                                    newAmplifier = 0;
//                                }
//                                StatusEffectInstance newEffect = new StatusEffectInstance(effect.getEffectType(), effect.getDuration(), newAmplifier, effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon());
//                                effectsToModify.add(newEffect);
//                                iterator.remove();
//                            }
//                        }
//                    }
//
//                    if (!effectsToModify.isEmpty()) {
//                        effectsToModify.forEach(instance -> entity.removeStatusEffect(instance.getEffectType()));
//                        effectsToModify.forEach(entity::addStatusEffect);
//                    }
//                    affectedEffects.clear();
//                    entity.removeStatusEffect(thisEffect.getEffectType());
//                }
//            }
//        }
//        return true;
//    }
//
//    @Override
//    public boolean canApplyUpdateEffect(int duration, int amplifier) {
//        return true;
//    }


    //    @Override
//    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
//        List<StatusEffectInstance> entityEffects = new ArrayList<>();
//        List<StatusEffectInstance> effectsToModify = new ArrayList<>();
//        for (StatusEffectInstance effect : entity.getStatusEffects()) {
//            if (effect.getEffectType() != this) {
//                entityEffects.add(effect);
//            }
//        }
//
//        for (StatusEffectInstance ignored : entityEffects) {
//            for (int i = 0; i < affectedEffects.size(); i++) {
//                if (!affectedEffects.contains(entityEffects.get(i))) {
//                    effectsToModify.add(entityEffects.get(i));
//                }
//            }
//        }
//        for (StatusEffectInstance effect : effectsToModify) {
//            if (effect.getEffectType() != this) {
//                // goes through each effect on the entity that isn't Acidic and increases the amplifier
//                int newAmplifier = effect.getAmplifier() + amplifier + 1;
//                if (newAmplifier > 255) {
//                    newAmplifier = 255;
//                }
//                StatusEffectInstance newEffect = new StatusEffectInstance(effect.getEffectType(), effect.getDuration(), newAmplifier, effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon());
//                affectedEffects.add(newEffect);
//            }
//        }
//        for (StatusEffectInstance effect : affectedEffects) {
//            //applies the new effects
//            entity.removeStatusEffect(effect.getEffectType());
//            entity.addStatusEffect(effect);
//        }
//    }
}
