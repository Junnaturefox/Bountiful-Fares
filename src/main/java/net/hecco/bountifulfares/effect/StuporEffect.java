package net.hecco.bountifulfares.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.ArrayList;
import java.util.List;

public class StuporEffect extends StatusEffect {
    public static final List<StatusEffect> EFFECTS_BLACKLIST = List.of(
            StatusEffects.CONDUIT_POWER.value(),
            StatusEffects.HERO_OF_THE_VILLAGE.value(),
            StatusEffects.BAD_OMEN.value(),
            StatusEffects.RAID_OMEN.value(),
            StatusEffects.TRIAL_OMEN.value());
    protected StuporEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
}
