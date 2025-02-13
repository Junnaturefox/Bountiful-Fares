package net.hecco.bountifulfares.registry.util;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class BFEffectTags {
    public static final TagKey<StatusEffect> ACIDIC_BLACKLIST = TagKey.of(RegistryKeys.STATUS_EFFECT, Identifier.of(BountifulFares.MOD_ID, "acidic_blacklist"));
    public static final TagKey<StatusEffect> STUPOR_BLACKLIST = TagKey.of(RegistryKeys.STATUS_EFFECT, Identifier.of(BountifulFares.MOD_ID, "stupor_blacklist"));
}
