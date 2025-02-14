package net.hecco.bountifulfares.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.ArrayList;
import java.util.List;

public class StuporEffect extends StatusEffect {
//    TODO: add sound effect when removing effects and when an effect fails to apply
    public StuporEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }
}
