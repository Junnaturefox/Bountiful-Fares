package net.hecco.bountifulfares.item.custom;

import net.hecco.bountifulfares.BountifulFares;
import net.minecraft.item.Item;
import net.minecraft.resource.featuretoggle.FeatureSet;

public class SweetBerryPipsItem extends Item {
    public SweetBerryPipsItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean isEnabled(FeatureSet enabledFeatures) {
        return BountifulFares.CONFIG.enableSweetBerryPips;
    }
}
