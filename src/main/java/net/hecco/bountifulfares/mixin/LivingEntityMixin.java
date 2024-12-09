package net.hecco.bountifulfares.mixin;

import com.google.common.collect.Maps;
import net.hecco.bountifulfares.effect.AcidicEffect;
import net.hecco.bountifulfares.effect.BFEffects;
import net.hecco.bountifulfares.effect.StuporEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.registry.entry.RegistryEntry;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {
    @Shadow
    private final Map<RegistryEntry<StatusEffect>, StatusEffectInstance> activeStatusEffects = Maps.newHashMap();
    @Shadow
    public final boolean addStatusEffect(StatusEffectInstance effect) {
        return true;
    }
    @Shadow
    protected void onStatusEffectRemoved(StatusEffectInstance effect){}
    @ModifyVariable(method = "addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;Lnet/minecraft/entity/Entity;)Z", at = @At("HEAD"), argsOnly = true)
    private StatusEffectInstance bountifulfares_acidicApply(StatusEffectInstance effect) {
        if (activeStatusEffects.containsKey(BFEffects.ACIDIC)) {
            if (effect.getEffectType() != BFEffects.ACIDIC && !AcidicEffect.EFFECTS_BLACKLIST.contains(effect.getEffectType().value())) {
                int amplifier = Math.min(effect.getAmplifier() + activeStatusEffects.get(BFEffects.ACIDIC).getAmplifier() + 1, 255);
                return new StatusEffectInstance(effect.getEffectType(), effect.getDuration(), amplifier);
            }
        }
        return effect;
    }
    @Inject(method = "removeStatusEffect", at = @At("HEAD"))
    private void bountifulfares_acidicRemove(RegistryEntry<StatusEffect> effect, CallbackInfoReturnable<Boolean> cir) {
        if (this.activeStatusEffects.containsKey(effect) && effect == BFEffects.ACIDIC) {
            int acidicAmplifier = this.activeStatusEffects.get(effect).getAmplifier();
            for (RegistryEntry<StatusEffect> entry : this.activeStatusEffects.keySet()) {
                if (entry != BFEffects.ACIDIC && !AcidicEffect.EFFECTS_BLACKLIST.contains(entry.value())) {
                    int amplifier = Math.max(this.activeStatusEffects.get(entry).getAmplifier() + acidicAmplifier + 1, 0);
                    StatusEffectInstance statusEffectInstance = this.activeStatusEffects.remove(entry);
                    if (statusEffectInstance != null) {
                        this.onStatusEffectRemoved(statusEffectInstance);
                    }
                    this.addStatusEffect(new StatusEffectInstance(entry, statusEffectInstance.getDuration(), amplifier));
                }
            }
        }
    }
    @Inject(method = "addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;Lnet/minecraft/entity/Entity;)Z", at = @At("HEAD"), cancellable = true)
    private void bountifulfares_stupor(StatusEffectInstance effect, @Nullable Entity source, CallbackInfoReturnable<Boolean> cir) {
        if (activeStatusEffects.containsKey(BFEffects.STUPOR)) {
            if (effect.getEffectType() != BFEffects.STUPOR && !StuporEffect.EFFECTS_BLACKLIST.contains(effect.getEffectType().value())) {
                cir.setReturnValue(false);
                cir.cancel();
            }
        }
    }
}
