package net.hecco.bountifulfares.mixin;

import com.google.common.collect.Maps;
import net.hecco.bountifulfares.BountifulFares;
import net.hecco.bountifulfares.effect.AcidicEffect;
import net.hecco.bountifulfares.registry.content.BFEffects;
import net.hecco.bountifulfares.effect.StuporEffect;
import net.hecco.bountifulfares.registry.util.BFEffectTags;
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
    public boolean removeStatusEffect(RegistryEntry<StatusEffect> effect) {
        return true;
    }

    @Shadow
    protected void onStatusEffectRemoved(StatusEffectInstance effect){}

    @Inject(method = "addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;Lnet/minecraft/entity/Entity;)Z", at = @At("HEAD"))
    private void bountifulfares_acidicApply(StatusEffectInstance effect, @Nullable Entity source, CallbackInfoReturnable<Boolean> cir) {
        if (!this.activeStatusEffects.containsKey(BFEffects.ACIDIC) && effect.getEffectType() == BFEffects.ACIDIC) {
            int acidicAmplifier = effect.getAmplifier();
            for (Map.Entry<RegistryEntry<StatusEffect>, StatusEffectInstance> entry : this.activeStatusEffects.entrySet()) {
                if (entry.getKey() != BFEffects.ACIDIC && !entry.getKey().isIn(BFEffectTags.ACIDIC_BLACKLIST)) {
                    int amplifier = Math.min(entry.getValue().getAmplifier() + acidicAmplifier + 1, 255);
//                    this.activeStatusEffects.remove(entry.getKey());
//                    this.activeStatusEffects.put(entry.getKey(), new StatusEffectInstance(entry.getKey(), entry.getValue().getDuration(), amplifier));
                }
            }
        }
    }
    @ModifyVariable(method = "addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;Lnet/minecraft/entity/Entity;)Z", at = @At("HEAD"), argsOnly = true)
    private StatusEffectInstance bountifulfares_ifAcidicPresent(StatusEffectInstance effect) {
         if (activeStatusEffects.containsKey(BFEffects.ACIDIC)) {
            if (effect.getEffectType() != BFEffects.ACIDIC && !effect.getEffectType().isIn(BFEffectTags.ACIDIC_BLACKLIST)) {
                int amplifier = Math.min(effect.getAmplifier() + activeStatusEffects.get(BFEffects.ACIDIC).getAmplifier() + 1, 255);
                return new StatusEffectInstance(effect.getEffectType(), effect.getDuration(), amplifier);
            }
        }
        return effect;
    }
    @Inject(method = "removeStatusEffect", at = @At("HEAD"))
    private void bountifulfares_acidicRemove(RegistryEntry<StatusEffect> effect, CallbackInfoReturnable<Boolean> cir) {
        try {
            if (effect == BFEffects.ACIDIC && this.activeStatusEffects.containsKey(BFEffects.ACIDIC)) {
                BountifulFares.LOGGER.info(this.activeStatusEffects + "");
                int acidicAmplifier = this.activeStatusEffects.get(effect).getAmplifier();
                BountifulFares.LOGGER.info(acidicAmplifier + "");
                for (Map.Entry<RegistryEntry<StatusEffect>, StatusEffectInstance> entry : this.activeStatusEffects.entrySet()) {
                    if (entry.getKey() != BFEffects.ACIDIC && !entry.getKey().isIn(BFEffectTags.ACIDIC_BLACKLIST)) {
//                        int amplifier = Math.max(entry.getValue().getAmplifier() - acidicAmplifier - 1, 0);
                        int amplifier = 4;
                        BountifulFares.LOGGER.info(amplifier + "");
                        this.activeStatusEffects.remove(entry.getKey());
                        this.activeStatusEffects.put(entry.getKey(), new StatusEffectInstance(entry.getKey(), entry.getValue().getDuration(), amplifier));                    }
                }
            }
        } catch (Exception e) {
            BountifulFares.LOGGER.info("didnt work :(");
        }
    }





    @Inject(method = "addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;Lnet/minecraft/entity/Entity;)Z", at = @At("HEAD"))
    private void bountifulfares_stuporApply(StatusEffectInstance effect, @Nullable Entity source, CallbackInfoReturnable<Boolean> cir) {
        if (effect.getEffectType() == BFEffects.STUPOR) {
            for (Map.Entry<RegistryEntry<StatusEffect>, StatusEffectInstance> entry : this.activeStatusEffects.entrySet()) {
                if (entry.getKey() != BFEffects.STUPOR && !entry.getKey().isIn(BFEffectTags.STUPOR_BLACKLIST)) {
                    this.removeStatusEffect(entry.getKey());
                }
            }
        }
    }
    @Inject(method = "addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;Lnet/minecraft/entity/Entity;)Z", at = @At("HEAD"), cancellable = true)
    private void bountifulfares_stupor(StatusEffectInstance effect, @Nullable Entity source, CallbackInfoReturnable<Boolean> cir) {
        if (activeStatusEffects.containsKey(BFEffects.STUPOR)) {
            if (effect.getEffectType() != BFEffects.STUPOR && !effect.getEffectType().isIn(BFEffectTags.STUPOR_BLACKLIST)) {
                cir.setReturnValue(false);
                cir.cancel();
            }
        }
    }
}
